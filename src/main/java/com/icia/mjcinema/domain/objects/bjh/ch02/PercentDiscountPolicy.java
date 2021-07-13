package com.icia.mjcinema.domain.objects.bjh.ch02;

public class PercentDiscountPolicy extends DefaultDiscountPolicy{

    private double percent;

    public PercentDiscountPolicy(double percent , DiscountCondition ... conditions){
        super(conditions);
        this.percent = percent;
    }


    @Override
    protected Money getDiscountAmount(Screening Screening) {
        return Screening.getMovieFee().times(percent);
    }
}
