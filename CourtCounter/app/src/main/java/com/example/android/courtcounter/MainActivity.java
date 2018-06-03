package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    int scoreA = 0;
    int scoreB = 0;
    public void freeA (View view){
        scoreA = scoreA+1;
        displayForTeamA(scoreA);
    }

    public void freeB (View view){
        scoreB = scoreB+1;
        displayForTeamB(scoreB);
    }


    public void threepointsA (View view){
        scoreA = scoreA+3;
        displayForTeamA(scoreA);
    }
    public void threepointsB (View view){
        scoreB = scoreB+3;
        displayForTeamB(scoreB);
    }


    public void twopointsA (View view){
        scoreA = scoreA+2;
        displayForTeamA(scoreA);
    }
    public void twopointsB (View view){
        scoreB = scoreB+2;
        displayForTeamB(scoreB);
    }

    public void reset (View view){
        scoreA = 0;
        scoreB = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
