// ==========================================
//  메시지 전송 REST 컨트롤러
//  - /send 엔드포인트로 메시지 전송
//  - StreamBridge를 통해 메시지를 바인딩에 전달
// ==========================================
package com.test.producer_app;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController // REST API 컨트롤러임을 명시
@RequiredArgsConstructor // 생성자 주입을 자동으로 생성
public class MessageController {

    private final StreamBridge streamBridge; // 메시지 바인딩을 위한 StreamBridge 주입

    /**
     * 메시지를 받아서 Kafka 등으로 전송하는 엔드포인트
     * @param message 전송할 메시지
     * @return 전송 결과 문자열
     */
    @GetMapping("/send")
    public ResponseEntity<String> send(@RequestParam String message) {
        streamBridge.send("send-out-0", message); // 바인딩 이름으로 메시지 전송
        return ResponseEntity.ok("Sent: " + message); // 성공 응답 반환
    }
}