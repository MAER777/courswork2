package com.calculator.demo.service.impl;

import com.calculator.demo.exception.QuestionAlreadyExistException;
import com.calculator.demo.exception.QuestionNotFoundException;
import com.calculator.demo.exception.QuestionsAreEmptyException;
import com.calculator.demo.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questionSet = new HashSet<>();
    private final Random random = new Random();
    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (!questionSet.add(question)) {
            throw new QuestionAlreadyExistException();
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questionSet.remove(question)) {
            throw new QuestionNotFoundException();
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questionSet);
    }

    @Override
    public Question getRandomQuestion() {
        if (questionSet.isEmpty()) {
            throw new QuestionsAreEmptyException();
        }
        return new ArrayList<>(questionSet).get(random.nextInt(questionSet.size()));
    }
}
