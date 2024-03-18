package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.Money;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {
    private UUID memberId;
    private Money amount;

    public void deduct(Money payment) {
        this.amount = this.amount.minus(payment);
    }

    public void deposit(Money profits) {
        this.amount = this.amount.plus(profits);
    }
}
