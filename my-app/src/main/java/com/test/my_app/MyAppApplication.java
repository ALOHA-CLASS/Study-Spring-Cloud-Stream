package com.test.my_app; // 패키지 선언

import java.util.function.Function; // Function 인터페이스 import

import org.springframework.boot.SpringApplication; // SpringApplication import
import org.springframework.boot.autoconfigure.SpringBootApplication; // SpringBootApplication 어노테이션 import
import org.springframework.context.annotation.Bean; // Bean 어노테이션 import

@SpringBootApplication // 이 클래스가 Spring Boot 애플리케이션의 시작점임을 명시
public class MyAppApplication { // MyAppApplication 클래스 선언

	public static void main(String[] args) { // main 메소드: 애플리케이션 시작점
		SpringApplication.run(MyAppApplication.class, args); // Spring Boot 애플리케이션 실행
	}

	/**
	 * 대문자로 변환하는 함수 빈을 정의합니다.
	 * 이 함수는 Spring Cloud Stream Binder에서 사용됩니다.
	 * 입력 문자열을 받아 대문자로 변환하여 반환합니다.
	 * spring.cloud.stream.bindings.uppercase-in-0.destination=input-topic
	 * 설정 때문에 이 함수는 input-topic에서 메시지를 수신하고,
	 * spring.cloud.stream.bindings.uppercase-out-0.destination=output-topic
	 * 설정 때문에 변환된 메시지를 output-topic으로 전송합니다.
	 * 
	 * @return
	 */
    @Bean // 이 메소드를 빈으로 등록 (Spring Cloud Stream Binder에서 사용)
    public Function<String, String> uppercase() { // 입력 문자열을 대문자로 변환하는 함수 빈
        return message -> { // 람다식으로 Function 구현
            System.out.println("Received: " + message); // 입력 메시지 로그 출력
            return message.toUpperCase(); // 대문자로 변환하여 반환
        };
    }
}