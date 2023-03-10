package hello.springbootall.basic.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
public class ApiExceptionController {


    @GetMapping("/api/members/{id}")
    public MemberDto getMember(@PathVariable("id") Integer id) {
        if (id.equals("ex")) {
            throw new RuntimeException("잘못된 사용자");
        }
        if (id.equals("bad")) {
            throw new IllegalArgumentException("잘못된 입력 값");
        }

        return new MemberDto(id, "hello " + id, LocalDateTime.now());
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class MemberDto {
        private Integer memberId;
        private String name;
        private LocalDateTime regDate;
    }
}
