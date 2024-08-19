package com.moa.gamemoa.controller;

import com.moa.gamemoa.domain.Member;
import com.moa.gamemoa.dto.member.MemberDataChangeRequestDto;
import com.moa.gamemoa.dto.member.MemberNewRequestDto;
import com.moa.gamemoa.dto.member.MemberPassChangeRequestDto;
import com.moa.gamemoa.dto.member.MemberResponseDto;
import com.moa.gamemoa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findMember(@PathVariable("id") Long memberId) {
        MemberResponseDto response = memberService.findMember(memberId);

        return ResponseEntity.ok()
                .body(response);
    }

    @PostMapping("/new")
    public ResponseEntity<Long> newMember(@RequestBody MemberNewRequestDto request) {
        Long memberId = memberService.newMember(request);

        return ResponseEntity.ok()
                .body(memberId);
    }

    @PatchMapping("/pass")
    public ResponseEntity<Long> passChange(@RequestBody MemberPassChangeRequestDto request) {
        memberService.updatePass(request);

        MemberResponseDto member = memberService.findMember(request.getMemberId());

        return ResponseEntity.ok()
                .body(member.getMemberId());
    }

    @PutMapping
    public ResponseEntity<Long> dataChange(@RequestBody MemberDataChangeRequestDto request) {
        memberService.updateMember(request);

        MemberResponseDto member = memberService.findMember(request.getMemberId());
        return ResponseEntity.ok()
                .body(member.getMemberId());
    }

}
