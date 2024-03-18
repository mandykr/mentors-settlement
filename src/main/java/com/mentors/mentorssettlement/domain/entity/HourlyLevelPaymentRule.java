package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.MentorLevel;
import com.mentors.mentorssettlement.domain.vo.Money;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class HourlyLevelPaymentRule implements PaymentRule {
    private final HashMap<MentorLevel, Money> hourlyAmount;

    public HourlyLevelPaymentRule() {
        this.hourlyAmount = null;
    }

    @Override
    public Money getMatch(PaymentCondition paymentCondition) {
        return Objects.requireNonNull(hourlyAmount).get(paymentCondition.getLevel());
    }
}
