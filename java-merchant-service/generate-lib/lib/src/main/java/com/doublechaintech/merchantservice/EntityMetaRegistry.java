package com.doublechaintech.merchantservice;

import io.teaql.core.meta.EntityDescriptor;
import io.teaql.core.meta.EntityMetaAssembler;
import io.teaql.core.meta.EntityMetaFactory;
import io.teaql.core.meta.PropertyDescriptor;
import java.time.LocalDateTime;

public class EntityMetaRegistry implements EntityMetaAssembler {
  private EntityMetaFactory $factory;

  @Override
  public void assemble(EntityMetaFactory factory) {
    this.$factory = factory;
    registerPlatform();
    registerMerchantStatusType();
    registerMerchant();
    registerMerchantKyc();
    registerEventStatusType();
    registerOutboxEvent();
  }
  private void registerPlatform() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.merchantservice.platform.Platform.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.merchantservice.platform.Platform.class);
      entityDescriptor.with("name", "System Platform")
      .with("module", "Platform")
      .with("module_key", "platform");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.platform.Platform.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.platform.Platform.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.platform.Platform.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.platform.Platform.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.platform.Platform.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.doublechaintech.merchantservice.platform.Platform.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.platform.Platform.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "Merchant Platform")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.platform.Platform.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.platform.Platform.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.platform.Platform.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerMerchant() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.merchantservice.merchant.Merchant.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.merchantservice.merchant.Merchant.class);
      entityDescriptor.with("name", "Merchant")
      .with("module", "Merchant Core")
      .with("module_key", "merchant-core");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchant.Merchant.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor companyName = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchant.Merchant.COMPANY_NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor contactEmail = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchant.Merchant.CONTACT_EMAIL_PROPERTY, String.class)
      ;
      PropertyDescriptor appKey = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchant.Merchant.APP_KEY_PROPERTY, String.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.merchantservice.merchant.Merchant.STATUS_PROPERTY, com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.INTERNAL_TYPE, com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.MERCHANT_LIST_PROPERTY, com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.class)
      ;
      PropertyDescriptor platform = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.merchantservice.merchant.Merchant.PLATFORM_PROPERTY, com.doublechaintech.merchantservice.platform.Platform.INTERNAL_TYPE, com.doublechaintech.merchantservice.platform.Platform.MERCHANT_LIST_PROPERTY, com.doublechaintech.merchantservice.platform.Platform.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchant.Merchant.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchant.Merchant.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchant.Merchant.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchant.Merchant.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchant.Merchant.COMPANY_NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchant.Merchant.CONTACT_EMAIL_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchant.Merchant.APP_KEY_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");



      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchant.Merchant.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchant.Merchant.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchant.Merchant.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerMerchantKyc() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.class);
      entityDescriptor.with("name", "Merchant Kyc")
      .with("module", "Merchant Core")
      .with("module_key", "merchant-core");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor businessLicenseNo = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.BUSINESS_LICENSE_NO_PROPERTY, String.class)
      ;
      PropertyDescriptor legalPerson = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.LEGAL_PERSON_PROPERTY, String.class)
      ;
      PropertyDescriptor bankAccountNo = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.BANK_ACCOUNT_NO_PROPERTY, String.class)
      ;
      PropertyDescriptor merchant = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.MERCHANT_PROPERTY, com.doublechaintech.merchantservice.merchant.Merchant.INTERNAL_TYPE, com.doublechaintech.merchantservice.merchant.Merchant.MERCHANT_KYC_LIST_PROPERTY, com.doublechaintech.merchantservice.merchant.Merchant.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.BUSINESS_LICENSE_NO_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.LEGAL_PERSON_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.BANK_ACCOUNT_NO_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerOutboxEvent() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.class);
      entityDescriptor.with("name", "Outbox Event")
      .with("module", "Integration")
      .with("module_key", "integration");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor eventType = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.EVENT_TYPE_PROPERTY, String.class)
      ;
      PropertyDescriptor payload = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.PAYLOAD_PROPERTY, String.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.merchantservice.outboxevent.OutboxEvent.STATUS_PROPERTY, com.doublechaintech.merchantservice.eventstatustype.EventStatusType.INTERNAL_TYPE, com.doublechaintech.merchantservice.eventstatustype.EventStatusType.OUTBOX_EVENT_LIST_PROPERTY, com.doublechaintech.merchantservice.eventstatustype.EventStatusType.class)
      ;
      PropertyDescriptor merchant = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.merchantservice.outboxevent.OutboxEvent.MERCHANT_PROPERTY, com.doublechaintech.merchantservice.merchant.Merchant.INTERNAL_TYPE, com.doublechaintech.merchantservice.merchant.Merchant.OUTBOX_EVENT_LIST_PROPERTY, com.doublechaintech.merchantservice.merchant.Merchant.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor processedAt = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.PROCESSED_AT_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.EVENT_TYPE_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.PAYLOAD_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");



      entityDescriptor.findProperty(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.PROCESSED_AT_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("optional", "true")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerMerchantStatusType() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.class);
      entityDescriptor.with("name", "Merchant Status Type")
      .with("module", "Merchant Core")
      .with("module_key", "merchant-core")
      .with("constant", "true")
      .with("identifier", "code");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor code = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.CODE_PROPERTY, String.class)
      ;
      PropertyDescriptor platform = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.PLATFORM_PROPERTY, com.doublechaintech.merchantservice.platform.Platform.INTERNAL_TYPE, com.doublechaintech.merchantservice.platform.Platform.MERCHANT_STATUS_TYPE_LIST_PROPERTY, com.doublechaintech.merchantservice.platform.Platform.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("candidates", "1001,1002,1003")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "Active,Pending Verification,Suspended")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.CODE_PROPERTY).with("identifier", "true")
      .with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "ACTIVE,PENDING_VERIFICATION,SUSPENDED")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.PLATFORM_PROPERTY).with("candidates", "platform(context)")
      .with("context", "true");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerEventStatusType() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.merchantservice.eventstatustype.EventStatusType.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.merchantservice.eventstatustype.EventStatusType.class);
      entityDescriptor.with("name", "Event Status Type")
      .with("module", "Integration")
      .with("module_key", "integration")
      .with("constant", "true")
      .with("identifier", "code");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.eventstatustype.EventStatusType.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.eventstatustype.EventStatusType.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor code = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.eventstatustype.EventStatusType.CODE_PROPERTY, String.class)
      ;
      PropertyDescriptor platform = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.merchantservice.eventstatustype.EventStatusType.PLATFORM_PROPERTY, com.doublechaintech.merchantservice.platform.Platform.INTERNAL_TYPE, com.doublechaintech.merchantservice.platform.Platform.EVENT_STATUS_TYPE_LIST_PROPERTY, com.doublechaintech.merchantservice.platform.Platform.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.merchantservice.eventstatustype.EventStatusType.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.doublechaintech.merchantservice.eventstatustype.EventStatusType.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("candidates", "1001,1002,1003")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.eventstatustype.EventStatusType.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "Pending,Processed,Failed")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.eventstatustype.EventStatusType.CODE_PROPERTY).with("identifier", "true")
      .with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "PENDING,PROCESSED,FAILED")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.eventstatustype.EventStatusType.PLATFORM_PROPERTY).with("candidates", "platform(context)")
      .with("context", "true");

      entityDescriptor.findProperty(com.doublechaintech.merchantservice.eventstatustype.EventStatusType.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
}