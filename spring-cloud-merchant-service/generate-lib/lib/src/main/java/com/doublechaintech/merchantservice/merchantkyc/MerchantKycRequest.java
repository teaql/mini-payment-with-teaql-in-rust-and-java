package com.doublechaintech.merchantservice.merchantkyc;

import com.doublechaintech.merchantservice.Q;
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

public class MerchantKycRequest<T extends MerchantKyc> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public MerchantKycRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public MerchantKycRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public MerchantKycRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public MerchantKycRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public MerchantKycRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public MerchantKycRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public MerchantKycRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (MerchantKycRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public MerchantKycRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public MerchantKycRequest<T> matchingAnyOf(MerchantKycRequest merchantKyc){
        super.internalMatchAny(merchantKyc);
        return this;
    }

    public MerchantKycRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public MerchantKycRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public MerchantKycRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public MerchantKycRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectBusinessLicenseNo().selectLegalPerson().selectBankAccountNo().selectMerchantIdOnly().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public MerchantKycRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public MerchantKycRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectBusinessLicenseNo().selectLegalPerson().selectBankAccountNo().selectMerchant().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public MerchantKycRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectBusinessLicenseNo().selectLegalPerson().selectBankAccountNo().selectMerchant().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public MerchantKycRequest<T> selectId(){
       selectProperty(MerchantKyc.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantKycRequest<T> unselectId(){
       unselectProperty(MerchantKyc.ID_PROPERTY);
       return this;
    }
    public MerchantKycRequest<T> selectBusinessLicenseNo(){
       selectProperty(MerchantKyc.BUSINESS_LICENSE_NO_PROPERTY);
       return this;
    }

    /**
     * fill the businessLicenseNo with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  businessLicenseNo) to fetch businessLicenseNo property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantKycRequest<T> unselectBusinessLicenseNo(){
       unselectProperty(MerchantKyc.BUSINESS_LICENSE_NO_PROPERTY);
       return this;
    }
    public MerchantKycRequest<T> selectLegalPerson(){
       selectProperty(MerchantKyc.LEGAL_PERSON_PROPERTY);
       return this;
    }

    /**
     * fill the legalPerson with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  legalPerson) to fetch legalPerson property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantKycRequest<T> unselectLegalPerson(){
       unselectProperty(MerchantKyc.LEGAL_PERSON_PROPERTY);
       return this;
    }
    public MerchantKycRequest<T> selectBankAccountNo(){
       selectProperty(MerchantKyc.BANK_ACCOUNT_NO_PROPERTY);
       return this;
    }

    /**
     * fill the bankAccountNo with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  bankAccountNo) to fetch bankAccountNo property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantKycRequest<T> unselectBankAccountNo(){
       unselectProperty(MerchantKyc.BANK_ACCOUNT_NO_PROPERTY);
       return this;
    }
    public MerchantKycRequest<T> selectMerchantIdOnly(){
       selectProperty(MerchantKyc.MERCHANT_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> selectMerchant(){
        return selectMerchantWith(Q.merchants().unlimited().selectSelf());
    }

    public MerchantKycRequest<T> selectMerchantWith(MerchantRequest merchant){
       selectProperty(MerchantKyc.MERCHANT_PROPERTY);
       enhanceRelation(MerchantKyc.MERCHANT_PROPERTY, merchant);
       return this;
    }

    public MerchantKycRequest<T> unselectMerchant(){
       unselectProperty(MerchantKyc.MERCHANT_PROPERTY);
       return this;
    }
    public MerchantKycRequest<T> selectCreateTime(){
       selectProperty(MerchantKyc.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantKycRequest<T> unselectCreateTime(){
       unselectProperty(MerchantKyc.CREATE_TIME_PROPERTY);
       return this;
    }
    public MerchantKycRequest<T> selectUpdateTime(){
       selectProperty(MerchantKyc.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantKycRequest<T> unselectUpdateTime(){
       unselectProperty(MerchantKyc.UPDATE_TIME_PROPERTY);
       return this;
    }
    public MerchantKycRequest<T> selectVersion(){
       selectProperty(MerchantKyc.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantKycRequest<T> unselectVersion(){
       unselectProperty(MerchantKyc.VERSION_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MerchantKyc.ID_PROPERTY, operator, values);
    }

    public MerchantKycRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public MerchantKycRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public MerchantKycRequest<T> filterByBusinessLicenseNo(String... businessLicenseNo){
      if (businessLicenseNo == null || businessLicenseNo.length == 0) {
        throw new IllegalArgumentException("filterByBusinessLicenseNo parameter businessLicenseNo cannot be empty");
      }
      return appendSearchCriteria(createBusinessLicenseNoCriteria(Operator.EQUAL, (Object[])businessLicenseNo));
    }

    public MerchantKycRequest<T> withBusinessLicenseNo(Operator operator, Object... values){
       return appendSearchCriteria(createBusinessLicenseNoCriteria(operator, values));
    }

    public MerchantKycRequest<T> withBusinessLicenseNoIsUnknown(){
       return withBusinessLicenseNo(Operator.IS_NULL);
    }

    public MerchantKycRequest<T> withBusinessLicenseNoIsKnown(){
       return withBusinessLicenseNo(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createBusinessLicenseNoCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MerchantKyc.BUSINESS_LICENSE_NO_PROPERTY, operator, values);
    }

    public MerchantKycRequest<T> withBusinessLicenseNoGreaterThan(String businessLicenseNo){
       return withBusinessLicenseNo(Operator.GREATER_THAN, businessLicenseNo);
    }

    public MerchantKycRequest<T> withBusinessLicenseNoGreaterThanOrEqualTo(String businessLicenseNo){
       return withBusinessLicenseNo(Operator.GREATER_THAN_OR_EQUAL, businessLicenseNo);
    }

    public MerchantKycRequest<T> withBusinessLicenseNoLessThan(String businessLicenseNo){
       return withBusinessLicenseNo(Operator.LESS_THAN, businessLicenseNo);
    }

    public MerchantKycRequest<T> withBusinessLicenseNoLessThanOrEqualTo(String businessLicenseNo){
       return withBusinessLicenseNo(Operator.LESS_THAN_OR_EQUAL, businessLicenseNo);
    }

    public MerchantKycRequest<T> withBusinessLicenseNoBetween(String startOfBusinessLicenseNo, String endOfBusinessLicenseNo){
       return withBusinessLicenseNo(Operator.BETWEEN, startOfBusinessLicenseNo, endOfBusinessLicenseNo);
    }
    public MerchantKycRequest<T> withBusinessLicenseNoStartingWith(String businessLicenseNo){
       return withBusinessLicenseNo(Operator.BEGIN_WITH, businessLicenseNo);
    }
    public MerchantKycRequest<T> withBusinessLicenseNoContaining(String businessLicenseNo){
       return withBusinessLicenseNo(Operator.CONTAIN, businessLicenseNo);
    }

    public MerchantKycRequest<T> withBusinessLicenseNoEndingWith(String businessLicenseNo){
       return withBusinessLicenseNo(Operator.END_WITH, businessLicenseNo);
    }

    public MerchantKycRequest<T> withBusinessLicenseNoIs(String businessLicenseNo){
       return withBusinessLicenseNo(Operator.EQUAL, businessLicenseNo);
    }

    public MerchantKycRequest<T> withBusinessLicenseNoSoundingLike(String businessLicenseNo){
       return withBusinessLicenseNo(Operator.SOUNDS_LIKE, businessLicenseNo);
    }



    public MerchantKycRequest<T> filterByLegalPerson(String... legalPerson){
      if (legalPerson == null || legalPerson.length == 0) {
        throw new IllegalArgumentException("filterByLegalPerson parameter legalPerson cannot be empty");
      }
      return appendSearchCriteria(createLegalPersonCriteria(Operator.EQUAL, (Object[])legalPerson));
    }

    public MerchantKycRequest<T> withLegalPerson(Operator operator, Object... values){
       return appendSearchCriteria(createLegalPersonCriteria(operator, values));
    }

    public MerchantKycRequest<T> withLegalPersonIsUnknown(){
       return withLegalPerson(Operator.IS_NULL);
    }

    public MerchantKycRequest<T> withLegalPersonIsKnown(){
       return withLegalPerson(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createLegalPersonCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MerchantKyc.LEGAL_PERSON_PROPERTY, operator, values);
    }

    public MerchantKycRequest<T> withLegalPersonGreaterThan(String legalPerson){
       return withLegalPerson(Operator.GREATER_THAN, legalPerson);
    }

    public MerchantKycRequest<T> withLegalPersonGreaterThanOrEqualTo(String legalPerson){
       return withLegalPerson(Operator.GREATER_THAN_OR_EQUAL, legalPerson);
    }

    public MerchantKycRequest<T> withLegalPersonLessThan(String legalPerson){
       return withLegalPerson(Operator.LESS_THAN, legalPerson);
    }

    public MerchantKycRequest<T> withLegalPersonLessThanOrEqualTo(String legalPerson){
       return withLegalPerson(Operator.LESS_THAN_OR_EQUAL, legalPerson);
    }

    public MerchantKycRequest<T> withLegalPersonBetween(String startOfLegalPerson, String endOfLegalPerson){
       return withLegalPerson(Operator.BETWEEN, startOfLegalPerson, endOfLegalPerson);
    }
    public MerchantKycRequest<T> withLegalPersonStartingWith(String legalPerson){
       return withLegalPerson(Operator.BEGIN_WITH, legalPerson);
    }
    public MerchantKycRequest<T> withLegalPersonContaining(String legalPerson){
       return withLegalPerson(Operator.CONTAIN, legalPerson);
    }

    public MerchantKycRequest<T> withLegalPersonEndingWith(String legalPerson){
       return withLegalPerson(Operator.END_WITH, legalPerson);
    }

    public MerchantKycRequest<T> withLegalPersonIs(String legalPerson){
       return withLegalPerson(Operator.EQUAL, legalPerson);
    }

    public MerchantKycRequest<T> withLegalPersonSoundingLike(String legalPerson){
       return withLegalPerson(Operator.SOUNDS_LIKE, legalPerson);
    }



    public MerchantKycRequest<T> filterByBankAccountNo(String... bankAccountNo){
      if (bankAccountNo == null || bankAccountNo.length == 0) {
        throw new IllegalArgumentException("filterByBankAccountNo parameter bankAccountNo cannot be empty");
      }
      return appendSearchCriteria(createBankAccountNoCriteria(Operator.EQUAL, (Object[])bankAccountNo));
    }

    public MerchantKycRequest<T> withBankAccountNo(Operator operator, Object... values){
       return appendSearchCriteria(createBankAccountNoCriteria(operator, values));
    }

    public MerchantKycRequest<T> withBankAccountNoIsUnknown(){
       return withBankAccountNo(Operator.IS_NULL);
    }

    public MerchantKycRequest<T> withBankAccountNoIsKnown(){
       return withBankAccountNo(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createBankAccountNoCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MerchantKyc.BANK_ACCOUNT_NO_PROPERTY, operator, values);
    }

    public MerchantKycRequest<T> withBankAccountNoGreaterThan(String bankAccountNo){
       return withBankAccountNo(Operator.GREATER_THAN, bankAccountNo);
    }

    public MerchantKycRequest<T> withBankAccountNoGreaterThanOrEqualTo(String bankAccountNo){
       return withBankAccountNo(Operator.GREATER_THAN_OR_EQUAL, bankAccountNo);
    }

    public MerchantKycRequest<T> withBankAccountNoLessThan(String bankAccountNo){
       return withBankAccountNo(Operator.LESS_THAN, bankAccountNo);
    }

    public MerchantKycRequest<T> withBankAccountNoLessThanOrEqualTo(String bankAccountNo){
       return withBankAccountNo(Operator.LESS_THAN_OR_EQUAL, bankAccountNo);
    }

    public MerchantKycRequest<T> withBankAccountNoBetween(String startOfBankAccountNo, String endOfBankAccountNo){
       return withBankAccountNo(Operator.BETWEEN, startOfBankAccountNo, endOfBankAccountNo);
    }
    public MerchantKycRequest<T> withBankAccountNoStartingWith(String bankAccountNo){
       return withBankAccountNo(Operator.BEGIN_WITH, bankAccountNo);
    }
    public MerchantKycRequest<T> withBankAccountNoContaining(String bankAccountNo){
       return withBankAccountNo(Operator.CONTAIN, bankAccountNo);
    }

    public MerchantKycRequest<T> withBankAccountNoEndingWith(String bankAccountNo){
       return withBankAccountNo(Operator.END_WITH, bankAccountNo);
    }

    public MerchantKycRequest<T> withBankAccountNoIs(String bankAccountNo){
       return withBankAccountNo(Operator.EQUAL, bankAccountNo);
    }

    public MerchantKycRequest<T> withBankAccountNoSoundingLike(String bankAccountNo){
       return withBankAccountNo(Operator.SOUNDS_LIKE, bankAccountNo);
    }



    public MerchantKycRequest<T> filterByMerchant(Merchant... merchant){
      if (merchant == null || merchant.length == 0) {
        throw new IllegalArgumentException("filterByMerchant parameter merchant cannot be empty");
      }
      return appendSearchCriteria(createMerchantCriteria(Operator.EQUAL, (Object[])merchant));
    }

    public MerchantKycRequest<T> withMerchant(Operator operator, Object... values){
       return appendSearchCriteria(createMerchantCriteria(operator, values));
    }

    public MerchantKycRequest<T> withMerchantIsUnknown(){
       return withMerchant(Operator.IS_NULL);
    }

    public MerchantKycRequest<T> withMerchantIsKnown(){
       return withMerchant(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createMerchantCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MerchantKyc.MERCHANT_PROPERTY, operator, values);
    }

    public MerchantKycRequest<T> filterByMerchant(Long merchant){
      if(merchant == null){
         return this;
      }
      return withMerchant(Operator.EQUAL, merchant);
    }
    public MerchantKycRequest<T> withMerchantMatching(MerchantRequest merchant){
       return appendSearchCriteria(new SubQuerySearchCriteria(MerchantKyc.MERCHANT_PROPERTY, merchant, Merchant.ID_PROPERTY));
    }

    public MerchantKycRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public MerchantKycRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public MerchantKycRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public MerchantKycRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MerchantKyc.CREATE_TIME_PROPERTY, operator, values);
    }

    public MerchantKycRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public MerchantKycRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public MerchantKycRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public MerchantKycRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public MerchantKycRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public MerchantKycRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public MerchantKycRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public MerchantKycRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public MerchantKycRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public MerchantKycRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public MerchantKycRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public MerchantKycRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public MerchantKycRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public MerchantKycRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MerchantKyc.UPDATE_TIME_PROPERTY, operator, values);
    }

    public MerchantKycRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public MerchantKycRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public MerchantKycRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public MerchantKycRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public MerchantKycRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public MerchantKycRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public MerchantKycRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public MerchantKycRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public MerchantKycRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public MerchantKycRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public MerchantKycRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public MerchantKycRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public MerchantKycRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public MerchantKycRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MerchantKyc.VERSION_PROPERTY, operator, values);
    }

    public MerchantKycRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public MerchantKycRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public MerchantKycRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public MerchantKycRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public MerchantKycRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public MerchantKycRequest<T> count(){
        super.count();
        return this;
    }
    public MerchantKycRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public MerchantKycRequest<T> groupByMerchantWithDetails(){
       return groupByMerchantWithDetails(Q.merchants().unlimited());
    }

    public MerchantKycRequest<T> groupByMerchantWithDetails(MerchantRequest subRequest){
       aggregate(MerchantKyc.MERCHANT_PROPERTY, subRequest);
       return this;
    }





    public MerchantKycRequest<T> groupById(){
       groupBy(MerchantKyc.ID_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> groupByIdAs(String retName){
       groupBy(retName, MerchantKyc.ID_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, MerchantKyc.ID_PROPERTY, function);
       return this;
    }

    public MerchantKycRequest<T> groupByBusinessLicenseNo(){
       groupBy(MerchantKyc.BUSINESS_LICENSE_NO_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> groupByBusinessLicenseNoAs(String retName){
       groupBy(retName, MerchantKyc.BUSINESS_LICENSE_NO_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> groupByBusinessLicenseNoWithFunction(String retName, AggrFunction function){
       groupBy(retName, MerchantKyc.BUSINESS_LICENSE_NO_PROPERTY, function);
       return this;
    }

    public MerchantKycRequest<T> groupByLegalPerson(){
       groupBy(MerchantKyc.LEGAL_PERSON_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> groupByLegalPersonAs(String retName){
       groupBy(retName, MerchantKyc.LEGAL_PERSON_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> groupByLegalPersonWithFunction(String retName, AggrFunction function){
       groupBy(retName, MerchantKyc.LEGAL_PERSON_PROPERTY, function);
       return this;
    }

    public MerchantKycRequest<T> groupByBankAccountNo(){
       groupBy(MerchantKyc.BANK_ACCOUNT_NO_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> groupByBankAccountNoAs(String retName){
       groupBy(retName, MerchantKyc.BANK_ACCOUNT_NO_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> groupByBankAccountNoWithFunction(String retName, AggrFunction function){
       groupBy(retName, MerchantKyc.BANK_ACCOUNT_NO_PROPERTY, function);
       return this;
    }
    public MerchantKycRequest<T> groupByMerchantWith(MerchantRequest subRequest){
       groupBy(MerchantKyc.MERCHANT_PROPERTY, subRequest);
       return this;
    }
    public MerchantKycRequest<T> groupByMerchant(){
       groupBy(MerchantKyc.MERCHANT_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> groupByMerchantAs(String retName){
       groupBy(retName, MerchantKyc.MERCHANT_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> groupByMerchantWithFunction(String retName, AggrFunction function){
       groupBy(retName, MerchantKyc.MERCHANT_PROPERTY, function);
       return this;
    }

    public MerchantKycRequest<T> groupByCreateTime(){
       groupBy(MerchantKyc.CREATE_TIME_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, MerchantKyc.CREATE_TIME_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, MerchantKyc.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public MerchantKycRequest<T> groupByUpdateTime(){
       groupBy(MerchantKyc.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, MerchantKyc.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, MerchantKyc.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public MerchantKycRequest<T> groupByVersion(){
       groupBy(MerchantKyc.VERSION_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> groupByVersionAs(String retName){
       groupBy(retName, MerchantKyc.VERSION_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, MerchantKyc.VERSION_PROPERTY, function);
       return this;
    }



    public MerchantKycRequest<T> orderByIdAscending(){
       addOrderByAscending(MerchantKyc.ID_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> orderByIdDescending(){
       addOrderByDescending(MerchantKyc.ID_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> orderByBusinessLicenseNoAscending(){
       addOrderByAscending(MerchantKyc.BUSINESS_LICENSE_NO_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> orderByBusinessLicenseNoDescending(){
       addOrderByDescending(MerchantKyc.BUSINESS_LICENSE_NO_PROPERTY);
       return this;
    }
    public MerchantKycRequest<T> orderByBusinessLicenseNoAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(MerchantKyc.BUSINESS_LICENSE_NO_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> orderByBusinessLicenseNoDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(MerchantKyc.BUSINESS_LICENSE_NO_PROPERTY);
       return this;
    }
    public MerchantKycRequest<T> orderByLegalPersonAscending(){
       addOrderByAscending(MerchantKyc.LEGAL_PERSON_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> orderByLegalPersonDescending(){
       addOrderByDescending(MerchantKyc.LEGAL_PERSON_PROPERTY);
       return this;
    }
    public MerchantKycRequest<T> orderByLegalPersonAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(MerchantKyc.LEGAL_PERSON_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> orderByLegalPersonDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(MerchantKyc.LEGAL_PERSON_PROPERTY);
       return this;
    }
    public MerchantKycRequest<T> orderByBankAccountNoAscending(){
       addOrderByAscending(MerchantKyc.BANK_ACCOUNT_NO_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> orderByBankAccountNoDescending(){
       addOrderByDescending(MerchantKyc.BANK_ACCOUNT_NO_PROPERTY);
       return this;
    }
    public MerchantKycRequest<T> orderByBankAccountNoAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(MerchantKyc.BANK_ACCOUNT_NO_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> orderByBankAccountNoDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(MerchantKyc.BANK_ACCOUNT_NO_PROPERTY);
       return this;
    }
    public MerchantKycRequest<T> orderByMerchantAscending(){
       addOrderByAscending(MerchantKyc.MERCHANT_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> orderByMerchantDescending(){
       addOrderByDescending(MerchantKyc.MERCHANT_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(MerchantKyc.CREATE_TIME_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(MerchantKyc.CREATE_TIME_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(MerchantKyc.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(MerchantKyc.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> orderByVersionAscending(){
       addOrderByAscending(MerchantKyc.VERSION_PROPERTY);
       return this;
    }

    public MerchantKycRequest<T> orderByVersionDescending(){
       addOrderByDescending(MerchantKyc.VERSION_PROPERTY);
       return this;
    }


    public MerchantRequest rollUpToMerchant(){
       MerchantRequest merchant = Q.merchants().unlimited();
       this.withMerchantMatching(merchant)
           .groupByMerchantWith(merchant);
       return merchant;
    }





   public MerchantKycRequest<T> facetByMerchantAs(String facetName, MerchantRequest merchant){
       return facetByMerchantAs(facetName, merchant, true);
   }

   public MerchantKycRequest<T> facetByMerchantAs(String facetName, MerchantRequest merchant, boolean includeAllFacets){
       addFacet(facetName, MerchantKyc.MERCHANT_PROPERTY, merchant, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public MerchantKycRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public MerchantKycRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public MerchantKycRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public MerchantKycRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public MerchantKycRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}