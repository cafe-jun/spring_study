package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach () {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
    @Test
    @Commit
    void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setName("hello");
        // When
        Long saveId = memberService.join(member);
        // Then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(),findMember.getName());
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // Given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        // When
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,() -> memberService.join(member2)); // 예외 발생
        // 에러 메세지 검증
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMember() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);
        //when
        List<Member> result = memberService.findMember();
        //then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void findOne() {
        // Given
        Member member1 = new Member();
        member1.setName("spring1");
        Long saveId = memberService.join(member1);
        // When
        Member member = memberService.findOne(saveId).get();
        // Then
        assertThat(saveId).isEqualTo(member.getId());
    }
}