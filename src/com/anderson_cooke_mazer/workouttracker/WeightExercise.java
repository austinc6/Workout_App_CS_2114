package com.anderson_cooke_mazer.workouttracker;
/**
 * // -------------------------------------------------------------------------
/**
 *  This is the weight version of the generic Exercise class
 *
 *  @author austinc6
 *  @partner jordyna
 *  @partner morganm7
 *  @version 2015.04.21
 */
public class WeightExercise extends StrengthExercise {
    // Fields .................................................................
    private int weight;

    private int WTCHANGE = 5;

    // Constructors ...........................................................
    /**
     * This is the main constructor for the class, which can be used to make
     * basic WeightExercise objects
     *
     * @param name  The name of the exercise
     * @param weight    The weight lifted
     * @param reps  The number of reps performed
     * @param sets  The number of sets performed
     */
    public WeightExercise(String name, int weight, int reps, int sets) {
        super(name, reps, sets);
        this.weight = weight;
    }

    /**
     * This constructor can be used to create an empty WeightExercise
     */
    public WeightExercise() {
        this("", 0, 0, 0);
    }

    // Methods ................................................................
    /**
     * Returns the weight lifted in the exercise
     *
     * @return weight
     */
    public int weight() {
        return weight;
    }

    /**
     * Sets the weight of this exercise to a new value
     *
     * @param newWeight The weight lifted
     */
    public void setWeight(int newWeight) {
        weight = newWeight;
    }

    /**
     * Increases the weight up by five, to make the UI of the app simple
     */
    public void weightUp() {
        setWeight(weight + WTCHANGE);
    }

    /**
     * Decreases the weight by five, to make the UI of the app simple
     */
    public void weightDown() {
        setWeight(weight - WTCHANGE);
    }
}
