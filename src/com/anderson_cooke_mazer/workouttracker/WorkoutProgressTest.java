package com.anderson_cooke_mazer.workouttracker;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
/**
 * // -------------------------------------------------------------------------
/**
 *  This class tests the WorkoutProgress screen. In order to do this, the screen
 *  uses a file called progresstest.txt. This file must be written using
 *  WorkoutScreen prior to using it, and the text of the actual file is kept in
 *  a duplicate file in this file system under the same name, so it can be
 *  viewed.
 *
 *  @author austinc6
 *  @partner jordyna
 *  @partner morganm7
 *  @version 2015.04.27
 */
public class WorkoutProgressTest extends
    student.AndroidTestCase<WorkoutProgress> {
    // Fields .................................................................
    private EditText editText1;
    private RadioButton strengthProg;
    private RadioButton cardioProg;
    private RadioButton weightProg;
    private Button search;
    private TextView firstPrm1Name;
    private TextView recentPrm1Name;
    private TextView avgPrm1Name;
    private TextView firstPrm2Name;
    private TextView recentPrm2Name;
    private TextView avgPrm2Name;
    private TextView firstPrm3Name;
    private TextView recentPrm3Name;
    private TextView avgPrm3Name;
    private TextView exerciseName;
    private TextView firstParam1;
    private TextView recParam1;
    private TextView avgParam1;
    private TextView firstParam2;
    private TextView recParam2;
    private TextView avgParam2;
    private TextView firstParam3;
    private TextView recParam3;
    private TextView avgParam3;
    private TextView performed;

    // Constructors ...........................................................
    /**
     * This is the constructor which puts the test in a state of running the
     * screen
     */
    public WorkoutProgressTest() {
        super(WorkoutProgress.class);
    }

    // Methods ................................................................
    /**
     * This is the setUp() method that runs before every test. It is left empty,
     * all work is done by the constructor
     */
    public void setUp() {
        //Do nothing
    }

    /**
     * This tests a standard entry in the file, an exercise titled standardTest,
     * of strength type with 1 rep and 1 set
     */
    public void testStandard() {
        String exName = "standardTest";
        enterText(editText1, exName);
        click(strengthProg);
        click(search);
        assertEquals(exerciseName.getText(), exName);
        assertEquals(firstPrm1Name.getText(), "First Reps:");
        assertEquals(recentPrm1Name.getText(), "Recent Reps:");
        assertEquals(avgPrm1Name.getText(), "Average Reps:");
        assertEquals(firstPrm2Name.getText(), "First Sets:");
        assertEquals(recentPrm2Name.getText(), "Recent Sets:");
        assertEquals(avgPrm2Name.getText(), "Average Sets:");
        assertEquals(firstPrm3Name.getText(), "");
        assertEquals(recentPrm3Name.getText(), "");
        assertEquals(avgPrm3Name.getText(), "");

        assertEquals(firstParam1.getText(), "1");
        assertEquals(recParam1.getText(), "1");
        assertEquals(avgParam1.getText(), "1");
        assertEquals(firstParam2.getText(), "1");
        assertEquals(recParam2.getText(), "1");
        assertEquals(avgParam2.getText(), "1");
        assertEquals(firstParam3.getText(), "");
        assertEquals(recParam3.getText(), "");
        assertEquals(avgParam3.getText(), "");
        assertEquals(performed.getText(), "1");
    }

    /**
     * This tests an entry in the file in which entries need to be averaged. The
     * exercise is of weight type, and is titled "averageTest"
     */
    public void testAverage() {
        String exName = "averageTest";
        enterText(editText1, exName);
        click(weightProg);
        click(search);
        assertEquals(exerciseName.getText(), exName);
        assertEquals(firstPrm1Name.getText(), "First Weight:");
        assertEquals(recentPrm1Name.getText(), "Recent Weight:");
        assertEquals(avgPrm1Name.getText(), "Average Weight:");
        assertEquals(firstPrm2Name.getText(), "First Reps:");
        assertEquals(recentPrm2Name.getText(), "Recent Reps:");
        assertEquals(avgPrm2Name.getText(), "Average Reps:");
        assertEquals(firstPrm3Name.getText(), "First Sets:");
        assertEquals(recentPrm3Name.getText(), "Recent Sets:");
        assertEquals(avgPrm3Name.getText(), "Average Sets:");

        assertEquals(firstParam1.getText(), "5");
        assertEquals(recParam1.getText(), "10");
        assertEquals(avgParam1.getText(), "7");
        assertEquals(firstParam2.getText(), "1");
        assertEquals(recParam2.getText(), "3");
        assertEquals(avgParam2.getText(), "2");
        assertEquals(firstParam3.getText(), "1");
        assertEquals(recParam3.getText(), "4");
        assertEquals(avgParam3.getText(), "2");
        assertEquals(performed.getText(), "2");
    }

    /**
     * This tests an entry in the file in which the values are zero. The
     * exercise is of cardio type, and is titled "zeroTest"
     */
    public void testZero() {
        String exName = "zeroTest";
        enterText(editText1, exName);
        click(cardioProg);
        click(search);
        assertEquals(exerciseName.getText(), exName);
        assertEquals(firstPrm1Name.getText(), "First Time:");
        assertEquals(recentPrm1Name.getText(), "Recent Time:");
        assertEquals(avgPrm1Name.getText(), "Average Time:");
        assertEquals(firstPrm2Name.getText(), "First Distance:");
        assertEquals(recentPrm2Name.getText(), "Recent Distance:");
        assertEquals(avgPrm2Name.getText(), "Average Distance:");
        assertEquals(firstPrm3Name.getText(), "");
        assertEquals(recentPrm3Name.getText(), "");
        assertEquals(avgPrm3Name.getText(), "");

        assertEquals(firstParam1.getText(), "0");
        assertEquals(recParam1.getText(), "0");
        assertEquals(avgParam1.getText(), "0");
        assertEquals(firstParam2.getText(), "0");
        assertEquals(recParam2.getText(), "0");
        assertEquals(avgParam2.getText(), "0");
        assertEquals(firstParam3.getText(), "");
        assertEquals(recParam3.getText(), "");
        assertEquals(avgParam3.getText(), "");
        assertEquals(performed.getText(), "1");
    }

    /**
     * This tests an entry in the file which has no results. It tests that the
     * name is always listed as no results, and also tests to make sure the name
     * variables are correct
     */
    public void testNoResults() {
        enterText(editText1, "noResultsTest");
        click(strengthProg);
        click(search);
        assertEquals(exerciseName.getText(), "No results");
        click(weightProg);
        click(search);
        assertEquals(exerciseName.getText(), "No results");
        click(cardioProg);
        click(search);
        assertEquals(exerciseName.getText(), "No results");
        assertEquals(firstPrm1Name.getText(), "First Time:");
        assertEquals(recentPrm1Name.getText(), "Recent Time:");
        assertEquals(avgPrm1Name.getText(), "Average Time:");
        assertEquals(firstPrm2Name.getText(), "First Distance:");
        assertEquals(recentPrm2Name.getText(), "Recent Distance:");
        assertEquals(avgPrm2Name.getText(), "Average Distance:");
        assertEquals(firstPrm3Name.getText(), "");
        assertEquals(recentPrm3Name.getText(), "");
        assertEquals(avgPrm3Name.getText(), "");
    }

    /**
     * This tests multiple exercises with the exact same parameters. They are of
     * weight type with name "sameTest"
     */
    public void testSame() {
        enterText(editText1, "sameTest");
        click(weightProg);
        click(search);

        assertEquals(firstParam1.getText(), "5");
        assertEquals(recParam1.getText(), "5");
        assertEquals(avgParam1.getText(), "5");
        assertEquals(firstParam2.getText(), "1");
        assertEquals(recParam2.getText(), "1");
        assertEquals(avgParam2.getText(), "1");
        assertEquals(firstParam3.getText(), "1");
        assertEquals(recParam3.getText(), "1");
        assertEquals(avgParam3.getText(), "1");
        assertEquals(performed.getText(), "2");
    }

    /**
     * This tests multiple exercises with the same name, but of different type
     * and values. They are named "differentTest" and are of Strength and Cardio
     * type
     */
    public void testDifferent() {
        enterText(editText1, "differentTest");
        click(strengthProg);
        click(search);
        assertEquals(firstParam1.getText(), "2");
        assertEquals(recParam1.getText(), "2");
        assertEquals(avgParam1.getText(), "2");
        assertEquals(firstParam2.getText(), "2");
        assertEquals(recParam2.getText(), "2");
        assertEquals(avgParam2.getText(), "2");
        assertEquals(firstParam3.getText(), "");
        assertEquals(recParam3.getText(), "");
        assertEquals(avgParam3.getText(), "");
        assertEquals(performed.getText(), "1");
        click(cardioProg);
        click(search);
        assertEquals(firstParam1.getText(), "5");
        assertEquals(recParam1.getText(), "5");
        assertEquals(avgParam1.getText(), "5");
        assertEquals(firstParam2.getText(), "1");
        assertEquals(recParam2.getText(), "1");
        assertEquals(avgParam2.getText(), "1");
        assertEquals(firstParam3.getText(), "");
        assertEquals(recParam3.getText(), "");
        assertEquals(avgParam3.getText(), "");
        assertEquals(performed.getText(), "1");
    }

    /**
     * This tests multiple exercises across multiple times (aka of separate
     * workouts). They are all named "timeTest", and consist of all three types
     */
    public void testTime() {
        enterText(editText1, "timeTest");
        click(strengthProg);
        click(search);
        assertEquals(firstParam1.getText(), "1");
        assertEquals(recParam1.getText(), "1");
        assertEquals(avgParam1.getText(), "1");
        assertEquals(firstParam2.getText(), "2");
        assertEquals(recParam2.getText(), "2");
        assertEquals(avgParam2.getText(), "2");
        assertEquals(firstParam3.getText(), "");
        assertEquals(recParam3.getText(), "");
        assertEquals(avgParam3.getText(), "");
        assertEquals(performed.getText(), "2");
        click(cardioProg);
        click(search);
        assertEquals(firstParam1.getText(), "5");
        assertEquals(recParam1.getText(), "10");
        assertEquals(avgParam1.getText(), "7");
        assertEquals(firstParam2.getText(), "1");
        assertEquals(recParam2.getText(), "2");
        assertEquals(avgParam2.getText(), "1");
        assertEquals(firstParam3.getText(), "");
        assertEquals(recParam3.getText(), "");
        assertEquals(avgParam3.getText(), "");
        assertEquals(performed.getText(), "2");
        click(weightProg);
        click(search);
        assertEquals(firstParam1.getText(), "0");
        assertEquals(recParam1.getText(), "0");
        assertEquals(avgParam1.getText(), "0");
        assertEquals(firstParam2.getText(), "0");
        assertEquals(recParam2.getText(), "0");
        assertEquals(avgParam2.getText(), "0");
        assertEquals(firstParam3.getText(), "0");
        assertEquals(recParam3.getText(), "0");
        assertEquals(avgParam3.getText(), "0");
        assertEquals(performed.getText(), "2");
    }
}
