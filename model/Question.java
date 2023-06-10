package com.calculator.demo.model;

import java.util.Objects;

public class Question {
    private final  String question;

    private final  String aswer;
    public Question(String question, String aswer) {
        this.question = question;
        this.aswer = aswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAswer() {
        return aswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) && Objects.equals(aswer, question1.aswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, aswer);
    }

    @Override
    public String toString() {
        return String.format("Вопрос: %s, ответ: %s", question, aswer);
    }
}
