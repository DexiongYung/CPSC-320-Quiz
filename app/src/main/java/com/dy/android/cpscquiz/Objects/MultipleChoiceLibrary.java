package com.dy.android.cpscquiz.Objects;

import com.dy.android.cpscquiz.R;

import java.security.InvalidParameterException;
import java.security.spec.InvalidParameterSpecException;
import java.util.InputMismatchException;

/**
 * Created by Dylan on 2017-06-27.
 */

public class MultipleChoiceLibrary {
    private String[] questions = {
            "What is the runtime of mergesort?",
            "Which type of graph has a search time of O(n^2)?",
            "Which one of the following is a graph search algorithm?",
            "Which is typicaly the most efficient pivot method?"};
    private String[] answer = {
            "O(nlog(n)",
            "complete graph",
            "Djikstras",
            "random pivot"};
    private String[][] potentialAnswers = {
            {answer[0], "O(n)", "O(n^2)"} ,
            {"Tree", answer[1], "Linear Graph"},
            {"Bloom filter", answer[2], "binary search"},
            {answer[3], "median pivot", "first element as pivot"}};

    public MultipleChoiceLibrary(){};

    public int getlength(){
        return questions.length;
    }

    public String getPotentialAnswers(int i, int j) {
        if( i >= potentialAnswers.length || i < 0)
            throw new InvalidParameterException("not a valid index");
        else if (j >= potentialAnswers[i].length || j < 0)
            throw new InvalidParameterException("not a valid index2");
        else
            return potentialAnswers[i][j];
    }

    public String getAnswer(int i) {
        if( i >= answer.length || i < 0)
            throw new InvalidParameterException("not a valid index");
        else
            return answer[i];
    }

    public String getQuestions(int i) {
        if( i >= questions.length || i < 0)
            throw new InvalidParameterException("not a valid index");
        else
            return questions[i];
    }
}
