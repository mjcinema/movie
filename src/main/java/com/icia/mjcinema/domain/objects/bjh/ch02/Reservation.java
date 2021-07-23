package com.icia.mjcinema.domain.objects.bjh.ch02;

import com.icia.mjcinema.domain.User;

public class Reservation {

    private Customer customer;
    private Screening screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }

    public Reservation(User user, com.icia.mjcinema.domain.Screening screening, com.icia.mjcinema.domain.Money calculateFee, int audienceCount) {
    }
}
