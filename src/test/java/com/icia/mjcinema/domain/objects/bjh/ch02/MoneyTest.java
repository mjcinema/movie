package com.icia.mjcinema.domain.objects.bjh.ch02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Money 값 객체 테스트")
class MoneyTest {


    @Test
    @DisplayName("LongType으로 금액이 들어왔을 때 생성이 된다.")
    void Long_Type으로_금액이_들어왔을_때_생성이_된다() {
        BigDecimal bigDecimalAmount =BigDecimal.valueOf(10000L);

        Long amount = 10000L;
        Money money = Money.wons(amount);

        assertThat(money).isEqualTo(new Money(bigDecimalAmount));
    }

    @Test
    @DisplayName("DoubleType으로 금액이 들어왔을 때 생성이 된다.")
    void MoneyByDoubleType() {
        BigDecimal bigDecimalAmount = BigDecimal.valueOf(300000L);
        Money moneyByBigDecimal = new Money(bigDecimalAmount);

        Double amount = 3e5;
        Money moneyByDouble = Money.wons(amount);

        assertThat(moneyByDouble).isEqualTo(moneyByBigDecimal);
    }

    @Test
    @DisplayName("800원과 700원을 더하면 1500이 된다.")
    void plus() {
        Money money = Money.wons(800);
        Money other = Money.wons(700);

        Money sum = money.plus(other);
        assertThat(sum).isEqualTo(Money.wons(1500));
    }

    @Test
    @DisplayName("2000원에서 700원을 빼면 1300원이 된다.")
    void minus() {
        Money money = Money.wons(2000L);
        Money other = Money.wons(700);

        assertThat(money.minus(other)).isEqualTo(Money.wons(1300));
    }

    @Test
    @DisplayName("2000원을 2배 곱하면 4000원이다.")
    void times() {
        Money money = Money.wons(2000);

        assertThat(money.times(2)).isEqualTo(Money.wons(4000));
    }

    @Test
    @DisplayName("1000원은 2000원과 같지 않다")
    void equals() {
        assertThat(Money.wons(1000)).isEqualTo(Money.wons(2000));
    }

    @Test
    @DisplayName("1000원은 500원보다 작지 않다.")
    void isLessThan() {
        Money money = Money.wons(1000);
        Money other = Money.wons(500);

        assertThat(money.isLessThan(other)).isFalse();
    }

    @Test
    @DisplayName("1000원은 500원 보다 크거나 같다.")
    void isGreaterThanOrEqual() {
        Money money = Money.wons(1000);
        Money other = Money.wons(500);

        assertThat(money.isGreaterThanOrEqual(other)).isTrue();
    }

    @Test
    @DisplayName("1000원은 1000원 보다 크거나 같다.")
    void 천원은_isGreaterThanOrEqual() {
        Money money = Money.wons(1000);
        Money other = Money.wons(1000);

        assertThat(money.isGreaterThanOrEqual(other)).isTrue();
    }
}