package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberRepository;
import com.example.demo.entity.Member;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final AtomicLong idCounter = new AtomicLong(1); 

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void registerMember(String name, String email) {
        Member member = new Member(idCounter.getAndIncrement(), name, email);
        memberRepository.save(member);
        System.out.println("Member registered successfully: " + member);
    }
    
    public Member getMemberById(Long id) {
        return memberRepository.findById(id);
    }
}
