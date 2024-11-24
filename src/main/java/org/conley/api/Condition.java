package org.conley.api;

import java.util.Objects;

@FunctionalInterface
public interface Condition {
    boolean evaluate(Facts facts);

    default Condition and(Condition other){
        Objects.requireNonNull(other);
        return (facts) ->{
            return this.evaluate(facts) &&
                    other.evaluate(facts);
        };
    }

    default Condition or(Condition other){
        Objects.requireNonNull(other);
        return (facts) ->{
            return this.evaluate(facts) || other.evaluate(facts);
        };
    }

    Condition FALSE = facts -> false;

    Condition TRUE = facts -> true;
}
