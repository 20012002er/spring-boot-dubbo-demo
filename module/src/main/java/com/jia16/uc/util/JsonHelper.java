package com.jia16.uc.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by lazyb on 2017/6/27.
 */
public class JsonHelper {

    public static Map parseJson(String json) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("parse json failed");
        }
    }

    public static String stringify(Map map) {
        Iterator i = map.entrySet().iterator();
        if (!i.hasNext())
            return "{}";

        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (; ; ) {
            Map.Entry e = (Map.Entry) i.next();
            Object key = e.getKey();
            Object value = e.getValue();
            append(sb, key);
            sb.append(':');
            append(sb, value);
            if (!i.hasNext())
                return sb.append('}').toString();
            sb.append(',').append(' ');
        }
    }

    public static String stringify(List list) {
        Iterator it = list.iterator();
        if (!it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (; ; ) {
            append(sb, it.next());
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    private static StringBuilder append(StringBuilder sb, Object e) {
        if (e instanceof Map) {
            sb.append(stringify((Map) e));
        } else if (e instanceof List) {
            sb.append(stringify((List) e));
        } else if (e instanceof String) {
            sb.append('"').append(e).append('"');
        } else {
            sb.append(e);
        }
        return sb;
    }

    public static String toJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String string;
        try {
            string = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return string;
    }

}
