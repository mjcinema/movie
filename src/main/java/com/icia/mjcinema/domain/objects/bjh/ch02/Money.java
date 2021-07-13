package com.icia.mjcinema.domain.objects.bjh.ch02;

import lombok.ToString;

import java.math.BigDecimal;

@ToString
public class Money {
    public static final Money ZERO = Money.wons(0);

    private final BigDecimal amount;

    public static Money wons(long amount){
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(double amount){
        return new Money(BigDecimal.valueOf(amount));
    }

    Money(BigDecimal amount){
        this.amount = amount;
    }

    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }

    public Money minus(Money amount){
        return new Money(this.amount.subtract(amount.amount));
    }

    public Money times(double percent){
        return new Money(this.amount.multiply(
                BigDecimal.valueOf(percent)));
    }

    public boolean isLessThan(Money other){
        return amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThanOrEqual(Money other){
        return amount.compareTo(other.amount) >= 0;
    }


    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Money)) {
            return false;
        } else {
            Money other = (Money)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$amount = this.amount;
                Object other$amount = other.amount;

                if (this$amount == null) {
                    if (other$amount != null) {
                        return false;
                    }
                }

                BigDecimal this$bigDecimalAmount = (BigDecimal) this$amount;
                BigDecimal other$bigDecimalAmount = (BigDecimal) other$amount;

                int result = this$bigDecimalAmount.compareTo(other$bigDecimalAmount);
                if (result == 0) return true;
                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Money;
    }

}
