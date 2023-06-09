package pr.studentmange.domain.mybatis;

import org.apache.ibatis.annotations.Mapper;
import pr.studentmange.domain.student.student;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StudentMapper {
    public student save(student student);

    public Optional<student> findById(Long studentId);
    public Optional<student> findByName(String name);

    public List<student> findAll();

    public List<student> sortedByAvg();



    public void update(Long studentId, student update);


}
