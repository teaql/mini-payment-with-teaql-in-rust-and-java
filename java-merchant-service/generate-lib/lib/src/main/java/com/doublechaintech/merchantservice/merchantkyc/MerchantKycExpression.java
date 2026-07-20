package com.doublechaintech.merchantservice.merchantkyc;

import com.doublechaintech.merchantservice.merchant.Merchant;
import com.doublechaintech.merchantservice.merchant.MerchantExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class MerchantKycExpression<T, E, U extends MerchantKyc> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public MerchantKycExpression(Expression<T, U> expression){
        super(expression);
    }

    public MerchantKycExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public MerchantKycExpression<T, U, U> updateId(Long id){
        return new MerchantKycExpression(this, $it -> {((MerchantKyc)$it).__internalSet("id", id); return this;});
     }

     public MerchantKycExpression<T, U, U> save(UserContext userContext){
        return new MerchantKycExpression(this, $it -> ((MerchantKyc)$it).auditAs("Saved by Expression").save(userContext));
     }

     public MerchantKycExpression<T, U, U> save(String intent, UserContext userContext){
        return new MerchantKycExpression(this, $it -> ((MerchantKyc)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getBusinessLicenseNo(){
       return apply(MerchantKyc::getBusinessLicenseNo);
    }
    public MerchantKycExpression<T, U, U> updateBusinessLicenseNo(String businessLicenseNo){
       return new MerchantKycExpression(this, $it ->  ((MerchantKyc)$it).updateBusinessLicenseNo(businessLicenseNo));
    }

    public Expression<T, String> getLegalPerson(){
       return apply(MerchantKyc::getLegalPerson);
    }
    public MerchantKycExpression<T, U, U> updateLegalPerson(String legalPerson){
       return new MerchantKycExpression(this, $it ->  ((MerchantKyc)$it).updateLegalPerson(legalPerson));
    }

    public Expression<T, String> getBankAccountNo(){
       return apply(MerchantKyc::getBankAccountNo);
    }
    public MerchantKycExpression<T, U, U> updateBankAccountNo(String bankAccountNo){
       return new MerchantKycExpression(this, $it ->  ((MerchantKyc)$it).updateBankAccountNo(bankAccountNo));
    }

    public MerchantExpression<T, U, Merchant> getMerchant(){
       return new MerchantExpression(this, $it ->  ((MerchantKyc)$it).getMerchant());
    }

    public MerchantKycExpression<T, U, U> updateMerchant(Merchant merchant){
       return new MerchantKycExpression(this, $it ->  ((MerchantKyc)$it).updateMerchant(merchant));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(MerchantKyc::getCreateTime);
    }
    public MerchantKycExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new MerchantKycExpression(this, $it ->  ((MerchantKyc)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(MerchantKyc::getUpdateTime);
    }
    public MerchantKycExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new MerchantKycExpression(this, $it ->  ((MerchantKyc)$it).updateUpdateTime(updateTime));
    }

}