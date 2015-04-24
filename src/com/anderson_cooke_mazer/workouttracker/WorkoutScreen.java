package com.anderson_cooke_mazer.workouttracker;

import java.io.FileOutputStream;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Context;
import sofia.app.Screen;

/**
 * // -------------------------------------------------------------------------
/**
 *  This is the main screen for the app
 *
 *  @author austinc6
 *  @partner jordyna
 *  @partner morganm7
 *  @version 2015.04.09
 */
public class WorkoutScreen extends Screen {
    // Fields .................................................................
    private Saver saver;
    private Button startWorkout;
    private Button endWorkout;

    // Methods ................................................................
    /**
     * This method functions as a constructor for the screen, and starts all
     * widgets, classes, and values
     */
    public void initialize() {
        clearFile("savertest.txt"); //TODO remove me!
        saver = new Saver();
        setWidgets();

        endWorkout.setEnabled(false);
    }

    /**
     * This is the method called when the startWorkout button is pressed
     */
    public void startWorkout() {
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

        //TODO go back to entrance screen
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
        finalSave("savertest.txt");
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
     * This method initializes the widgets of this screen. Called from the
     * initialize method
     */
    public void setWidgets() {
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
    }
}
