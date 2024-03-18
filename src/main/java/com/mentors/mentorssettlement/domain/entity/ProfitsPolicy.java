package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.Money;

public interface ProfitsPolicy {
    Money calculate(ProfitsCondition profitsCondition);
}
