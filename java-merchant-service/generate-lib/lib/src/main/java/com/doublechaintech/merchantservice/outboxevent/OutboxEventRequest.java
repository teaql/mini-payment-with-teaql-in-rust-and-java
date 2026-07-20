package com.doublechaintech.merchantservice.outboxevent;

import com.doublechaintech.merchantservice.Q;
import com.doublechaintech.merchantservice.eventstatustype.EventStatusType;
import com.doublechaintech.merchantservice.eventstatustype.EventStatusTypeRequest;
import com.doublechaintech.merchantservice.merchant.Merchant;
import com.doublechaintech.merchantservice.merchant.MerchantRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class OutboxEventRequest<T extends OutboxEvent> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public OutboxEventRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public OutboxEventRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public OutboxEventRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public OutboxEventRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public OutboxEventRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public OutboxEventRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public OutboxEventRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (OutboxEventRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public OutboxEventRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public OutboxEventRequest<T> matchingAnyOf(OutboxEventRequest outboxEvent){
        super.internalMatchAny(outboxEvent);
        return this;
    }

    public OutboxEventRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public OutboxEventRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public OutboxEventRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public OutboxEventRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectEventType().selectPayload().selectStatusIdOnly().selectMerchantIdOnly().selectCreateTime().selectUpdateTime().selectProcessedAt().selectVersion();
    }

    public OutboxEventRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public OutboxEventRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectEventType().selectPayload().selectStatus().selectMerchant().selectCreateTime().selectUpdateTime().selectProcessedAt().selectVersion();
    }

    public OutboxEventRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectEventType().selectPayload().selectStatus().selectMerchant().selectCreateTime().selectUpdateTime().selectProcessedAt().selectVersion();
    }


    public OutboxEventRequest<T> selectId(){
       selectProperty(OutboxEvent.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OutboxEventRequest<T> unselectId(){
       unselectProperty(OutboxEvent.ID_PROPERTY);
       return this;
    }
    public OutboxEventRequest<T> selectEventType(){
       selectProperty(OutboxEvent.EVENT_TYPE_PROPERTY);
       return this;
    }

    /**
     * fill the eventType with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  eventType) to fetch eventType property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OutboxEventRequest<T> unselectEventType(){
       unselectProperty(OutboxEvent.EVENT_TYPE_PROPERTY);
       return this;
    }
    public OutboxEventRequest<T> selectPayload(){
       selectProperty(OutboxEvent.PAYLOAD_PROPERTY);
       return this;
    }

    /**
     * fill the payload with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  payload) to fetch payload property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OutboxEventRequest<T> unselectPayload(){
       unselectProperty(OutboxEvent.PAYLOAD_PROPERTY);
       return this;
    }
    public OutboxEventRequest<T> selectStatusIdOnly(){
       selectProperty(OutboxEvent.STATUS_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> selectStatus(){
        return selectStatusWith(Q.eventStatusTypes().unlimited().selectSelf());
    }

    public OutboxEventRequest<T> selectStatusWith(EventStatusTypeRequest status){
       selectProperty(OutboxEvent.STATUS_PROPERTY);
       enhanceRelation(OutboxEvent.STATUS_PROPERTY, status);
       return this;
    }

    public OutboxEventRequest<T> unselectStatus(){
       unselectProperty(OutboxEvent.STATUS_PROPERTY);
       return this;
    }
    public OutboxEventRequest<T> selectMerchantIdOnly(){
       selectProperty(OutboxEvent.MERCHANT_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> selectMerchant(){
        return selectMerchantWith(Q.merchants().unlimited().selectSelf());
    }

    public OutboxEventRequest<T> selectMerchantWith(MerchantRequest merchant){
       selectProperty(OutboxEvent.MERCHANT_PROPERTY);
       enhanceRelation(OutboxEvent.MERCHANT_PROPERTY, merchant);
       return this;
    }

    public OutboxEventRequest<T> unselectMerchant(){
       unselectProperty(OutboxEvent.MERCHANT_PROPERTY);
       return this;
    }
    public OutboxEventRequest<T> selectCreateTime(){
       selectProperty(OutboxEvent.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OutboxEventRequest<T> unselectCreateTime(){
       unselectProperty(OutboxEvent.CREATE_TIME_PROPERTY);
       return this;
    }
    public OutboxEventRequest<T> selectUpdateTime(){
       selectProperty(OutboxEvent.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OutboxEventRequest<T> unselectUpdateTime(){
       unselectProperty(OutboxEvent.UPDATE_TIME_PROPERTY);
       return this;
    }
    public OutboxEventRequest<T> selectProcessedAt(){
       selectProperty(OutboxEvent.PROCESSED_AT_PROPERTY);
       return this;
    }

    /**
     * fill the processedAt with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  processedAt) to fetch processedAt property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OutboxEventRequest<T> unselectProcessedAt(){
       unselectProperty(OutboxEvent.PROCESSED_AT_PROPERTY);
       return this;
    }
    public OutboxEventRequest<T> selectVersion(){
       selectProperty(OutboxEvent.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OutboxEventRequest<T> unselectVersion(){
       unselectProperty(OutboxEvent.VERSION_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OutboxEvent.ID_PROPERTY, operator, values);
    }

    public OutboxEventRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public OutboxEventRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public OutboxEventRequest<T> filterByEventType(String... eventType){
      if (eventType == null || eventType.length == 0) {
        throw new IllegalArgumentException("filterByEventType parameter eventType cannot be empty");
      }
      return appendSearchCriteria(createEventTypeCriteria(Operator.EQUAL, (Object[])eventType));
    }

    public OutboxEventRequest<T> withEventType(Operator operator, Object... values){
       return appendSearchCriteria(createEventTypeCriteria(operator, values));
    }

    public OutboxEventRequest<T> withEventTypeIsUnknown(){
       return withEventType(Operator.IS_NULL);
    }

    public OutboxEventRequest<T> withEventTypeIsKnown(){
       return withEventType(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEventTypeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OutboxEvent.EVENT_TYPE_PROPERTY, operator, values);
    }

    public OutboxEventRequest<T> withEventTypeGreaterThan(String eventType){
       return withEventType(Operator.GREATER_THAN, eventType);
    }

    public OutboxEventRequest<T> withEventTypeGreaterThanOrEqualTo(String eventType){
       return withEventType(Operator.GREATER_THAN_OR_EQUAL, eventType);
    }

    public OutboxEventRequest<T> withEventTypeLessThan(String eventType){
       return withEventType(Operator.LESS_THAN, eventType);
    }

    public OutboxEventRequest<T> withEventTypeLessThanOrEqualTo(String eventType){
       return withEventType(Operator.LESS_THAN_OR_EQUAL, eventType);
    }

    public OutboxEventRequest<T> withEventTypeBetween(String startOfEventType, String endOfEventType){
       return withEventType(Operator.BETWEEN, startOfEventType, endOfEventType);
    }
    public OutboxEventRequest<T> withEventTypeStartingWith(String eventType){
       return withEventType(Operator.BEGIN_WITH, eventType);
    }
    public OutboxEventRequest<T> withEventTypeContaining(String eventType){
       return withEventType(Operator.CONTAIN, eventType);
    }

    public OutboxEventRequest<T> withEventTypeEndingWith(String eventType){
       return withEventType(Operator.END_WITH, eventType);
    }

    public OutboxEventRequest<T> withEventTypeIs(String eventType){
       return withEventType(Operator.EQUAL, eventType);
    }

    public OutboxEventRequest<T> withEventTypeSoundingLike(String eventType){
       return withEventType(Operator.SOUNDS_LIKE, eventType);
    }



    public OutboxEventRequest<T> filterByPayload(String... payload){
      if (payload == null || payload.length == 0) {
        throw new IllegalArgumentException("filterByPayload parameter payload cannot be empty");
      }
      return appendSearchCriteria(createPayloadCriteria(Operator.EQUAL, (Object[])payload));
    }

    public OutboxEventRequest<T> withPayload(Operator operator, Object... values){
       return appendSearchCriteria(createPayloadCriteria(operator, values));
    }

    public OutboxEventRequest<T> withPayloadIsUnknown(){
       return withPayload(Operator.IS_NULL);
    }

    public OutboxEventRequest<T> withPayloadIsKnown(){
       return withPayload(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPayloadCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OutboxEvent.PAYLOAD_PROPERTY, operator, values);
    }

    public OutboxEventRequest<T> withPayloadGreaterThan(String payload){
       return withPayload(Operator.GREATER_THAN, payload);
    }

    public OutboxEventRequest<T> withPayloadGreaterThanOrEqualTo(String payload){
       return withPayload(Operator.GREATER_THAN_OR_EQUAL, payload);
    }

    public OutboxEventRequest<T> withPayloadLessThan(String payload){
       return withPayload(Operator.LESS_THAN, payload);
    }

    public OutboxEventRequest<T> withPayloadLessThanOrEqualTo(String payload){
       return withPayload(Operator.LESS_THAN_OR_EQUAL, payload);
    }

    public OutboxEventRequest<T> withPayloadBetween(String startOfPayload, String endOfPayload){
       return withPayload(Operator.BETWEEN, startOfPayload, endOfPayload);
    }
    public OutboxEventRequest<T> withPayloadStartingWith(String payload){
       return withPayload(Operator.BEGIN_WITH, payload);
    }
    public OutboxEventRequest<T> withPayloadContaining(String payload){
       return withPayload(Operator.CONTAIN, payload);
    }

    public OutboxEventRequest<T> withPayloadEndingWith(String payload){
       return withPayload(Operator.END_WITH, payload);
    }

    public OutboxEventRequest<T> withPayloadIs(String payload){
       return withPayload(Operator.EQUAL, payload);
    }

    public OutboxEventRequest<T> withPayloadSoundingLike(String payload){
       return withPayload(Operator.SOUNDS_LIKE, payload);
    }



    public OutboxEventRequest<T> filterByStatus(EventStatusType... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public OutboxEventRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public OutboxEventRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public OutboxEventRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OutboxEvent.STATUS_PROPERTY, operator, values);
    }

    public OutboxEventRequest<T> filterByStatus(Long status){
      if(status == null){
         return this;
      }
      return withStatus(Operator.EQUAL, status);
    }
    public OutboxEventRequest<T> withStatusMatching(EventStatusTypeRequest status){
       return appendSearchCriteria(new SubQuerySearchCriteria(OutboxEvent.STATUS_PROPERTY, status, EventStatusType.ID_PROPERTY));
    }

    public OutboxEventRequest<T> filterByMerchant(Merchant... merchant){
      if (merchant == null || merchant.length == 0) {
        throw new IllegalArgumentException("filterByMerchant parameter merchant cannot be empty");
      }
      return appendSearchCriteria(createMerchantCriteria(Operator.EQUAL, (Object[])merchant));
    }

    public OutboxEventRequest<T> withMerchant(Operator operator, Object... values){
       return appendSearchCriteria(createMerchantCriteria(operator, values));
    }

    public OutboxEventRequest<T> withMerchantIsUnknown(){
       return withMerchant(Operator.IS_NULL);
    }

    public OutboxEventRequest<T> withMerchantIsKnown(){
       return withMerchant(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createMerchantCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OutboxEvent.MERCHANT_PROPERTY, operator, values);
    }

    public OutboxEventRequest<T> filterByMerchant(Long merchant){
      if(merchant == null){
         return this;
      }
      return withMerchant(Operator.EQUAL, merchant);
    }
    public OutboxEventRequest<T> withMerchantMatching(MerchantRequest merchant){
       return appendSearchCriteria(new SubQuerySearchCriteria(OutboxEvent.MERCHANT_PROPERTY, merchant, Merchant.ID_PROPERTY));
    }

    public OutboxEventRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public OutboxEventRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public OutboxEventRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public OutboxEventRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OutboxEvent.CREATE_TIME_PROPERTY, operator, values);
    }

    public OutboxEventRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public OutboxEventRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public OutboxEventRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public OutboxEventRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public OutboxEventRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public OutboxEventRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public OutboxEventRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public OutboxEventRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public OutboxEventRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public OutboxEventRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public OutboxEventRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public OutboxEventRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public OutboxEventRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public OutboxEventRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OutboxEvent.UPDATE_TIME_PROPERTY, operator, values);
    }

    public OutboxEventRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public OutboxEventRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public OutboxEventRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public OutboxEventRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public OutboxEventRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public OutboxEventRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public OutboxEventRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public OutboxEventRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public OutboxEventRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public OutboxEventRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public OutboxEventRequest<T> filterByProcessedAt(LocalDateTime... processedAt){
      if (processedAt == null || processedAt.length == 0) {
        throw new IllegalArgumentException("filterByProcessedAt parameter processedAt cannot be empty");
      }
      return appendSearchCriteria(createProcessedAtCriteria(Operator.EQUAL, (Object[])processedAt));
    }

    public OutboxEventRequest<T> withProcessedAt(Operator operator, Object... values){
       return appendSearchCriteria(createProcessedAtCriteria(operator, values));
    }

    public OutboxEventRequest<T> withProcessedAtIsUnknown(){
       return withProcessedAt(Operator.IS_NULL);
    }

    public OutboxEventRequest<T> withProcessedAtIsKnown(){
       return withProcessedAt(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createProcessedAtCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OutboxEvent.PROCESSED_AT_PROPERTY, operator, values);
    }

    public OutboxEventRequest<T> withProcessedAtGreaterThan(LocalDateTime processedAt){
       return withProcessedAt(Operator.GREATER_THAN, processedAt);
    }

    public OutboxEventRequest<T> withProcessedAtGreaterThanOrEqualTo(LocalDateTime processedAt){
       return withProcessedAt(Operator.GREATER_THAN_OR_EQUAL, processedAt);
    }

    public OutboxEventRequest<T> withProcessedAtLessThan(LocalDateTime processedAt){
       return withProcessedAt(Operator.LESS_THAN, processedAt);
    }

    public OutboxEventRequest<T> withProcessedAtLessThanOrEqualTo(LocalDateTime processedAt){
       return withProcessedAt(Operator.LESS_THAN_OR_EQUAL, processedAt);
    }

    public OutboxEventRequest<T> withProcessedAtBetween(LocalDateTime startOfProcessedAt, LocalDateTime endOfProcessedAt){
       return withProcessedAt(Operator.BETWEEN, startOfProcessedAt, endOfProcessedAt);
    }
    public OutboxEventRequest<T> withProcessedAtBefore(LocalDateTime processedAt){
       return withProcessedAt(Operator.LESS_THAN, processedAt);
    }

    public OutboxEventRequest<T> withProcessedAtBefore(Date processedAt){
       return withProcessedAt(Operator.LESS_THAN, processedAt);
    }

    public OutboxEventRequest<T> withProcessedAtAfter(LocalDateTime processedAt){
       return withProcessedAt(Operator.GREATER_THAN, processedAt);
    }

    public OutboxEventRequest<T> withProcessedAtAfter(Date processedAt){
       return withProcessedAt(Operator.GREATER_THAN, processedAt);
    }

    public OutboxEventRequest<T> withProcessedAtBetween(Date startOfProcessedAt, Date endOfProcessedAt){
       return withProcessedAt(Operator.BETWEEN, startOfProcessedAt, endOfProcessedAt);
    }




    public OutboxEventRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public OutboxEventRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public OutboxEventRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public OutboxEventRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OutboxEvent.VERSION_PROPERTY, operator, values);
    }

    public OutboxEventRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public OutboxEventRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public OutboxEventRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public OutboxEventRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public OutboxEventRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public OutboxEventRequest<T> count(){
        super.count();
        return this;
    }
    public OutboxEventRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public OutboxEventRequest<T> groupByStatusWithDetails(){
       return groupByStatusWithDetails(Q.eventStatusTypes().unlimited());
    }

    public OutboxEventRequest<T> groupByStatusWithDetails(EventStatusTypeRequest subRequest){
       aggregate(OutboxEvent.STATUS_PROPERTY, subRequest);
       return this;
    }

    public OutboxEventRequest<T> groupByMerchantWithDetails(){
       return groupByMerchantWithDetails(Q.merchants().unlimited());
    }

    public OutboxEventRequest<T> groupByMerchantWithDetails(MerchantRequest subRequest){
       aggregate(OutboxEvent.MERCHANT_PROPERTY, subRequest);
       return this;
    }






    public OutboxEventRequest<T> groupById(){
       groupBy(OutboxEvent.ID_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByIdAs(String retName){
       groupBy(retName, OutboxEvent.ID_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, OutboxEvent.ID_PROPERTY, function);
       return this;
    }

    public OutboxEventRequest<T> groupByEventType(){
       groupBy(OutboxEvent.EVENT_TYPE_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByEventTypeAs(String retName){
       groupBy(retName, OutboxEvent.EVENT_TYPE_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByEventTypeWithFunction(String retName, AggrFunction function){
       groupBy(retName, OutboxEvent.EVENT_TYPE_PROPERTY, function);
       return this;
    }

    public OutboxEventRequest<T> groupByPayload(){
       groupBy(OutboxEvent.PAYLOAD_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByPayloadAs(String retName){
       groupBy(retName, OutboxEvent.PAYLOAD_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByPayloadWithFunction(String retName, AggrFunction function){
       groupBy(retName, OutboxEvent.PAYLOAD_PROPERTY, function);
       return this;
    }
    public OutboxEventRequest<T> groupByStatusWith(EventStatusTypeRequest subRequest){
       groupBy(OutboxEvent.STATUS_PROPERTY, subRequest);
       return this;
    }
    public OutboxEventRequest<T> groupByStatus(){
       groupBy(OutboxEvent.STATUS_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByStatusAs(String retName){
       groupBy(retName, OutboxEvent.STATUS_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, OutboxEvent.STATUS_PROPERTY, function);
       return this;
    }
    public OutboxEventRequest<T> groupByMerchantWith(MerchantRequest subRequest){
       groupBy(OutboxEvent.MERCHANT_PROPERTY, subRequest);
       return this;
    }
    public OutboxEventRequest<T> groupByMerchant(){
       groupBy(OutboxEvent.MERCHANT_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByMerchantAs(String retName){
       groupBy(retName, OutboxEvent.MERCHANT_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByMerchantWithFunction(String retName, AggrFunction function){
       groupBy(retName, OutboxEvent.MERCHANT_PROPERTY, function);
       return this;
    }

    public OutboxEventRequest<T> groupByCreateTime(){
       groupBy(OutboxEvent.CREATE_TIME_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, OutboxEvent.CREATE_TIME_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, OutboxEvent.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public OutboxEventRequest<T> groupByUpdateTime(){
       groupBy(OutboxEvent.UPDATE_TIME_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, OutboxEvent.UPDATE_TIME_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, OutboxEvent.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public OutboxEventRequest<T> groupByProcessedAt(){
       groupBy(OutboxEvent.PROCESSED_AT_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByProcessedAtAs(String retName){
       groupBy(retName, OutboxEvent.PROCESSED_AT_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByProcessedAtWithFunction(String retName, AggrFunction function){
       groupBy(retName, OutboxEvent.PROCESSED_AT_PROPERTY, function);
       return this;
    }

    public OutboxEventRequest<T> groupByVersion(){
       groupBy(OutboxEvent.VERSION_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByVersionAs(String retName){
       groupBy(retName, OutboxEvent.VERSION_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, OutboxEvent.VERSION_PROPERTY, function);
       return this;
    }

    public OutboxEventRequest<T> withStatusIsPending(){
       filterByStatus(com.doublechaintech.merchantservice.Constants.EVENT_STATUS_TYPE_PENDING);
       return this;
    }


    public OutboxEventRequest<T> withStatusIsProcessed(){
       filterByStatus(com.doublechaintech.merchantservice.Constants.EVENT_STATUS_TYPE_PROCESSED);
       return this;
    }


    public OutboxEventRequest<T> withStatusIsFailed(){
       filterByStatus(com.doublechaintech.merchantservice.Constants.EVENT_STATUS_TYPE_FAILED);
       return this;
    }




    public OutboxEventRequest<T> orderByIdAscending(){
       addOrderByAscending(OutboxEvent.ID_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByIdDescending(){
       addOrderByDescending(OutboxEvent.ID_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByEventTypeAscending(){
       addOrderByAscending(OutboxEvent.EVENT_TYPE_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByEventTypeDescending(){
       addOrderByDescending(OutboxEvent.EVENT_TYPE_PROPERTY);
       return this;
    }
    public OutboxEventRequest<T> orderByEventTypeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(OutboxEvent.EVENT_TYPE_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByEventTypeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(OutboxEvent.EVENT_TYPE_PROPERTY);
       return this;
    }
    public OutboxEventRequest<T> orderByPayloadAscending(){
       addOrderByAscending(OutboxEvent.PAYLOAD_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByPayloadDescending(){
       addOrderByDescending(OutboxEvent.PAYLOAD_PROPERTY);
       return this;
    }
    public OutboxEventRequest<T> orderByPayloadAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(OutboxEvent.PAYLOAD_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByPayloadDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(OutboxEvent.PAYLOAD_PROPERTY);
       return this;
    }
    public OutboxEventRequest<T> orderByStatusAscending(){
       addOrderByAscending(OutboxEvent.STATUS_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByStatusDescending(){
       addOrderByDescending(OutboxEvent.STATUS_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByMerchantAscending(){
       addOrderByAscending(OutboxEvent.MERCHANT_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByMerchantDescending(){
       addOrderByDescending(OutboxEvent.MERCHANT_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(OutboxEvent.CREATE_TIME_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(OutboxEvent.CREATE_TIME_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(OutboxEvent.UPDATE_TIME_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(OutboxEvent.UPDATE_TIME_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByProcessedAtAscending(){
       addOrderByAscending(OutboxEvent.PROCESSED_AT_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByProcessedAtDescending(){
       addOrderByDescending(OutboxEvent.PROCESSED_AT_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByVersionAscending(){
       addOrderByAscending(OutboxEvent.VERSION_PROPERTY);
       return this;
    }

    public OutboxEventRequest<T> orderByVersionDescending(){
       addOrderByDescending(OutboxEvent.VERSION_PROPERTY);
       return this;
    }


    public EventStatusTypeRequest rollUpToStatus(){
       EventStatusTypeRequest status = Q.eventStatusTypes().unlimited();
       this.withStatusMatching(status)
           .groupByStatusWith(status);
       return status;
    }

    public MerchantRequest rollUpToMerchant(){
       MerchantRequest merchant = Q.merchants().unlimited();
       this.withMerchantMatching(merchant)
           .groupByMerchantWith(merchant);
       return merchant;
    }






   public OutboxEventRequest<T> facetByStatusAs(String facetName, EventStatusTypeRequest status){
       return facetByStatusAs(facetName, status, true);
   }

   public OutboxEventRequest<T> facetByStatusAs(String facetName, EventStatusTypeRequest status, boolean includeAllFacets){
       addFacet(facetName, OutboxEvent.STATUS_PROPERTY, status, includeAllFacets);
       return this;
   }
   public OutboxEventRequest<T> facetByMerchantAs(String facetName, MerchantRequest merchant){
       return facetByMerchantAs(facetName, merchant, true);
   }

   public OutboxEventRequest<T> facetByMerchantAs(String facetName, MerchantRequest merchant, boolean includeAllFacets){
       addFacet(facetName, OutboxEvent.MERCHANT_PROPERTY, merchant, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public OutboxEventRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public OutboxEventRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public OutboxEventRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public OutboxEventRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public OutboxEventRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}