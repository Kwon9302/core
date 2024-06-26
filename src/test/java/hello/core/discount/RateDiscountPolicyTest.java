package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIPsms 10%할인 적용")
    void discount() {

        Member member = new Member(1L, "memberVIP", Grade.VIP);
        int discount = discountPolicy.discount(member,10000);
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIp아니면 할인 x")
    void vip_x() {
        Member member = new Member(1L, "memberVIP", Grade.BASIC);
        int discount = discountPolicy.discount(member,20000);
        assertThat(discount).isEqualTo(1000);
    }
}