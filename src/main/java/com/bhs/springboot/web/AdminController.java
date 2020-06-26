package com.bhs.springboot.web;

import com.bhs.springboot.dto.postDto.PostsResponseDto;
import com.bhs.springboot.dto.userDto.UserResponseDto;
import com.bhs.springboot.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
@Log4j2
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("User", adminService.findAllDesc());

        return "admin";
    }
//회원상세
    @GetMapping("/adminupdate/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        UserResponseDto dto = adminService.findById(id);
        model.addAttribute("user", dto);
        log.info("admin 상세");
        return "adminupdate";
    }
//회원삭제
    @DeleteMapping("/adminupdate/{id}")
    public void delete(@PathVariable Long id) {
        adminService.delete(id);
    }
}


