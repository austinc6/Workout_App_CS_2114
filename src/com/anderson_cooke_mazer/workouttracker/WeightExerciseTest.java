package com.anderson_cooke_mazer.workouttracker;

import student.TestCase;
/**
 * // -------------------------------------------------------------------------
/**
 *  This tests all aspects and methods of the WeightExercise class
 *
 *  @author austinc6
 *  @partner jordyna
 *  @partner morganm7
 *  @version 2015.04.21
 */
public class WeightExerciseTest extends TestCase {
    // Fields .................................................................
    private WeightExercise exercise1;
    private WeightExercise exercise2;

    private String EXERCISE = "Bench Press";
    private int WT = 10;
    private int REPS = 10;
    private int SETS = 10;

    // Constructors ...........................................................
    /**
     * This is the constructor, it requires no behavior
     */
    public WeightExerciseTest() {
        // Do nothing
    }

    // Methods ................................................................
    /**
     * This method runs before every test, ensuring they have the same starting
     * conditions. It also calls both constructors independently.
     */
    public void setUp() {
        exercise1 = new WeightExercise();
        exercise2 = new WeightExercise(EXERCISE, WT, REPS, SETS);
    }

    /**
     * This tests the equals method when the two exercises are not the same
     */
    public void testEqualsA() {
        assertFalse(exercise1.equals(exercise2));
    }

    /**
     * This tests the equals method when the two objects have the same name and
     * attributes
     */
    public void testEqualsB() {
        exercise1.setName(EXERCISE);
        exercise1.setWeight(WT);
        exercise1.setReps(REPS);
        exercise1.setSets(SETS);
        assertTrue(exercise1.equals(exercise2));
    }

    /**
     * This tests the equals method when the two objects have the same name but
     * different attributes
     */
    public void testEqualsC() {
        exercise1.setName(EXERCISE);
        assertTrue(exercise1.equals(exercise2));
    }

    /**
     * This method tests all behavior related to the weight attribute
     */
    public void testWeight() {
        assertEquals(0, exercise1.weight());
        exercise1.setWeight(WT);
        assertEquals(WT, exercise1.weight());
        exercise1.weightUp();
        assertEquals(WT + 5, exercise1.weight());
        exercise1.weightDown();
        assertEquals(WT, exercise1.weight());
    }
}
