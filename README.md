# React-springboot-final

프론트(react,vscode) 백(springBoot, Intellij) 


## React-Springboot Book 프로젝트

### 스프링부트

- SpringBoot ^2.6.3
- JPA
- MariaDB (H2)
- gradle
- Lombok

### React

- yarn add react-router-dom@6
- yarn add redux react-redux
- yarn add react-bootstrap bootstrap

```txt
import 'bootstrap/dist/css/bootstrap.min.css';
```

# 프록시 설정 , CORS ERROR

- 일단 구글링해봄 이전까지는 @CrossOrigin 이엇나 이걸로 컨트롤러에서 프론트엔드 api 요청 들어왔을떄 해줫는데 보안상의 이유로 안된다는걸 깨달음
- react(프론트)에서 packge.json에서 밑에와 같이 쓰면 된다는데 나는안됨;;;;

```text
"proxy" : "http://localhost:8080",
```

- 결론 : 서버단에 WebConfing.java라는 파일만들고 복붙 그럼 오케이

```java

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}

출처:https://www.youtube.com/watch?v=1bcBddLXns8
```

ㅇ
