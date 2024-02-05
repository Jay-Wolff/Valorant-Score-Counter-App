package com.example.scorecounterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


//HelloToastActivity was referenced for the count methods
public class MainActivity extends AppCompatActivity {
    //made int variables for the count method that is connected to showing the number of points each
    //team will be recieving
    private int CountOne = 0;
    private int CountTwo = 0;
    //each team score has it's own textview to be connected to the textview in the main activity
    private TextView ShowTeamOneScore;
    private TextView ShowTeamTwoScore;
    //used this string to reference who the winner is which is displayed in the winner activity
    private String winner;
    //used this int to do a calculation where on the winner activity it'd state who won and how many
    //points they won by, hence the name pointsWonBy
    private int pointsWonBy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //the activity is being created
        setContentView(R.layout.activity_main);
        //calling the textviews from the xml to outprint the numbers when the count methods happen
        //each textview has a seperate count method since they are connected to seperate buttons
        //Basically teamScoreOne = TeamOne's buttons and textviews
        ShowTeamOneScore = (TextView) findViewById(R.id.teamCountOne);
        ShowTeamTwoScore = (TextView) findViewById(R.id.teamCountTwo);

    }

    //count up methods that add up whenever the user clicks the buttons that are for the team
    //count one is for team one
    public void countUpOne(View view) {
        CountOne++;
        if (ShowTeamOneScore != null) {
            ShowTeamOneScore.setText(Integer.toString(CountOne));
        }
        //if statement below tells us who the winner is. so if countOne which is a reference of team1
        //gets their count equal to 5 then team one wins. team one is OMEN in my code.
        if(CountOne == 5){
            //winner is found so connect the winner string to the name of the winning team
            winner = "Omen";
            //calculate for the pointswonby
            pointsWonBy = CountOne - CountTwo;
            //launch the second activity, and in the second activity we'll display these things
            launchWinnerActivity();

        }
    }

    //count two is for team two
    //I tried to keep the numbers correspondent with the teams they referenced throughout the entire
    // code so team two is referenced in count two and the countuptwo method
    public void countUpTwo(View view) {
        CountTwo++;
        if (ShowTeamTwoScore != null) {
            ShowTeamTwoScore.setText(Integer.toString(CountTwo));
        }
        //if statement below tells us who the winner is. so if countTwo which is a reference of team2
        //gets their count equal to 5 then team two wins. team two is SAGE in my code.
        if(CountTwo == 5){
            //winner is found so connect the winner string to the name of the winning team
            winner = "Sage";
            //calculate for the pointswonby
            pointsWonBy = CountTwo - CountOne;
            //launch the second activity, and in the second activity we'll display these things
            launchWinnerActivity();
        }
    }

    //launch winner activity which calls upon the second activity i made
    public void launchWinnerActivity(){
        //
        Intent intent = new Intent(this, WinnerActivity.class);
        //
        intent.putExtra("winnerName", winner);
        intent.putExtra("Points", pointsWonBy);
        //
        startActivity(intent);
    }
}