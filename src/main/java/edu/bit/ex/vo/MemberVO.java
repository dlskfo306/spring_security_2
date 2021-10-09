package edu.bit.ex.vo;

import java.util.List; 

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

/*
USERNAME NOT NULL VARCHAR2(50)
PASSWORD NOT NULL VARCHAR1(100)
ENABLED           CHAR(1)
 */

@Log4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberVO {
  
    private String username;
    private String password;
    private String enabled;
    
    private List<AuthVO> authList;
    //MemberVO (1) : AuthList (N) 관계
}