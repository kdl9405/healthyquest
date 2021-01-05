package com.OMe.service.user;


import com.OMe.domain.avatar.AvatarRepository;
import com.OMe.domain.user.User;
import com.OMe.domain.user.UserRepository;
import com.OMe.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final AvatarRepository avatarRepository;

    @Transactional
    public Long AvatarUpdate(Long userId, Long cid){

        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("로그인된 계정이 없습니다. id = "+ userId));

        user.avatarUpdate(avatarRepository.getOne(cid));

         return  userId;
    }


    public UserResponseDto findById(Long id){
        User entity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = "+ id));

        return new UserResponseDto(entity);
    }
}
