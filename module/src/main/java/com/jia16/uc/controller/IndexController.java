package com.jia16.uc.controller;

import com.jia16.uc.service.inter.UserAuthService;
import com.jia16.uc.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lazyb on 2017/6/22.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserAuthService userAuthService;

    @RequestMapping("/index")
    public ModelAndView index() {
        logger.info("index");
        return new ModelAndView("index");
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        userAuthService.login(name, password);
        String sid = SessionUtil.getSessionIdFromCookie(request);
        logger.info("login sid: {}", sid);
        return "success";
    }

}
