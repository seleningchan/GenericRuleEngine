package org.conley.api;

public interface Rule extends Comparable<Rule> {
    String DEFAULT_NAME = "rule";
    String DEFAULT_DESCRIPTION = "description";
    int DEFAULT_PRIORITY = Integer.MAX_VALUE - 1;
    default  String getName(){
        return DEFAULT_NAME;
    }
    default String getDescription(){
        return DEFAULT_DESCRIPTION;
    }
    default int getPriority(){
        return DEFAULT_PRIORITY;
    }
    boolean evaluate(Facts facts);
    void execute(Facts facts);
    boolean apply(Facts facts);
}
