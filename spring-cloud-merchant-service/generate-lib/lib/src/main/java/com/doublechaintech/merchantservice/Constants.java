package com.doublechaintech.merchantservice;

import com.doublechaintech.merchantservice.eventstatustype.EventStatusType;
import com.doublechaintech.merchantservice.merchantstatustype.MerchantStatusType;
import com.doublechaintech.merchantservice.platform.Platform;

public interface Constants  {
  public static final long PLATFORM_ID = 1l;
  public static final Platform PLATFORM = Platform.refer(PLATFORM_ID);
  public static final long MERCHANT_STATUS_TYPE_ACTIVE_ID = 1001l ;
  public static final MerchantStatusType MERCHANT_STATUS_TYPE_ACTIVE = MerchantStatusType.refer(MERCHANT_STATUS_TYPE_ACTIVE_ID);public static final long MERCHANT_STATUS_TYPE_PENDING_VERIFICATION_ID = 1002l ;
  public static final MerchantStatusType MERCHANT_STATUS_TYPE_PENDING_VERIFICATION = MerchantStatusType.refer(MERCHANT_STATUS_TYPE_PENDING_VERIFICATION_ID);public static final long MERCHANT_STATUS_TYPE_SUSPENDED_ID = 1003l ;
  public static final MerchantStatusType MERCHANT_STATUS_TYPE_SUSPENDED = MerchantStatusType.refer(MERCHANT_STATUS_TYPE_SUSPENDED_ID);
  public static final long EVENT_STATUS_TYPE_PENDING_ID = 1001l ;
  public static final EventStatusType EVENT_STATUS_TYPE_PENDING = EventStatusType.refer(EVENT_STATUS_TYPE_PENDING_ID);public static final long EVENT_STATUS_TYPE_PROCESSED_ID = 1002l ;
  public static final EventStatusType EVENT_STATUS_TYPE_PROCESSED = EventStatusType.refer(EVENT_STATUS_TYPE_PROCESSED_ID);public static final long EVENT_STATUS_TYPE_FAILED_ID = 1003l ;
  public static final EventStatusType EVENT_STATUS_TYPE_FAILED = EventStatusType.refer(EVENT_STATUS_TYPE_FAILED_ID);
  public static final long EVENT_STATUS_TYPE_DEAD_LETTER_ID = 1004l;
  public static final EventStatusType EVENT_STATUS_TYPE_DEAD_LETTER = EventStatusType.refer(EVENT_STATUS_TYPE_DEAD_LETTER_ID);
}