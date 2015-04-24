package com.anderson_cooke_mazer.workouttracker;

import student.TestCase;
/**
 * // -------------------------------------------------------------------------
/**
 *  This is the test for the Exercise object
 *
 *  @author austinc6
 *  @partner jordyna
 *  @partner morganm7
 *  @version 2015.04.09
 */
public class ExerciseTest extends TestCase {
    // Fields .................................................................
    private Exercise exercise1;
    private Exercise exercise2;

    private String EXERCISE = "exercise";

    // Constructors ...........................................................
    /**
     * This is the constructor, it requires no behavior
     */
    public ExerciseTest() {
        // Do nothing
    }

    // Methods ................................................................
    /**
     * This method runs before every test, ensuring they have the same starting
     * conditions. It also calls both constructors independently.
     */
    public void setUp() {
        exercise1 = new Exercise();
        exercise2 = new Exercise(EXERCISE);
    }

    /**
     * This tests the equals method with an object which is not an exercise
     */
    public void testEqualsA() {
        assertFalse(exercise1.equals(new Object()));
    }

    /**
     * This tests the equals method when the two exercises are not the same
     */
    public void testEqualsB() {
        assertFalse(exercise1.equals(exercise2));
    }

    /**
     * This tests the equals method when the two objects have the same name
     */
    public void testEqualsC() {
        exercise1.setName(EXERCISE);
        assertTrue(exercise1.equals(exercise2));
    }

    /**
     * This method tests all behavior related to the name attribute
     */
    public void testName() {
        assertEquals("", exercise1.name());
        exercise1.setName("pushups");
        assertEquals("pushups", exercise1.name());
    }
}
