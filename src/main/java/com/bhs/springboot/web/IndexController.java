package com.bhs.springboot.web;

import com.bhs.springboot.config.auth.LoginUser;
import com.bhs.springboot.config.auth.dto.SessionUser;
import com.bhs.springboot.dto.GalleryDto;
import com.bhs.springboot.dto.postDto.PostsListResponseDto;
import com.bhs.springboot.dto.userDto.UserResponseDto;
import com.bhs.springboot.service.*;
import com.bhs.springboot.dto.postDto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Log4j2
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    private final MyinfoService myInfoService;
    private final WeathersService weathersService;
    private S3Service s3Service;
    private GalleryService galleryService;


    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {

        if (user != null) {
            model.addAttribute("userNames", user.getName());
        }

        return "index";
    }

    @GetMapping("/landom")
    public String test() {
        return "landom";
    }


    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }


    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

    @GetMapping("/myinfo")
    public String myInfo(Model model, @LoginUser SessionUser user) {
        model.addAttribute("userNames", user.getName());
        model.addAttribute("userEmails", user.getEmail());
        log.info("사용자 정보 뿌리기");
        log.info(user);
        System.out.println(user.getEmail());
        System.out.println(user.getName());
        return "myinfo";
    }

    @DeleteMapping("/myinfo")
    public void delete(@LoginUser SessionUser user/*, HttpSession session*/) {
        log.info(user.getEmail());
        myInfoService.UserDelete(user.getEmail());
        /*session.invalidate();*/

    }



    @GetMapping("/diary") // 서비스 뿌려주기
    public String diary(Model model, @LoginUser SessionUser user) {

        model.addAttribute("userNames", user.getName());
        model.addAttribute("posts", postsService.findAllDesc());



        return "diary";
    }



}