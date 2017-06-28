package com.jia16.uc.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.*;

/**
 * Created by lazyb on 2017/6/27.
 */
public class Session implements Serializable {

    private static Logger logger = LoggerFactory.getLogger(Session.class);

    private final Map<String, Object> attributes = new HashMap<>();

    private final static String LAST_ACCESS_TIME = "____PRIVATE_LAST_ACCESS_TIME";
    private final static String VERSION = "____PRIVATE_VERSION";
    private final static List<String> PRIVATE_KEYS = new ArrayList<String>() {{
        add(LAST_ACCESS_TIME);
        add(VERSION);
    }};

    public Session() {
        attributes.put(LAST_ACCESS_TIME, System.currentTimeMillis());
        attributes.put(VERSION, 0);
    }

    public void setAttribute(String key, Object value) {
        logger.debug("SET ATTRIBUTE: {}", key);

        if (!PRIVATE_KEYS.contains(key)) {
            attributes.put(key, value);
        } else {
            logger.error("TRY TO REMOVE PRIVATE KEY: {} IGNORED", key);
        }

        updateAccessTime();
        updateVersion();
    }

    public Object getAttribute(String key) {
        updateAccessTime();
        return attributes.get(key);
    }

    public Enumeration getAttributeNames() {
        return (new Enumerator(attributes.keySet(), true));
    }

    public void removeAttribute(String key) {
        if (!PRIVATE_KEYS.contains(key)) {
            attributes.remove(key);
        } else {
            logger.error("TRY TO REMOVE PRIVATE KEY: {}IGNORED", key);
        }
        updateAccessTime();
        updateVersion();
    }


    public void invalidate() {
        attributes.clear();
    }

    public void updateVersion() {
        int version = Integer.parseInt(attributes.get(VERSION).toString());
        attributes.put(VERSION, ++version);
    }

    public void updateAccessTime() {
        attributes.put(LAST_ACCESS_TIME, System.currentTimeMillis());
    }

    public boolean isTimeout(long seconds) {
        Object lastAccessTime = attributes.get(LAST_ACCESS_TIME);

        if (lastAccessTime == null) {
            return true;
        }

        long idleInSeconds = (System.currentTimeMillis() - Long.parseLong(lastAccessTime.toString())) / 1000;
        return idleInSeconds > seconds;
    }

}
