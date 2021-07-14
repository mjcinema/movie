package com.icia.mjcinema.domain.objects.bjh.ch05;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
