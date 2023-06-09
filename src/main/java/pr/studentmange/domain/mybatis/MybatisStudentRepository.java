package pr.studentmange.domain.mybatis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pr.studentmange.domain.student.StudentInterface;
import pr.studentmange.domain.student.student;

import java.util.List;
import java.util.Optional;
@Slf4j
@Repository
@RequiredArgsConstructor
public class MybatisStudentRepository implements StudentInterface{
    private final StudentMapper studentMapper;

    @Override
    public student save(student student) {
        studentMapper.save(student);
        return student;
    }

    @Override
    public Optional<student> findById(Long studentId) {
        return studentMapper.findById(studentId);
    }

    @Override
    public Optional<student> findByName(String name) {
        return studentMapper.findByName(name);
    }

    @Override
    public List<student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public List<student> sortedByAvg() {
        return studentMapper.sortedByAvg();
    }

    @Override
    public void update(Long studentId, student update) {
        studentMapper.update(studentId, update);
    }
}
