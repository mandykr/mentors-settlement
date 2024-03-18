package com.mentors.mentorssettlement.domain.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class RatioPerLevel {
    private final Map<MentorLevel, Ratio> ratioPerLevel;

    protected RatioPerLevel() {
        this.ratioPerLevel = null;
    }
}
