package com.dy.android.cpscquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dy.android.cpscquiz.Objects.MultipleChoiceLibrary;

/**
 * Created by Dylan on 2017-06-27.
 */

public class MultipleChoiceActivity extends AppCompatActivity implements View.OnClickListener {
    private MultipleChoiceLibrary mMultipleChoiceLibraryLibrary = new MultipleChoiceLibrary();

    //Values
    private int index = 0;
    private int score = 0;
    private String answer;

    //View Objects
    private TextView scoreTextView;
    private TextView questionTextView;
    private Button buttonA;
    private Button buttonB;
    private Button buttonC;

    @Override
    protected void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_multiple_choice_quiz);

        //Initiate TextViews
        questionTextView = (TextView) findViewById(R.id.Question);
        scoreTextView = (TextView) findViewById(R.id.score_number);

        //Initiate Buttons
        buttonA = (Button) findViewById(R.id.answer_a);
        buttonB = (Button) findViewById(R.id.answer_b);
        buttonC = (Button) findViewById(R.id.answer_c);

        //Button listeners
        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);

        //Set initial question and Answers
        updateQuestion();
        updateAnswers();
        answer = mMultipleChoiceLibraryLibrary.getAnswer(index);
    }

    //Set the question
    private void updateQuestion(){
        if(index >= mMultipleChoiceLibraryLibrary.getlength()){
            startShortAnswerActivity();
        }
        else {
            String question = mMultipleChoiceLibraryLibrary.getQuestions(index);
            questionTextView.setText(question);
        }
    }

    private void updateScore(int point){
        scoreTextView.setText("" + point);
    }

    //Sets the Answers
    private void updateAnswers(){
        if(index >= mMultipleChoiceLibraryLibrary.getlength()){
            startShortAnswerActivity();
        }
        else {
            answer = mMultipleChoiceLibraryLibrary.getAnswer(index);

            String answerA = mMultipleChoiceLibraryLibrary.getPotentialAnswers(index, 0);
            buttonA.setText(answerA);

            String answerB = mMultipleChoiceLibraryLibrary.getPotentialAnswers(index, 1);
            buttonB.setText(answerB);

            String answerC = mMultipleChoiceLibraryLibrary.getPotentialAnswers(index, 2);
            buttonC.setText(answerC);
        }
    }

    private void startShortAnswerActivity(){
        Intent myIntent = new Intent(this, ShortAnswerActivity.class);
        myIntent.putExtra("ScoreID", score);
        startActivity(myIntent);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonA){
            if(buttonA.getText() == answer) {
                score++;
                updateScore(score);
            };
            index++;
            updateAnswers();
            updateQuestion();
        }
        else if ( v == buttonB){
            if(buttonB.getText() == answer) {
                score++;
                updateScore(score);
            };
            index++;
            updateAnswers();
            updateQuestion();
        }
        else{
            if(buttonC.getText() == answer) {
                score++;
                updateScore(score);
            };
            index++;
            updateAnswers();
            updateQuestion();
        }
    }
}
