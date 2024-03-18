package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.Money;

public class BasicProfitsPolicy implements ProfitsPolicy {
    @Override
    public Money calculate(ProfitsCondition profitsCondition) {
        return profitsCondition.getProfits()
                .minus(profitsCondition.getCommission());
    }
}
