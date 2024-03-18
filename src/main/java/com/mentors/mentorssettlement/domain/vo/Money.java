package com.mentors.mentorssettlement.domain.vo;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Money {
    public static final Money ZERO = Money.wons(0);
    private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

    private final BigDecimal amount;

    protected Money() {
        this.amount = BigDecimal.valueOf(0);
    }

    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }

    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }

    public Money times(double multiplicand) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(multiplicand))
                .setScale(0, RoundingMode.CEILING));
    }

    public Money percentOf(double percent) {
        return new Money((this.amount.multiply(
                BigDecimal.valueOf(percent).divide(ONE_HUNDRED, 3, RoundingMode.HALF_UP)))
                .setScale(0, RoundingMode.CEILING));
    }

    public boolean isLessThan(Money other) {
        return amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }
}
