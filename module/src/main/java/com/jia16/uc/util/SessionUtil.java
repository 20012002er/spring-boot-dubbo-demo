package com.jia16.uc.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by lazyb on 2017/6/27.
 */
public class SessionUtil {

    public static String getSessionIdFromCookie(HttpServletRequest request) {
        Cookie cookies[] = request.getCookies();
        String sid = "";
        if (cookies != null && cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie sessionCookie = cookies[i];
                if (sessionCookie.getName().equalsIgnoreCase("p2psessionid")) {
                    sid = sessionCookie.getValue();
                }
            }
        }
        return sid;
    }

}
