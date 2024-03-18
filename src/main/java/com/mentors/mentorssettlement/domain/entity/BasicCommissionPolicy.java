package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.Money;
import com.mentors.mentorssettlement.domain.vo.Ratio;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@RequiredArgsConstructor
public class BasicCommissionPolicy implements CommissionPolicy {
    private final CommissionRatioRule rule;

    @Override
    public Money calculate(CommissionCondition condition) {
        Ratio ratio = findRatio(condition);
        return condition.getProfits().percentOf(ratio.getPercent());
    }

    private Ratio findRatio(CommissionCondition condition) {
        return Objects.requireNonNull(rule).getMatch(condition);
    }

}
