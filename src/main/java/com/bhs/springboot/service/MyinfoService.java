package com.bhs.springboot.service;

import com.bhs.springboot.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

@AllArgsConstructor //이거쓰니까 되네 씨발
@Service
@Log4j2
public class MyinfoService {
    private UserRepository userRepository;

    @Transactional
    public void UserDelete (String email) {
        log.info(email);
        userRepository.deleteUserByEmail(email);
    }

}
