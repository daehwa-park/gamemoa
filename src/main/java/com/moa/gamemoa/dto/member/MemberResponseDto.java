package com.moa.gamemoa.dto.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberResponseDto {
    private Long memberId;

    private String userId;

    private String userName;

    private String nickname;
}
