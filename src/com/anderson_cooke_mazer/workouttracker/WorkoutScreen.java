package com.anderson_cooke_mazer.workouttracker;

import android.content.Intent;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.RadioButton;
import java.io.FileOutputStream;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Context;
import sofia.app.Screen;

/**
 * // -------------------------------------------------------------------------
/**
 *  This is the main screen for the app. It has all functionality to record
 *  exercises in a readable format. Keep in mid that for testing this project,
 *  some things need to be changed in the main code for testing to run smoothly.
 *  Instances of this include clearing the file on creation, using a specific
 *  testing file rather than the file which is used for the user's information,
 *  and finally not opening the welcome screen upon workout completion, which
 *  halts the tests.
 *
 *  @author austinc6
 *  @partner jordyna
 *  @partner morganm7
 *  @version 2015.04.09
 */
public class WorkoutScreen extends Screen {
    // Fields .................................................................
    private Button startWorkout;
    private Button endWorkout;
    private EditText editText;
    private RadioButton strength;
    private RadioButton cardio;
    private RadioButton weight;
    private Button up1;
    private Button up2;
    private Button up3;
    private TextView param1;
    private TextView param2;
    private TextView param3;
    private Button down1;
    private Button down2;
    private Button down3;
    private TextView param1Name;
    private TextView param2Name;
    private TextView param3Name;
    private Button submit;
    private TextView submission;

    private Saver saver;
    private boolean strengthMode;
    private boolean cardioMode;
    private boolean weightMode;
    private boolean started;

    //private String SAVER_FILE = "savertest.txt";
    private String PROGRESS_FILE = "progresstest.txt";
    //private String APP_FILE = "workoutStorage.txt";
    private String FILE = PROGRESS_FILE;

    // Methods ................................................................
    /**
     * This method functions as a constructor for the screen, and starts all
     * widgets, classes, and values
     */
    public void initialize() {
        //clearFile(FILE); //This call is only here when testing is
        //being performed. The inner argument is the desired file to test on.
        saver = new Saver();
        started = false;
        strengthMode = false;
        cardioMode = false;
        weightMode = false;
        setButtons();
        setRadioButtons();
        editText = (EditText) findViewById(R.id.editText);
        param1 = (TextView) findViewById(R.id.param1);
        param2 = (TextView) findViewById(R.id.param2);
        param3 = (TextView) findViewById(R.id.param3);
        param1Name = (TextView) findViewById(R.id.param1Name);
        param2Name = (TextView) findViewById(R.id.param2Name);
        param3Name = (TextView) findViewById(R.id.param3Name);
        clearTextViews();
    }

    /**
     * This is the method called when the startWorkout button is pressed
     */
    public void startWorkout() {
        started = true;
        saver.startWorkout();
        endWorkout.setEnabled(true);
        startWorkout.setEnabled(false);
    }

    /**
     * This is the method called when the finishWorkout button is pressed
     */
    public void endWorkout() {
        saver.endWorkout();
        endWorkout.setEnabled(false);
        startWorkout.setEnabled(true);
        this.finalSave();

        //While testing, this next block is a comment, so tests can run
        //correctly
        Intent intent = new Intent(this, WorkoutTracker.class);
        startActivity(intent);
    }

    /**
     * This is the method called by any of the up* buttons.
     *
     * @param choice    The button pressed
     */
    public void upParam(int choice) {
        switch (choice) {
            case 1:
                int current1 = Integer.parseInt(param1.getText().toString());
                if (strengthMode) {
                    param1.setText("" + (current1 + 1));
                }
                else if (cardioMode) {
                    param1.setText("" + (current1 + 5));
                }
                else if (weightMode) {
                    param1.setText("" + (current1 + 1));
                }
                break;
            case 2:
                int current2 = Integer.parseInt(param2.getText().toString());
                if (weightMode) {
                    param2.setText("" + (current2 + 5));
                }
                break;
            case 3:
                int current3 = Integer.parseInt(param3.getText().toString());
                if (strengthMode) {
                    param3.setText("" + (current3 + 1));
                }
                else if (cardioMode) {
                    param3.setText("" + (current3 + 1));
                }
                else if (weightMode) {
                    param3.setText("" + (current3 + 1));
                }
                break;
            default: //Do nothing
                break;
        }
    }

    /**
     * This is the method called by any of the down* buttons.
     *
     * @param choice    The button pressed
     */
    public void downParam(int choice) {
        switch (choice) {
            case 1:
                int current1 = Integer.parseInt(param1.getText().toString());
                if (current1 == 0) {
                    break;
                }
                else if (strengthMode) {
                    param1.setText("" + (current1 - 1));
                }
                else if (cardioMode) {
                    param1.setText("" + (current1 - 5));
                }
                else if (weightMode) {
                    param1.setText("" + (current1 - 1));
                }
                break;
            case 2:
                int current2 = Integer.parseInt(param2.getText().toString());
                if (current2 == 0) {
                    break;
                }
                else if (weightMode) {
                    param2.setText("" + (current2 - 5));
                }
                break;
            case 3:
                int current3 = Integer.parseInt(param3.getText().toString());
                if (current3 == 0) {
                    break;
                }
                else if (strengthMode) {
                    param3.setText("" + (current3 - 1));
                }
                else if (cardioMode) {
                    param3.setText("" + (current3 - 1));
                }
                else if (weightMode) {
                    param3.setText("" + (current3 - 1));
                }
                break;
            default: //Do nothing
                break;
        }
    }

