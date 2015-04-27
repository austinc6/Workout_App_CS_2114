package com.anderson_cooke_mazer.workouttracker;

import student.TestCase;
/**
 * // -------------------------------------------------------------------------
/**
 *  This tests all methods and aspects of the CardioExercise class
 *
 *  @author austinc6
 *  @partner jordyna
 *  @partner moranm7
 *  @version 2015.04.21
 */
public class CardioExerciseTest extends TestCase {
    // Fields .................................................................
    private CardioExercise exercise1;
    private CardioExercise exercise2;

    private String EXERCISE = "Running";
    private int TIME = 10;
    private int DIST = 10;

    // Constructors ...........................................................
    /**
     * This is the constructor, it requires no behavior
     */
    public CardioExerciseTest() {
        // Do nothing
    }

    // Methods ................................................................
    /**
     * This method runs before every test, ensuring they have the same starting
     * conditions. It also calls both constructors independently.
     */
    public void setUp() {
        exercise1 = new CardioExercise();
        exercise2 = new CardioExercise(EXERCISE, TIME, DIST);
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
        exercise1.setTime(TIME);
        exercise1.setDistance(DIST);
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
     * This method tests all behavior related to the reps attribute
     */
    public void testTime() {
        assertEquals(0, exercise1.time());
        exercise1.setTime(TIME);
        assertEquals(TIME, exercise1.time());
        exercise1.timeUp();
        assertEquals(TIME + 5, exercise1.time());
        exercise1.timeDown();
        assertEquals(TIME, exercise1.time());
    }

    /**
     * This method tests all behavior related to the sets attribute
     */
    public void testDistance() {
        assertEquals(0, exercise1.distance());
        exercise1.setDistance(DIST);
        assertEquals(DIST, exercise1.distance());
        exercise1.distanceUp();
        assertEquals(DIST + 1, exercise1.distance());
        exercise1.distanceDown();
        assertEquals(DIST, exercise1.distance());
    }
}
