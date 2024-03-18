package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.MentorLevel;
import com.mentors.mentorssettlement.domain.vo.Money;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CommissionCondition {
    private Money profits;
    private MentorLevel level;
}
