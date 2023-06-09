package pr.studentmange.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pr.studentmange.domain.member.Member;
import pr.studentmange.domain.member.MemberInterface;
import pr.studentmange.domain.member.MemberRepository;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberInterface memberRepository;

    @GetMapping("/members/add")
    public String addForm(@ModelAttribute("member") Member member){
        return "/members/addMemberForm";
    }

    @PostMapping("/members/add")
    public String save(@Validated @ModelAttribute Member member, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "member/addMemberForm";
        }
        Member member1 = memberRepository.save(member);
        return "redirect:/";
    }


//    @PostConstruct
//    public void init() {
//        memberRepository.save(new Member("test", "1111", "홍길동"));
//        memberRepository.save(new Member("test2", "2222", "김유신"));
//    }
}
