package edu.bit.ex.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
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
@ToString
public class UserVO {
    private String username;
    private String password;
    private int enabled;
    
    public UserVO() {
        this("user", "1111", 1);
    }
    //테스트용 디폴트값
}
