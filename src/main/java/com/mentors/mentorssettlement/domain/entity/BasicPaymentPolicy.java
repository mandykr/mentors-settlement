package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.Money;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class BasicPaymentPolicy implements PaymentPolicy {
    private final PaymentRule paymentRule;

    public BasicPaymentPolicy() {
        this.paymentRule = null;
    }

    @Override
    public Money calculate(PaymentCondition condition) {
        return Objects.requireNonNull(paymentRule).getMatch(condition)
                .times(condition.getHour());
    }
}
