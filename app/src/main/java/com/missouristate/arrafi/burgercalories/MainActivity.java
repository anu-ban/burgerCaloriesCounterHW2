package com.missouristate.arrafi.burgercalories;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //Task 1: Declaring UI for Reference
    private RadioGroup pattyRG;
    private CheckBox proCBX;
    private RadioGroup cheeseRG;
    private SeekBar sauseSB;

    private TextView totalCalView;

    // Declaring variable to compute callories from the BurgerCal java class, and I have put this to main activity
    // so that, I can access the burger class in all the sub methods and classes
    private BurgerCal mBurgerCal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initiziled mBurgerCal to call for using getters and setters
        mBurgerCal = new BurgerCal();
        initialize();

        //Registering changes in listeners onClick calorie count
        registerCngOnClickListener();
    }

    private void initialize() {
        // Initializeing UI components with UI reference Decleared before
        pattyRG = findViewById(R.id.radioGroupPatty);
        cheeseRG = findViewById(R.id.radioGroupChees);
        proCBX = findViewById(R.id.checkBox);
        sauseSB = findViewById(R.id.seekBar);
        totalCalView = findViewById(R.id.textViewCalories);


    }

    private void registerCngOnClickListener() {
        //Create onCick listener register changes through UI! It takes the radio groups for cheese and patties
        pattyRG.setOnCheckedChangeListener(foodListener);
        cheeseRG.setOnCheckedChangeListener(foodListener);
        //this is a seek bar with massures the amount of sause you want on your burger
        sauseSB.setOnSeekBarChangeListener(sausListener);

    }

    private RadioGroup.OnCheckedChangeListener foodListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int id) {
            //Radio button listener for selection of Burger patties & Cheese selection!
            View view;
            RadioButton rb = findViewById(id);
            //Using switch with case id to capture the selection of patties & Cheese
            switch (id){
                //if the radio button for beef is selected
                // ,then it will capture users selection and set it to
                // burger calories class method of setPattyCalories to
                // FINAL CONSTANT VAlUE of BEEF cal count and holds
                // the information to return the final calorie count
                // to mainActivity for this to be viewed in displayCalories(); method
                //the same goes for all other radio buttons for pattie and cheese
                case R.id.radioBtnBeef:
                    mBurgerCal.setPattyCalories(BurgerCal.BEEF);
                    break;
                case R.id.radioBtnLamp:
                    mBurgerCal.setPattyCalories(BurgerCal.LAMB);
                    break;
                case R.id.radioBtnOstrich:
                    mBurgerCal.setPattyCalories(BurgerCal.OSTRICH);
                    break;
                case R.id.radioBtnAsiago:
                    mBurgerCal.setCheeseCalories(BurgerCal.ASIAGO);
                    break;
                case R.id.radioBtnChadder:
                    mBurgerCal.setCheeseCalories(BurgerCal.CREME_FRAICHE);
                    break;
            }
            //Calling the displayCalories(); method to display the final totalCalorie count
            displayCalories();

        }
    };

    private void displayCalories() {
        //Displaying total calories as string value
        String cals = "Total Calories :" + mBurgerCal.getTotalCalories();
        totalCalView.setText(cals);
    }


    public void beconListener(View view) {
        //This BeconListener method Checks if the Prosciutto option is
        // checked or not, if it is checked, the method setsProsciuttoCalories to the
        // FINAL_CONSTANT value gives and plugs it back into displayCalories method To show to display the total calories to the user
        if(proCBX.isChecked()){
            mBurgerCal.setProsciuttoCalories(BurgerCal.PROSCIUTTO);
        }
        else
            mBurgerCal.setProsciuttoCalories(0);
        displayCalories();
    }
    private SeekBar.OnSeekBarChangeListener sausListener = new SeekBar.OnSeekBarChangeListener() {
        //this is for the amount of sause you want, the process is the same as other method
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

            mBurgerCal.setSauceCalories(seekBar.getProgress());

            displayCalories();

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            //The touching position of seek bar for sause amount

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            //Where the touch has ended

        }
    };



}
