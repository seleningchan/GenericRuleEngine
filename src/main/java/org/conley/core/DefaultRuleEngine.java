package org.conley.core;

import org.conley.api.Facts;
import org.conley.api.Rule;
import org.conley.api.RuleEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultRuleEngine implements RuleEngine {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultRuleEngine.class);
    @Override
    public void fire(Rule rule, Facts facts) {
        if(rule == null){
            LOGGER.error("Rule is null! Nothing to apply");
            return;
        }
        rule.apply(facts);
    }
}
