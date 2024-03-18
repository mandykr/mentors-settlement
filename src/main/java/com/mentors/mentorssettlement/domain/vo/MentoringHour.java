package com.mentors.mentorssettlement.domain.vo;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class MentoringHour {
    private final long hour;

    protected MentoringHour() {
        this.hour = Long.MIN_VALUE;
    }

    public static MentoringHour hour(long hour) {
        return new MentoringHour(hour);
    }
}
