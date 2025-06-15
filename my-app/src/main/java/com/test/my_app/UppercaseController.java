package com.test.my_app; // 패키지 선언

import java.util.function.Function; // Function 인터페이스 import

import org.springframework.beans.factory.annotation.Autowired; // 의존성 주입 관련 import
import org.springframework.web.bind.annotation.RestController; // REST 컨트롤러 어노테이션 import
import org.springframework.web.bind.annotation.GetMapping; // GET 매핑 어노테이션 import
import org.springframework.web.bind.annotation.RequestParam; // 요청 파라미터 어노테이션 import


@RestController // 이 클래스가 REST API 컨트롤러임을 명시
public class UppercaseController { // UppercaseController 클래스 선언

    @Autowired // 스프링이 자동으로 빈을 주입
    private Function<String, String> uppercase; // 문자열을 대문자로 변환하는 함수 빈

    @GetMapping("/uppercase") // HTTP GET 요청을 "/uppercase" 경로에 매핑
    public String convert(@RequestParam String input) { // input 파라미터를 받아 처리하는 메소드
        return uppercase.apply(input); // input을 대문자로 변환하여 반환
    }
    
    
}