    /**
     * This is the state set when the strength radio button is checked
     */
    public void strengthMode() {
        strength.setChecked(true);
        cardio.setChecked(false);
        weight.setChecked(false);
        strengthMode = true;
        cardioMode = false;
        weightMode = false;
        up1.setEnabled(true);
        up2.setEnabled(false);
        up3.setEnabled(true);
        down1.setEnabled(true);
        down2.setEnabled(false);
        down3.setEnabled(true);
        clearTextViews();
        param1Name.setText("Reps");
        param3Name.setText("Sets");
        submit.setEnabled(true);
    }

    /**
     * This is the state set when the cardio radio button is checked
     */
    public void cardioMode() {
        strength.setChecked(false);
        cardio.setChecked(true);
        weight.setChecked(false);
        strengthMode = false;
        cardioMode = true;
        weightMode = false;
        up1.setEnabled(true);
        up2.setEnabled(false);
        up3.setEnabled(true);
        down1.setEnabled(true);
        down2.setEnabled(false);
        down3.setEnabled(true);
        clearTextViews();
        param1Name.setText("Time");
        param3Name.setText("Distance");
        submit.setEnabled(true);
    }

    /**
     * This is the state set when the weight radio button is checked
     */
    public void weightMode() {
        strength.setChecked(false);
        cardio.setChecked(false);
        weight.setChecked(true);
        strengthMode = false;
        cardioMode = false;
        weightMode = true;
        up1.setEnabled(true);
        up2.setEnabled(true);
        up3.setEnabled(true);
        down1.setEnabled(true);
        down2.setEnabled(true);
        down3.setEnabled(true);
        clearTextViews();
        param1Name.setText("Reps");
        param2Name.setText("Weight");
        param3Name.setText("Sets");
        submit.setEnabled(true);
    }

    /**
     * This method is called by pressing the submit button. It sends an exercise
     * to the text file
     */
    public void submit() {
        submission = (TextView) findViewById(R.id.submission);
        if (!started) {
            submission.setText("Please click Start Workout first!");
            return;
        }
        String name = editText.getText().toString();
        int parameter1 = Integer.parseInt(param1.getText().toString());
        int parameter3 = Integer.parseInt(param3.getText().toString());
        Exercise toAdd;
        if (strengthMode) {
            int reps = parameter1;
            int sets = parameter3;
            toAdd = new StrengthExercise(name, reps, sets);
        }
        else if (cardioMode) {
            int time = parameter1;
            int distance = parameter3;
            toAdd = new CardioExercise(name, time, distance);
        }
        else if (weightMode) {
            int weightParam = Integer.parseInt(param2.getText().toString());
            int reps = parameter1;
            int sets = parameter3;
            toAdd = new WeightExercise(name, weightParam, reps, sets);
        }
        else {
            toAdd = new Exercise();
        }
        saver.addExercise(toAdd);
        submission.setText(name + " submitted!");
    }

    /**
     * This saves the information that the Saver instance holds. This method is
     * the one used directly, and will be left private in the final product.
     *
     * @param fileName  This is the file that will be saved to
     */
    public void finalSave(String fileName) {
        String string = saver.getWorkoutString();
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(fileName, Context.MODE_APPEND);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This saves the information using the previous method, but only to the
     * file which is intended to be used for saving.
     */
    public void finalSave() {
        //For testing, the name of this file has been savertest.txt.
        //For general usage, the name of this file will be workoutStorage.txt
        finalSave(FILE);
    }

    /**
     * This clears the file which is sent to it, used for testing
     *
     * @param fileName  The file to be cleared
     */
    public void clearFile(String fileName) {
        String string = "";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method initializes the buttons of this screen. Called from the
     * initialize method
     */
    public void setButtons() {
        startWorkout = (Button) findViewById(R.id.startWorkout);
        startWorkout.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startWorkout();
            }
        });
        endWorkout = (Button) findViewById(R.id.endWorkout);
        endWorkout.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                endWorkout();
            }
        });
        up1 = (Button) findViewById(R.id.up1);
        up1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                upParam(1);
            }
        });
        up2 = (Button) findViewById(R.id.up2);
        up2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                upParam(2);
            }
        });
        up3 = (Button) findViewById(R.id.up3);
        up3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                upParam(3);
            }
        });
        down1 = (Button) findViewById(R.id.down1);
        down1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                downParam(1);
            }
        });
        down2 = (Button) findViewById(R.id.down2);
        down2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                downParam(2);
            }
        });
        down3 = (Button) findViewById(R.id.down3);
        down3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                downParam(3);
            }
        });
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                submit();
            }
        });
        endWorkout.setEnabled(false);
        up1.setEnabled(false);
        up2.setEnabled(false);
        up3.setEnabled(false);
        down1.setEnabled(false);
        down2.setEnabled(false);
        down3.setEnabled(false);
        submit.setEnabled(false);
    }

    /**
     * This method initializes the RadioButtons of the screen
     */
    public void setRadioButtons() {
        strength = (RadioButton) findViewById(R.id.strength);
        strength.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                strengthMode();
            }
        });
        cardio = (RadioButton) findViewById(R.id.cardio);
        cardio.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                cardioMode();
            }
        });
        weight = (RadioButton) findViewById(R.id.weight);
        weight.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                weightMode();
            }
        });
    }

    /**
     * This method empties the TextViews to make the app look cleaner. It sets
     * some TextViews to show 0, rather than simply making them empty.
     */
    public void clearTextViews() {
        param1.setText("0");
        param2.setText("0");
        param3.setText("0");
        param1Name.setText("");
        param2Name.setText("");
        param3Name.setText("");
    }
}
