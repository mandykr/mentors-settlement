package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.Money;

public interface PaymentPolicy {
    Money calculate(PaymentCondition condition);
}
