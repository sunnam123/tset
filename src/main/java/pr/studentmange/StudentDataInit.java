package pr.studentmange;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pr.studentmange.domain.student.StudentRepository;
import pr.studentmange.domain.student.student;

@Slf4j
@AllArgsConstructor
public class StudentDataInit {

    private final StudentRepository studentRepository;


    @EventListener(ApplicationReadyEvent.class)
    public void StudentDatainit(){
        studentRepository.save(new student("오씨", 80, 50, 70));
        studentRepository.save(new student("이씨", 60, 50, 50));
    }

}
