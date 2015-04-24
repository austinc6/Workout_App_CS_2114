package com.anderson_cooke_mazer.workouttracker;

import java.io.File;
import java.util.Scanner;
import android.widget.Button;
/**
 * // -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
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
}
