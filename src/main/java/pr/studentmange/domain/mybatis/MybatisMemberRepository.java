package pr.studentmange.domain.mybatis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pr.studentmange.domain.member.Member;
import pr.studentmange.domain.member.MemberInterface;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MybatisMemberRepository implements MemberInterface {

    private final MemberMapper memberMapper;

    @Override
    public Member save(Member member) {
        memberMapper.save(member);
        return member;
    }

    @Override
    public Member findById(Long id) {
        return memberMapper.findById(id);
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        return memberMapper.findByLoginId(loginId);
    }

    @Override
    public Optional<Member> findByName(String name) {
        return memberMapper.findByName(name);
    }
}
