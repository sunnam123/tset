package pr.studentmange.domain.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pr.studentmange.domain.student.student;

import java.util.*;
import java.util.stream.Collectors;


@Repository
public class StudentRepository implements StudentInterface{
    private static final Map<Long, student> store = new HashMap<>();
    private static long sequence =0L;

    @Override
    public student save(student student){
        student.setId(++sequence);
        student.setAvg(pr.studentmange.domain.student.student.avg(student.getKor(), student.getEng(), student.getMath()));

        store.put(student.getId(), student);
        return student;
    }

    @Override
    public Optional<student> findById(Long studentId){
        return Optional.ofNullable(store.get(studentId));
    }


    @Override
    public Optional<student> findByName(String name){
        return store.values().stream().filter(student -> student.getName().equals(name)).findAny();
    }

    @Override
    public List<student> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<student> sortedByAvg() {
        return store.values().stream().sorted(Comparator.comparing(student::getAvg).reversed()).collect(Collectors.toList());
    }

    @Override
    public void update(Long studentId, student update){
        student findstduent = findById(studentId).get();
        findstduent.setName(update.getName());
        findstduent.setKor(update.getKor());
        findstduent.setEng(update.getEng());
        findstduent.setMath(update.getMath());
        findstduent.setAvg(student.avg(update.getKor(), update.getEng(), update.getMath()));
    }


}
