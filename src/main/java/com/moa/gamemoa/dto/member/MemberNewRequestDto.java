package com.moa.gamemoa.dto.member;

import lombok.Getter;
import lombok.Setter;

@Getter
public class MemberNewRequestDto {
    private String userId;

    private String userPass;

    private String nickname;

    private String userName;

    private String address;

    private String phone;
}
