package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Member;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepository {
    private final List<Member> members = new ArrayList<>();

    public void save(Member member) {
        members.add(member);
    }

    public List<Member> findAll() {
        return members;
    }

    public Member findById(Long id) {
        return members.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
