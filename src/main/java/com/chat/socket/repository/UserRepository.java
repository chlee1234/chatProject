package com.chat.socket.repository;

import com.chat.socket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByNickname(String NickName);
    @Query("SELECT distinct t FROM User t join fetch t.friends")
    public List<User> findByUsernameWithFriendUsingFetchJoin(String username);

    @Query("SELECT distinct t FROM User t join fetch t.chatRoomList")
    public List<User> findByUsernameWithChatRoomUsingFetchJoin(String username);
}
