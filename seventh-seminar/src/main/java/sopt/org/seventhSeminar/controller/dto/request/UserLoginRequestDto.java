package sopt.org.seventhSeminar.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Schema(description = "유저 로그인 DTO")
public class UserLoginRequestDto {

    @Email(message = "이메일 형식에 맞지 않습니다")
    @NotBlank
    @Schema(description = "유저 이메일")
    private String email;

    @NotNull
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다")
    @Schema(description = "유저 비밀번호")
    private String password;
}
