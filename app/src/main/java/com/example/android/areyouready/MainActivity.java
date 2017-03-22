package com.example.android.areyouready;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.R.attr.id;
import static android.R.string.yes;
import static android.transition.Fade.IN;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.android.areyouready.R.id.box1;
import static com.example.android.areyouready.R.id.box2;
import static com.example.android.areyouready.R.id.box3;
import static com.example.android.areyouready.R.id.box4;
import static com.example.android.areyouready.R.id.button_n;
import static com.example.android.areyouready.R.id.button_ok;
import static com.example.android.areyouready.R.id.button_y;
import static com.example.android.areyouready.R.id.main_image;
import static com.example.android.areyouready.R.id.q4_layout;
import static com.example.android.areyouready.R.id.q5_edit_text;
import static com.example.android.areyouready.R.id.q5_layout;
import static com.example.android.areyouready.R.id.q6_layout;
import static com.example.android.areyouready.R.id.question;
import static com.example.android.areyouready.R.id.radio_no;
import static com.example.android.areyouready.R.id.radio_yes;
import static com.example.android.areyouready.R.id.summary;

public class MainActivity extends AppCompatActivity {

    int counter = 0;                //keeps track of the question asked
    int food_counter = 0;           // tracks food-points
    boolean hassaidno = false;      // tracks if user has input "no"
    int score = 0;

    int apple=0, donut=0, cake=0, orange=0;
    boolean last_summary = false;   //is set to true after the last question. helps setting up another round


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    /*
    called when clicking yes or no
    increases counter by 1
    changes the summary-text according to counter
    */
    public void yes (View view)
    {
        //getting references of the objekts
        ImageView main_image = (ImageView) findViewById(R.id.main_image);
        Button button_n = (Button) findViewById(R.id.button_n);
        Button button_y = (Button) findViewById(R.id.button_y);
        Button button_ok = (Button) findViewById(R.id.button_ok);
        TextView summary = (TextView) findViewById(R.id.summary);
        TextView question = (TextView) findViewById(R.id.question);



        //increasing the counter. This is how the programm knows which question is being asked
        counter = counter +1;

        //exchanging the buttons
        button_n.setVisibility(GONE);
        button_y.setVisibility(GONE);
        button_ok.setVisibility(VISIBLE);

        //getting the summary the right text
        if (counter == 1)
        {
            summary.setText("Very good!\nGetting enough sleep will help you concentrate on the lections.");
            score++;
        }

        if (counter == 2)
        {
            summary.setText("Very good!\nStaying hydrated will help you concentrate on the lections.");
            score++;

        }

        if (counter == 3)
        {
            summary.setText("Very good!\nStaying physically fit will help you concentrate on the lections.");
            score++;

        }

        //exchanging the Image for the summary-text
        main_image.setVisibility(GONE);
        summary.setVisibility(VISIBLE);

    }

    public void no (View view)
    {
        //getting references of the objekts
        ImageView main_image = (ImageView) findViewById(R.id.main_image);
        Button button_n = (Button) findViewById(R.id.button_n);
        Button button_y = (Button) findViewById(R.id.button_y);
        Button button_ok = (Button) findViewById(R.id.button_ok);
        TextView summary = (TextView) findViewById(R.id.summary);
        TextView question = (TextView) findViewById(R.id.question);



        //increasing the counter. This is how the programm knows which question is being asked
        counter = counter +1;

        //exchanging the buttons
        button_n.setVisibility(GONE);
        button_y.setVisibility(GONE);
        button_ok.setVisibility(VISIBLE);

        //getting the summary the right text
        if (counter == 1)
        {
            summary.setText("Go take a nap!\nGetting enough sleep will help you concentrate on the lections.");
        }

        if (counter == 2)
        {
            summary.setText("Drink a Glas of Water!\nStaying hydrated will help you concentrate on the lections.");
        }

        if (counter == 3)
        {
            summary.setText("Do 10 Jumping Jacks!\nStaying physically fit will help you concentrate on the lections.");
        }



        //exchanging the Image for the summary-text
        main_image.setVisibility(GONE);
        summary.setVisibility(VISIBLE);


    }

