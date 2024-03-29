package sopt.org.sixthSeminar.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserLoginResponseDto {
    private Long userId;
    private String accessToken;
    private String refreshToken;

    public static UserLoginResponseDto of(Long userId, String accessToken, String refreshToken){
        return new UserLoginResponseDto(userId, accessToken, refreshToken);
    }
}
