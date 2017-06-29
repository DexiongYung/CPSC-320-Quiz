package com.dy.android.cpscquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.dy.android.cpscquiz.Objects.MultipleChoiceLibrary;
import com.dy.android.cpscquiz.Objects.ShortAnswerActivityLibrary;

import org.w3c.dom.Text;

/**
 * Created by Dylan on 2017-06-28.
 */

public class EndActivity extends Activity {
    private TextView score;
    private MultipleChoiceLibrary mcLibrary = new MultipleChoiceLibrary();
    private ShortAnswerActivityLibrary saLibrary = new ShortAnswerActivityLibrary();

    @Override
    protected void onCreate(Bundle savedStateInstance){
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_end);

        //Carry Score over from ShortAnswer Activity
        Intent intent = getIntent();
        int scoreInt = intent.getIntExtra("ScoreID", 0);

        //Set score text
        score = (TextView) findViewById(R.id.scoresum);
        int sum = mcLibrary.getlength() + saLibrary.getLength();
        score.setText("" + scoreInt + " out of " + sum);
    }
}
