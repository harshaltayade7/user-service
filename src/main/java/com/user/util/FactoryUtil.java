package com.user.util;
import com.user.request.UserRequest;

public class FactoryUtil {
    public static UserRequest createUserBody() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("hh");
        userRequest.setPassword("hh");
        return userRequest;
    }
}
