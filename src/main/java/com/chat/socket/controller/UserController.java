package com.chat.socket.controller;


import com.chat.socket.model.User;
import com.chat.socket.model.dto.MainloginchecknameDto;
import com.chat.socket.model.dto.SignupRequestDto;
import com.chat.socket.security.UserDetailsImpl;
import com.chat.socket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
//@CrossOrigin("http://localhost:3000")
public class UserController {

    private final UserService userService;

    // 회원 가입 요청 처리
    @PostMapping("/api/user/join")
    public String registerUser(@RequestBody SignupRequestDto requestDto) {
        if (requestDto.getCheckUsername()) {
            String res = userService.registerUser(requestDto);
            if (res.equals("")) {
                return "회원가입 성공";
            } else {
                return res;
            }
        }
        else
            return "아이디 중복 확인";
    }

    //유저 아이디 체크
    @PostMapping("/api/user/username")
    public String userIdCheck(@RequestBody MainloginchecknameDto mainloginchecknameDto) {
        return userService.userIdCheck(mainloginchecknameDto);

    }

    //로그인 유저 정보
    @GetMapping("user/login/auth")
    public User userDetails(@AuthenticationPrincipal UserDetailsImpl userDetails) {
       return userService.userInfo(userDetails);
    }
}