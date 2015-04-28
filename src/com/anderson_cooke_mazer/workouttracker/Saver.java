package com.anderson_cooke_mazer.workouttracker;

import android.annotation.SuppressLint;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
/**
 * // -------------------------------------------------------------------------
/**
 *  This class saves information from the workout app, and puts it in a format
 *  which can later be read by the Loader class. A suppress is at the beginning
 *  of the class so that the date and time can be read without trouble. The
 *  actual saving is performed by WorkoutScreen, as it can save to local android
 *  files
 *
 *  @author austinc6
 *  @partner jordyna
 *  @partner morganm7
 *  @version 2015.04.09
 */
@SuppressLint("SimpleDateFormat")
public class Saver {
    // Fields .................................................................
    private String workoutString;

    // Constructors ...........................................................
    /**
     * This initializes the workoutString
     */
    public Saver() {
        workoutString = "";
    }

    // Methods ................................................................
    /**
     * Used to begin the workout, and notes the current system time and date
     */
    public void startWorkout() {
        workoutString += "Workout Start\n";
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        workoutString += dateFormat.format(date) + "\n";
    }

    /**
     * Used to end the workout, and notes the current system time and date
     */
    public void endWorkout() {
        workoutString += "Workout End\n";
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        //Two end lines to separate the workouts
        workoutString += dateFormat.format(date) + "\n\n";
    }

    /**
     * This is the method which adds exercises to the file, separating them by
     * type. It calls the next three methods depending on the type of exercise
     * given to the method.
     *
     * @param exercise  The exercise to be saved
     */
    public void addExercise(Exercise exercise) {
        //Checks for the type of the Exercise to save its attributes to file
        if (exercise instanceof CardioExercise) {
            addCardioExercise(exercise.name(),
                ((CardioExercise)exercise).time(),
                ((CardioExercise)exercise).distance());
        }
        else if (exercise instanceof WeightExercise) {
            addWeightExercise(exercise.name(),
                ((WeightExercise)exercise).weight(),
                ((WeightExercise)exercise).reps(),
                ((WeightExercise)exercise).sets());
        }
        else if (exercise instanceof StrengthExercise) {
            addStrengthExercise(exercise.name(),
                ((StrengthExercise)exercise).reps(),
                ((StrengthExercise)exercise).sets());
        }
        else {
            workoutString += exercise.name() + "\n";
        }
    }

    /**
     * This is a format for adding cardio exercises to the save file
     *
     * @param toAdd The name of the exercise performed
     * @param time  The amount of time elapsed in the exercise
     * @param distance  The distance covered in the exercise
     */
    public void addCardioExercise(String toAdd, int time, int distance) {
        workoutString += toAdd + " T: " + time + " D: " + distance + "\n";
    }

    /**
     * This is a format for adding strength exercises to the save file
     *
     * @param toAdd The name of the exercise performed
     * @param reps  The number of reps performed
     * @param sets  The number of sets performed
     */
    public void addStrengthExercise(String toAdd, int reps, int sets) {
        workoutString += toAdd + " R: " + reps + " S: " + sets + "\n";
    }

    /**
     * This is a format for adding weight exercises to the save file
     *
     * @param toAdd The name of the exercise performed
     * @param weight    The weight that is lifted
     * @param reps   The number of reps performed
     * @param sets   The number of sets performed
     */
    public void addWeightExercise(String toAdd, int weight, int reps,
        int sets) {
        workoutString += toAdd + " W: " + weight + " R: " + reps + " S: " +
        sets + "\n";
    }

    /**
     * This returns the String which is the entire filewrite. It exists for
     * testing.
     *
     * @return  The string that will be on the file
     */
    public String getWorkoutString() {
        return workoutString;
    }
}
