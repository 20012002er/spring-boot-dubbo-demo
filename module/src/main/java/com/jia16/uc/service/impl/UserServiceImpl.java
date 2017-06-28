package com.jia16.uc.service.impl;

import com.jia16.uc.domain.User;
import com.jia16.uc.mapper.UserMapper;
import com.jia16.uc.service.inter.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
