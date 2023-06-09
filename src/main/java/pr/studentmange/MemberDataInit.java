package pr.studentmange;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pr.studentmange.domain.member.Member;
import pr.studentmange.domain.member.MemberRepository;

@Slf4j
@RequiredArgsConstructor
public class MemberDataInit {

    private final MemberRepository memberRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void MemberDataInit(){
        memberRepository.save(new Member("test", "1111", "홍길동"));
        memberRepository.save(new Member("test2", "2222", "김유신"));
    }
}
