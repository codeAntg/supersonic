package com.tencent.supersonic.common.util;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class StringUtil {

    public static final String COMMA_WRAPPER = "'%s'";
    public static final String SPACE_WRAPPER = " %s ";

    public static String getCommaWrap(String value) {
        return String.format(COMMA_WRAPPER, value);
    }

    public static String getSpaceWrap(String value) {
        return String.format(SPACE_WRAPPER, value);
    }

}