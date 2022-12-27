package com.excercise.api.gateway.constant;

public class PatternConstants {

    public static final String PATTERN_PARAM_IN_URL_BEFORE_REWRITE = "(?<segment>.*)";

    public static final String PATTERN_PARAM_IN_URL_AFTER_REWRITE = "${segment}";
}
