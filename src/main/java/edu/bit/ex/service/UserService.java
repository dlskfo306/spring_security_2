package edu.bit.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.ex.mapper.UserMapper;
import edu.bit.ex.vo.UserVO;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
@Service
public class UserService {
    
    //암호화모듈
    @Autowired
    private BCryptPasswordEncoder passEncoder;
    
    @Autowired
    private UserMapper userMapper;
    
    @Transactional(rollbackFor = Exception.class)
    public void addUser(UserVO userVO) {
        //여기서부터 패스워드 암호화
        String password = userVO.getPassword();
        String encode = passEncoder.encode(password);
        
        userVO.setPassword(encode);
        
        userMapper.insertUser(userVO);
        userMapper.insertAuthorities(userVO);
    }

}
