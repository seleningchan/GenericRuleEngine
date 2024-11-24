package org.conley;

import org.conley.api.Rule;
import org.conley.api.RuleEngine;
import org.conley.core.AnyRules;
import org.conley.core.CompositeRule;
import org.conley.core.DefaultRuleEngine;
import org.conley.core.RuleBuilder;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
       /* System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }*/


        RuleEngine ruleEngine = new DefaultRuleEngine();
        Rule rule = new RuleBuilder()
                .name("hello world rule")
                .descriotion("always say hell world")
                .priority(1)
                .when(facts -> true)
                .then(facts -> System.out.println("facts hello"))
                .build();
        CompositeRule rules = AnyRules.anyOf(rule);
        ruleEngine.fire(rules, null);
    }
}