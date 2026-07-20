package com.doublechaintech.merchantservice;

import io.teaql.core.criteria.Operator;

public class Q  {
  public static com.doublechaintech.merchantservice.platform.PlatformRequest<com.doublechaintech.merchantservice.platform.Platform> platforms(){
      return new com.doublechaintech.merchantservice.platform.PlatformRequest(com.doublechaintech.merchantservice.platform.Platform.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.merchantservice.platform.PlatformRequest<com.doublechaintech.merchantservice.platform.Platform> platformsWithMinimalFields(){
      return new com.doublechaintech.merchantservice.platform.PlatformRequest(com.doublechaintech.merchantservice.platform.Platform.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.doublechaintech.merchantservice.merchant.MerchantRequest<com.doublechaintech.merchantservice.merchant.Merchant> merchants(){
      return new com.doublechaintech.merchantservice.merchant.MerchantRequest(com.doublechaintech.merchantservice.merchant.Merchant.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.merchantservice.merchant.MerchantRequest<com.doublechaintech.merchantservice.merchant.Merchant> merchantsWithMinimalFields(){
      return new com.doublechaintech.merchantservice.merchant.MerchantRequest(com.doublechaintech.merchantservice.merchant.Merchant.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.doublechaintech.merchantservice.merchantkyc.MerchantKycRequest<com.doublechaintech.merchantservice.merchantkyc.MerchantKyc> merchantKycs(){
      return new com.doublechaintech.merchantservice.merchantkyc.MerchantKycRequest(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.merchantservice.merchantkyc.MerchantKycRequest<com.doublechaintech.merchantservice.merchantkyc.MerchantKyc> merchantKycsWithMinimalFields(){
      return new com.doublechaintech.merchantservice.merchantkyc.MerchantKycRequest(com.doublechaintech.merchantservice.merchantkyc.MerchantKyc.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.doublechaintech.merchantservice.outboxevent.OutboxEventRequest<com.doublechaintech.merchantservice.outboxevent.OutboxEvent> outboxEvents(){
      return new com.doublechaintech.merchantservice.outboxevent.OutboxEventRequest(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.merchantservice.outboxevent.OutboxEventRequest<com.doublechaintech.merchantservice.outboxevent.OutboxEvent> outboxEventsWithMinimalFields(){
      return new com.doublechaintech.merchantservice.outboxevent.OutboxEventRequest(com.doublechaintech.merchantservice.outboxevent.OutboxEvent.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusTypeRequest<com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType> merchantStatusTypes(){
      return new com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusTypeRequest(com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusTypeRequest<com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType> merchantStatusTypesWithMinimalFields(){
      return new com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusTypeRequest(com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.doublechaintech.merchantservice.eventstatustype.EventStatusTypeRequest<com.doublechaintech.merchantservice.eventstatustype.EventStatusType> eventStatusTypes(){
      return new com.doublechaintech.merchantservice.eventstatustype.EventStatusTypeRequest(com.doublechaintech.merchantservice.eventstatustype.EventStatusType.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.merchantservice.eventstatustype.EventStatusTypeRequest<com.doublechaintech.merchantservice.eventstatustype.EventStatusType> eventStatusTypesWithMinimalFields(){
      return new com.doublechaintech.merchantservice.eventstatustype.EventStatusTypeRequest(com.doublechaintech.merchantservice.eventstatustype.EventStatusType.class).withVersion(Operator.GREATER_THAN, 0l);
  }


}