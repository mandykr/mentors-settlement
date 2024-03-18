package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.Money;
import com.mentors.mentorssettlement.domain.vo.ProfitsDuration;
import com.mentors.mentorssettlement.domain.vo.Ratio;
import com.mentors.mentorssettlement.domain.vo.RatioPerLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class ProfitsLevelCommissionRatioRule implements CommissionRatioRule {
    private final Map<ProfitsDuration, RatioPerLevel> rules;

    protected ProfitsLevelCommissionRatioRule() {
        this.rules = null;
    }

    @Override
    public Ratio getMatch(CommissionCondition condition) {
        return Objects.requireNonNull(rules)
                .get(findDuration(condition.getProfits()))
                .getRatioPerLevel()
                .get(condition.getLevel());
    }

    private ProfitsDuration findDuration(Money profits) {
        return Objects.requireNonNull(rules).keySet().stream()
                .filter(d -> d.contains(profits))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
