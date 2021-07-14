package com.icia.mjcinema.domain.objects.bjh.ch05;

import com.icia.mjcinema.domain.objects.bjh.ch02.Money;

import java.time.Duration;

public class NoneDiscountMovie extends Movie {



    public NoneDiscountMovie(String title , Duration runningTime , Money fee){
        super(title , runningTime , fee);
    }

    @Override
    protected  Money calculateDiscountAmount(){
        return Money.ZERO;
    }

}
