package com.chat.socket.model.dto;

import com.chat.socket.model.ChatRoom;
import com.chat.socket.model.Friend;
import com.chat.socket.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserReturnDto {
    private  Long Id;
    private  String username;
    private  String password;
    private  String nickname;
    private  String encodeUserName;
    private  String userStatus;
    private  String profileImage;
    private  String profileBgImage;
    private  String realname;
    private  List<Friend> friends;
    private  List<ChatRoom> chatRoomList;

    public UserReturnDto(User user, List<Friend> userFriendGroup){// List<ChatRoom> chatRooms) {
        this.Id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.nickname = user.getNickname();
        this.encodeUserName = user.getEncodeUserName();
        this.userStatus = user.getUserStatus();
        this.profileImage = user.getProfileImage();
        this.profileBgImage = user.getProfileBgImage();
        this.realname = user.getRealname();
        this.friends = userFriendGroup;
       // this.chatRoomList = chatRooms;
    }
}
