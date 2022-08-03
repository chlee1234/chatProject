package com.chat.socket.controller;



import com.chat.socket.Exception.CustomException;
import com.chat.socket.model.dto.FriendNewRequertDto;
import com.chat.socket.model.dto.FriendResponseDto;
import com.chat.socket.security.UserDetailsImpl;
import com.chat.socket.service.FriendService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendController {

    private final com.chat.socket.service.FriendService FriendService;

    public FriendController(FriendService FriendService) {
        this.FriendService = FriendService;
    }

    @GetMapping("/api/friend/list") //메인 투척.
    public ResponseEntity<FriendResponseDto> showFriendList(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(FriendService.showFriendList(userDetails));
    }


    @PostMapping("/api/friend/new")
    public CustomException friendNew(@RequestBody FriendNewRequertDto friendNewRequertDto,
                                     @AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        return FriendService.friendNew(friendNewRequertDto,userDetails);
    }

    @GetMapping("/")
    public String gooja(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return userDetails.getUser().getNickname();
    }
}
