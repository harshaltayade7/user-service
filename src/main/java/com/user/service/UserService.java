package com.user.service;
import com.user.config.JwtConfig;
import com.user.entity.User;
import com.user.exceptions.ItemNotFoundException;
import com.user.mapper.UserMapper;
import com.user.request.UserRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private final MongoTemplate mongoTemplate;
    private final UserMapper userMapper;
    private final JwtConfig jwtConfig;
    public Query userQuery(String username, String password) {
        Query query = new Query(Criteria.where("username").is(username).and("password").is(password));
        return query;
    }

    public User createUser(UserRequest userRequst) {
        return mongoTemplate.save(userMapper.toUser(userRequst));
    }
    public String login(UserRequest userRequest) {
        String requestedUserName = userRequest.getUsername();
        String requestedPassword = userRequest.getPassword();

        try{
            User user = mongoTemplate.findOne(userQuery(requestedUserName, requestedPassword), User.class);
            if(user != null && !requestedUserName.isEmpty() && !requestedPassword.isEmpty() && user.getUsername().equals(requestedUserName) && user.getPassword().equals(requestedPassword)) {
                String token = jwtConfig.generateToken(userRequest.getUsername());
                return token;
            } else {
                return "login unsuccessful";
            }
        } catch (RuntimeException e) {
            throw new ItemNotFoundException("User not found"+e);
        }

    }
}
