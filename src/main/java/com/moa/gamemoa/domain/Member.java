package com.moa.gamemoa.domain;

import com.moa.gamemoa.dto.member.MemberNewRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Inquiry> inquiries = new ArrayList<>();

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private Basket basket;

    //setter
    private void setUserId(String userId) {
        this.userId = userId;
    }

    private void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    private void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }

    //생성 메서드
    public static Member createMember(MemberNewRequestDto request) {
        Member member = new Member();
        member.setUserId(request.getUserId());
        member.setUserPass(request.getUserPass());
        member.setUserName(request.getUserName());
        member.setNickname(request.getNickname());
        member.setPhone(request.getPhone());
        member.setAddress(request.getAddress());

        return member;
    }

}
