package edu.bit.ex.mapper;
 
import org.apache.ibatis.annotations.Mapper;

import edu.bit.ex.vo.MemberVO;

@Mapper
public interface MemberMapper {
    public MemberVO getMember(String username);
    //username = ID
}