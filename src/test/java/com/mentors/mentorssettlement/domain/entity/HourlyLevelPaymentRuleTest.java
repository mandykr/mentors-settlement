package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.MentorLevel;
import com.mentors.mentorssettlement.domain.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.mentors.mentorssettlement.domain.entity.HourlyLevelPaymentRuleFixture.paymentRule;
import static com.mentors.mentorssettlement.domain.vo.MentoringHour.hour;
import static org.assertj.core.api.Assertions.assertThat;

class HourlyLevelPaymentRuleTest {

    @DisplayName("멘토의 레벨에 맞는 시간당 금액 찾아 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "BEGINNER, 3000",
            "AMATEUR, 5000",
            "SEMIPRO, 10000",
            "PRO, 30000"})
    void getMatch(MentorLevel level, long expected) {
        Money actual = paymentRule.getMatch(new PaymentCondition(level, hour(3)));
        assertThat(actual).isEqualTo(Money.wons(expected));
    }
}
