package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.mentors.mentorssettlement.domain.entity.HourlyLevelPaymentRuleFixture.paymentRule;
import static com.mentors.mentorssettlement.domain.entity.ProfitsLevelCommissionRatioRuleFixture.ratioRule;
import static com.mentors.mentorssettlement.domain.vo.MentorLevel.PRO;
import static com.mentors.mentorssettlement.domain.vo.MentoringHour.hour;
import static com.mentors.mentorssettlement.domain.vo.MentoringStatus.ACCEPTANCE;
import static com.mentors.mentorssettlement.domain.vo.MentoringStatus.COMPLETION;
import static com.mentors.mentorssettlement.domain.vo.Money.wons;
import static org.assertj.core.api.Assertions.assertThat;

class SettlementPolicyTest {
    private SettlementPolicy settlementPolicy;

    @BeforeEach
    void setup() {
        PaymentPolicy paymentPolicy = new BasicPaymentPolicy(paymentRule);
        ProfitsPolicy profitsPolicy = new BasicProfitsPolicy();
        CommissionPolicy commissionPolicy = new BasicCommissionPolicy(ratioRule);
        settlementPolicy = new SettlementPolicy(paymentPolicy, commissionPolicy, profitsPolicy);
    }

    @DisplayName("기본 지불금 정책에 따라 멘티의 지불금을 정산한다.")
    @Test
    void calculatePayment() {
        Mentoring mentoring = new Mentoring(PRO, ACCEPTANCE, hour(3));
        Money payment = settlementPolicy.calculatePayment(mentoring);
        assertThat(payment).isEqualTo(wons(90_000));
    }

    @DisplayName("기본 수익금, 기본 수수료 정책에 따라 멘토의 수익금을 정산한다.")
    @Test
    void calculateProfits() {
        Mentoring mentoring = new Mentoring(PRO, COMPLETION, hour(3));
        Money profits = settlementPolicy.calculateProfits(mentoring, wons(90_000));
        assertThat(profits).isEqualTo(wons(87_660));
    }
}
