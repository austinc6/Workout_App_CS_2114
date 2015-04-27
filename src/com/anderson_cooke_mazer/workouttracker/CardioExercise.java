package com.anderson_cooke_mazer.workouttracker;
/**
 * // -------------------------------------------------------------------------
/**
 *  This class is the cardio exercise version of the class Exercise
 *
 *  @author austinc6
 *  @partner jordyna
 *  @partner morganm7
 *  @version 2015.04.21
 */
public class CardioExercise extends Exercise {
    // Fields .................................................................
    private int time;
    private int distance;

    private int TIMECHANGE = 5;
    private int DISTCHANGE = 1;

    // Constructors ...........................................................
    /**
     * This is the basic constructor which can be used to make
     * CardioExercise objects
     *
     * @param name  The name of the exercise
     * @param time  The amount of time elapsed during the exercise
     * @param distance  The amount of distance covered in the exercise
     */
    public CardioExercise(String name, int time, int distance) {
        super(name);
        this.time = time;
        this.distance = distance;
    }

    /**
     * This can be used to make empty CardioExercise objects
     */
    public CardioExercise() {
        this("", 0, 0);
    }

    // Methods ................................................................
    /**
     * Returns the amount of time elapsed
     *
     * @return variable time
     */
    public int time() {
        return time;
    }

    /**
     * Returns the distance covered
     *
     * @return variable distance
     */
    public int distance() {
        return distance;
    }

    /**
     * This sets the amount of time elapsed
     *
     * @param newTime   The value time will be set to
     */
    public void setTime(int newTime) {
        time = newTime;
    }

    /**
     * Increases the time by five, to make the UI of the app simple
     */
    public void timeUp() {
        setTime(time + TIMECHANGE);
    }

    /**
     * Decreases the time by five, to make the UI of the app simple
     */
    public void timeDown() {
        setTime(time - TIMECHANGE);
    }

    /**
     * This sets the distance covered
     *
     * @param newDistance   The value distance will be set to
     */
    public void setDistance(int newDistance) {
        distance = newDistance;
    }

    /**
     * Increases the distance by 1, to make the UI of the app simple
     */
    public void distanceUp() {
        setDistance(distance + DISTCHANGE);
    }

    /**
     * Decreases the distance by 1, to make the UI of the app simple
     */
    public void distanceDown() {
        setDistance(distance - DISTCHANGE);
    }
}
