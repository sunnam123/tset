package pr.studentmange;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pr.studentmange.interceptor.LogInterceptor;
import pr.studentmange.interceptor.LoginCheckInterceptor;

//설정관련 스프링 빈을 등록
@Configuration
public class Webconfig implements WebMvcConfigurer {
    //@Bean: 메소드 단위로 빈을 등록할 때 사용
    //@Bean
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1) // 인터셉터 적용 순위
                .addPathPatterns("/**") // 모든 경로에 적용
                .excludePathPatterns("/css/**", "/*.ico", "/error");
//        /css/**는 /css로 시작하는 모든 경로를 제외합니다.
//         /*.ico는 루트 경로(/)에 있는 .ico 파일을 제외합니다.
//         /error는 /error 경로를 제외합니다.

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/members/add", "/login", "/logout",
                        "/css/**", "/*.ico", "/error", "/searchForm2");
    }


}
