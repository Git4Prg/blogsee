package com.mintshock.blog.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.mintshock.blog.domain.CreatePostRequest;
import com.mintshock.blog.domain.UpdatePostRequest;
import com.mintshock.blog.domain.dtos.CreatePostRequestDto;
import com.mintshock.blog.domain.dtos.PostDto;
import com.mintshock.blog.domain.dtos.UpdatePostRequestDto;
import com.mintshock.blog.domain.entities.Post;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    PostDto toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto);

    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto dto);
}