    /*
    called when clicking ok
    changes the question text according to counter and starts the question-methods
     */
    public void ok (View view)
    {
        //getting references of the objekts
        ImageView main_image = (ImageView) findViewById(R.id.main_image);
        Button button_n = (Button) findViewById(R.id.button_n);
        Button button_y = (Button) findViewById(R.id.button_y);
        Button button_ok = (Button) findViewById(R.id.button_ok);
        TextView summary = (TextView) findViewById(R.id.summary);
        TextView question = (TextView) findViewById(R.id.question);
        CheckBox box1 = (CheckBox) findViewById(R.id.box1);
        CheckBox box2 = (CheckBox) findViewById(R.id.box2);
        CheckBox box3 = (CheckBox) findViewById(R.id.box3);
        CheckBox box4 = (CheckBox) findViewById(R.id.box4);
        EditText q5_edit_text = (EditText) findViewById(R.id.q5_edit_text);
        RadioButton radio_yes = (RadioButton) findViewById(R.id.radio_yes);
        RadioButton radio_no = (RadioButton) findViewById(R.id.radio_no);
        RelativeLayout q5_layout = (RelativeLayout) findViewById(R.id.q5_layout);
        RelativeLayout toast_layout = (RelativeLayout) findViewById(R.id.toast_layout);
        ImageView toast_image = (ImageView) findViewById(R.id.toast_image);
        TextView toast_score = (TextView) findViewById(R.id.toast_score);


        reset_ui();


        //restarts the game
        if (last_summary == true){
            //general
            counter = 0;
            last_summary = false;
            score = 0;


            // q4
            apple=0;
            donut=0;
            cake=0;
            orange=0;
            box1.setChecked(false);
            box2.setChecked(false);
            box3.setChecked(false);
            box4.setChecked(false);
            food_counter = 0;

            // q5
            hassaidno = false;
            q5_edit_text.setText("");

            // q6
            radio_yes.setChecked(false);
            radio_no.setChecked(false);


        }

        //changing the text and the image for every question
        if (counter == 0)
        {
            question.setText("Are you well rested?");
            main_image.setImageResource(R.drawable.bett);
        }


        if (counter == 1)
        {
            question.setText("Did you drink water today?");
            main_image.setImageResource(R.drawable.wasser);
        }


        if (counter == 2)
        {
            question.setText("Did you do sport today?");
            main_image.setImageResource(R.drawable.joggen);

        }


        if (counter == 3)
        {
            question.setText("What do you think is healthy food?");
            main_image.setVisibility(GONE);
            button_n.setVisibility(GONE);
            button_y.setVisibility(GONE);
            button_ok.setVisibility(VISIBLE);
            button_ok.setText("enter");
            question_food();
        }


        if (counter == 4)
        {
            if (hassaidno == false) {
                question.setText("Are you smart enough?\nwrite yes or no");
            }

            main_image.setVisibility(GONE);
            button_n.setVisibility(GONE);
            button_y.setVisibility(GONE);
            button_ok.setVisibility(VISIBLE);
            question_edit();

        }


        if (counter == 5)
        {
            question.setText("Do you like this App?");
            main_image.setVisibility(GONE);
            button_n.setVisibility(GONE);
            button_y.setVisibility(GONE);
            button_ok.setVisibility(VISIBLE);
            question_radio();

        }


        //ending screen after all questions have been answered
        if (counter == 6)
        {
            question.setText("Thank you :-)\n\nNow get going!");
            button_n.setVisibility(View.GONE);
            button_y.setVisibility(View.GONE);
            question.setVisibility(View.VISIBLE);
            toast_layout.setVisibility(VISIBLE);
            main_image.setVisibility(GONE);
            toast_score.setText("You scored "+ score + " points!");

            button_ok.setText("play again");
            button_ok.setVisibility(VISIBLE);
            last_summary = true;
        }


    }

