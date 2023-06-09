package pr.studentmange.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pr.studentmange.domain.student.StudentInterface;
import pr.studentmange.domain.student.StudentRepository;
import pr.studentmange.domain.member.Member;
import pr.studentmange.domain.member.SessionConst;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
    private final StudentInterface studentRepository;

//    @GetMapping("/")
    public String home(){
        return "/home";
    }

    @GetMapping("/")
    public String homeLogin(HttpServletRequest request, Model model){

        HttpSession session = request.getSession(false);
        if(session==null){
            return "home";
        }

        Member loginMember = (Member)session.getAttribute(SessionConst.LOGIN_MEMBER);

        if(loginMember == null){
            return "home";
        }
        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}
