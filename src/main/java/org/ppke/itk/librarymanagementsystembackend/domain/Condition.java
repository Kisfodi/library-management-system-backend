package org.ppke.itk.librarymanagementsystembackend.domain;

public enum Condition {
    POOR("poor"), GOOD("good"), MINT("mint");

    private final String condition;

    public String getCondition() {
        return condition;
    }
    Condition(String condition) {
        this.condition = condition;
    }
}
