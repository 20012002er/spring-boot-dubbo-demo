package com.jia16.uc.service.inter;

import com.jia16.uc.domain.User;

import java.util.Map;

/**
 * Created by lazyb on 2017/6/22.
 */
public interface UserService {

    User findByPhone(String phone);

    Map<String, Object> login(String phone, String password);

}
