package pr.studentmange.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pr.studentmange.domain.member.Member;
import pr.studentmange.domain.member.MemberInterface;
import pr.studentmange.domain.member.MemberRepository;
@RequiredArgsConstructor
@Service

public class LoginService {

    private final MemberInterface memberRepository;

    public Member login(String loginId, String password){
        return memberRepository.findByLoginId(loginId).filter(m->m.getPassword().equals(password)).orElse(null);
    }
}