    /*
    ok button gets clicked and counter = 3 ( = q4)
    calculates if the right choices were enabled in the checkbox-question
     */
    private void question_food ()
    {
        //getting references of the objekts
        LinearLayout q4_layout = (LinearLayout) findViewById(R.id.q4_layout);
        CheckBox box1 = (CheckBox) findViewById(R.id.box1);
        CheckBox box2 = (CheckBox) findViewById(R.id.box2);
        CheckBox box3 = (CheckBox) findViewById(R.id.box3);
        CheckBox box4 = (CheckBox) findViewById(R.id.box4);
        TextView question = (TextView) findViewById(R.id.question);
        Button button_ok = (Button) findViewById(R.id.button_ok);


        q4_layout.setVisibility(VISIBLE);

        if (box1.isChecked())
            apple = 1;
        else
            apple = 0;

        if (box2.isChecked())
            donut = -3;
        else
            donut = 0;

        if (box3.isChecked())
            cake = -3;
        else
            cake = 0;

        if (box4.isChecked())
            orange = 1;
        else
            orange = 0;

        food_counter = apple + donut + cake + orange;

        /*
        2 is the correct solution. when the solution is correct counter gets +1
        the initiation-value of food_counter is 0. if at least one checkbox is enabled, foodcounter cant be 0.
        after the first try where anything at all was checked ( and thus the question was understood) the questiontext changes to Try again!
        */
        if (food_counter==2){
            counter++;
            box1.setChecked(false);
            box4.setChecked(false);
            button_ok.setText("okay");
            reset_ui();
            score++;


        }
        else
            if (food_counter != 0)
            question.setText("Try again and press ENTER");

    }


    /*
    ok button is clicked and counter = 4 ( = q5)
    calculates the Edit_text question
     */
    private void question_edit ()
    {
        //get references
        RelativeLayout q5_layout = (RelativeLayout) findViewById(R.id.q5_layout);
        EditText q5_edit_text = (EditText) findViewById(R.id.q5_edit_text);
        TextView question = (TextView) findViewById(R.id.question);
        TextView summary = (TextView) findViewById(R.id.summary);

        q5_layout.setVisibility(VISIBLE);

        String text = q5_edit_text.getText().toString();

        if (!hassaidno) {
            if (text.equals("yes")) {
                counter++;
                reset_ui();
                score++;

            }

            if (text.equals("no")) {
                question.setText("What? please type \nI AM A BEAST AND I CAN DO THIS");
                hassaidno = true;
            }
        }
        if (hassaidno){
            if (text.equals("I AM A BEAST AND I CAN DO THIS")) {
                counter++;
                reset_ui();
                score++;
            }
        }
    }


    /*
    ok button and counter = 5 ( = q6)
    does the radio-button question
     */
    private void question_radio(){
        // get references
        RelativeLayout q6_layout = (RelativeLayout) findViewById(R.id.q6_layout);
        RadioButton radio_yes = (RadioButton) findViewById(R.id.radio_yes);
        RadioButton radio_no = (RadioButton) findViewById(R.id.radio_no);
        TextView question = (TextView) findViewById(R.id.question);



        q6_layout.setVisibility(VISIBLE);
        if (radio_yes.isChecked()){
            counter++;
            reset_ui();

        }

        if (radio_no.isChecked()){
            question.setText("ERROR in android.activity\nPlease try again");
        }
    }


    /*
     resets ui for next question
     not perfect for all questions but guarantees every question starts with the same conditions
     */
    private void reset_ui(){
        ImageView main_image = (ImageView) findViewById(R.id.main_image);
        Button button_n = (Button) findViewById(R.id.button_n);
        Button button_y = (Button) findViewById(R.id.button_y);
        Button button_ok = (Button) findViewById(R.id.button_ok);
        TextView summary = (TextView) findViewById(R.id.summary);
        TextView question = (TextView) findViewById(R.id.question);
        LinearLayout q4_layout = (LinearLayout) findViewById(R.id.q4_layout);
        RelativeLayout q5_layout = (RelativeLayout) findViewById(R.id.q5_layout);
        RelativeLayout q6_layout = (RelativeLayout) findViewById(R.id.q6_layout);
        RelativeLayout toast_layout = (RelativeLayout) findViewById(R.id.toast_layout);

        // stuff that is enabled
        question.setVisibility(VISIBLE);
        main_image.setVisibility(VISIBLE);
        button_n.setVisibility(VISIBLE);
        button_y.setVisibility(VISIBLE);


        // stuff that is disabled
        summary.setVisibility(GONE);
        button_ok.setVisibility(GONE);
        q4_layout.setVisibility(GONE);
        q5_layout.setVisibility(GONE);
        q6_layout.setVisibility(GONE);
        toast_layout.setVisibility(GONE);


    }






                }