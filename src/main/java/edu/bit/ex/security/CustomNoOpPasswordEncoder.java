package edu.bit.ex.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder {

   //인코딩하는 메서드
   public String encode(CharSequence rawPassword) {

      //log.warn(); : 처리 가능한 문제, 향후 시스템 에러의 원인이 될 수 있는 경고성 메시지를 나타냄 
      log.warn("before encode :" + rawPassword);
      
      //패스워드를 암호화없이 그대로 저장
      return rawPassword.toString();
   }

   //요청받은 패스워드가 인코딩된 패스워드와 일치하는지 확인하는 메서드, 디코딩
   public boolean matches(CharSequence rawPassword, String encodedPassword) {

      log.warn("matches: " + rawPassword + ":" + encodedPassword);

      //패스워드를 인코딩 없이 저장했기 때문에 문자열들을 그대로 비교
      return rawPassword.toString().equals(encodedPassword);
   }

}