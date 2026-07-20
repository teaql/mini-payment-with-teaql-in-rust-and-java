package com.example.merchant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.teaql.core.meta.EntityMetaFactory;
import io.teaql.core.meta.SimpleEntityMetaFactory;
import io.teaql.provider.springjdbc.SpringJdbcSqlExecutor;
import com.doublechaintech.merchantservice.EntityMetaRegistry;
import io.teaql.runtime.DefaultUserContext;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  // Custom SpringJdbcSqlExecutor subclass to patch Postgres DDL <max> bug in teaql-postgres
  public static class PostgresJdbcSqlExecutor extends SpringJdbcSqlExecutor {
      public PostgresJdbcSqlExecutor(NamedParameterJdbcTemplate jdbcTemplate) {
          super(jdbcTemplate);
      }

      @Override
      public void execute(String sql) {
          if (sql != null) {
              sql = sql.replace("<max>", "255");
          }
          super.execute(sql);
      }
  }

  @Bean
  public EntityMetaFactory entityMetaFactory() {
      SimpleEntityMetaFactory factory = new SimpleEntityMetaFactory();
      new EntityMetaRegistry().assemble(factory);
      
      // Register entity suppliers explicitly to avoid "No entity supplier registered" exception
      factory.resolveEntityDescriptor("Platform").setEntitySupplier(com.doublechaintech.merchantservice.platform.Platform::new);
      factory.resolveEntityDescriptor("Merchant").setEntitySupplier(com.doublechaintech.merchantservice.merchant.Merchant::new);
      factory.resolveEntityDescriptor("MerchantKyc").setEntitySupplier(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc::new);
      factory.resolveEntityDescriptor("MerchantStatusType").setEntitySupplier(com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType::new);
      factory.resolveEntityDescriptor("EventStatusType").setEntitySupplier(com.doublechaintech.merchantservice.eventstatustype.EventStatusType::new);
      factory.resolveEntityDescriptor("OutboxEvent").setEntitySupplier(com.doublechaintech.merchantservice.outboxevent.OutboxEvent::new);
      
      EntityMetaFactory.registerGlobal(factory); // Register globally to avoid NullPointerException in data service
      return factory;
  }

  @Bean
  public SpringJdbcSqlExecutor springJdbcSqlExecutor(NamedParameterJdbcTemplate jdbcTemplate) {
      return new PostgresJdbcSqlExecutor(jdbcTemplate);
  }

  @Bean
  public io.teaql.core.DataServiceExecutor dataServiceExecutor(SpringJdbcSqlExecutor executor) {
      return new io.teaql.core.postgres.PostgresDataServiceExecutor("default", executor);
  }

  @Bean
  public io.teaql.core.DataServiceRegistry dataServiceRegistry(io.teaql.core.DataServiceExecutor dataServiceExecutor) {
      io.teaql.runtime.DefaultDataServiceRegistry registry = new io.teaql.runtime.DefaultDataServiceRegistry();
      registry.register("default", dataServiceExecutor);
      return registry;
  }

  @Bean
  public io.teaql.core.sql.portable.TeaQLDatabase teaqlDatabase(SpringJdbcSqlExecutor executor) {
      return new io.teaql.core.sql.portable.TeaQLDatabase() {
          @Override
          public java.util.List<java.util.Map<String, Object>> query(String sql, Object[] args) {
              return executor.queryForList(sql, args);
          }
          @Override
          public java.util.List<java.util.Map<String, Object>> query(io.teaql.core.UserContext ctx, String sql, Object[] args) {
              return executor.queryForList(sql, args);
          }
          @Override
          public int executeUpdate(String sql, Object[] args) {
              return executor.update(sql, args);
          }
          @Override
          public int executeUpdate(io.teaql.core.UserContext ctx, String sql, Object[] args) {
              return executor.update(sql, args);
          }
          @Override
          public int[] batchUpdate(String sql, java.util.List<Object[]> batchArgs) {
              return executor.batchUpdate(sql, batchArgs);
          }
          @Override
          public int[] batchUpdate(io.teaql.core.UserContext ctx, String sql, java.util.List<Object[]> batchArgs) {
              return executor.batchUpdate(sql, batchArgs);
          }
          @Override
          public void execute(String sql) {
              executor.execute(sql);
          }
          @Override
          public void execute(io.teaql.core.UserContext ctx, String sql) {
              executor.execute(sql);
          }
          @Override
          public void executeInTransaction(Runnable action) {
              action.run();
          }
          @Override
          public java.util.List<java.util.Map<String, Object>> getTableColumns(String tableName) {
              return executor.queryForList("SELECT column_name, data_type FROM information_schema.columns WHERE table_name = ? AND table_schema = 'public'", new Object[]{tableName.toLowerCase()});
          }
      };
  }

  @Bean
  public io.teaql.runtime.TeaQLRuntime teaqlRuntime(
      EntityMetaFactory entityMetaFactory,
      io.teaql.core.DataServiceExecutor dataServiceExecutor,
      io.teaql.core.sql.portable.TeaQLDatabase teaqlDatabase
  ) {
      return io.teaql.runtime.TeaQLRuntime.builder()
              .metadata(entityMetaFactory)
              .dataService("default", dataServiceExecutor)
              .idGenerationService(new io.teaql.core.sql.portable.IdSpaceIdGenerator(teaqlDatabase))
              .build();
  }

  @Bean
  public CommandLineRunner schemaInitializer(
      io.teaql.core.DataServiceExecutor executor,
      io.teaql.runtime.TeaQLRuntime runtime
  ) {
      return args -> {
          DefaultUserContext ctx = new DefaultUserContext(runtime);
          if (executor instanceof io.teaql.core.postgres.PostgresDataServiceExecutor) {
              System.out.println("Initializing database schema via TeaQL Postgres Executor with <max> replacement...");
              ((io.teaql.core.postgres.PostgresDataServiceExecutor) executor).ensureSchema(ctx);
              System.out.println("Database schema initialized successfully!");
          } else {
              System.out.println("Executor is not PostgresDataServiceExecutor, skipping schema init.");
          }
      };
  }

}
