package com.anderson_cooke_mazer.workouttracker;

/**
 * // -------------------------------------------------------------------------
/**
 *  This is the basic class that all exercises will be based off of. It is
 *  simply a data structure which describes an exercise
 *
 *  @author austinc6
 *  @partner jordyna
 *  @partner morganm7
 *  @version 2015.04.10
 */
public class Exercise {
    // Fields .................................................................
    private String name;

    // Constructors ...........................................................
    /**
     * The main constructor for the class, which can be used to create simple
     * Exercise objects to a specification
     *
     * @param name  The name of the exercise
     */
    public Exercise(String name) {
        this.name = name;
    }

    /**
     * A general constructor, which can be used to make a blank exercise object
     */
    public Exercise() {
        this("");
    }

    // Methods ................................................................
    /**
     * This equals method only checks for the name of the Exercise, as this is
     * all that is necessary for Loader ot perform properly
     *
     * @param toCheck   The object to check about equality
     *
     * @return  Whether or not the parameter equals this object
     */
    public boolean equals(Object toCheck) {
        if (!(toCheck instanceof Exercise)) {
            return false;
        }
        Exercise otherExercise = (Exercise) toCheck;
        return this.name().equals(otherExercise.name());
    }

    /**
     * Returns the name of the exercise
     *
     * @return name
     */
    public String name() {
        return name;
    }

    /**
     * Sets the name of this exercise to a new value
     *
     * @param newName   The name of the exercise
     */
    public void setName(String newName) {
        name = newName;
    }


}
