package com.calculator.demo.service.impl;

import com.calculator.demo.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
