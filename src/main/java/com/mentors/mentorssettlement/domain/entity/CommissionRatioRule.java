package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.Ratio;

public interface CommissionRatioRule {
    Ratio getMatch(CommissionCondition condition);
}
