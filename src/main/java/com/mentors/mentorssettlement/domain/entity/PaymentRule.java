package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.Money;

public interface PaymentRule {
    Money getMatch(PaymentCondition paymentCondition);
}
