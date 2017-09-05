package com.dy.android.cpscquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.dy.android.cpscquiz.Objects.ShortAnswerActivityLibrary;

/**
 * Created by Dylan on 2017-06-27.
 */

public class ShortAnswerActivity extends Activity{
    private ShortAnswerActivityLibrary library = new ShortAnswerActivityLibrary();
    private int score;
    private int index = 0;

    private TextView scoreTextView;
    private TextView questionTextView;
    private Button submitButton;
    private EditText answerEditText;

    @Override
    protected void onCreate(Bundle savedStateInstance){
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_short_answer_quiz);

        // Carry Score over from Multiple Choice Activity
        Intent intent = getIntent();
        score = intent.getIntExtra("ScoreID", 0);
        scoreTextView = (TextView) findViewById(R.id.score_number);
        scoreTextView.setText("" + score);

        // Answer input and submit button
        answerEditText = (EditText) findViewById(R.id.short_answer);
        submitButton = (Button) findViewById(R.id.submit_button);

        // Question Setter
        questionTextView = (TextView) findViewById(R.id.Question);
        questionTextView.setText(library.getQuestion(index));

        // Button listener
        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                CharSequence answer = answerEditText.getText().toString();
                answerEditText.setText("");

                if(Math.abs(levenshteinDistance(answer, library.getAnswer(index))) < 4) {
                    score++;
                    updateScore();
                }

                index++;
                updateQuestion();

            }
        });
    }

    // Call end activity
    private void startEndActivity(){
        Intent myIntent = new Intent(this, EndActivity.class);
        myIntent.putExtra("ScoreID", score);
        startActivity(myIntent);
    }

    // Change question TextView
    private void updateQuestion(){
        if(index >= library.getLength())
            startEndActivity();
        else
            questionTextView.setText(library.getQuestion(index));
    }

    private void updateScore(){
        scoreTextView.setText("" + score);
    }

    // Levenshtein Distance Algorithm
    public int levenshteinDistance (CharSequence lhs, CharSequence rhs) {
        int len0 = lhs.length() + 1;
        int len1 = rhs.length() + 1;

        // the array of distances
        int[] cost = new int[len0];
        int[] newcost = new int[len0];

        // initial cost of skipping prefix in String s0
        for (int i = 0; i < len0; i++)
            cost[i] = i;

        // dynamically computing the array of distances

        // transformation cost for each letter in s1
        for (int j = 1; j < len1; j++) {
            // initial cost of skipping prefix in String s1
            newcost[0] = j;

            // transformation cost for each letter in s0
            for(int i = 1; i < len0; i++) {
                // matching current letters in both strings
                int match = (lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1;

                // computing cost for each transformation
                int cost_replace = cost[i - 1] + match;
                int cost_insert  = cost[i] + 1;
                int cost_delete  = newcost[i - 1] + 1;

                // keep minimum cost
                newcost[i] = Math.min(Math.min(cost_insert, cost_delete), cost_replace);
            }

            // swap cost/newcost arrays
            int[] swap = cost; cost = newcost; newcost = swap;
        }

        // the distance is the cost for transforming all letters in both strings
        return cost[len0 - 1];
    }
}
