package com.moa.gamemoa.service;

import com.moa.gamemoa.domain.Member;
import com.moa.gamemoa.dto.member.MemberDataChangeRequestDto;
import com.moa.gamemoa.dto.member.MemberNewRequestDto;
import com.moa.gamemoa.dto.member.MemberPassChangeRequestDto;
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
        Member member = Member.createMember(request.getUserId(), request.getUserPass(), request.getUserName(), request.getNickname(), request.getPhone(), request.getAddress());

        Member newMember = memberRepository.save(member);

        return newMember.getId();
    }

    @Transactional
    public void updatePass(MemberPassChangeRequestDto request) {
        Member member = memberRepository.findMember(request.getMemberId()).orElseThrow();

        if (!memberRepository.existsByIdAndUserPass(request.getMemberId(), request.getCurPass())) {
            throw new RuntimeException("현재 비밀번호가 다릅니다.");
        }
        if (!request.getNewPass().equals(request.getNewPassRepeat())){
            throw new RuntimeException("새로운 비밀번호가 다릅니다.");
        }

        // 비밀번호 적합성 검증

        member.updatePass(request.getNewPass());
    }

    @Transactional
    public void updateMember(MemberDataChangeRequestDto request) {
        Member member = memberRepository.findMember(request.getMemberId()).orElseThrow();

        // 적합성 체크

        member.updateMember(request.getUserName(), request.getNickname(), request.getAddress(), request.getPhone());

    }
}
