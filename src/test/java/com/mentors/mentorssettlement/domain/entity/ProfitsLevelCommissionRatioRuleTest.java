package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.MentorLevel;
import com.mentors.mentorssettlement.domain.vo.Ratio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.mentors.mentorssettlement.domain.vo.Money.wons;
import static com.mentors.mentorssettlement.domain.entity.ProfitsLevelCommissionRatioRuleFixture.ratioRule;
import static org.assertj.core.api.Assertions.assertThat;

class ProfitsLevelCommissionRatioRuleTest {

    @DisplayName("A type: 수익금이 '1원 이상' 일 때 레벨에 따라 2.7%, 2.6%, 2.5%, 2.4% 비율을 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "BEGINNER, 2.7",
            "AMATEUR, 2.6",
            "SEMIPRO, 2.5",
            "PRO, 2.4"})
    void getMatchTypeAGOE(MentorLevel level, double expected) {
        CommissionCondition condition = new CommissionCondition(wons(1), level);
        Ratio actual = ratioRule.getMatch(condition);
        assertThat(actual).isEqualTo(new Ratio(expected));
    }

    @DisplayName("A type: 수익금이 '1만원 미만' 일 때 레벨에 따라 2.7%, 2.6%, 2.5%, 2.4% 비율을 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "BEGINNER, 2.7",
            "AMATEUR, 2.6",
            "SEMIPRO, 2.5",
            "PRO, 2.4"})
    void getMatchTypeALT(MentorLevel level, double expected) {
        CommissionCondition condition = new CommissionCondition(wons(9_999), level);
        Ratio actual = ratioRule.getMatch(condition);
        assertThat(actual).isEqualTo(new Ratio(expected));
    }

    @DisplayName("B type: 수익금이 '1만원 이상' 일 때 레벨에 따라 2.7%, 2.7%, 2.6%, 2.5% 비율을 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "BEGINNER, 2.8",
            "AMATEUR, 2.7",
            "SEMIPRO, 2.6",
            "PRO, 2.5"})
    void getMatchTypeBGOE(MentorLevel level, double expected) {
        CommissionCondition condition = new CommissionCondition(wons(10_000), level);
        Ratio actual = ratioRule.getMatch(condition);
        assertThat(actual).isEqualTo(new Ratio(expected));
    }

    @DisplayName("B type: 수익금이 '5만원 미만' 일 때 레벨에 따라 2.7%, 2.7%, 2.6%, 2.5% 비율을 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "BEGINNER, 2.8",
            "AMATEUR, 2.7",
            "SEMIPRO, 2.6",
            "PRO, 2.5"})
    void getMatchTypeBLT(MentorLevel level, double expected) {
        CommissionCondition condition = new CommissionCondition(wons(49_999), level);
        Ratio actual = ratioRule.getMatch(condition);
        assertThat(actual).isEqualTo(new Ratio(expected));
    }

    @DisplayName("C type: 수익금이 '5만원 이상' 일 때 레벨에 따라 2.9%, 2.8%, 2.7%, 2.6% 비율을 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "BEGINNER, 2.9",
            "AMATEUR, 2.8",
            "SEMIPRO, 2.7",
            "PRO, 2.6"})
    void getMatchTypeCGOE(MentorLevel level, double expected) {
        CommissionCondition condition = new CommissionCondition(wons(50_000), level);
        Ratio actual = ratioRule.getMatch(condition);
        assertThat(actual).isEqualTo(new Ratio(expected));
    }

    @DisplayName("C type: 수익금이 '10만원 미만' 일 때 레벨에 따라 2.9%, 2.8%, 2.7%, 2.6% 비율을 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "BEGINNER, 2.9",
            "AMATEUR, 2.8",
            "SEMIPRO, 2.7",
            "PRO, 2.6"})
    void getMatchTypeCLT(MentorLevel level, double expected) {
        CommissionCondition condition = new CommissionCondition(wons(99_000), level);
        Ratio actual = ratioRule.getMatch(condition);
        assertThat(actual).isEqualTo(new Ratio(expected));
    }

    @DisplayName("D type: 수익금이 '10만원 이상' 일 때 레벨에 따라 1%, 2.9%, 2.8%, 2.7% 비율을 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "BEGINNER, 3.0",
            "AMATEUR, 2.9",
            "SEMIPRO, 2.8",
            "PRO, 2.7"})
    void getMatchTypeDGOE(MentorLevel level, double expected) {
        CommissionCondition condition = new CommissionCondition(wons(100_000), level);
        Ratio actual = ratioRule.getMatch(condition);
        assertThat(actual).isEqualTo(new Ratio(expected));
    }
}
