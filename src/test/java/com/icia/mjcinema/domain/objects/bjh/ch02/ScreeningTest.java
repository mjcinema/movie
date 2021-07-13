package com.icia.mjcinema.domain.objects.bjh.ch02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.*;

class ScreeningTest {

    @Test
    void getStartTime() {
    }

    @Test
    void isSequence() {
    }

    @Test
    @DisplayName("영화 요금을 구한다.")
    void getMovieFee() {
        DiscountCondition discountCondition = new DefaultDiscountCondition();
        DiscountPolicy discountPolicy = new AmountDiscountPolicy(Money.wons(1000), discountCondition);
        Movie movie = new Movie("랑종", Duration.ofMinutes(130), Money.wons(12000), discountPolicy);

        Screening screening = new Screening(movie, 1, LocalDateTime.of(2021, 07, 13, 23, 30));

        Money money = screening.getMovieFee();

        assertThat(money).isEqualTo(Money.wons(12000));
    }

    @Test
    void reserve() {
    }
}