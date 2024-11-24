package org.conley.core;

import org.conley.api.Facts;
import org.conley.api.Rule;

import java.util.Collections;

public class AnyRules extends CompositeRule{
    public static CompositeRule anyOf(Rule... rules){
        CompositeRule instance = new AnyRules();
        Collections.addAll(instance.rules, rules);
        return instance;
    }

    @Override
    public boolean evaluate(Facts facts) {
        if(rules.stream().anyMatch(rule -> rule.evaluate(facts)))
            return true;
        return false;
    }

    @Override
    public void execute(Facts facts) {
        //不支持 OR relation
        throw new RuntimeException("execute not supported for or relation composite");
    }

    @Override
    protected boolean doApply(Facts facts) {
        for(Rule rule : rules){
            if(rule.apply(facts)){
                return true;
            }
        }
        return false;
    }
}
