package com.minervamendoza.rickastleyquiz;

import android.content.Context;
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app is quizzes the User's knowledge of Rick Astley.
 */

public class MainActivity extends AppCompatActivity {

    int score = 0;
    Button reset_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset_button=(Button)findViewById(R.id.reset_button);
        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restartIntent = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
                restartIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(restartIntent);
            }
        });
    }

    /**
     * This method adds a score if answer to Question 1 is correct.
     */

    public void q1Answer() {
        CheckBox q1Option7CheckBox = (CheckBox) findViewById(R.id.Q1_option7);
        boolean q1Option7CheckBoxChecked = q1Option7CheckBox.isChecked();
        if (q1Option7CheckBoxChecked) {
            score += 1;
        }
    }

    /**
     * This method adds a score if answer to Question 2 is correct.
     */

    public void q2Answer() {
        CheckBox q2Option4CheckBox = (CheckBox) findViewById(R.id.Q2_option4);
        boolean q2Option4CheckBoxChecked = q2Option4CheckBox.isChecked();
        if (q2Option4CheckBoxChecked) {
            score += 1;
        }
    }

    /**
     * This method adds a score if answer to Question 3 is correct.
     */

    public void q3Answer() {
        EditText answerField = (EditText) findViewById(R.id.middlename_answer);
        String correctAnswer = answerField.getText().toString().replace(" ", "");
        if(correctAnswer.equals("Paul")) {
            score += 1;
        }
    }

    /**
     * This method adds a score if answer to Question 4 is correct.
     */

    public void q4Answer() {
        RadioButton q4TrueRadioButton = (RadioButton) findViewById(R.id.true_radio_button);
        boolean q4TrueRadioButtonChecked = q4TrueRadioButton.isChecked();
        if (q4TrueRadioButtonChecked) {
            score += 1;
        }
    }

    /**
     * This method adds a score if answer to Question 5 is correct.
     */

    public void q5Answer() {
        RadioButton q5Option3RadioButton = (RadioButton) findViewById(R.id.Q5_option3);
        boolean q5Option3RadioButtonChecked = q5Option3RadioButton.isChecked();
        if (q5Option3RadioButtonChecked) {
            score += 1;
        }
    }

    /**
     * This method is called when the scores are added.
     */
    public void calculateScore() {

        q1Answer();
        q2Answer();
        q3Answer();
        q4Answer();
        q5Answer();
    }


    /**
     * This method is called when the GET SCORE button is clicked.
     */
    public void getScore(View view) {

        calculateScore();

        if (score == 5) {
            String scoreMessage5 = "You scored " + score + " out of 5! " + "Great Job! You really know Rick Astley! :)";
            Toast.makeText(this, scoreMessage5, Toast.LENGTH_LONG).show();
        } else if (score == 4) {
            String scoreMessage4 = "You scored " + score + " out of 5! " + "Great Job!";
            Toast.makeText(this, scoreMessage4, Toast.LENGTH_LONG).show();
        } else if (score == 3) {
            String scoreMessage3 = "You scored " + score + " out of 5! " + "Good effort!";
            Toast.makeText(this, scoreMessage3, Toast.LENGTH_LONG).show();
        } else if (score == 2) {
            String scoreMessage2 = "You scored " + score + " out of 5! " + "Keep trying!";
            Toast.makeText(this, scoreMessage2, Toast.LENGTH_LONG).show();
        } else if (score == 1) {
            String scoreMessage1 = "You scored " + score + " out of 5! " + "You don\'t even know the guy. ";
            Toast.makeText(this, scoreMessage1, Toast.LENGTH_LONG).show();
        } else {
            String scoreMessage = "You scored " + score + " out of 5! " + "Aww! How can you not know Rick Astley? :)";
            Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();
        }

        final Button score_button = (Button) findViewById(R.id.score_button);
        score_button.setClickable(false);
        score_button.setVisibility(view.GONE);
    }

    /**
     * This method is called when the RESET button is clicked.
     */
    public void resetQuiz(View view) {
        score = 0;
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }


}
