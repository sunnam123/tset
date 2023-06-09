package pr.studentmange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import pr.studentmange.config.MyBatisConfig;
import pr.studentmange.domain.member.MemberInterface;
import pr.studentmange.domain.member.MemberRepository;
import pr.studentmange.domain.mybatis.MemberMapper;
import pr.studentmange.domain.mybatis.MybatisMemberRepository;

@Import(MyBatisConfig.class)
@SpringBootApplication(scanBasePackages = "pr.studentmange.controller")
public class StudentmangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentmangeApplication.class, args);
	}
//
//	@Bean
//	@Profile("test")
//	public MemberDataInit memberDataInit(MemberInterface memberInterface){
//		return new MemberDataInit(memberInterface);
//	}
}
