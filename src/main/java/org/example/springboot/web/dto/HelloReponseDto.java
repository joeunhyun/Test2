package org.example.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //선언된 모든 필드 get 메소드 생성
@RequiredArgsConstructor //선언된 모든 final 필드가 포함된 생성자 생ㅅ성
public class HelloReponseDto {
    private final String name;
    private final int amount;
}
