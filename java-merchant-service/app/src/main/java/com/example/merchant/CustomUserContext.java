package com.example.merchant;

import io.teaql.runtime.DefaultUserContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import com.doublechaintech.merchantservice.MerchantServiceUserContext;

@Component
@RequestScope
public class CustomUserContext extends DefaultUserContext implements MerchantServiceUserContext {
  
  public CustomUserContext(io.teaql.runtime.TeaQLRuntime runtime) {
    super(runtime);
  }

  public void init(Object request) {
      // Custom initialization if needed
  }
}
