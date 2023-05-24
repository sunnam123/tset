package pr.studentmange.domain;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private static final Map<Long, student> store = new HashMap<>();
    private static long sequence =0L;

    public student save(student student){
        student.setId(++sequence);
        student.setAvg(pr.studentmange.domain.student.avg(student.getKor(), student.getEng(), student.getMath()));

        store.put(student.getId(), student);
        return student;
    }

    public Optional<student> findById(Long studentId){
        return Optional.ofNullable(store.get(studentId));
    }

    public Optional<student> findByName(String name){
        return store.values().stream().filter(student -> student.getName().equals(name)).findAny();
    }

    public List<student> findAll() {
        return new ArrayList<>(store.values());
    }

    public List<student> sortedByAvg() {
        return store.values().stream().sorted(Comparator.comparing(student::getAvg).reversed()).collect(Collectors.toList());
    }



    public void update(Long studentId, student update){
        student findstduent = findById(studentId).get();
        findstduent.setName(update.getName());
        findstduent.setKor(update.getKor());
        findstduent.setEng(update.getEng());
        findstduent.setMath(update.getMath());
        findstduent.setAvg(student.avg(update.getKor(), update.getEng(), update.getMath()));
    }

    public void clearStore() {
        store.clear();
    }
}
