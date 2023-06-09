package pr.studentmange.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pr.studentmange.domain.member.Member;
import pr.studentmange.domain.member.MemberInterface;
import pr.studentmange.domain.member.MemberRepository;
import pr.studentmange.domain.member.SessionConst;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final MemberInterface memberRepository;
    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form){
        return"login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return "login/loginForm";
        }

        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());

        if(loginMember == null){
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 올바르지 않습니다. ");
            return "login/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return "redirect:/";

    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session =request.getSession(false);
        if(session !=null){
            session.invalidate();
        }
        return"redirect:/";
    }

    @GetMapping("/searchForm2")
    public String searchForm2(){
        return "login/searchForm2";
    }

    @PostMapping("/searchForm2")
    public String search(@RequestParam("name") String name, Model model){
        Member result = memberRepository.findByName(name).get();
        model.addAttribute("member", result);
        return "login/search";

    }

}
