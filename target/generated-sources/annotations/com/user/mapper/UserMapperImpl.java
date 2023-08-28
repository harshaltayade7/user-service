package com.user.mapper;

import com.user.entity.User;
import com.user.request.UserRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-28T12:40:18+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserRequest contactRequest) {
        if ( contactRequest == null ) {
            return null;
        }

        String username = null;
        String password = null;

        username = contactRequest.getUsername();
        password = contactRequest.getPassword();

        User user = new User( username, password );

        return user;
    }
}
