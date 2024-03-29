package sopt.org.eighthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sopt.org.eighthSeminar.domain.SocialPlatform;
import sopt.org.eighthSeminar.domain.SocialUser;
import sopt.org.eighthSeminar.external.client.kakao.KakaoApiClient;
import sopt.org.eighthSeminar.external.client.kakao.KakaoAuthApiClient;
import sopt.org.eighthSeminar.external.client.kakao.dto.response.KakaoAccessTokenResponse;
import sopt.org.eighthSeminar.external.client.kakao.dto.response.KakaoUserResponse;
import sopt.org.eighthSeminar.infrastructure.SocialUserRepository;
import sopt.org.eighthSeminar.service.dto.request.SocialLoginRequest;

@Service
@RequiredArgsConstructor
public class KakaoSocialService extends SocialService {

    @Value("${kakao.clientId}")
    private String clientId;

    private final SocialUserRepository socialUserRepository;
    private final KakaoAuthApiClient kakaoAuthApiClient;
    private final KakaoApiClient kakaoApiClient;

    @Override
    public Long login(SocialLoginRequest request) {

        System.out.println(clientId);

        // Authorization code로 Access Token 불러오기
        KakaoAccessTokenResponse tokenResponse = kakaoAuthApiClient.getOAuth2AccessToken(
                "authorization_code",
                clientId,
                "http://localhost:8080/kakao/callback",
                request.getCode()
        );

        // Access Token으로 유저 정보 불러오기
        KakaoUserResponse userResponse = kakaoApiClient.getUserInformation("Bearer " + tokenResponse.getAccessToken());

        SocialUser user = SocialUser.of(
                userResponse.getKakaoAccount().getProfile().getNickname(),
                userResponse.getKakaoAccount().getProfile().getProfileImageUrl(),
                SocialPlatform.KAKAO,
                tokenResponse.getAccessToken(),
                tokenResponse.getRefreshToken()
        );

        socialUserRepository.save(user);

        return user.getId();
    }
}