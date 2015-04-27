package com.anderson_cooke_mazer.workouttracker;
/**
 * // -------------------------------------------------------------------------
/**
 *  This is the Strength version of the generic Exercise class
 *
 *  @author austinc6
 *  @partner jordyna
 *  @partner morganm7
 *  @version 2015.04.21
 */
public class StrengthExercise extends Exercise {
    // Fields .................................................................
    private int reps;
    private int sets;

    private int REPCHANGE = 1;
    private int SETCHANGE = 1;

    // Methods ................................................................
    /**
     *The main constructor, which can be used to make any basic StrengthExercise
     *
     *@param name   The name of the exercise
     *@param reps   The number of reps performed
     *@param sets   The number of sets performed
     */
    public StrengthExercise(String name, int reps, int sets) {
        super(name);
        this.reps = reps;
        this.sets = sets;
    }

    /**
     * This constructor can be used to create an empty StrengthExercise
     */
    public StrengthExercise() {
        this("", 0, 0);
    }

    // Methods ................................................................
    /**
     * Returns the number of reps performed in the exercise
     *
     * @return reps
     */
    public int reps() {
        return reps;
    }

    /**
     * Returns the number of sets performed in the exercise
     *
     * @return sets
     */
    public int sets() {
        return sets;
    }

    /**
     * Sets the reps of this exercise to a new value
     *
     * @param newReps   The number of reps
     */
    public void setReps(int newReps) {
        reps = newReps;
    }

    /**
     * Increases the reps up by one, to make the UI of the app simple
     */
    public void repsUp() {
        setReps(reps + REPCHANGE);
    }

    /**
     * Decreases the reps by one, to make the UI of the app simple
     */
    public void repsDown() {
        setReps(reps - REPCHANGE);
    }

    /**
     * Sets the sets of this exercise to a new value
     *
     * @param newSets   The number of sets
     */
    public void setSets(int newSets) {
        sets = newSets;
    }

    /**
     * Increases the sets up by one, to make the UI of the app simple
     */
    public void setsUp() {
        setSets(sets + SETCHANGE);
    }

    /**
     * Decreases the sets by one, to make the UI of the app simple
     */
    public void setsDown() {
        setSets(sets - SETCHANGE);
    }
}
