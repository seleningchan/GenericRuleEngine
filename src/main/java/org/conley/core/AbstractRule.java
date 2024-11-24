package org.conley.core;

import org.conley.api.Facts;
import org.conley.api.Rule;

import java.util.Objects;

public abstract class AbstractRule implements Rule {
    protected String name;
    protected String description;
    protected int priority;

    public AbstractRule() {
        this(Rule.DEFAULT_NAME, Rule.DEFAULT_DESCRIPTION, Rule.DEFAULT_PRIORITY);
    }

    public AbstractRule(final String name) {
        this(name, Rule.DEFAULT_DESCRIPTION, Rule.DEFAULT_PRIORITY);
    }

    public AbstractRule(final int priority) {
        this(Rule.DEFAULT_NAME, Rule.DEFAULT_DESCRIPTION, priority);
    }

    /**
     * Create a new {@link AbstractRule}.
     *
     * @param name        rule name
     * @param description rule description
     */
    public AbstractRule(final String name, final String description) {
        this(name, description, Rule.DEFAULT_PRIORITY);
    }

    /**
     * Create a new {@link AbstractRule}.
     *
     * @param name        rule name
     * @param description rule description
     * @param priority    rule priority
     */
    public AbstractRule(final String name, final String description, final int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public abstract boolean evaluate(Facts facts);

    public abstract void execute(Facts facts);

    public abstract boolean apply(Facts facts);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        AbstractRule basicRule = (AbstractRule) obj;
        if (priority != basicRule.priority)
            return false;
        if (!name.equals(basicRule.name))
            return false;
        return Objects.equals(description, basicRule.description);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + priority;
        return result;
    }

    @Override
    public int compareTo(final Rule rule) {
        if(getPriority()<rule.getPriority())
            return -1;
        else if (getPriority()>rule.getPriority())
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        return name + ":" + priority;
    }
}
