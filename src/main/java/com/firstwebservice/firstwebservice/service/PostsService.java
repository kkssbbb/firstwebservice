package com.firstwebservice.firstwebservice.service;

import com.firstwebservice.firstwebservice.domain.posts.Posts;
import com.firstwebservice.firstwebservice.domain.posts.PostsRepository;
import com.firstwebservice.firstwebservice.web.dto.PostsResponseDto;
import com.firstwebservice.firstwebservice.web.dto.PostsSaveRequestDto;
import com.firstwebservice.firstwebservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));


        return new PostsResponseDto(entity);
    }
}
