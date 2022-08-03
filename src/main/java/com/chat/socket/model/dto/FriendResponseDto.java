package com.chat.socket.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FriendResponseDto {
    private FriendListDto userProfile;
    private List<FriendListDto> friendList;

    public FriendResponseDto(FriendListDto userProfile,
                            List<FriendListDto> friendList){
        this.userProfile =userProfile;
        this.friendList = friendList;
    }
}
