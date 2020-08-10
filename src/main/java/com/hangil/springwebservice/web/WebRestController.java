package com.hangil.springwebservice.web;

import com.hangil.springwebservice.domain.posts.PostsRepository;
import com.hangil.springwebservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;//트랜잭션 추가후 변경
  //private PostsRepository postsRepository;//적용 전
    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);//트랜잭션 추가 후 변경

        //  postsRepository.save(dto.toEntity());//트랜잭션 적용 전
    }
}