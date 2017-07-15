package com.example.android.baseballscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int scoreHome = 0;
    private int scoreAway = 0;
    private int outs = 0;
    private int inning = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayHomeScore(scoreHome);
        displayAwayScore(scoreAway);
        displayHomeOuts();
        displayAwayOuts();
        displayTopInning();
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayHomeScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_home_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayAwayScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_away_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the outs for the home team
     */
    public void displayHomeOuts() {
        String msg = "outs: " + outs;
        TextView outsView = (TextView) findViewById(R.id.team_home_outs);
        outsView.setText(msg);
    }

    /**
     * Adds 1 run to the score for the home team
     */
    public void addRunForHomeTeam(View view) {
        scoreHome += 1;
        displayHomeScore(scoreHome);
    }

    /**
     * Adds 1 out for Home team and changes to bottom of the inning on the third out
     */
    public void addOutForHomeTeam(View view) {
        String msg = "Outs: ";
        outs++;

        if(outs == 3) {
            outs = 0;
            displayBottomInning();
            displayAwayOuts();
        }

        displayHomeOuts();
    }

    /**
     * Adds 1 out for the Away team and changes to top of the next inning on the third out
     */
    public void addOutForAwayTeam(View view) {
        String msg = "Outs: ";
        outs++;

        if(outs == 3) {
            outs = 0;
            inning++;
            displayTopInning();
            displayHomeOuts();
        }

        displayAwayOuts();
    }

    /**
     * Adds 1 run to the score for the home team
     */
    public void addRunForAwayTeam(View view) {
        scoreAway += 1;
        displayAwayScore(scoreAway);
    }

    /**
     * displays the outs for the away team
     */
    public void displayAwayOuts() {
        String msg = "outs: " + outs;
        TextView outsView = (TextView) findViewById(R.id.team_away_outs);
        outsView.setText(msg);
    }

    /**
     * displays The top of the inning
     */
    public void displayTopInning() {
        String msg = "Inning: Top " + inning;
        TextView inningHomeView = (TextView) findViewById(R.id.team_home_inning);
        inningHomeView.setText(msg);

        TextView inningAwayView = (TextView) findViewById(R.id.team_away_inning);
        inningAwayView.setText(msg);

        Button btnAwayRun = (Button) findViewById(R.id.away_run_btn);
        btnAwayRun.setEnabled(false);

        Button btnAwayOut = (Button) findViewById(R.id.away_out_btn);
        btnAwayOut.setEnabled(false);

        Button btnHomeRun = (Button) findViewById(R.id.home_run_btn);
        btnHomeRun.setEnabled(true);

        Button btnHomeOut = (Button) findViewById(R.id.home_out_btn);
        btnHomeOut.setEnabled(true);
    }

    public void displayBottomInning() {
        String msg = "Inning: Bot " + inning;
        TextView inningHomeView = (TextView) findViewById(R.id.team_home_inning);
        inningHomeView.setText(msg);

        TextView inningAwayView = (TextView) findViewById(R.id.team_away_inning);
        inningAwayView.setText(msg);

        Button btnAwayRun = (Button) findViewById(R.id.away_run_btn);
        btnAwayRun.setEnabled(true);

        Button btnAwayOut = (Button) findViewById(R.id.away_out_btn);
        btnAwayOut.setEnabled(true);

        Button btnHomeRun = (Button) findViewById(R.id.home_run_btn);
        btnHomeRun.setEnabled(false);

        Button btnHomeOut = (Button) findViewById(R.id.home_out_btn);
        btnHomeOut.setEnabled(false);
    }

    /**
     * Sets both scores to 0, the outs to 0 and the inning to 1 and sets it to the top of the inning
     */
    public void reset(View view) {
        scoreHome = 0;
        scoreAway = 0;
        outs = 0;
        inning = 1;

        displayHomeScore(scoreHome);
        displayAwayScore(scoreAway);
        displayHomeOuts();
        displayAwayOuts();
        displayTopInning();
    }
}