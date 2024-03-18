package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.Money;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SettlementPolicy {
    private PaymentPolicy paymentPolicy;
    private CommissionPolicy commissionPolicy;
    private ProfitsPolicy profitsPolicy;

    public Money calculatePayment(Mentoring mentoring) {
        PaymentCondition condition = new PaymentCondition(mentoring.getMentorLevel(), mentoring.getHour());
        return paymentPolicy.calculate(condition);
    }

    public Money calculateProfits(Mentoring mentoring, Money payment) {
        CommissionCondition commissionCondition = new CommissionCondition(payment, mentoring.getMentorLevel());
        Money commission = commissionPolicy.calculate(commissionCondition);

        ProfitsCondition profitsCondition = new ProfitsCondition(payment, commission);
        return profitsPolicy.calculate(profitsCondition);
    }
}
