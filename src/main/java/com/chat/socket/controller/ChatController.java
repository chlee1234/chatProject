package com.chat.socket.controller;


import com.chat.socket.Exception.CustomException;
import com.chat.socket.Exception.ErrorCode;
import com.chat.socket.model.dto.ChatMessageDetailDTO;
import com.chat.socket.model.dto.ChatResponseDto;
import com.chat.socket.model.dto.ChatRoomDetailDTO;
import com.chat.socket.model.dto.UserDto;
import com.chat.socket.security.UserDetailsImpl;
import com.chat.socket.service.ChatRoomService;
import com.chat.socket.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatService cs;
    private final ChatRoomService chatRoomService;

    //채팅방 찾기
    @PostMapping("/chatRoom/find")
    public ChatResponseDto findRoomByUsername(@RequestBody UserDto userDto,
                                              @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ChatResponseDto chatRoom = chatRoomService.findChatRoom(userDto, userDetails);
        if (chatRoom.getRoomId().equals("")) {
            throw new CustomException(ErrorCode.CAN_NOT_CREATE_ROOM);
        }
        return chatRoom;
    }


    //채팅방 만들기
    @PostMapping("/chatRoom/create")
    public ChatResponseDto createChatRoom(@RequestBody UserDto userDto,
                                 @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ChatResponseDto chatRoom = chatRoomService.createChatRoom(userDto, userDetails);
        if (chatRoom.getRoomId().equals("")) {
            throw new CustomException(ErrorCode.CAN_NOT_CREATE_ROOM);
        }
        return chatRoom;
    }

    //채팅방 전부찾기
    @PostMapping("/chatRoom/findAll")
    public List<ChatRoomDetailDTO> findAllRoom(@RequestBody UserDto userDto,
                                               @AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<ChatRoomDetailDTO> chatRooms = chatRoomService.findAllChatRoom(userDto,userDetails);
        if (chatRooms.size() == 0) {
            throw new CustomException(ErrorCode.CAN_NOT_CREATE_ROOM);
        }
        return chatRooms;
    }

    //채팅메시지 작성.
    @GetMapping("/chatRoom/{roomId}")
    public List<ChatMessageDetailDTO> findChats(@PathVariable("roomId") String roomId) {
        List<ChatMessageDetailDTO> chats = chatRoomService.findChat(roomId);
        if (chats.size() == 0) {
            throw new CustomException(ErrorCode.CAN_NOT_CREATE_ROOM);
        }
        return chats;
    }
}
