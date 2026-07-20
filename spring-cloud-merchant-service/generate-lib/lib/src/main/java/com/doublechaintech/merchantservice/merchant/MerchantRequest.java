package com.doublechaintech.merchantservice.merchant;

import com.doublechaintech.merchantservice.Q;
import com.doublechaintech.merchantservice.merchantkyc.MerchantKyc;
import com.doublechaintech.merchantservice.merchantkyc.MerchantKycRequest;
import com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType;
import com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusTypeRequest;
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
import java.time.LocalDateTime;
import java.util.Date;

public class MerchantRequest<T extends Merchant> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public MerchantRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public MerchantRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public MerchantRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public MerchantRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public MerchantRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public MerchantRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public MerchantRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (MerchantRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public MerchantRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public MerchantRequest<T> matchingAnyOf(MerchantRequest merchant){
        super.internalMatchAny(merchant);
        return this;
    }

    public MerchantRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public MerchantRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public MerchantRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public MerchantRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectCompanyName().selectContactEmail().selectAppKey().selectStatusIdOnly().selectPlatformIdOnly().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public MerchantRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public MerchantRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectCompanyName().selectContactEmail().selectAppKey().selectStatus().selectPlatform().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public MerchantRequest<T> selectChildren(){
        super.selectAny();
        selectMerchantKycList().selectOutboxEventList();
        return selectId().selectCompanyName().selectContactEmail().selectAppKey().selectStatus().selectPlatform().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public MerchantRequest<T> selectId(){
       selectProperty(Merchant.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantRequest<T> unselectId(){
       unselectProperty(Merchant.ID_PROPERTY);
       return this;
    }
    public MerchantRequest<T> selectCompanyName(){
       selectProperty(Merchant.COMPANY_NAME_PROPERTY);
       return this;
    }

    /**
     * fill the companyName with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  companyName) to fetch companyName property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantRequest<T> unselectCompanyName(){
       unselectProperty(Merchant.COMPANY_NAME_PROPERTY);
       return this;
    }
    public MerchantRequest<T> selectContactEmail(){
       selectProperty(Merchant.CONTACT_EMAIL_PROPERTY);
       return this;
    }

    /**
     * fill the contactEmail with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  contactEmail) to fetch contactEmail property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantRequest<T> unselectContactEmail(){
       unselectProperty(Merchant.CONTACT_EMAIL_PROPERTY);
       return this;
    }
    public MerchantRequest<T> selectAppKey(){
       selectProperty(Merchant.APP_KEY_PROPERTY);
       return this;
    }

    /**
     * fill the appKey with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  appKey) to fetch appKey property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantRequest<T> unselectAppKey(){
       unselectProperty(Merchant.APP_KEY_PROPERTY);
       return this;
    }
    public MerchantRequest<T> selectStatusIdOnly(){
       selectProperty(Merchant.STATUS_PROPERTY);
       return this;
    }

    public MerchantRequest<T> selectStatus(){
        return selectStatusWith(Q.merchantStatusTypes().unlimited().selectSelf());
    }

    public MerchantRequest<T> selectStatusWith(MerchantStatusTypeRequest status){
       selectProperty(Merchant.STATUS_PROPERTY);
       enhanceRelation(Merchant.STATUS_PROPERTY, status);
       return this;
    }

    public MerchantRequest<T> unselectStatus(){
       unselectProperty(Merchant.STATUS_PROPERTY);
       return this;
    }
    public MerchantRequest<T> selectPlatformIdOnly(){
       selectProperty(Merchant.PLATFORM_PROPERTY);
       return this;
    }

    public MerchantRequest<T> selectPlatform(){
        return selectPlatformWith(Q.platforms().unlimited().selectSelf());
    }

    public MerchantRequest<T> selectPlatformWith(PlatformRequest platform){
       selectProperty(Merchant.PLATFORM_PROPERTY);
       enhanceRelation(Merchant.PLATFORM_PROPERTY, platform);
       return this;
    }

    public MerchantRequest<T> unselectPlatform(){
       unselectProperty(Merchant.PLATFORM_PROPERTY);
       return this;
    }
    public MerchantRequest<T> selectCreateTime(){
       selectProperty(Merchant.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantRequest<T> unselectCreateTime(){
       unselectProperty(Merchant.CREATE_TIME_PROPERTY);
       return this;
    }
    public MerchantRequest<T> selectUpdateTime(){
       selectProperty(Merchant.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantRequest<T> unselectUpdateTime(){
       unselectProperty(Merchant.UPDATE_TIME_PROPERTY);
       return this;
    }
    public MerchantRequest<T> selectVersion(){
       selectProperty(Merchant.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantRequest<T> unselectVersion(){
       unselectProperty(Merchant.VERSION_PROPERTY);
       return this;
    }
    public MerchantRequest<T> selectMerchantKycList(){
       return selectMerchantKycListWith(Q.merchantKycs().selectSelf());
    }

    public MerchantRequest<T> selectMerchantKycListWith(MerchantKycRequest merchantKycList){
       enhanceRelation(Merchant.MERCHANT_KYC_LIST_PROPERTY, merchantKycList);
       return this;
    }
    public MerchantRequest<T> selectOutboxEventList(){
       return selectOutboxEventListWith(Q.outboxEvents().selectSelf());
    }

    public MerchantRequest<T> selectOutboxEventListWith(OutboxEventRequest outboxEventList){
       enhanceRelation(Merchant.OUTBOX_EVENT_LIST_PROPERTY, outboxEventList);
       return this;
    }

    public MerchantRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Merchant.ID_PROPERTY, operator, values);
    }

    public MerchantRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public MerchantRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public MerchantRequest<T> filterByCompanyName(String... companyName){
      if (companyName == null || companyName.length == 0) {
        throw new IllegalArgumentException("filterByCompanyName parameter companyName cannot be empty");
      }
      return appendSearchCriteria(createCompanyNameCriteria(Operator.EQUAL, (Object[])companyName));
    }

    public MerchantRequest<T> withCompanyName(Operator operator, Object... values){
       return appendSearchCriteria(createCompanyNameCriteria(operator, values));
    }

    public MerchantRequest<T> withCompanyNameIsUnknown(){
       return withCompanyName(Operator.IS_NULL);
    }

    public MerchantRequest<T> withCompanyNameIsKnown(){
       return withCompanyName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCompanyNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Merchant.COMPANY_NAME_PROPERTY, operator, values);
    }

    public MerchantRequest<T> withCompanyNameGreaterThan(String companyName){
       return withCompanyName(Operator.GREATER_THAN, companyName);
    }

    public MerchantRequest<T> withCompanyNameGreaterThanOrEqualTo(String companyName){
       return withCompanyName(Operator.GREATER_THAN_OR_EQUAL, companyName);
    }

    public MerchantRequest<T> withCompanyNameLessThan(String companyName){
       return withCompanyName(Operator.LESS_THAN, companyName);
    }

    public MerchantRequest<T> withCompanyNameLessThanOrEqualTo(String companyName){
       return withCompanyName(Operator.LESS_THAN_OR_EQUAL, companyName);
    }

    public MerchantRequest<T> withCompanyNameBetween(String startOfCompanyName, String endOfCompanyName){
       return withCompanyName(Operator.BETWEEN, startOfCompanyName, endOfCompanyName);
    }
    public MerchantRequest<T> withCompanyNameStartingWith(String companyName){
       return withCompanyName(Operator.BEGIN_WITH, companyName);
    }
    public MerchantRequest<T> withCompanyNameContaining(String companyName){
       return withCompanyName(Operator.CONTAIN, companyName);
    }

    public MerchantRequest<T> withCompanyNameEndingWith(String companyName){
       return withCompanyName(Operator.END_WITH, companyName);
    }

    public MerchantRequest<T> withCompanyNameIs(String companyName){
       return withCompanyName(Operator.EQUAL, companyName);
    }

    public MerchantRequest<T> withCompanyNameSoundingLike(String companyName){
       return withCompanyName(Operator.SOUNDS_LIKE, companyName);
    }



    public MerchantRequest<T> filterByContactEmail(String... contactEmail){
      if (contactEmail == null || contactEmail.length == 0) {
        throw new IllegalArgumentException("filterByContactEmail parameter contactEmail cannot be empty");
      }
      return appendSearchCriteria(createContactEmailCriteria(Operator.EQUAL, (Object[])contactEmail));
    }

    public MerchantRequest<T> withContactEmail(Operator operator, Object... values){
       return appendSearchCriteria(createContactEmailCriteria(operator, values));
    }

    public MerchantRequest<T> withContactEmailIsUnknown(){
       return withContactEmail(Operator.IS_NULL);
    }

    public MerchantRequest<T> withContactEmailIsKnown(){
       return withContactEmail(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createContactEmailCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Merchant.CONTACT_EMAIL_PROPERTY, operator, values);
    }

    public MerchantRequest<T> withContactEmailGreaterThan(String contactEmail){
       return withContactEmail(Operator.GREATER_THAN, contactEmail);
    }

    public MerchantRequest<T> withContactEmailGreaterThanOrEqualTo(String contactEmail){
       return withContactEmail(Operator.GREATER_THAN_OR_EQUAL, contactEmail);
    }

    public MerchantRequest<T> withContactEmailLessThan(String contactEmail){
       return withContactEmail(Operator.LESS_THAN, contactEmail);
    }

    public MerchantRequest<T> withContactEmailLessThanOrEqualTo(String contactEmail){
       return withContactEmail(Operator.LESS_THAN_OR_EQUAL, contactEmail);
    }

    public MerchantRequest<T> withContactEmailBetween(String startOfContactEmail, String endOfContactEmail){
       return withContactEmail(Operator.BETWEEN, startOfContactEmail, endOfContactEmail);
    }
    public MerchantRequest<T> withContactEmailStartingWith(String contactEmail){
       return withContactEmail(Operator.BEGIN_WITH, contactEmail);
    }
    public MerchantRequest<T> withContactEmailContaining(String contactEmail){
       return withContactEmail(Operator.CONTAIN, contactEmail);
    }

    public MerchantRequest<T> withContactEmailEndingWith(String contactEmail){
       return withContactEmail(Operator.END_WITH, contactEmail);
    }

    public MerchantRequest<T> withContactEmailIs(String contactEmail){
       return withContactEmail(Operator.EQUAL, contactEmail);
    }

    public MerchantRequest<T> withContactEmailSoundingLike(String contactEmail){
       return withContactEmail(Operator.SOUNDS_LIKE, contactEmail);
    }



    public MerchantRequest<T> filterByAppKey(String... appKey){
      if (appKey == null || appKey.length == 0) {
        throw new IllegalArgumentException("filterByAppKey parameter appKey cannot be empty");
      }
      return appendSearchCriteria(createAppKeyCriteria(Operator.EQUAL, (Object[])appKey));
    }

    public MerchantRequest<T> withAppKey(Operator operator, Object... values){
       return appendSearchCriteria(createAppKeyCriteria(operator, values));
    }

    public MerchantRequest<T> withAppKeyIsUnknown(){
       return withAppKey(Operator.IS_NULL);
    }

    public MerchantRequest<T> withAppKeyIsKnown(){
       return withAppKey(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAppKeyCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Merchant.APP_KEY_PROPERTY, operator, values);
    }

    public MerchantRequest<T> withAppKeyGreaterThan(String appKey){
       return withAppKey(Operator.GREATER_THAN, appKey);
    }

    public MerchantRequest<T> withAppKeyGreaterThanOrEqualTo(String appKey){
       return withAppKey(Operator.GREATER_THAN_OR_EQUAL, appKey);
    }

    public MerchantRequest<T> withAppKeyLessThan(String appKey){
       return withAppKey(Operator.LESS_THAN, appKey);
    }

    public MerchantRequest<T> withAppKeyLessThanOrEqualTo(String appKey){
       return withAppKey(Operator.LESS_THAN_OR_EQUAL, appKey);
    }

    public MerchantRequest<T> withAppKeyBetween(String startOfAppKey, String endOfAppKey){
       return withAppKey(Operator.BETWEEN, startOfAppKey, endOfAppKey);
    }
    public MerchantRequest<T> withAppKeyStartingWith(String appKey){
       return withAppKey(Operator.BEGIN_WITH, appKey);
    }
    public MerchantRequest<T> withAppKeyContaining(String appKey){
       return withAppKey(Operator.CONTAIN, appKey);
    }

    public MerchantRequest<T> withAppKeyEndingWith(String appKey){
       return withAppKey(Operator.END_WITH, appKey);
    }

    public MerchantRequest<T> withAppKeyIs(String appKey){
       return withAppKey(Operator.EQUAL, appKey);
    }

    public MerchantRequest<T> withAppKeySoundingLike(String appKey){
       return withAppKey(Operator.SOUNDS_LIKE, appKey);
    }



    public MerchantRequest<T> filterByStatus(MerchantStatusType... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public MerchantRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public MerchantRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public MerchantRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Merchant.STATUS_PROPERTY, operator, values);
    }

    public MerchantRequest<T> filterByStatus(Long status){
      if(status == null){
         return this;
      }
      return withStatus(Operator.EQUAL, status);
    }
    public MerchantRequest<T> withStatusMatching(MerchantStatusTypeRequest status){
       return appendSearchCriteria(new SubQuerySearchCriteria(Merchant.STATUS_PROPERTY, status, MerchantStatusType.ID_PROPERTY));
    }

    public MerchantRequest<T> filterByPlatform(Platform... platform){
      if (platform == null || platform.length == 0) {
        throw new IllegalArgumentException("filterByPlatform parameter platform cannot be empty");
      }
      return appendSearchCriteria(createPlatformCriteria(Operator.EQUAL, (Object[])platform));
    }

    public MerchantRequest<T> withPlatform(Operator operator, Object... values){
       return appendSearchCriteria(createPlatformCriteria(operator, values));
    }

    public MerchantRequest<T> withPlatformIsUnknown(){
       return withPlatform(Operator.IS_NULL);
    }

    public MerchantRequest<T> withPlatformIsKnown(){
       return withPlatform(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPlatformCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Merchant.PLATFORM_PROPERTY, operator, values);
    }

    public MerchantRequest<T> filterByPlatform(Long platform){
      if(platform == null){
         return this;
      }
      return withPlatform(Operator.EQUAL, platform);
    }
    public MerchantRequest<T> withPlatformMatching(PlatformRequest platform){
       return appendSearchCriteria(new SubQuerySearchCriteria(Merchant.PLATFORM_PROPERTY, platform, Platform.ID_PROPERTY));
    }

    public MerchantRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public MerchantRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public MerchantRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public MerchantRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Merchant.CREATE_TIME_PROPERTY, operator, values);
    }

    public MerchantRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public MerchantRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public MerchantRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public MerchantRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public MerchantRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public MerchantRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public MerchantRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public MerchantRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public MerchantRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public MerchantRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public MerchantRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public MerchantRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public MerchantRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public MerchantRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Merchant.UPDATE_TIME_PROPERTY, operator, values);
    }

    public MerchantRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public MerchantRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public MerchantRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public MerchantRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public MerchantRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public MerchantRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public MerchantRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public MerchantRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public MerchantRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public MerchantRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public MerchantRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public MerchantRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public MerchantRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public MerchantRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Merchant.VERSION_PROPERTY, operator, values);
    }

    public MerchantRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public MerchantRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public MerchantRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public MerchantRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public MerchantRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public MerchantRequest<T> withMerchantKycListMatching(MerchantKycRequest merchantKycRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Merchant.ID_PROPERTY, merchantKycRequest, MerchantKyc.MERCHANT_PROPERTY));
    }

    public MerchantRequest<T> withoutMerchantKycListMatching(MerchantKycRequest merchantKycRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Merchant.ID_PROPERTY, merchantKycRequest, MerchantKyc.MERCHANT_PROPERTY)));
    }

    public MerchantRequest<T> haveMerchantKycs(){
        return withMerchantKycListMatching(Q.merchantKycs().unlimited());
    }

    public MerchantRequest<T> haveNoMerchantKycs(){
        return withoutMerchantKycListMatching(Q.merchantKycs().unlimited());
    }
    public MerchantRequest<T> withOutboxEventListMatching(OutboxEventRequest outboxEventRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Merchant.ID_PROPERTY, outboxEventRequest, OutboxEvent.MERCHANT_PROPERTY));
    }

    public MerchantRequest<T> withoutOutboxEventListMatching(OutboxEventRequest outboxEventRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Merchant.ID_PROPERTY, outboxEventRequest, OutboxEvent.MERCHANT_PROPERTY)));
    }

    public MerchantRequest<T> haveOutboxEvents(){
        return withOutboxEventListMatching(Q.outboxEvents().unlimited());
    }

    public MerchantRequest<T> haveNoOutboxEvents(){
        return withoutOutboxEventListMatching(Q.outboxEvents().unlimited());
    }

    public MerchantRequest<T> count(){
        super.count();
        return this;
    }
    public MerchantRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public MerchantRequest<T> groupByStatusWithDetails(){
       return groupByStatusWithDetails(Q.merchantStatusTypes().unlimited());
    }

    public MerchantRequest<T> groupByStatusWithDetails(MerchantStatusTypeRequest subRequest){
       aggregate(Merchant.STATUS_PROPERTY, subRequest);
       return this;
    }

    public MerchantRequest<T> groupByPlatformWithDetails(){
       return groupByPlatformWithDetails(Q.platforms().unlimited());
    }

    public MerchantRequest<T> groupByPlatformWithDetails(PlatformRequest subRequest){
       aggregate(Merchant.PLATFORM_PROPERTY, subRequest);
       return this;
    }




    public MerchantRequest<T> groupByMerchantKycsWithDetails(MerchantKycRequest subRequest){
       aggregate(Merchant.MERCHANT_KYC_LIST_PROPERTY, subRequest);
       return this;
    }
    public MerchantRequest<T> groupByOutboxEventsWithDetails(OutboxEventRequest subRequest){
       aggregate(Merchant.OUTBOX_EVENT_LIST_PROPERTY, subRequest);
       return this;
    }

    public MerchantRequest<T> groupById(){
       groupBy(Merchant.ID_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByIdAs(String retName){
       groupBy(retName, Merchant.ID_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Merchant.ID_PROPERTY, function);
       return this;
    }

    public MerchantRequest<T> groupByCompanyName(){
       groupBy(Merchant.COMPANY_NAME_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByCompanyNameAs(String retName){
       groupBy(retName, Merchant.COMPANY_NAME_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByCompanyNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Merchant.COMPANY_NAME_PROPERTY, function);
       return this;
    }

    public MerchantRequest<T> groupByContactEmail(){
       groupBy(Merchant.CONTACT_EMAIL_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByContactEmailAs(String retName){
       groupBy(retName, Merchant.CONTACT_EMAIL_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByContactEmailWithFunction(String retName, AggrFunction function){
       groupBy(retName, Merchant.CONTACT_EMAIL_PROPERTY, function);
       return this;
    }

    public MerchantRequest<T> groupByAppKey(){
       groupBy(Merchant.APP_KEY_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByAppKeyAs(String retName){
       groupBy(retName, Merchant.APP_KEY_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByAppKeyWithFunction(String retName, AggrFunction function){
       groupBy(retName, Merchant.APP_KEY_PROPERTY, function);
       return this;
    }
    public MerchantRequest<T> groupByStatusWith(MerchantStatusTypeRequest subRequest){
       groupBy(Merchant.STATUS_PROPERTY, subRequest);
       return this;
    }
    public MerchantRequest<T> groupByStatus(){
       groupBy(Merchant.STATUS_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByStatusAs(String retName){
       groupBy(retName, Merchant.STATUS_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, Merchant.STATUS_PROPERTY, function);
       return this;
    }
    public MerchantRequest<T> groupByPlatformWith(PlatformRequest subRequest){
       groupBy(Merchant.PLATFORM_PROPERTY, subRequest);
       return this;
    }
    public MerchantRequest<T> groupByPlatform(){
       groupBy(Merchant.PLATFORM_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByPlatformAs(String retName){
       groupBy(retName, Merchant.PLATFORM_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByPlatformWithFunction(String retName, AggrFunction function){
       groupBy(retName, Merchant.PLATFORM_PROPERTY, function);
       return this;
    }

    public MerchantRequest<T> groupByCreateTime(){
       groupBy(Merchant.CREATE_TIME_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Merchant.CREATE_TIME_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Merchant.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public MerchantRequest<T> groupByUpdateTime(){
       groupBy(Merchant.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Merchant.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Merchant.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public MerchantRequest<T> groupByVersion(){
       groupBy(Merchant.VERSION_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Merchant.VERSION_PROPERTY);
       return this;
    }

    public MerchantRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Merchant.VERSION_PROPERTY, function);
       return this;
    }

    public MerchantRequest<T> withStatusIsActive(){
       filterByStatus(com.doublechaintech.merchantservice.Constants.MERCHANT_STATUS_TYPE_ACTIVE);
       return this;
    }


    public MerchantRequest<T> withStatusIsPendingVerification(){
       filterByStatus(com.doublechaintech.merchantservice.Constants.MERCHANT_STATUS_TYPE_PENDING_VERIFICATION);
       return this;
    }


    public MerchantRequest<T> withStatusIsSuspended(){
       filterByStatus(com.doublechaintech.merchantservice.Constants.MERCHANT_STATUS_TYPE_SUSPENDED);
       return this;
    }




    public MerchantRequest<T> orderByIdAscending(){
       addOrderByAscending(Merchant.ID_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByIdDescending(){
       addOrderByDescending(Merchant.ID_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByCompanyNameAscending(){
       addOrderByAscending(Merchant.COMPANY_NAME_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByCompanyNameDescending(){
       addOrderByDescending(Merchant.COMPANY_NAME_PROPERTY);
       return this;
    }
    public MerchantRequest<T> orderByCompanyNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Merchant.COMPANY_NAME_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByCompanyNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Merchant.COMPANY_NAME_PROPERTY);
       return this;
    }
    public MerchantRequest<T> orderByContactEmailAscending(){
       addOrderByAscending(Merchant.CONTACT_EMAIL_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByContactEmailDescending(){
       addOrderByDescending(Merchant.CONTACT_EMAIL_PROPERTY);
       return this;
    }
    public MerchantRequest<T> orderByContactEmailAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Merchant.CONTACT_EMAIL_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByContactEmailDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Merchant.CONTACT_EMAIL_PROPERTY);
       return this;
    }
    public MerchantRequest<T> orderByAppKeyAscending(){
       addOrderByAscending(Merchant.APP_KEY_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByAppKeyDescending(){
       addOrderByDescending(Merchant.APP_KEY_PROPERTY);
       return this;
    }
    public MerchantRequest<T> orderByAppKeyAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Merchant.APP_KEY_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByAppKeyDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Merchant.APP_KEY_PROPERTY);
       return this;
    }
    public MerchantRequest<T> orderByStatusAscending(){
       addOrderByAscending(Merchant.STATUS_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByStatusDescending(){
       addOrderByDescending(Merchant.STATUS_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByPlatformAscending(){
       addOrderByAscending(Merchant.PLATFORM_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByPlatformDescending(){
       addOrderByDescending(Merchant.PLATFORM_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Merchant.CREATE_TIME_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Merchant.CREATE_TIME_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Merchant.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Merchant.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByVersionAscending(){
       addOrderByAscending(Merchant.VERSION_PROPERTY);
       return this;
    }

    public MerchantRequest<T> orderByVersionDescending(){
       addOrderByDescending(Merchant.VERSION_PROPERTY);
       return this;
    }


    public MerchantRequest<T> statsFromMerchantKycsAs(String name, MerchantKycRequest subRequest){
       return statsFromMerchantKycsAs(name, subRequest, false);
    }

    public MerchantRequest<T> statsFromMerchantKycsAs(String name, MerchantKycRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(MerchantKyc.MERCHANT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public MerchantRequest<T> statsFromMerchantKycs(MerchantKycRequest subRequest){
       return statsFromMerchantKycsAs(REFINEMENTS, subRequest);
    }
    public MerchantRequest<T> statsFromOutboxEventsAs(String name, OutboxEventRequest subRequest){
       return statsFromOutboxEventsAs(name, subRequest, false);
    }

    public MerchantRequest<T> statsFromOutboxEventsAs(String name, OutboxEventRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(OutboxEvent.MERCHANT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public MerchantRequest<T> statsFromOutboxEvents(OutboxEventRequest subRequest){
       return statsFromOutboxEventsAs(REFINEMENTS, subRequest);
    }
    public MerchantStatusTypeRequest rollUpToStatus(){
       MerchantStatusTypeRequest status = Q.merchantStatusTypes().unlimited();
       this.withStatusMatching(status)
           .groupByStatusWith(status);
       return status;
    }

    public PlatformRequest rollUpToPlatform(){
       PlatformRequest platform = Q.platforms().unlimited();
       this.withPlatformMatching(platform)
           .groupByPlatformWith(platform);
       return platform;
    }




    public MerchantRequest<T> countMerchantKycs(){
        return countMerchantKycsAs("Count");
    }

    public MerchantRequest<T> countMerchantKycsAs(String name){
        return countMerchantKycsWith(name, Q.merchantKycs().unlimited());
    }

    public MerchantRequest<T> countMerchantKycsWith(String name, MerchantKycRequest subRequest){
        return statsFromMerchantKycsAs(name, subRequest.count(), true);
    }
    public MerchantRequest<T> countOutboxEvents(){
        return countOutboxEventsAs("Count");
    }

    public MerchantRequest<T> countOutboxEventsAs(String name){
        return countOutboxEventsWith(name, Q.outboxEvents().unlimited());
    }

    public MerchantRequest<T> countOutboxEventsWith(String name, OutboxEventRequest subRequest){
        return statsFromOutboxEventsAs(name, subRequest.count(), true);
    }

   public MerchantRequest<T> facetByStatusAs(String facetName, MerchantStatusTypeRequest status){
       return facetByStatusAs(facetName, status, true);
   }

   public MerchantRequest<T> facetByStatusAs(String facetName, MerchantStatusTypeRequest status, boolean includeAllFacets){
       addFacet(facetName, Merchant.STATUS_PROPERTY, status, includeAllFacets);
       return this;
   }
   public MerchantRequest<T> facetByPlatformAs(String facetName, PlatformRequest platform){
       return facetByPlatformAs(facetName, platform, true);
   }

   public MerchantRequest<T> facetByPlatformAs(String facetName, PlatformRequest platform, boolean includeAllFacets){
       addFacet(facetName, Merchant.PLATFORM_PROPERTY, platform, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public MerchantRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public MerchantRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public MerchantRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public MerchantRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public MerchantRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}