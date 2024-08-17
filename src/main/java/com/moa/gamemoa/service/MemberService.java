package com.moa.gamemoa.service;

import com.moa.gamemoa.domain.Member;
import com.moa.gamemoa.dto.member.MemberNewRequestDto;
import com.moa.gamemoa.dto.member.MemberResponseDto;
import com.moa.gamemoa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseDto findMember(Long memberId){
        Member member = memberRepository.findMember(memberId).orElseThrow();
        MemberResponseDto dto = new MemberResponseDto();
        dto.setMemberId(member.getId());
        dto.setUserId(member.getUserId());
        dto.setNickname(member.getNickname());
        dto.setUserName(member.getUserName());

        return dto;
    }

    @Transactional
    public Long newMember(MemberNewRequestDto request) {
        Member member = Member.createMember(request);

        Member newMember = memberRepository.save(member);

        return newMember.getId();
    }
}
