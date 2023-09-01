package com.user.controller;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.user.BaseTest;
import com.user.request.UserRequest;
import com.user.util.FactoryUtil;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.user.util.CodeUtil.USER_SERVICE;
import static com.user.util.FactoryUtil.createUserBody;

public class UserControllerTest extends BaseTest {
    private static final JsonMapper MAPPER = JsonMapper.builder()
            .findAndAddModules()
            .build();

    @Autowired
    private MockMvc mockMvc;
    @Order(1)
    @Test
    @SneakyThrows
    public void createUser() {
        UserRequest request = FactoryUtil.createUserBody();
        mockMvc.perform(post(USER_SERVICE)
            .contentType(APPLICATION_JSON)
            .content(MAPPER.writeValueAsString(request))
            .accept(APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Order(2)
    @Test
    @SneakyThrows
    public void login() {
        UserRequest request = FactoryUtil.createUserBody();
        mockMvc.perform(post(USER_SERVICE+"/login")
            .contentType(APPLICATION_JSON)
            .content(MAPPER.writeValueAsString(request))
            .accept(APPLICATION_JSON))
            .andExpect(status().isOk());
    }
}
