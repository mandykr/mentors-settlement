package com.mentors.mentorssettlement.domain.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.mentors.mentorssettlement.domain.vo.Money.wons;
import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {
    private UUID memberId;

    @BeforeEach
    void setup() {
        memberId = UUID.fromString("3db756fd-f540-4509-be4e-e96a3ac8fee7");
    }

    @DisplayName("지불금을 차감한다.")
    @Test
    void deduct() {
        Account account = new Account(memberId, wons(30_000));
        account.deduct(wons(15_000));
        assertThat(account.getAmount()).isEqualTo(wons(30_000 - 15_000));
    }

    @DisplayName("수익금을 입금한다.")
    @Test
    void deposit() {
        Account account = new Account(memberId, wons(30_000));
        account.deposit(wons(15_000));
        assertThat(account.getAmount()).isEqualTo(wons(30_000 + 15_000));
    }
}
