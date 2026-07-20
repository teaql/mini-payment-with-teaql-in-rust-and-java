package com.doublechaintech.merchantservice.eventstatustype;

import com.doublechaintech.merchantservice.Q;
import com.doublechaintech.merchantservice.outboxevent.OutboxEvent;
import com.doublechaintech.merchantservice.outboxevent.OutboxEventRequest;
import com.doublechaintech.merchantservice.platform.Platform;
import com.doublechaintech.merchantservice.platform.PlatformRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;

public class EventStatusTypeRequest<T extends EventStatusType> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public EventStatusTypeRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public EventStatusTypeRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public EventStatusTypeRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public EventStatusTypeRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public EventStatusTypeRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public EventStatusTypeRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public EventStatusTypeRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (EventStatusTypeRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public EventStatusTypeRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public EventStatusTypeRequest<T> matchingAnyOf(EventStatusTypeRequest eventStatusType){
        super.internalMatchAny(eventStatusType);
        return this;
    }

    public EventStatusTypeRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public EventStatusTypeRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public EventStatusTypeRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public EventStatusTypeRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectCode().selectPlatformIdOnly().selectVersion();
    }

    public EventStatusTypeRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public EventStatusTypeRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectCode().selectPlatform().selectVersion();
    }

    public EventStatusTypeRequest<T> selectChildren(){
        super.selectAny();
        selectOutboxEventList();
        return selectId().selectName().selectCode().selectPlatform().selectVersion();
    }


    public EventStatusTypeRequest<T> selectId(){
       selectProperty(EventStatusType.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EventStatusTypeRequest<T> unselectId(){
       unselectProperty(EventStatusType.ID_PROPERTY);
       return this;
    }
    public EventStatusTypeRequest<T> selectName(){
       selectProperty(EventStatusType.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EventStatusTypeRequest<T> unselectName(){
       unselectProperty(EventStatusType.NAME_PROPERTY);
       return this;
    }
    public EventStatusTypeRequest<T> selectCode(){
       selectProperty(EventStatusType.CODE_PROPERTY);
       return this;
    }

    /**
     * fill the code with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  code) to fetch code property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EventStatusTypeRequest<T> unselectCode(){
       unselectProperty(EventStatusType.CODE_PROPERTY);
       return this;
    }
    public EventStatusTypeRequest<T> selectPlatformIdOnly(){
       selectProperty(EventStatusType.PLATFORM_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> selectPlatform(){
        return selectPlatformWith(Q.platforms().unlimited().selectSelf());
    }

    public EventStatusTypeRequest<T> selectPlatformWith(PlatformRequest platform){
       selectProperty(EventStatusType.PLATFORM_PROPERTY);
       enhanceRelation(EventStatusType.PLATFORM_PROPERTY, platform);
       return this;
    }

    public EventStatusTypeRequest<T> unselectPlatform(){
       unselectProperty(EventStatusType.PLATFORM_PROPERTY);
       return this;
    }
    public EventStatusTypeRequest<T> selectVersion(){
       selectProperty(EventStatusType.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EventStatusTypeRequest<T> unselectVersion(){
       unselectProperty(EventStatusType.VERSION_PROPERTY);
       return this;
    }
    public EventStatusTypeRequest<T> selectOutboxEventList(){
       return selectOutboxEventListWith(Q.outboxEvents().selectSelf());
    }

    public EventStatusTypeRequest<T> selectOutboxEventListWith(OutboxEventRequest outboxEventList){
       enhanceRelation(EventStatusType.OUTBOX_EVENT_LIST_PROPERTY, outboxEventList);
       return this;
    }

    public EventStatusTypeRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(EventStatusType.ID_PROPERTY, operator, values);
    }

    public EventStatusTypeRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public EventStatusTypeRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public EventStatusTypeRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public EventStatusTypeRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public EventStatusTypeRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public EventStatusTypeRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(EventStatusType.NAME_PROPERTY, operator, values);
    }

    public EventStatusTypeRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public EventStatusTypeRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public EventStatusTypeRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public EventStatusTypeRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public EventStatusTypeRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public EventStatusTypeRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public EventStatusTypeRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public EventStatusTypeRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public EventStatusTypeRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public EventStatusTypeRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public EventStatusTypeRequest<T> filterByCode(String... code){
      if (code == null || code.length == 0) {
        throw new IllegalArgumentException("filterByCode parameter code cannot be empty");
      }
      return appendSearchCriteria(createCodeCriteria(Operator.EQUAL, (Object[])code));
    }

    public EventStatusTypeRequest<T> withCode(Operator operator, Object... values){
       return appendSearchCriteria(createCodeCriteria(operator, values));
    }

    public EventStatusTypeRequest<T> withCodeIsUnknown(){
       return withCode(Operator.IS_NULL);
    }

    public EventStatusTypeRequest<T> withCodeIsKnown(){
       return withCode(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCodeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(EventStatusType.CODE_PROPERTY, operator, values);
    }

    public EventStatusTypeRequest<T> withCodeGreaterThan(String code){
       return withCode(Operator.GREATER_THAN, code);
    }

    public EventStatusTypeRequest<T> withCodeGreaterThanOrEqualTo(String code){
       return withCode(Operator.GREATER_THAN_OR_EQUAL, code);
    }

    public EventStatusTypeRequest<T> withCodeLessThan(String code){
       return withCode(Operator.LESS_THAN, code);
    }

    public EventStatusTypeRequest<T> withCodeLessThanOrEqualTo(String code){
       return withCode(Operator.LESS_THAN_OR_EQUAL, code);
    }

    public EventStatusTypeRequest<T> withCodeBetween(String startOfCode, String endOfCode){
       return withCode(Operator.BETWEEN, startOfCode, endOfCode);
    }
    public EventStatusTypeRequest<T> withCodeStartingWith(String code){
       return withCode(Operator.BEGIN_WITH, code);
    }
    public EventStatusTypeRequest<T> withCodeContaining(String code){
       return withCode(Operator.CONTAIN, code);
    }

    public EventStatusTypeRequest<T> withCodeEndingWith(String code){
       return withCode(Operator.END_WITH, code);
    }

    public EventStatusTypeRequest<T> withCodeIs(String code){
       return withCode(Operator.EQUAL, code);
    }

    public EventStatusTypeRequest<T> withCodeSoundingLike(String code){
       return withCode(Operator.SOUNDS_LIKE, code);
    }



    public EventStatusTypeRequest<T> filterByPlatform(Platform... platform){
      if (platform == null || platform.length == 0) {
        throw new IllegalArgumentException("filterByPlatform parameter platform cannot be empty");
      }
      return appendSearchCriteria(createPlatformCriteria(Operator.EQUAL, (Object[])platform));
    }

    public EventStatusTypeRequest<T> withPlatform(Operator operator, Object... values){
       return appendSearchCriteria(createPlatformCriteria(operator, values));
    }

    public EventStatusTypeRequest<T> withPlatformIsUnknown(){
       return withPlatform(Operator.IS_NULL);
    }

    public EventStatusTypeRequest<T> withPlatformIsKnown(){
       return withPlatform(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPlatformCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(EventStatusType.PLATFORM_PROPERTY, operator, values);
    }

    public EventStatusTypeRequest<T> filterByPlatform(Long platform){
      if(platform == null){
         return this;
      }
      return withPlatform(Operator.EQUAL, platform);
    }
    public EventStatusTypeRequest<T> withPlatformMatching(PlatformRequest platform){
       return appendSearchCriteria(new SubQuerySearchCriteria(EventStatusType.PLATFORM_PROPERTY, platform, Platform.ID_PROPERTY));
    }

    public EventStatusTypeRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public EventStatusTypeRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public EventStatusTypeRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public EventStatusTypeRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(EventStatusType.VERSION_PROPERTY, operator, values);
    }

    public EventStatusTypeRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public EventStatusTypeRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public EventStatusTypeRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public EventStatusTypeRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public EventStatusTypeRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public EventStatusTypeRequest<T> withOutboxEventListMatching(OutboxEventRequest outboxEventRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(EventStatusType.ID_PROPERTY, outboxEventRequest, OutboxEvent.STATUS_PROPERTY));
    }

    public EventStatusTypeRequest<T> withoutOutboxEventListMatching(OutboxEventRequest outboxEventRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(EventStatusType.ID_PROPERTY, outboxEventRequest, OutboxEvent.STATUS_PROPERTY)));
    }

    public EventStatusTypeRequest<T> haveOutboxEvents(){
        return withOutboxEventListMatching(Q.outboxEvents().unlimited());
    }

    public EventStatusTypeRequest<T> haveNoOutboxEvents(){
        return withoutOutboxEventListMatching(Q.outboxEvents().unlimited());
    }

    public EventStatusTypeRequest<T> count(){
        super.count();
        return this;
    }
    public EventStatusTypeRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public EventStatusTypeRequest<T> groupByPlatformWithDetails(){
       return groupByPlatformWithDetails(Q.platforms().unlimited());
    }

    public EventStatusTypeRequest<T> groupByPlatformWithDetails(PlatformRequest subRequest){
       aggregate(EventStatusType.PLATFORM_PROPERTY, subRequest);
       return this;
    }


    public EventStatusTypeRequest<T> groupByOutboxEventsWithDetails(OutboxEventRequest subRequest){
       aggregate(EventStatusType.OUTBOX_EVENT_LIST_PROPERTY, subRequest);
       return this;
    }

    public EventStatusTypeRequest<T> groupById(){
       groupBy(EventStatusType.ID_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> groupByIdAs(String retName){
       groupBy(retName, EventStatusType.ID_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, EventStatusType.ID_PROPERTY, function);
       return this;
    }

    public EventStatusTypeRequest<T> groupByName(){
       groupBy(EventStatusType.NAME_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> groupByNameAs(String retName){
       groupBy(retName, EventStatusType.NAME_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, EventStatusType.NAME_PROPERTY, function);
       return this;
    }

    public EventStatusTypeRequest<T> groupByCode(){
       groupBy(EventStatusType.CODE_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> groupByCodeAs(String retName){
       groupBy(retName, EventStatusType.CODE_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> groupByCodeWithFunction(String retName, AggrFunction function){
       groupBy(retName, EventStatusType.CODE_PROPERTY, function);
       return this;
    }
    public EventStatusTypeRequest<T> groupByPlatformWith(PlatformRequest subRequest){
       groupBy(EventStatusType.PLATFORM_PROPERTY, subRequest);
       return this;
    }
    public EventStatusTypeRequest<T> groupByPlatform(){
       groupBy(EventStatusType.PLATFORM_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> groupByPlatformAs(String retName){
       groupBy(retName, EventStatusType.PLATFORM_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> groupByPlatformWithFunction(String retName, AggrFunction function){
       groupBy(retName, EventStatusType.PLATFORM_PROPERTY, function);
       return this;
    }

    public EventStatusTypeRequest<T> groupByVersion(){
       groupBy(EventStatusType.VERSION_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> groupByVersionAs(String retName){
       groupBy(retName, EventStatusType.VERSION_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, EventStatusType.VERSION_PROPERTY, function);
       return this;
    }



    public EventStatusTypeRequest<T> orderByIdAscending(){
       addOrderByAscending(EventStatusType.ID_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> orderByIdDescending(){
       addOrderByDescending(EventStatusType.ID_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> orderByNameAscending(){
       addOrderByAscending(EventStatusType.NAME_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> orderByNameDescending(){
       addOrderByDescending(EventStatusType.NAME_PROPERTY);
       return this;
    }
    public EventStatusTypeRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(EventStatusType.NAME_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(EventStatusType.NAME_PROPERTY);
       return this;
    }
    public EventStatusTypeRequest<T> orderByCodeAscending(){
       addOrderByAscending(EventStatusType.CODE_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> orderByCodeDescending(){
       addOrderByDescending(EventStatusType.CODE_PROPERTY);
       return this;
    }
    public EventStatusTypeRequest<T> orderByCodeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(EventStatusType.CODE_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> orderByCodeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(EventStatusType.CODE_PROPERTY);
       return this;
    }
    public EventStatusTypeRequest<T> orderByPlatformAscending(){
       addOrderByAscending(EventStatusType.PLATFORM_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> orderByPlatformDescending(){
       addOrderByDescending(EventStatusType.PLATFORM_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> orderByVersionAscending(){
       addOrderByAscending(EventStatusType.VERSION_PROPERTY);
       return this;
    }

    public EventStatusTypeRequest<T> orderByVersionDescending(){
       addOrderByDescending(EventStatusType.VERSION_PROPERTY);
       return this;
    }


    public EventStatusTypeRequest<T> statsFromOutboxEventsAs(String name, OutboxEventRequest subRequest){
       return statsFromOutboxEventsAs(name, subRequest, false);
    }

    public EventStatusTypeRequest<T> statsFromOutboxEventsAs(String name, OutboxEventRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(OutboxEvent.STATUS_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public EventStatusTypeRequest<T> statsFromOutboxEvents(OutboxEventRequest subRequest){
       return statsFromOutboxEventsAs(REFINEMENTS, subRequest);
    }
    public PlatformRequest rollUpToPlatform(){
       PlatformRequest platform = Q.platforms().unlimited();
       this.withPlatformMatching(platform)
           .groupByPlatformWith(platform);
       return platform;
    }


    public EventStatusTypeRequest<T> countOutboxEvents(){
        return countOutboxEventsAs("Count");
    }

    public EventStatusTypeRequest<T> countOutboxEventsAs(String name){
        return countOutboxEventsWith(name, Q.outboxEvents().unlimited());
    }

    public EventStatusTypeRequest<T> countOutboxEventsWith(String name, OutboxEventRequest subRequest){
        return statsFromOutboxEventsAs(name, subRequest.count(), true);
    }

   public EventStatusTypeRequest<T> facetByPlatformAs(String facetName, PlatformRequest platform){
       return facetByPlatformAs(facetName, platform, true);
   }

   public EventStatusTypeRequest<T> facetByPlatformAs(String facetName, PlatformRequest platform, boolean includeAllFacets){
       addFacet(facetName, EventStatusType.PLATFORM_PROPERTY, platform, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public EventStatusTypeRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public EventStatusTypeRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public EventStatusTypeRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public EventStatusTypeRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public EventStatusTypeRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}