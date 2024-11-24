package org.conley.core;

import org.conley.api.Facts;
import org.conley.api.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

public class NaturalRules extends CompositeRule{
    private static final Logger LOGGER = LoggerFactory.getLogger(NaturalRules.class);

    public static CompositeRule of(Rule... rules){
        CompositeRule instance = new NaturalRules();
        Collections.addAll(instance.rules, rules);
        return instance;
    }

    @Override
    public boolean evaluate(Facts facts) {
        throw new RuntimeException("evaluate not supported for natural composite");
    }

    @Override
    public void execute(Facts facts) {
        throw new RuntimeException("execute not supported for natural composite");
    }

    @Override
    protected boolean doApply(Facts facts) {
        LOGGER.debug("start natural composite rule apply");
        for (Rule rule : rules)
            rule.apply(facts);
        return true;
    }
}
