package com.kaaptech.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MyQuizActivity extends AppCompatActivity
{
    public static int score = 0;
    RadioGroup radioGroup, radioGroup2, radioGroup3, radioGroup4;
    RadioButton rbQ1, rbQ3, rbQ5, rbQ6;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_quiz);
        radioGroup = findViewById(R.id.radio_group);
        radioGroup2 = findViewById(R.id.radio_group2);
        radioGroup3 = findViewById(R.id.radio_group3);
        radioGroup4 = findViewById(R.id.radio_group4);

        //Creating an EventListerner for readio group Of Question 1
        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        // Get a reference to the RadioButton that is currently checked
                        rbQ1 = (RadioButton) group.findViewById(checkedId);
                    }
                }
        );

        //Creating an EventListerner for radio group Of Question 3
        radioGroup2.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        // Get a reference to the RadioButton that is currently checked
                        rbQ3 = (RadioButton) group.findViewById(checkedId);
                    }
                }
        );

        //Creating an EventListerner for readio group Of Question 5
        radioGroup3.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        // Get a reference to the RadioButton that is currently checked
                        rbQ5 = (RadioButton) group.findViewById(checkedId);
                    }
                }
        );

        //Creating an EventListerner for radio group Of Question 6
        radioGroup4.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        // Get a reference to the RadioButton that is currently checked
                        rbQ6 = (RadioButton) group.findViewById(checkedId);
                    }
                }
        );

    }

    /**
     * This method is call when the submit button is clicked
     * check all correct answers and call the display score method
     *
     * @param view
     */

    public void submitQuiz(View view)
    {
        //Question 1 with Radio button, the option 2 is the correct choice
        if (rbQ1 != null)
        {
            //Reset the Radio button  colors to black
            ((RadioButton) findViewById(R.id.option1)).setTextColor(getResources().getColor(R.color.black));
            ((RadioButton) findViewById(R.id.option2)).setTextColor(getResources().getColor(R.color.black));
            ((RadioButton) findViewById(R.id.option3)).setTextColor(getResources().getColor(R.color.black));
            ((RadioButton) findViewById(R.id.option4)).setTextColor(getResources().getColor(R.color.black));

            if (rbQ1.getId() == R.id.option2)
            {
                //set the color to green for the correct answer
                rbQ1.setTextColor(getResources().getColor(R.color.green));
                //add 2 points to the score
                score += 2;
            }
            else
            {
                //set wrong choice to Red
                rbQ1.setTextColor(getResources().getColor(R.color.red));
            }
        }
        else
        {
            //This display a message telling the user to answer the question if not answered
            Toast.makeText(this, "Please answer Question 1", Toast.LENGTH_SHORT).show();
            //Reset the score to zero before resubmission
            score =0;

            return;
        }

        //Question 2 with Checkboxes; checkbox1 and 4 are the correct choices
        CheckBox checkbox1 = findViewById(R.id.checkbox1);
        CheckBox checkbox2 = findViewById(R.id.checkbox2);
        CheckBox checkbox3 = findViewById(R.id.checkbox3);
        CheckBox checkbox4 = findViewById(R.id.checkbox4);

        boolean isCheckbox1 = checkbox1.isChecked();
        boolean isCheckbox2 = checkbox2.isChecked();
        boolean isCheckbox3 = checkbox3.isChecked();
        boolean isCheckbox4 = checkbox4.isChecked();

        // Make sure the user answer the question (Question 2)
        if (!(isCheckbox1 || isCheckbox2 || isCheckbox3 || isCheckbox4))
        {
            //This display a message telling the user to answer the question if not answered
            Toast.makeText(this, "Please answer Question 2", Toast.LENGTH_SHORT).show();
            //Reset the score to zero before resubmission
            score =0;

            return;
        }
        else
        {
            // Calculate the score for question 2 and add it to the score variable
            score += calculateScore(isCheckbox1, isCheckbox2, isCheckbox3, isCheckbox4);
        }

        //Question 3, Option 1 is correct answer
        if (rbQ3 != null)
        {
            //Reset the Radio button colors to black
            ((RadioButton) findViewById(R.id.option1a)).setTextColor(getResources().getColor(R.color.black));
            ((RadioButton) findViewById(R.id.option2a)).setTextColor(getResources().getColor(R.color.black));
            ((RadioButton) findViewById(R.id.option3a)).setTextColor(getResources().getColor(R.color.black));
            ((RadioButton) findViewById(R.id.option4a)).setTextColor(getResources().getColor(R.color.black));

            if (rbQ3.getId() == R.id.option1a)
            {
                //set the color to green for the correct answer
                rbQ3.setTextColor(getResources().getColor(R.color.green));
                //add 2 points to the score
                score += 2;

            }
            else
            {
                //set the color to red for the wrong answer
                rbQ3.setTextColor(getResources().getColor(R.color.red));
            }
        }
        else
        {
            //This display a message telling the user to answer the question if not answered
            Toast.makeText(this, "Please answer Question 3", Toast.LENGTH_SHORT).show();
            //Reset the score to zero before resubmission
            score =0;

            return;
        }

        //Question 4 Rhinoceros is the answer

        EditText editQ4 = (EditText) findViewById(R.id.edit_q4);
        String answer = editQ4.getText().toString();

        if (answer.trim().isEmpty())
        {
            //This display a message telling the user to answer the question if not answered
            Toast.makeText(this, "Please answer Question 4", Toast.LENGTH_SHORT).show();
            //Reset the score to zero before resubmission
            score =0;

            return;
        }
        else
        {
            if (answer.equalsIgnoreCase("rhinoceros") || answer.equalsIgnoreCase("rhino"))
            {
                //add 2 points for right option
                score += 2;
            }
        }

        //Question 5, Option 2 is the correct answer
        if (rbQ5 != null)
        {
            //Reset the Radio button colors to black
            ((RadioButton) findViewById(R.id.option1b)).setTextColor(getResources().getColor(R.color.black));
            ((RadioButton) findViewById(R.id.option2b)).setTextColor(getResources().getColor(R.color.black));

            if (rbQ5.getId() == R.id.option2b)
            {
                //set the color to green for the correct answer
                rbQ5.setTextColor(getResources().getColor(R.color.green));
                //add 2 points for right option
                score += 2;
            }
            else
            {
                //Set the TextColor to red for the wrong choice
                rbQ5.setTextColor(getResources().getColor(R.color.red));
            }

        }
        else
        {
            //This display a message telling the user to answer the question if not answered
            Toast.makeText(this, "Please answer Question 5", Toast.LENGTH_SHORT).show();
            //Reset the score to zero before resubmission
            score =0;

            return;
        }

        //Question 6, Option 2 is the right answer
        //check is is not answered
        if (rbQ6 != null) {
            //Reset the Radio button colors to black
            ((RadioButton) findViewById(R.id.option1c)).setTextColor(getResources().getColor(R.color.black));
            ((RadioButton) findViewById(R.id.option2c)).setTextColor(getResources().getColor(R.color.black));

            if (rbQ6.getId() == R.id.option2c)
            {
                //set the color to green for the correct answer
                rbQ6.setTextColor(getResources().getColor(R.color.green));
                //add 2 points for right option
                score += 2;

            }
            else
            {
                //set the color to red for the correct answer
                rbQ6.setTextColor(getResources().getColor(R.color.red));
            }
        }
        else
        {
            //This display a message telling the user to answer the question if not answered
            Toast.makeText(this, "Please answer Question 6", Toast.LENGTH_SHORT).show();
            //Reset the score to zero before resubmission
            score =0;
            return;
        }
        //Call the displaySocre method and pass the score as parameter
        displayScore(score);

        //Reset the score to 0 in case the user click the submit again
        score = 0;


    }

    /**
     * This calculate the score for question 2
     * @param isCheckbox1
     * @param isCheckbox2
     * @param isCheckbox3
     * @param isCheckbox4
     * @return score
     */

    private int calculateScore(boolean isCheckbox1, boolean isCheckbox2, boolean isCheckbox3, boolean isCheckbox4)
    {
        //Reset the check box colors to black
        ((CheckBox) findViewById(R.id.checkbox1)).setTextColor(getResources().getColor(R.color.black));
        ((CheckBox) findViewById(R.id.checkbox2)).setTextColor(getResources().getColor(R.color.black));
        ((CheckBox) findViewById(R.id.checkbox3)).setTextColor(getResources().getColor(R.color.black));
        ((CheckBox) findViewById(R.id.checkbox4)).setTextColor(getResources().getColor(R.color.black));

        if (isCheckbox2 && isCheckbox4 && isCheckbox3 && isCheckbox1)
        {
            //Checkbox text color red when all is selected
            ((CheckBox) findViewById(R.id.checkbox1)).setTextColor(getResources().getColor(R.color.red));
            ((CheckBox) findViewById(R.id.checkbox2)).setTextColor(getResources().getColor(R.color.red));
            ((CheckBox) findViewById(R.id.checkbox3)).setTextColor(getResources().getColor(R.color.red));
            ((CheckBox) findViewById(R.id.checkbox4)).setTextColor(getResources().getColor(R.color.red));

            return 0;
        }

        if (isCheckbox2 && isCheckbox4 && !isCheckbox1 && !isCheckbox3)
        {
            //Set color Green in case when checkbox 2 and 4 are selected which is the correct options
            ((CheckBox) findViewById(R.id.checkbox2)).setTextColor(getResources().getColor(R.color.green));
            ((CheckBox) findViewById(R.id.checkbox4)).setTextColor(getResources().getColor(R.color.green));

            // Return 2 as score for correct option
            return 2;
        }

        if (isCheckbox1)
        {
            //wrong option, color red
            ((CheckBox) findViewById(R.id.checkbox1)).setTextColor(getResources().getColor(R.color.red));
        }

        if (isCheckbox3)
        {
            //Wrong option, color red
            ((CheckBox) findViewById(R.id.checkbox3)).setTextColor(getResources().getColor(R.color.red));
        }

        return 0;
    }

    /**
     * This method display the score of the user
     *
     * @param score The score of the user
     */
    private void displayScore(int score) {
        Toast.makeText(this, "Your score is : " + score + " Out of 12", Toast.LENGTH_SHORT).show();
    }
}
