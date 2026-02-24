package com.jpa.market.controller;

import com.jpa.market.dto.KakaoTokenDto;
import com.jpa.market.service.KaKaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class KakaoLoginController {

    private final KaKaoService kaKaoService;

    @GetMapping("/auth/members/kakao")
    public @ResponseBody String kakaoCallback(@RequestParam("code") String code) {

        //토큰 요청
        KakaoTokenDto assessToken = kaKaoService.getKakaoAccessToken(code);

        String userInfo = kaKaoService.getKakaoUserInfo(assessToken);

        //토큰 정보가 json형태로 출력
        return "카카오 토큰 정보 : " + userInfo;

    }
}
