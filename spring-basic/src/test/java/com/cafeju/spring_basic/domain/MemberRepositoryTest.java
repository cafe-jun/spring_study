package com.cafeju.spring_basic.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }
    @Test
    void save() {
        //given
        Member member = new Member("hello", 20);
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(savedMember.getId());

        assertEquals(findMember, savedMember);
    }

    @Test
    void findAll() {
        //given
        Member member = new Member("hello", 20);
        Member member1 = new Member("hello1", 30);
        //when
        memberRepository.save(member);
        memberRepository.save(member1);
        //then
        assertEquals(memberRepository.findAll().size(), 2);

    }
}