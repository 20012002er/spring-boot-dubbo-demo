package com.jia16.uc.service.inter;

import com.jia16.uc.domain.User;

/**
 * Created by lazyb on 2017/6/22.
 */
public interface UserService {

    User findByPhone(String phone);

}
