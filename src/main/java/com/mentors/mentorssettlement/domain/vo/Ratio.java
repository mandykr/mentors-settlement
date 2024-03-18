package com.mentors.mentorssettlement.domain.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Ratio {
    private final double percent;

    protected Ratio() {
        this.percent = 0.0;
    }
}
