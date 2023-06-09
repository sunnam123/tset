package pr.studentmange.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pr.studentmange.domain.student.StudentRepository;
import pr.studentmange.domain.student.student;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StudentRepositoryTest {

    StudentRepository repository = new StudentRepository();



    @Test
    public void save() {
        student student = new student("홍길동",80,60,70);

        repository.save(student);

        student result = repository.findById(student.getId()).get();
        assertThat(student).isEqualTo(result);
    }

    @Test
    public void findByName() {
        student student1 = new student("홍",80,80,80);
        repository.save(student1);

        student student2 = new student("항",80,80,80);
        repository.save(student2);

        student result = repository.findByName("홍").get();
        assertThat(result).isEqualTo(student1);
    }

    @Test
    public void findAll() {
        student student1 = new student("홍",80,80,80);
        repository.save(student1);

        student student2 = new student("항",80,80,80);
        repository.save(student2);

        List<student> all = repository.findAll();

        assertThat(all.size()).isEqualTo(2);
    }
}
