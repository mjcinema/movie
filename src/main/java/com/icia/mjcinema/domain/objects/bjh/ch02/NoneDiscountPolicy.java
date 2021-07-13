package com.icia.mjcinema.domain.objects.bjh.ch02;

public class NoneDiscountPolicy implements DiscountPolicy{

    @Override
    public Money calculateDiscountAmount(Screening Screening) {
        return Money.ZERO;
    }
}
