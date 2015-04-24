package com.anderson_cooke_mazer.workouttracker;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

/**
 * // -------------------------------------------------------------------------
/**
 *  This class loads all of the exercises in the saved file in a usable format
 *  for the app to use
 *
 *  @author austinc6
 *  @partner jordyna
 *  @partner morganm7
 *  @version 2015.04.09
 */
public class Loader {
    // Fields .................................................................
    private Scanner scanner;
    private Exercise[][] workouts;

    // Constructors ...........................................................
    /**
     * This constructor simply loads the scanner, all other behavior is handled
     * by other methods
     *
     * @param fileName  The name of the file to be loaded
     *
     * @throws FileNotFoundException
     */
    public Loader(String fileName) throws FileNotFoundException {
        File file = new File(fileName);

        try {
            scanner = new Scanner(file);
        }
        catch (Exception e) {
            System.out.println("There is no file found for the scanner to read "
                + "from.");
            e.printStackTrace();
        }
    }
    /**
     * This constructor sets the loader with a known filename
     *
     * @throws FileNotFoundException
     */
    public Loader() throws FileNotFoundException {
        this("workoutSave.txt");
    }

    // Methods ................................................................
    /**
     * This determines the size of the workouts variable based on the scanner
     * file
     */
    public void calculateNumWorkoutsAndExercises() {
        int numWorkouts = 0;
        int maxExercises = 0;
        while(scanner.hasNext()) {
            String toCheck = scanner.next();
            if (toCheck.equals("Workout Start")) {
                int numExercises = 0;
                numWorkouts++;
                while(scanner.hasNext() && !toCheck.equals("Workout End")) {
                    numExercises++;
                    toCheck = scanner.next();
                }
                if (numExercises > maxExercises) {
                    maxExercises = numExercises;
                }
            }
        }
        workouts = new Exercise[numWorkouts][maxExercises];
        resetScanner();
    }

    /**
     * This sets the values of workouts to be all of the exercises in the saved
     * file
     */
    public void setWorkoutValues() {
        int workoutNum = 0;
        int exerciseNum = 0;
        while(scanner.hasNext()) {
            String toCheck = scanner.next();
            Exercise newExercise = new Exercise();
            if (toCheck.equals("Workout End")) {
                workoutNum++;
            }
            else if (!toCheck.equals("Workout Start") &&
                    !toCheck.startsWith("2")) {
                @SuppressWarnings("resource")
                Scanner scanner2 = new Scanner(toCheck).useDelimiter("\\s");
                if (scanner2.hasNext()) {
                    newExercise.setName(scanner2.next());
                    scanner2.next();
                    //newExercise.setWeight(Integer.parseInt(scanner2.next()));
                    scanner2.next();
                    //newExercise.setReps(Integer.parseInt(scanner2.next()));
                    scanner2.next();
                    //newExercise.setSets(Integer.parseInt(scanner2.next()));
                    workouts[workoutNum][exerciseNum] = newExercise;
                    exerciseNum++;
                }
                scanner2.close();
            }
        }
        resetScanner();
    }

    /**
     * This resets the scanner so that any other called method can safely
     * perform its action
     */
    public void resetScanner() {
        scanner.close();

        File file = new File("workoutSave.txt");
        try {
            scanner = new Scanner(file);
        }
        catch (Exception e) {
            System.out.println("There is no file found for the scanner to read "
                + "from.");
            e.printStackTrace();
        }
    }

    /**
     * This returns the workouts variable
     *
     * @return  the workouts array
     */
    public Exercise[][] getWorkouts() {
        return workouts;
    }
}
