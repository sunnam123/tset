package pr.studentmange.domain.student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface StudentInterface {

    public student save(student student);

    public Optional<student> findById(Long studentId);
    public Optional<student> findByName(String name);

    public List<student> findAll();

    public List<student> sortedByAvg();



    public void update(Long studentId, student update);


}
