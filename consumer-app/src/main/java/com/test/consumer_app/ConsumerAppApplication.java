package com.test.consumer_app;

// Java의 Consumer 함수형 인터페이스를 사용하여 메시지를 처리합니다.
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerAppApplication.class, args);
	}
    // Consumer<String> 빈을 등록하여 메시지를 수신합니다.
    // Spring Cloud Stream에서 바인딩된 채널로부터 메시지를 받아 처리합니다.
    // 이 예제에서는 단순히 메시지를 콘솔에 출력합니다.
    @Bean
    public Consumer<String> receive() {
        // 메시지를 수신할 때마다 실행되는 람다 함수입니다.
        return message -> System.out.println(">>> Received: " + message);
    }
}