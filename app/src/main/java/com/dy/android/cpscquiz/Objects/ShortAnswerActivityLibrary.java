package com.dy.android.cpscquiz.Objects;

/**
 * Created by Dylan on 2017-06-27.
 */

public class ShortAnswerActivityLibrary {
    private String[] questions = {
            "Given x number of cities each with a y distance from each other, find a path between them while minimizing y",
            "Given a capacity x and a number of objects y with each one weighing a different amount, try to fit as much as you can without exceeding capacity",
            "A safety program pairs up people into pairs. Some are in more than one pair, but we want all pairs to have at least one trained person",
            "Array of numbers, find a consecutive sequence of numbers that sum to x, which problem is this?"
    };
    private CharSequence[] AnswerTags = {
            "traveling salesman",
            "knapsack prob",
            "Vertex Cover",
            "subset sum prob"
    };

    public String getQuestion(int index){
        return questions[index];
    }

    public CharSequence getAnswer(int index){
        return AnswerTags[index];
    }

    public int getLength() {
        return questions.length;
    }
}
