package com.moa.gamemoa.dto.member;

import lombok.Getter;

@Getter
public class MemberDataChangeRequestDto {
    private Long memberId;
    private String nickname;
    private String userName;
    private String address;
    private String phone;
}
