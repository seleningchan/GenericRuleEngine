package org.conley.api;

@FunctionalInterface
public interface Action {
    void execute(Facts facts);
}
