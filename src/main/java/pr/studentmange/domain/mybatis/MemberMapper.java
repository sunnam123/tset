package pr.studentmange.domain.mybatis;

import org.apache.ibatis.annotations.Mapper;
import pr.studentmange.domain.member.Member;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    public Member save(Member member);
    public Member findById(Long id);
    public Optional<Member> findByLoginId(String loginId);
    public Optional<Member> findByName(String name);


}
