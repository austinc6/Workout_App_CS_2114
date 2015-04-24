package com.anderson_cooke_mazer.workouttracker;

import android.annotation.SuppressLint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import student.TestCase;
/**
 * // -------------------------------------------------------------------------
/**
 *  This tests all the methods of the Saver class
 *
 *  @author austinc6
 *  @partner jordyna
 *  @partner morganm7
 *  @version 2015.04.10
 */
@SuppressLint("SimpleDateFormat")
public class SaverTest extends TestCase {
    // Fields .................................................................
    private Saver saver;
    private CardioExercise running;
    private StrengthExercise pushUps;
    private WeightExercise benchPress;
    private Exercise general;

    // Constructors ...........................................................
    /**
     * This constructor has no behavior
     */
    public SaverTest() {
        //Do nothing
    }

    // Methods ................................................................
    /**
     * This method sets all behavior for the test methods, ensuring that the
     * scanner and writer work correctly, etc.
     */
    public void setUp() {
        saver = new Saver();
        running = new CardioExercise("Running", 10, 10.0f);
        pushUps = new StrengthExercise("Push-ups", 10, 10);
        benchPress = new WeightExercise("Bench Press", 10, 10,
            10);
        general = new Exercise("General");
    }

    /**
     * This tests the startWorkout method
     */
    public void testStartWorkout() {
        saver.startWorkout();
        String saverString = "Workout Start\n";
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        saverString += dateFormat.format(date) + "\n\n";

        assertEquals(saverString, saver.getWorkoutString());
    }

    /**
     * This tests the endWorkout method
     */
    public void testEndWorkout() {
        saver.endWorkout();
        String saverString = "Workout End\n";
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        saverString += dateFormat.format(date) + "\n\n";

        assertEquals(saverString, saver.getWorkoutString());
    }

    /**
     * This tests the three add exercise methods independently
     */
    public void testAddExerciseA() {
        saver.addCardioExercise("Running", 10, 10.0f);
        saver.addStrengthExercise("Push-ups", 10, 10);
        saver.addWeightExercise("Bench Press", 10, 10, 10);
        String saverString = "Running T: 10 D: 10.0\n";
        saverString += "Push-ups R: 10 S: 10\n";
        saverString += "Bench Press W: 10 R: 10 S: 10\n";

        assertEquals(saverString, saver.getWorkoutString());
    }

    /**
     * This tests the addExercise method with the main method, which should
     * streamline the process
     */
    public void testAddExerciseB() {
        saver.addExercise(running);
        saver.addExercise(pushUps);
        saver.addExercise(benchPress);
        saver.addExercise(general);
        String saverString = "Running T: 10 D: 10.0\n";
        saverString += "Push-ups R: 10 S: 10\n";
        saverString += "Bench Press W: 10 R: 10 S: 10\n";
        saverString += "General\n";

        assertEquals(saverString, saver.getWorkoutString());
    }
}
