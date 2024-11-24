package org.conley.core;

import org.conley.api.Facts;
import org.conley.api.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.Compilable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CompositeRule extends AbstractRule{
    private static final Logger LOGGER = LoggerFactory.getLogger(Compilable.class);
    protected List<Rule> rules = new ArrayList<>();
    private boolean isSorted = false;

    public CompositeRule priority(int priority){
        this.priority = priority;
        return this;
    }

    public CompositeRule name(String name){
        this.name = name;
        return this;
    }

    public CompositeRule(){}

    @Override
    public boolean evaluate(Facts facts) {
        return false;
    }

    @Override
    public void execute(Facts facts) {

    }

    @Override
    public boolean apply(Facts facts) {
        sort();
        return doApply(facts);
    }

    protected abstract boolean doApply(Facts facts);

    protected void sort(){
        if(!isSorted){
            LOGGER.debug(this.name +" before sort: "+rules);
            Collections.sort(rules);
            LOGGER.debug(this.name+" after sort: "+rules);
            isSorted = true;
        }
    }
}
