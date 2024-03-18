package com.mentors.mentorssettlement.domain.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class ProfitsDuration {
    private final Money from;
    private final Money to;

    protected ProfitsDuration() {
        this.from = Money.ZERO;
        this.to = Money.ZERO;
    }

    public boolean contains(Money profits) {
        return profits.isGreaterThanOrEqual(from)
                && profits.isLessThan(to);
    }
}
