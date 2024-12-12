package org.ppke.itk.librarymanagementsystembackend.domain;

import java.util.stream.Stream;

public enum Condition {
    POOR("poor"), GOOD("good"), MINT("mint");

    private final String condition;

    public String getCondition() {
        return condition;
    }
    Condition(String condition) {
        this.condition = condition;
    }

    public static Condition of(String condition) {
        return Stream.of(Condition.values())
                .filter(c ->
                        c.getCondition().equals(condition))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
