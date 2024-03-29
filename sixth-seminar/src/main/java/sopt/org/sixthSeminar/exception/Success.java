package sopt.org.sixthSeminar.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Success {

    // 200 OK
    LOGIN_SUCCESS(HttpStatus.OK, "로그인에 성공했습니다"),
    AUTHORIZATION_SUCCESS(HttpStatus.OK, "토큰 재인증에 성공했습니다"),

    // 201 OK
    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입이 완료됐습니다"),
    CREATE_BOARD_SUCCESS(HttpStatus.CREATED, "게시물 생성이 완료됐습니다")
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode(){
        return httpStatus.value();
    }
}
