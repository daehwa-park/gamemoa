package com.moa.gamemoa.dto.member;

import lombok.Getter;

@Getter
public class MemberPassChangeRequestDto {
    private Long memberId;
    private String curPass;
    private String newPass;
    private String newPassRepeat;
}
