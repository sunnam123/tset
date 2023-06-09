package pr.studentmange.domain.member;

import java.util.Optional;

public interface MemberInterface {
    public Member save(Member member);
    public Member findById(Long id);
    public Optional<Member> findByLoginId(String loginId);
    public Optional<Member> findByName(String name);


}
