package hello.core.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemberServiceTest {
    MemberService memberService;

    @Test
    void join() {
        Member member = new Member(3L, "memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println(member);
        System.out.println(findMember);
        assertThat(member).isEqualTo(findMember);
    }
}
