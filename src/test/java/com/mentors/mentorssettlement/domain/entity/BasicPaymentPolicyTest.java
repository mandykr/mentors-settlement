package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.mentors.mentorssettlement.domain.entity.HourlyLevelPaymentRuleFixture.paymentRule;
import static com.mentors.mentorssettlement.domain.vo.MentorLevel.PRO;
import static com.mentors.mentorssettlement.domain.vo.MentoringHour.hour;
import static org.assertj.core.api.Assertions.assertThat;

class BasicPaymentPolicyTest {

    @DisplayName("멘토의 레벨별 시간당 금액 규칙으로 지불금을 계산한다.")
    @Test
    void calculate() {
        BasicPaymentPolicy policy = new BasicPaymentPolicy(paymentRule);
        Money payment = policy.calculate(new PaymentCondition(PRO, hour(3)));
        System.out.println("payment = " + payment.getAmount());
        assertThat(payment).isEqualTo(Money.wons(90_000));
    }
}
