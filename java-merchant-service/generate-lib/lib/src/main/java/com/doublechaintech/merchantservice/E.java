package com.doublechaintech.merchantservice;

import com.doublechaintech.merchantservice.eventstatustype.EventStatusType;
import com.doublechaintech.merchantservice.eventstatustype.EventStatusTypeExpression;
import com.doublechaintech.merchantservice.merchant.Merchant;
import com.doublechaintech.merchantservice.merchant.MerchantExpression;
import com.doublechaintech.merchantservice.merchantkyc.MerchantKyc;
import com.doublechaintech.merchantservice.merchantkyc.MerchantKycExpression;
import com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType;
import com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusTypeExpression;
import com.doublechaintech.merchantservice.outboxevent.OutboxEvent;
import com.doublechaintech.merchantservice.outboxevent.OutboxEventExpression;
import com.doublechaintech.merchantservice.platform.Platform;
import com.doublechaintech.merchantservice.platform.PlatformExpression;
import io.teaql.core.value.ValueExpression;

public class E  {
  public static PlatformExpression<Platform, Platform, Platform> platform(Platform platform){
      return new PlatformExpression(new ValueExpression(platform));
  }
  public static MerchantExpression<Merchant, Merchant, Merchant> merchant(Merchant merchant){
      return new MerchantExpression(new ValueExpression(merchant));
  }
  public static MerchantKycExpression<MerchantKyc, MerchantKyc, MerchantKyc> merchantKyc(MerchantKyc merchantKyc){
      return new MerchantKycExpression(new ValueExpression(merchantKyc));
  }
  public static OutboxEventExpression<OutboxEvent, OutboxEvent, OutboxEvent> outboxEvent(OutboxEvent outboxEvent){
      return new OutboxEventExpression(new ValueExpression(outboxEvent));
  }
  public static MerchantStatusTypeExpression<MerchantStatusType, MerchantStatusType, MerchantStatusType> merchantStatusType(MerchantStatusType merchantStatusType){
      return new MerchantStatusTypeExpression(new ValueExpression(merchantStatusType));
  }
  public static EventStatusTypeExpression<EventStatusType, EventStatusType, EventStatusType> eventStatusType(EventStatusType eventStatusType){
      return new EventStatusTypeExpression(new ValueExpression(eventStatusType));
  }
}