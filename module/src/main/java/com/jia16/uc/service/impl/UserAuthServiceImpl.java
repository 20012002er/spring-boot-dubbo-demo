package com.jia16.uc.service.impl;

import com.jia16.uc.service.inter.UserAuthService;
import com.jia16.uc.session.Session;
import com.jia16.uc.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lazyb on 2017/6/27.
 */
@Service("userAuthService")
public class UserAuthServiceImpl implements UserAuthService {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthServiceImpl.class);

    @Value("${ums.url}")
    private String umsUrl;

    @Override
    public void login(String name, String password) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.set("MIDAS-SYSTEM", "uc");
        Map<String, String> body = new HashMap<>();
        body.put("name", name);
        body.put("password", password);
        HttpEntity<String> entity = new HttpEntity<>(JsonUtil.toJson(body), headers);
        ResponseEntity<String> re = restTemplate.exchange(umsUrl + "users/uc-login", HttpMethod.POST, entity, String.class);
        logger.info("responseBody: {}", re.getBody());
    }
}
