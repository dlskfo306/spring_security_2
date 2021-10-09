package edu.bit.ex.vo;

import java.util.ArrayList; 
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//principal.member.username 이런식으로 붙음
@Setter
@Getter
@ToString
public class MemberUser extends User {

    private MemberVO member;
       
       //기본적으로 부모의 생성자를 호출해야만 정상적으로 작동
    
    public MemberUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        //super의 밑에 3개는 무조건 필수!
        super(username, password, authorities);
    }

    public MemberUser(MemberVO memberVO) {

        //super의 밑에 3개는 무조건 필수!
        super(memberVO.getUsername(), memberVO.getPassword(), getAuth(memberVO));

        this.member = memberVO;
    }

    // 유저가 갖고 있는 권한 목록
    public static Collection<? extends GrantedAuthority> getAuth(MemberVO memberVO) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (AuthVO auth : memberVO.getAuthList()) {
            authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
        }

        return authorities;
    }
}
