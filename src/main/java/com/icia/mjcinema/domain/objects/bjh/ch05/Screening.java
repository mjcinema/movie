package com.icia.mjcinema.domain.objects.bjh.ch05;

import com.icia.mjcinema.domain.objects.bjh.ch02.Money;
import com.icia.mjcinema.domain.objects.bjh.ch04.Customer;

import lombok.Getter;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    @Getter
    private int sequence;
    @Getter
    private LocalDateTime whenScreened;

    public Reservation reserve(Customer customer , int audienceCount){
        return new Reservation(customer , this , calculateFee(audienceCount) , audienceCount);
    }

    private Money calculateFee(int audienceCount){
        return movie.calculateMovieFee(this).times(audienceCount);
    }


}
