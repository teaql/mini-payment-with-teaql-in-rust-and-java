package com.doublechaintech.merchantservice.merchantstatustype;

import com.doublechaintech.merchantservice.Q;
import com.doublechaintech.merchantservice.merchant.Merchant;
import com.doublechaintech.merchantservice.merchant.MerchantRequest;
import com.doublechaintech.merchantservice.platform.Platform;
import com.doublechaintech.merchantservice.platform.PlatformRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;

public class MerchantStatusTypeRequest<T extends MerchantStatusType> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public MerchantStatusTypeRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public MerchantStatusTypeRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public MerchantStatusTypeRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public MerchantStatusTypeRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public MerchantStatusTypeRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public MerchantStatusTypeRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public MerchantStatusTypeRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (MerchantStatusTypeRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public MerchantStatusTypeRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public MerchantStatusTypeRequest<T> matchingAnyOf(MerchantStatusTypeRequest merchantStatusType){
        super.internalMatchAny(merchantStatusType);
        return this;
    }

    public MerchantStatusTypeRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public MerchantStatusTypeRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public MerchantStatusTypeRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public MerchantStatusTypeRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectCode().selectPlatformIdOnly().selectVersion();
    }

    public MerchantStatusTypeRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public MerchantStatusTypeRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectCode().selectPlatform().selectVersion();
    }

    public MerchantStatusTypeRequest<T> selectChildren(){
        super.selectAny();
        selectMerchantList();
        return selectId().selectName().selectCode().selectPlatform().selectVersion();
    }


    public MerchantStatusTypeRequest<T> selectId(){
       selectProperty(MerchantStatusType.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantStatusTypeRequest<T> unselectId(){
       unselectProperty(MerchantStatusType.ID_PROPERTY);
       return this;
    }
    public MerchantStatusTypeRequest<T> selectName(){
       selectProperty(MerchantStatusType.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantStatusTypeRequest<T> unselectName(){
       unselectProperty(MerchantStatusType.NAME_PROPERTY);
       return this;
    }
    public MerchantStatusTypeRequest<T> selectCode(){
       selectProperty(MerchantStatusType.CODE_PROPERTY);
       return this;
    }

    /**
     * fill the code with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  code) to fetch code property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantStatusTypeRequest<T> unselectCode(){
       unselectProperty(MerchantStatusType.CODE_PROPERTY);
       return this;
    }
    public MerchantStatusTypeRequest<T> selectPlatformIdOnly(){
       selectProperty(MerchantStatusType.PLATFORM_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> selectPlatform(){
        return selectPlatformWith(Q.platforms().unlimited().selectSelf());
    }

    public MerchantStatusTypeRequest<T> selectPlatformWith(PlatformRequest platform){
       selectProperty(MerchantStatusType.PLATFORM_PROPERTY);
       enhanceRelation(MerchantStatusType.PLATFORM_PROPERTY, platform);
       return this;
    }

    public MerchantStatusTypeRequest<T> unselectPlatform(){
       unselectProperty(MerchantStatusType.PLATFORM_PROPERTY);
       return this;
    }
    public MerchantStatusTypeRequest<T> selectVersion(){
       selectProperty(MerchantStatusType.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MerchantStatusTypeRequest<T> unselectVersion(){
       unselectProperty(MerchantStatusType.VERSION_PROPERTY);
       return this;
    }
    public MerchantStatusTypeRequest<T> selectMerchantList(){
       return selectMerchantListWith(Q.merchants().selectSelf());
    }

    public MerchantStatusTypeRequest<T> selectMerchantListWith(MerchantRequest merchantList){
       enhanceRelation(MerchantStatusType.MERCHANT_LIST_PROPERTY, merchantList);
       return this;
    }

    public MerchantStatusTypeRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MerchantStatusType.ID_PROPERTY, operator, values);
    }

    public MerchantStatusTypeRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public MerchantStatusTypeRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public MerchantStatusTypeRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public MerchantStatusTypeRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public MerchantStatusTypeRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public MerchantStatusTypeRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MerchantStatusType.NAME_PROPERTY, operator, values);
    }

    public MerchantStatusTypeRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public MerchantStatusTypeRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public MerchantStatusTypeRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public MerchantStatusTypeRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public MerchantStatusTypeRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public MerchantStatusTypeRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public MerchantStatusTypeRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public MerchantStatusTypeRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public MerchantStatusTypeRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public MerchantStatusTypeRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public MerchantStatusTypeRequest<T> filterByCode(String... code){
      if (code == null || code.length == 0) {
        throw new IllegalArgumentException("filterByCode parameter code cannot be empty");
      }
      return appendSearchCriteria(createCodeCriteria(Operator.EQUAL, (Object[])code));
    }

    public MerchantStatusTypeRequest<T> withCode(Operator operator, Object... values){
       return appendSearchCriteria(createCodeCriteria(operator, values));
    }

    public MerchantStatusTypeRequest<T> withCodeIsUnknown(){
       return withCode(Operator.IS_NULL);
    }

    public MerchantStatusTypeRequest<T> withCodeIsKnown(){
       return withCode(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCodeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MerchantStatusType.CODE_PROPERTY, operator, values);
    }

    public MerchantStatusTypeRequest<T> withCodeGreaterThan(String code){
       return withCode(Operator.GREATER_THAN, code);
    }

    public MerchantStatusTypeRequest<T> withCodeGreaterThanOrEqualTo(String code){
       return withCode(Operator.GREATER_THAN_OR_EQUAL, code);
    }

    public MerchantStatusTypeRequest<T> withCodeLessThan(String code){
       return withCode(Operator.LESS_THAN, code);
    }

    public MerchantStatusTypeRequest<T> withCodeLessThanOrEqualTo(String code){
       return withCode(Operator.LESS_THAN_OR_EQUAL, code);
    }

    public MerchantStatusTypeRequest<T> withCodeBetween(String startOfCode, String endOfCode){
       return withCode(Operator.BETWEEN, startOfCode, endOfCode);
    }
    public MerchantStatusTypeRequest<T> withCodeStartingWith(String code){
       return withCode(Operator.BEGIN_WITH, code);
    }
    public MerchantStatusTypeRequest<T> withCodeContaining(String code){
       return withCode(Operator.CONTAIN, code);
    }

    public MerchantStatusTypeRequest<T> withCodeEndingWith(String code){
       return withCode(Operator.END_WITH, code);
    }

    public MerchantStatusTypeRequest<T> withCodeIs(String code){
       return withCode(Operator.EQUAL, code);
    }

    public MerchantStatusTypeRequest<T> withCodeSoundingLike(String code){
       return withCode(Operator.SOUNDS_LIKE, code);
    }



    public MerchantStatusTypeRequest<T> filterByPlatform(Platform... platform){
      if (platform == null || platform.length == 0) {
        throw new IllegalArgumentException("filterByPlatform parameter platform cannot be empty");
      }
      return appendSearchCriteria(createPlatformCriteria(Operator.EQUAL, (Object[])platform));
    }

    public MerchantStatusTypeRequest<T> withPlatform(Operator operator, Object... values){
       return appendSearchCriteria(createPlatformCriteria(operator, values));
    }

    public MerchantStatusTypeRequest<T> withPlatformIsUnknown(){
       return withPlatform(Operator.IS_NULL);
    }

    public MerchantStatusTypeRequest<T> withPlatformIsKnown(){
       return withPlatform(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPlatformCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MerchantStatusType.PLATFORM_PROPERTY, operator, values);
    }

    public MerchantStatusTypeRequest<T> filterByPlatform(Long platform){
      if(platform == null){
         return this;
      }
      return withPlatform(Operator.EQUAL, platform);
    }
    public MerchantStatusTypeRequest<T> withPlatformMatching(PlatformRequest platform){
       return appendSearchCriteria(new SubQuerySearchCriteria(MerchantStatusType.PLATFORM_PROPERTY, platform, Platform.ID_PROPERTY));
    }

    public MerchantStatusTypeRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public MerchantStatusTypeRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public MerchantStatusTypeRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public MerchantStatusTypeRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MerchantStatusType.VERSION_PROPERTY, operator, values);
    }

    public MerchantStatusTypeRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public MerchantStatusTypeRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public MerchantStatusTypeRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public MerchantStatusTypeRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public MerchantStatusTypeRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public MerchantStatusTypeRequest<T> withMerchantListMatching(MerchantRequest merchantRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(MerchantStatusType.ID_PROPERTY, merchantRequest, Merchant.STATUS_PROPERTY));
    }

    public MerchantStatusTypeRequest<T> withoutMerchantListMatching(MerchantRequest merchantRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(MerchantStatusType.ID_PROPERTY, merchantRequest, Merchant.STATUS_PROPERTY)));
    }

    public MerchantStatusTypeRequest<T> haveMerchants(){
        return withMerchantListMatching(Q.merchants().unlimited());
    }

    public MerchantStatusTypeRequest<T> haveNoMerchants(){
        return withoutMerchantListMatching(Q.merchants().unlimited());
    }

    public MerchantStatusTypeRequest<T> count(){
        super.count();
        return this;
    }
    public MerchantStatusTypeRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public MerchantStatusTypeRequest<T> groupByPlatformWithDetails(){
       return groupByPlatformWithDetails(Q.platforms().unlimited());
    }

    public MerchantStatusTypeRequest<T> groupByPlatformWithDetails(PlatformRequest subRequest){
       aggregate(MerchantStatusType.PLATFORM_PROPERTY, subRequest);
       return this;
    }


    public MerchantStatusTypeRequest<T> groupByMerchantsWithDetails(MerchantRequest subRequest){
       aggregate(MerchantStatusType.MERCHANT_LIST_PROPERTY, subRequest);
       return this;
    }

    public MerchantStatusTypeRequest<T> groupById(){
       groupBy(MerchantStatusType.ID_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> groupByIdAs(String retName){
       groupBy(retName, MerchantStatusType.ID_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, MerchantStatusType.ID_PROPERTY, function);
       return this;
    }

    public MerchantStatusTypeRequest<T> groupByName(){
       groupBy(MerchantStatusType.NAME_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> groupByNameAs(String retName){
       groupBy(retName, MerchantStatusType.NAME_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, MerchantStatusType.NAME_PROPERTY, function);
       return this;
    }

    public MerchantStatusTypeRequest<T> groupByCode(){
       groupBy(MerchantStatusType.CODE_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> groupByCodeAs(String retName){
       groupBy(retName, MerchantStatusType.CODE_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> groupByCodeWithFunction(String retName, AggrFunction function){
       groupBy(retName, MerchantStatusType.CODE_PROPERTY, function);
       return this;
    }
    public MerchantStatusTypeRequest<T> groupByPlatformWith(PlatformRequest subRequest){
       groupBy(MerchantStatusType.PLATFORM_PROPERTY, subRequest);
       return this;
    }
    public MerchantStatusTypeRequest<T> groupByPlatform(){
       groupBy(MerchantStatusType.PLATFORM_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> groupByPlatformAs(String retName){
       groupBy(retName, MerchantStatusType.PLATFORM_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> groupByPlatformWithFunction(String retName, AggrFunction function){
       groupBy(retName, MerchantStatusType.PLATFORM_PROPERTY, function);
       return this;
    }

    public MerchantStatusTypeRequest<T> groupByVersion(){
       groupBy(MerchantStatusType.VERSION_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> groupByVersionAs(String retName){
       groupBy(retName, MerchantStatusType.VERSION_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, MerchantStatusType.VERSION_PROPERTY, function);
       return this;
    }



    public MerchantStatusTypeRequest<T> orderByIdAscending(){
       addOrderByAscending(MerchantStatusType.ID_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> orderByIdDescending(){
       addOrderByDescending(MerchantStatusType.ID_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> orderByNameAscending(){
       addOrderByAscending(MerchantStatusType.NAME_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> orderByNameDescending(){
       addOrderByDescending(MerchantStatusType.NAME_PROPERTY);
       return this;
    }
    public MerchantStatusTypeRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(MerchantStatusType.NAME_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(MerchantStatusType.NAME_PROPERTY);
       return this;
    }
    public MerchantStatusTypeRequest<T> orderByCodeAscending(){
       addOrderByAscending(MerchantStatusType.CODE_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> orderByCodeDescending(){
       addOrderByDescending(MerchantStatusType.CODE_PROPERTY);
       return this;
    }
    public MerchantStatusTypeRequest<T> orderByCodeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(MerchantStatusType.CODE_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> orderByCodeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(MerchantStatusType.CODE_PROPERTY);
       return this;
    }
    public MerchantStatusTypeRequest<T> orderByPlatformAscending(){
       addOrderByAscending(MerchantStatusType.PLATFORM_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> orderByPlatformDescending(){
       addOrderByDescending(MerchantStatusType.PLATFORM_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> orderByVersionAscending(){
       addOrderByAscending(MerchantStatusType.VERSION_PROPERTY);
       return this;
    }

    public MerchantStatusTypeRequest<T> orderByVersionDescending(){
       addOrderByDescending(MerchantStatusType.VERSION_PROPERTY);
       return this;
    }


    public MerchantStatusTypeRequest<T> statsFromMerchantsAs(String name, MerchantRequest subRequest){
       return statsFromMerchantsAs(name, subRequest, false);
    }

    public MerchantStatusTypeRequest<T> statsFromMerchantsAs(String name, MerchantRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Merchant.STATUS_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public MerchantStatusTypeRequest<T> statsFromMerchants(MerchantRequest subRequest){
       return statsFromMerchantsAs(REFINEMENTS, subRequest);
    }
    public PlatformRequest rollUpToPlatform(){
       PlatformRequest platform = Q.platforms().unlimited();
       this.withPlatformMatching(platform)
           .groupByPlatformWith(platform);
       return platform;
    }


    public MerchantStatusTypeRequest<T> countMerchants(){
        return countMerchantsAs("Count");
    }

    public MerchantStatusTypeRequest<T> countMerchantsAs(String name){
        return countMerchantsWith(name, Q.merchants().unlimited());
    }

    public MerchantStatusTypeRequest<T> countMerchantsWith(String name, MerchantRequest subRequest){
        return statsFromMerchantsAs(name, subRequest.count(), true);
    }

   public MerchantStatusTypeRequest<T> facetByPlatformAs(String facetName, PlatformRequest platform){
       return facetByPlatformAs(facetName, platform, true);
   }

   public MerchantStatusTypeRequest<T> facetByPlatformAs(String facetName, PlatformRequest platform, boolean includeAllFacets){
       addFacet(facetName, MerchantStatusType.PLATFORM_PROPERTY, platform, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public MerchantStatusTypeRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public MerchantStatusTypeRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public MerchantStatusTypeRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public MerchantStatusTypeRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public MerchantStatusTypeRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}