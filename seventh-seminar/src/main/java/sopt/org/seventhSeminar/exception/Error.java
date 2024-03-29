package sopt.org.seventhSeminar.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Error {

    // 400 BAD REQUEST
    REQUEST_VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다"),
    NO_REQUEST_PARAMETER_EXCEPTION(HttpStatus.BAD_REQUEST, "요청 파라미터 값이 없습니다"),
    VALIDATION_WRONG_TYPE_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 타입이 입력되었습니다"),
    PARAMETER_TYPE_MISMATCH_EXCEPTION(HttpStatus.BAD_REQUEST, "파라미터 타입이 잘못되었습니다"),
    INVALID_PASSWORD_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 비밀번호가 입력됐습니다."),
    INVALID_MULTIPART_EXTENSION_EXCEPTION(HttpStatus.BAD_REQUEST, "multipart 오류가 발생했습니다."),

    // 401 UNAUTHORIZED
    TOKEN_TIME_EXPIRED_EXCEPTION(HttpStatus.UNAUTHORIZED, "만료된 토큰입니다. 다시 로그인하거나 토큰을 재발급 받으세요"),

    // 404 NOT FOUND
    NOT_FOUND_USER_EXCEPTION(HttpStatus.NOT_FOUND, "존재하지 않는 유저입니다"),
    NOT_FOUND_IMAGE_EXCEPTION(HttpStatus.NOT_FOUND,"이미지를 찾을 수 없습니다"),
    NOT_FOUND_SAVE_IMAGE_EXCEPTION(HttpStatus.NOT_FOUND,"저장된 이미지를 찾을 수 없습니다"),

    // 409 CONFLICT
    ALREADY_EXIST_USER_EXCEPTION(HttpStatus.CONFLICT, "이미 존재하는 유저입니다"),

    // 500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 에러가 발생했습니다");

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode(){
        return httpStatus.value();
    }

}