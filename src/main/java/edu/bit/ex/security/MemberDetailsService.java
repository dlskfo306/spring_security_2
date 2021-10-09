package edu.bit.ex.security;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.MemberMapper;
import edu.bit.ex.vo.MemberUser;
import edu.bit.ex.vo.MemberVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

//principal.users.username 이렇게 달고싶으면 (확장하고 싶으면)
//UserDetailsService에 대해서 자손이 구현해야 할 게 있는데
//loadUserByUsername 이거 하나만 구현하면 된다.(Polymorphism-다형성)
//->리턴값이 UserDetails에 맞게끔 리턴값을 돌리게 되면
//principal.users.username 처럼 확장 할 수 있게 된다.

@Log4j
@Service
public class MemberDetailsService implements UserDetailsService {

   //주입만 시켜주면 된다. Inject도 상관없고, 클래스에 올컨스트럭터 써도 된다.
    @Setter(onMethod_ = @Autowired)
    private MemberMapper memberMapper;

    //자손이 구현 이거 하나만 하면 된다. 
    //memberMapper 가져와서 userDetails로 리턴시켜야 한다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.warn("Load User By MemberVO number: " + username);
        
        //MemberVO에서 username객체를 가져온다.
        MemberVO vo = memberMapper.getMember(username);

        log.warn("queried by MemberVO mapper: " + vo);

        return vo == null ? null : new MemberUser(vo);

    }
}