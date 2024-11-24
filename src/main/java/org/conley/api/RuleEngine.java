package org.conley.api;

public interface RuleEngine {
    void fire(Rule rule, Facts facts);
}
