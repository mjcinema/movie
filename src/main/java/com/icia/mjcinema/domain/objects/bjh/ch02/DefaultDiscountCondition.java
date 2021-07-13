package com.icia.mjcinema.domain.objects.bjh.ch02;

public class DefaultDiscountCondition implements DiscountCondition {

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return true;
    }
}
