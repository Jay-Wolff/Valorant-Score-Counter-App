package com.example.scorecounterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {
    //making variables that show the winning team at the top of the second activity and
    private String winnerName;
    //textview which connects to the top of the winnerActivity which displays the winning team
    private TextView displayWinnerName;
    //textview which connects to the bottom of the winner activity which displays the number of
    //points the winning team beat the other team by
    private TextView pointsWonBy;
    private String pointSentence;
    //making variable to show the points won by
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //the activity is being created
        setContentView(R.layout.activity_winner);
        //
        Bundle result = getIntent().getExtras();
        //Intent intent = getIntent();
        //
        if(result != null){
            winnerName = result.getString("winnerName");
            points = result.getInt("Points");
        }
        //connecting the textView in the winning team based whichever team the user clicked to the
        //value of 5 first
        displayWinnerName = findViewById(R.id.WinningTeam);
        //setting the text for the display winner name to the winnername string which is called in
        //the main activity
        displayWinnerName.setText(winnerName);

        pointsWonBy = findViewById(R.id.howMuchWonBy);
        //pointSentence = displayWinnerName + " won by " + (points);
        //how you display int to text view
        pointsWonBy.setText(winnerName + " won by " +String.valueOf(points));
    }

    //this is the method to return back to the main activity using the back button we created on the
    //bottom right of the screen
    public void backToMain(View view) {
        //whith the intent we make sure that the package conext is the winner activity and the main
        //activity class is the one being referenced to be called
        Intent intent = new Intent(this, MainActivity.class);
        //start activity ensures that when the button is clicked the activity will start and return
        //the user back to the main activity where they can once again pick which team wins
        startActivity(intent);
    }
}