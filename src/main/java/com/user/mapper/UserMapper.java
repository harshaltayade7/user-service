package com.user.mapper;

import com.user.entity.User;
import com.user.request.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    public User toUser(UserRequest contactRequest);

}