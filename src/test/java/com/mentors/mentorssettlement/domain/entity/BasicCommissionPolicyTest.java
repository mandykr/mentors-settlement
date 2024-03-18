package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.MentorLevel;
import com.mentors.mentorssettlement.domain.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.mentors.mentorssettlement.domain.entity.ProfitsLevelCommissionRatioRuleFixture.ratioRule;
import static org.assertj.core.api.Assertions.assertThat;

class BasicCommissionPolicyTest {

    @DisplayName("수익금/레벨 별 수수료 비율 규칙으로 수수료를 계산한다.")
    @Test
    void calculate() {
        BasicCommissionPolicy commissionPolicy = new BasicCommissionPolicy(ratioRule);
        Money commission = commissionPolicy.calculate(
                new CommissionCondition(Money.wons(15_000), MentorLevel.BEGINNER));
        assertThat(commission).isEqualTo(Money.wons(15_000).percentOf(2.8));
    }
}
