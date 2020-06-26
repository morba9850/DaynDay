package com.bhs.springboot.service;

import com.bhs.springboot.domain.user.User;
import com.bhs.springboot.domain.user.UserRepository;
import com.bhs.springboot.dto.userDto.UserListResponseDto;
import com.bhs.springboot.dto.userDto.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log4j2
public class AdminService {
    private final UserRepository userRepository;

    @Transactional
    public List<UserListResponseDto> findAllDesc() {
        return userRepository.findAllDesc().stream()
                .map(UserListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserResponseDto findById(Long id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return new UserResponseDto(entity);
    }

    @Transactional
    public void delete (Long id) {
        userRepository.deleteById(id);
    }



}
