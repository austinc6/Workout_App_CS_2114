package com.anderson_cooke_mazer.workouttracker;

import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.EditText;
import java.io.File;
import java.util.Scanner;
import android.widget.Button;
/**
 * // -------------------------------------------------------------------------
/**
 *  This tests all the aspects of the WorkoutScreen class, checking for
 *  irregular user input as well. Keep in mind that whilst running these tests,
 *  some lines in WorkoutScreen will need to be changed, read its opening
 *  comment for clarification.
 *
 *  @author austinc6
 *  @partner jordyna
 *  @partner morganm7
 *  @version 2015.04.24
 */
public class WorkoutScreenTest extends student.AndroidTestCase<WorkoutScreen> {
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

    // Constructors ...........................................................
    /**
     * Test cases that extend AndroidTestCase must have a parameterless
     * constructor that calls super() and passes it the screen/activity class
     * being tested.
     */
    public WorkoutScreenTest() {
        super(WorkoutScreen.class);
    }

    // Methods ................................................................
    /**
     * This method sets up all the fixtures for each class, and then runs each
     * one individually
     */
    public void setUp() {
        //Do something
    }

    /**
     * This method tests the startWorkout and endWorkout buttons. They need to
     * be tested at the same time, because endWorkout does the writing to the
     * file.
     */
    public void testStartAndEndWorkout() {
        click(startWorkout);
        click(endWorkout);
        Scanner sc;
        try {
            sc = new Scanner(new File("savertest.txt"));
            String toCheck = "";
            if (sc.hasNext()) {
                toCheck = sc.next();
            }
            assertEquals("Workout Start\n", toCheck);
            if (sc.hasNext()) {
                sc.next();
                toCheck = sc.next();
            }
            assertEquals("Workout End\n", toCheck);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This tests all the work that should be done when the workout buttons are
     * used in the manner they should be
     */
    public void testWorkout() {
        click(startWorkout);
        enterText(editText, "Pushups");
        click(strength);
        assertEquals(param1Name.getText(), "Reps");
        assertEquals(param3Name.getText(), "Sets");
        click(up1);
        assertEquals(param1.getText(), "1");
        click(up3);
        assertEquals(param3.getText(), "1");
        click(submit);
        assertEquals(submission.getText(), "Pushups submitted!");
        click(down1);
        assertEquals(param1.getText(), "0");
        click(down3);
        assertEquals(param3.getText(), "0");
        enterText(editText, "");
        enterText(editText, "Jogging");
        click(cardio);
        assertEquals(param1Name.getText(), "Time");
        assertEquals(param3Name.getText(), "Distance");
        click(up1);
        assertEquals(param1.getText(), "5");
        click(up3);
        click(submit);
        assertEquals(submission.getText(), "Jogging submitted!");
        click(down1);
        assertEquals(param1.getText(), "0");
        click(down3);
        enterText(editText, "");
        enterText(editText, "Bench Press");
        click(weight);
        assertEquals(param1Name.getText(), "Reps");
        assertEquals(param2Name.getText(), "Weight");
        assertEquals(param3Name.getText(), "Sets");
        click(up1);
        click(up2);
        assertEquals(param2.getText(), "5");
        click(up3);
        click(submit);
        assertEquals(submission.getText(), "Bench Press submitted!");
        click(down1);
        click(down2);
        assertEquals(param2.getText(), "0");
        click(down3);
    }

    /**
     * This scans the savertest.txt file to see if the outputs have been sent
     * to the file. It runs the previous method to get test fixture data
     */
    public void testSaverTest() {
        testWorkout();
        Scanner sc;
        try {
            sc = new Scanner(new File("savertest.txt"));
            assertEquals("Workout Start\n", sc.next());
            sc.next();
            assertEquals("Pushups R: 1 S: 1\n", sc.next());
            assertEquals("Jogging T: 5 D: 1\n", sc.next());
            assertEquals("Bench Press W: 5 R: 1 S: 1", sc.next());
            assertEquals("Workout End\n", sc.next());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This runs any activity that the user may attempt which is against the
     * direction of the screen. For example, attempting to submit an exercise
     * before the user starts the workout.
     */
    public void testAgainstUser() {
        click(strength);
        click(up1);
        click(up3);
        click(submit);
        assertEquals("Please click Start Workout first!", submission.getText());
    }
}
