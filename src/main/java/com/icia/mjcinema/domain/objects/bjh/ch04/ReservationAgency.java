package com.icia.mjcinema.domain.objects.bjh.ch04;

import com.icia.mjcinema.domain.objects.bjh.ch02.Money;

import java.time.LocalTime;

public class ReservationAgency {

    public Reservation reserve(Screening screening , Customer customer , int audienceCount){
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer , screening , fee ,audienceCount);
    }
}
