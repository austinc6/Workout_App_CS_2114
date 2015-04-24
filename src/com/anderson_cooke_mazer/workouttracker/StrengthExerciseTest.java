package com.anderson_cooke_mazer.workouttracker;

import student.TestCase;
/**
 * // -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Austinc6
 *  @version Apr 21, 2015
 */
public class StrengthExerciseTest extends TestCase {
    // Fields .................................................................
    private StrengthExercise exercise1;
    private StrengthExercise exercise2;

    private String EXERCISE = "Push-ups";
    private int REPS = 10;
    private int SETS = 10;

    // Constructors ...........................................................
    /**
     * This is the constructor, it requires no behavior
     */
    public StrengthExerciseTest() {
        // Do nothing
    }

    // Methods ................................................................
    /**
     * This method runs before every test, ensuring they have the same starting
     * conditions. It also calls both constructors independently.
     */
    public void setUp() {
        exercise1 = new StrengthExercise();
        exercise2 = new StrengthExercise(EXERCISE, REPS, SETS);
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
        exercise1.setReps(REPS);
        exercise1.setSets(10);
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
    public void testReps() {
        assertEquals(0, exercise1.reps());
        exercise1.setReps(REPS);
        assertEquals(REPS, exercise1.reps());
        exercise1.repsUp();
        assertEquals(REPS + 1, exercise1.reps());
        exercise1.repsDown();
        assertEquals(REPS, exercise1.reps());
    }

    /**
     * This method tests all behavior related to the sets attribute
     */
    public void testSets() {
        assertEquals(0, exercise1.sets());
        exercise1.setSets(SETS);
        assertEquals(SETS, exercise1.sets());
        exercise1.setsUp();
        assertEquals(SETS + 1, exercise1.sets());
        exercise1.setsDown();
        assertEquals(SETS, exercise1.sets());
    }
}
