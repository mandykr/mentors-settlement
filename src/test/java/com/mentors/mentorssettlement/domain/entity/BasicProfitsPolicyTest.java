package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BasicProfitsPolicyTest {

    @DisplayName("수익금을 계산한다.")
    @Test
    void calculate() {
        BasicProfitsPolicy policy = new BasicProfitsPolicy();
        ProfitsCondition condition = new ProfitsCondition(Money.wons(15_000), Money.wons(150));
        Money profits = policy.calculate(condition);
        assertThat(profits).isEqualTo(Money.wons(15_000 - 150));
    }
}
