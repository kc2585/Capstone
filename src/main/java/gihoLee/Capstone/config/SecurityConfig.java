package gihoLee.Capstone.config;

import gihoLee.Capstone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception { // http 관련 인증 설정
        http
		        .authorizeRequests()
                .mvcMatchers("/","/css/**","/img/**","/js/**","/vendor/**","/xml/**")
                .permitAll()
                .and()
                .formLogin() // 로그인 설정
                .loginPage("/login") // 로그인 페이지
                .defaultSuccessUrl("/") // 로그인 성공 후 주소
                .and()
                .logout() // 로그아웃 설정
                .logoutSuccessUrl("/login") // 로그아웃 성공 후 주소
                .invalidateHttpSession(true);// 세션 초기화
    }

    @Override
    public void configure(WebSecurity web) { // resources 하위 파일 목록(css, js, img, vendor, xml) 인증 무시
        web
                .ignoring()
                .antMatchers("/resources/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception { // 정보 가져오기
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

}