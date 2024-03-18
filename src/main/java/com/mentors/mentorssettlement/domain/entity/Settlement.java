package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.Money;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Settlement {
    private SettlementPolicy settlementPolicy;
    private Account menteeAccount;
    private Account mentorAccount;

    public void settlePayment(Mentoring mentoring) {
        menteeAccount.deduct(settlementPolicy.calculatePayment(mentoring));
    }

    public void settleProfits(Mentoring mentoring, Money payment) {
        mentorAccount.deposit(settlementPolicy.calculateProfits(mentoring, payment));
    }
}
