package com.jia16.uc.mapper;

import com.jia16.uc.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lazyb on 2017/6/22.
 */
public interface UserMapper {

    User findUserByPhone(@Param("phone") String phone);

}
