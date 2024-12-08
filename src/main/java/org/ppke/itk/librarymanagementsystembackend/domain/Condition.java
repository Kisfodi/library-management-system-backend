package org.ppke.itk.librarymanagementsystembackend.domain;

public enum Condition {
    POOR("poor"), GOOD("good"), MINT("mint");

    private String condition;
    Condition(String condition) {
        this.condition = condition;
    }
}
