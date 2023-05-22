package pr.studentmange.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pr.studentmange.domain.StudentRepository;
import pr.studentmange.domain.student;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class studentcontoller {
    private final StudentRepository repository;

    // 시작 페이지
    @GetMapping("/")
    public String home(Model model){
        List<student> students = repository.findAll();
        model.addAttribute("student",students);
        return "students";
    }
    // 모든 학생들 표시 끝

    // 학생들 세부 정보

    @GetMapping("/student/{studentId}")
    public String student(@PathVariable Long studentId, Model model) {
        student student = repository.findById(studentId).get();
        model.addAttribute("student",student);
        return "student";
    }

    // 세부 정보 표시 끝

    // 학생 정보 수정
    @GetMapping("/student/{studentId}/edit")
    public String studentEdit(@PathVariable Long studentId, Model model) {
        student student = repository.findById(studentId).get();
        model.addAttribute("student",student);
        return "editForm";
    }
    @PostMapping("student/{studentId}/edit")
    public String edit(@PathVariable Long studentId, @ModelAttribute student student) {
        repository.update(studentId, student);

        return "redirect:/student/{studentId}";
    }
    // 학생 정보 수정 끝



    // 학생 등록
    @GetMapping("/addForm")
    public String addForm(){
        return "addForm";
    }
    @PostMapping("/addForm")
    public String add(student student){
        repository.save(student);

        return "student";
    }

    // 학생 등록 끝

    // 학생 이름으로 검색
    @GetMapping("/searchForm")
    public String searchForm(){
        return "searchForm";
    }

    @PostMapping("/searchForm")
    public String search(@RequestParam("name") String name, Model model){
        student result = repository.findByName(name).get();
        model.addAttribute("student",result);
        return "student";
    }
    // 이름으로 검색 끝
    @GetMapping("/sorted")
    public String sortedByAvg(Model model){
        List<student> sortedbyavg = repository.sortedByAvg();
        model.addAttribute("student",sortedbyavg);
        return "students";
    }

    @GetMapping("/home")
    public String home(){
        return "redirect:/";
    }


    @PostConstruct
    public void init() {
        repository.save(new student("김씨", 80, 50, 70));
        repository.save(new student("이씨", 60, 50, 50));
    }


}
