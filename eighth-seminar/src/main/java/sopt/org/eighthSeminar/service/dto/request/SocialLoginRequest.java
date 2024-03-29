package sopt.org.eighthSeminar.service.dto.request;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SocialLoginRequest {

    private String code;

    public static SocialLoginRequest of(String code) {
        return new SocialLoginRequest(code);
    }
}
