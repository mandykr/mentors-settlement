package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.MentorLevel;
import com.mentors.mentorssettlement.domain.vo.Money;

import java.util.HashMap;

import static com.mentors.mentorssettlement.domain.vo.MentorLevel.*;

public class HourlyLevelPaymentRuleFixture {
    public static final HourlyLevelPaymentRule paymentRule;

    static {
        HashMap<MentorLevel, Money> hourlyAmount = new HashMap<>();
        hourlyAmount.put(BEGINNER, Money.wons(3_000));
        hourlyAmount.put(AMATEUR, Money.wons(5_000));
        hourlyAmount.put(SEMIPRO, Money.wons(10_000));
        hourlyAmount.put(PRO, Money.wons(30_000));

        paymentRule = new HourlyLevelPaymentRule(hourlyAmount);
    }
}
