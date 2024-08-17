package com.moa.gamemoa.controller;

import com.moa.gamemoa.dto.member.MemberNewRequestDto;
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



}
