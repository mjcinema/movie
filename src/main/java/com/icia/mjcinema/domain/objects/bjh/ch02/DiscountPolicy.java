package com.icia.mjcinema.domain.objects.bjh.ch02;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
