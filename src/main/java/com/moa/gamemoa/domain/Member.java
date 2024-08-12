package com.moa.gamemoa.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String userId;

    private String userPass;

    private String nickname;

    private String userName;

    private String address;

    private String phone;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
