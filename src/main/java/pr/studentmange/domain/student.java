package pr.studentmange.domain;

import lombok.Data;

@Data
public class student {
    private Long Id;
    private String name;
    private Integer kor;
    private Integer eng;
    private Integer math;
    private Double avg;

    public student(String name, Integer kor, Integer eng, Integer math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.avg = student.avg(kor,eng,math);
    }

    public static Double avg(Integer kor,Integer eng,Integer math){
        return Math.round(((kor+eng+math)/3.0)*100)/100.0;
    }

}
