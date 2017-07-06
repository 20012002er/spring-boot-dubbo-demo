package com.jia16.uc.service.impl;

import com.jia16.uc.domain.User;
import com.jia16.uc.mapper.UserMapper;
import com.jia16.uc.service.inter.UserService;
import com.jia16.uc.util.PasswordEncryption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.jia16.uc.util.PasswordEncryption.BCRYPT;

/**
 * Created by lazyb on 2017/6/22.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByPhone(String phone) {
        logger.info("findByPhone");
        return userMapper.findUserByPhone(phone);
    }

    @Override
    public Map<String, Object> login(String phone, String password) {
        Map<String, Object> res = new HashMap<>();
        User user = userMapper.findUserByPhone(phone);
        int code = 0;
        String msg = "success";
        if (user == null) {
            code = 1;
            msg = "phone is error";
        } else {
            if (!BCRYPT.check(password, user.getPassword())) {
                code = 2;
                msg = "password is error";
            } else {
                res.put("user", user);
            }
        }
        res.put("code", code);
        res.put("msg", msg);
        return res;
    }
}
