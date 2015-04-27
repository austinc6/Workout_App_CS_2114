package com.anderson_cooke_mazer.workouttracker;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import android.content.Context;
import android.content.Intent;
import java.io.FileNotFoundException;
import java.util.Scanner;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RadioButton;
import java.util.Stack;
import sofia.app.Screen;
/**
 * // -------------------------------------------------------------------------
/**
 *  This is the screen class that reads from the file saved to, and shows the
 *  data. It uses a stack to store the data from Saver, and then runs through
 *  the stack to interpret and display the data.
 *
 *  @author austinc6
 *  @partner jordyna
 *  @partner morganm7
 *  @version 2015.04.26
 */
public class WorkoutProgress extends Screen {
    // Fields .................................................................
    private EditText editText1;
    private RadioButton strengthProg;
    private RadioButton cardioProg;
    private RadioButton weightProg;
    private Button search;
    private Button back;
    private TextView firstPrm1Name;
    private TextView recentPrm1Name;
    private TextView avgPrm1Name;
    private TextView firstPrm2Name;
    private TextView recentPrm2Name;
    private TextView avgPrm2Name;
    private TextView firstPrm3Name;
    private TextView recentPrm3Name;
    private TextView avgPrm3Name;
    private TextView exerciseName;
    private TextView firstParam1;
    private TextView recParam1;
    private TextView avgParam1;
    private TextView firstParam2;
    private TextView recParam2;
    private TextView avgParam2;
    private TextView firstParam3;
    private TextView recParam3;
    private TextView avgParam3;
    private TextView performed;

    private Scanner scanner;
    private Stack<WeightExercise> weightStack;
    private Stack<CardioExercise> cardioStack;
    private Stack<StrengthExercise> strengthStack;
    private boolean strengthMode;
    private boolean cardioMode;
    private boolean weightMode;

    //private String SAVER_FILE = "savertest.txt";
    private String PROGRESS_FILE = "progresstest.txt";
    private String FILE = PROGRESS_FILE;

    // Methods ................................................................
    /**
     * This is the opening method on the class, and runs whenever the screen
     * opens
     */
    public void initialize() {
        strengthMode = false;
        cardioMode = false;
        weightMode = false;
        setWidgets();
        setTextViews();
        clearTextViews();
    }

    /**
     * This is the reaction to clicking the strength radio button. It sets
     * important booleans.
     */
    public void strengthMode() {
        strengthMode = true;
        cardioMode = false;
        weightMode = false;
        strengthProg.setChecked(true);
        cardioProg.setChecked(false);
        weightProg.setChecked(false);
        search.setEnabled(true);
        strengthStack = new Stack<StrengthExercise>();
    }

    /**
     * This is the reaction to clicking the cardio radio button. It sets
     * important booleans.
     */
    public void cardioMode() {
        strengthMode = false;
        cardioMode = true;
        weightMode = false;
        strengthProg.setChecked(false);
        cardioProg.setChecked(true);
        weightProg.setChecked(false);
        search.setEnabled(true);
        cardioStack = new Stack<CardioExercise>();
    }

    /**
     * This is the reaction to clicking the weight radio button. It sets
     * important booleans.
     */
    public void weightMode() {
        strengthMode = false;
        cardioMode = false;
        weightMode = true;
        strengthProg.setChecked(false);
        cardioProg.setChecked(false);
        weightProg.setChecked(true);
        search.setEnabled(true);
        weightStack = new Stack<WeightExercise>();
    }

    /**
     * This searches the save file for the information to display
     *
     * @param term  The search name for the exercise
     */
    @SuppressWarnings("resource")
    public void search(String term) {
        clearTextViews();
        String ret = "";
        try {
            InputStream inputStream = openFileInput(FILE);
            if (inputStream != null) {
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String recieveString = "";
                StringBuilder builder = new StringBuilder();
                while ((recieveString = bufferedReader.readLine()) != null) {
                    builder.append(recieveString);
                    builder.append("\n");
                }
                inputStream.close();
                ret = builder.toString();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner = new Scanner(ret).useDelimiter("\n");
        while (scanner.hasNext()) {
            addToStack(term, scanner.next());
        }
        processResults();
    }

    /**
     * This method runs in a while loop inside the search method, adding values
     * from the text file to the stack.
     *
     * @param term  The search term
     * @param next  The next line from the scanner
     */
    public void addToStack(String term, String next) {
        if (next.startsWith(term + " W:") && weightMode) {
            weightStack.push(setWeightType(next));
        }
        else if (next.startsWith(term + " T:") && cardioMode) {
            cardioStack.push(setCardioType(next));
        }
        else if (next.startsWith(term + " R:") && strengthMode) {
            strengthStack.push(setStrengthType(next));
        }
    }

    /**
     * This returns a WeightExercise object by using a scanner on the string
     *
     * @param ex    This is the line the weight exercise is on.
     *
     * @return a WeightExercise object which will be put into the stack
     */
    @SuppressWarnings("resource")
    public WeightExercise setWeightType(String ex) {
        Scanner stringScan = new Scanner(ex);
        String name = "";
        int weight = 0;
        int reps = 0;
        int sets = 0;
        String next = stringScan.next();
        while (!next.equals("W:")) {
            name += next;
            next = stringScan.next();
        }
        weight = Integer.parseInt(stringScan.next());
        stringScan.next();
        reps = Integer.parseInt(stringScan.next());
        stringScan.next();
        sets = Integer.parseInt(stringScan.next());
        return new WeightExercise(name, weight, reps, sets);
    }

    /**
     * This returns a CardioExercise object by using a scanner on the string
     *
     * @param ex    This is the line the cardio exercise is on
     *
     * @return  a cardioExercise object which will be put into the stack
     */
    @SuppressWarnings("resource")
    public CardioExercise setCardioType(String ex) {
        Scanner stringScan = new Scanner(ex);
        String name = "";
        int time = 0;
        int distance = 0;
        String next = stringScan.next();
        while (!next.equals("T:")) {
            name += next;
            next = stringScan.next();
        }
        time = Integer.parseInt(stringScan.next());
        stringScan.next();
        distance = Integer.parseInt(stringScan.next());
        return new CardioExercise(name, time, distance);
    }

    /**
     * This returns a StrengthExercise object by using a scanner on the string
     *
     * @param ex    This is the line the strength exercise is on.
     *
     * @return a StrengthExercise object which will be put into the stack
     */
    @SuppressWarnings("resource")
    public StrengthExercise setStrengthType(String ex) {
        Scanner stringScan = new Scanner(ex);
        String name = "";
        int reps = 0;
        int sets = 0;
        String next = stringScan.next();
        while (!next.equals("R:")) {
            name += next;
            next = stringScan.next();
        }
        reps = Integer.parseInt(stringScan.next());
        stringScan.next();
        sets = Integer.parseInt(stringScan.next());
        System.out.println((new StrengthExercise(name, reps, sets)).toString());
        return new StrengthExercise(name, reps, sets);
    }

    /**
     * This method processes the stack, putting all the relevant information on
     * the screen to display
     */
    public void processResults() {
        if (weightMode) {
            firstPrm1Name.setText("First Weight:");
            recentPrm1Name.setText("Recent Weight:");
            avgPrm1Name.setText("Average Weight:");
            firstPrm2Name.setText("First Reps:");
            recentPrm2Name.setText("Recent Reps:");
            avgPrm2Name.setText("Average Reps:");
            firstPrm3Name.setText("First Sets:");
            recentPrm3Name.setText("Recent Sets:");
            avgPrm3Name.setText("Average Sets:");
            processWeight();
        }
        else if (cardioMode) {
            firstPrm1Name.setText("First Time:");
            recentPrm1Name.setText("Recent Time:");
            avgPrm1Name.setText("Average Time:");
            firstPrm2Name.setText("First Distance:");
            recentPrm2Name.setText("Recent Distance:");
            avgPrm2Name.setText("Average Distance:");
            processCardio();
        }
        else if (strengthMode) {
            firstPrm1Name.setText("First Reps:");
            recentPrm1Name.setText("Recent Reps:");
            avgPrm1Name.setText("Average Reps:");
            firstPrm2Name.setText("First Sets:");
            recentPrm2Name.setText("Recent Sets:");
            avgPrm2Name.setText("Average Sets:");
            processStrength();
        }
    }

    /**
     * This method sets the values of all the parameters on the left side of
     * the screen with a weight exercise
     */
    public void processWeight() {
        WeightExercise first = new WeightExercise();
        WeightExercise recent = new WeightExercise();
        WeightExercise average = new WeightExercise();
        int count = 0;
        while (!weightStack.isEmpty()) {
            WeightExercise current = weightStack.pop();
            count++;
            first = current;
            if (count == 1) {
                recent = current;
            }
            average.setWeight(average.weight() + current.weight());
            average.setReps(average.reps() + current.reps());
            average.setSets(average.sets() + current.sets());
        }
        printWeightValues(first, recent, average, count);
    }

    /**
     * This method puts the weight values in their corresponding places in the
     * TextViews
     *
     * @param first The first exercise
     * @param recent The last exercise
     * @param average   The mean exercise
     * @param count The number of exercises
     */
    public void printWeightValues(WeightExercise first, WeightExercise recent,
        WeightExercise average, int count) {
        if (count != 0) {
            exerciseName.setText(first.name());
            firstParam1.setText("" + first.weight());
            recParam1.setText("" + recent.weight());
            avgParam1.setText("" + (average.weight() / count));
            firstParam2.setText("" + first.reps());
            recParam2.setText("" + recent.reps());
            avgParam2.setText("" + (average.reps() / count));
            firstParam3.setText("" + first.sets());
            recParam3.setText("" + recent.sets());
            avgParam3.setText("" + (average.sets() / count));
            performed.setText("" + count);
        }
        else {
            exerciseName.setText("No results");
        }
    }

    /**
     * This method sets the values of all the parameters on the left side of
     * the screen with a cardio exercise
     */
    public void processCardio() {
        CardioExercise first = new CardioExercise();
        CardioExercise recent = new CardioExercise();
        CardioExercise average = new CardioExercise();
        int count = 0;
        while (!cardioStack.isEmpty()) {
            CardioExercise current = cardioStack.pop();
            count++;
            first = current;
            if (count == 1) {
                recent = current;
            }
            average.setTime(average.time() + current.time());
            average.setDistance(average.distance() + current.distance());
        }
        printCardioValues(first, recent, average, count);
    }

    /**
     * This method puts the cardio values in their corresponding places in the
     * TextViews
     *
     * @param first The first exercise
     * @param recent The last exercise
     * @param average   The mean exercise
     * @param count The number of exercises
     */
    public void printCardioValues(CardioExercise first, CardioExercise recent,
        CardioExercise average, int count) {
        if (count != 0) {
            exerciseName.setText(first.name());
            firstParam1.setText("" + first.time());
            recParam1.setText("" + recent.time());
            avgParam1.setText("" + (average.time() / count));
            firstParam2.setText("" + first.distance());
            recParam2.setText("" + recent.distance());
            avgParam2.setText("" + (average.distance() / count));
            performed.setText("" + count);
        }
        else {
            exerciseName.setText("No results");
        }
    }

    /**
     * This method sets the values of all the parameters on the left side of
     * the screen with a strength exercise
     */
    public void processStrength() {
        StrengthExercise first = new StrengthExercise();
        StrengthExercise recent = new StrengthExercise();
        StrengthExercise average = new StrengthExercise();
        int count = 0;
        while (!strengthStack.isEmpty()) {
            StrengthExercise current = strengthStack.pop();
            count++;
            first = current;
            if (count == 1) {
                recent = current;
            }
            average.setReps(average.reps() + current.reps());
            average.setSets(average.sets() + current.sets());
        }
        printStrengthValues(first, recent, average, count);
    }

    /**
     * This method puts the strength values in their corresponding places in the
     * TextViews
     *
     * @param first The first exercise
     * @param recent The last exercise
     * @param average   The mean exercise
     * @param count The number of exercises
     */
    public void printStrengthValues(StrengthExercise first,
        StrengthExercise recent, StrengthExercise average, int count) {
        if (count != 0) {
            exerciseName.setText(first.name());
            firstParam1.setText("" + first.reps());
            recParam1.setText("" + recent.reps());
            avgParam1.setText("" + (average.reps() / count));
            firstParam2.setText("" + first.sets());
            recParam2.setText("" + recent.sets());
            avgParam2.setText("" + (average.sets() / count));
            performed.setText("" + count);
        }
        else {
            exerciseName.setText("No results");
        }
    }

    /**
     * This method sets the listeners for all the buttons and widgets in the
     * screen
     */
    public void setWidgets() {
        final Context context = this;
        editText1 = (EditText) findViewById(R.id.editText1);
        strengthProg = (RadioButton) findViewById(R.id.strengthProg);
        strengthProg.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                strengthMode();
            }
        });
        cardioProg = (RadioButton) findViewById(R.id.cardioProg);
        cardioProg.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                cardioMode();
            }
        });
        weightProg = (RadioButton) findViewById(R.id.weightProg);
        weightProg.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                weightMode();
            }
        });
        search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                search(editText1.getText().toString());
            }
        });
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, WorkoutTracker.class);
                startActivity(intent);
            }
        });
        search.setEnabled(false);
    }

    /**
     * This method sets all the TextViews by applying them to their ids.
     */
    public void setTextViews() {
        firstPrm1Name = (TextView) findViewById(R.id.firstPrm1Name);
        recentPrm1Name = (TextView) findViewById(R.id.recentPrm1Name);
        avgPrm1Name = (TextView) findViewById(R.id.avgPrm1Name);
        firstPrm2Name = (TextView) findViewById(R.id.firstPrm2Name);
        recentPrm2Name = (TextView) findViewById(R.id.recentPrm2Name);
        avgPrm2Name = (TextView) findViewById(R.id.avgPrm2Name);
        firstPrm3Name = (TextView) findViewById(R.id.firstPrm3Name);
        recentPrm3Name = (TextView) findViewById(R.id.recentPrm3Name);
        avgPrm3Name = (TextView) findViewById(R.id.avgPrm3Name);
        exerciseName = (TextView) findViewById(R.id.exerciseName);
        firstParam1 = (TextView) findViewById(R.id.firstParam1);
        recParam1 = (TextView) findViewById(R.id.recParam1);
        avgParam1 = (TextView) findViewById(R.id.avgParam1);
        firstParam2 = (TextView) findViewById(R.id.firstParam2);
        recParam2 = (TextView) findViewById(R.id.recParam2);
        avgParam2 = (TextView) findViewById(R.id.avgParam2);
        firstParam3 = (TextView) findViewById(R.id.firstParam3);
        recParam3 = (TextView) findViewById(R.id.recParam3);
        avgParam3 = (TextView) findViewById(R.id.avgParam3);
        performed = (TextView) findViewById(R.id.performed);
    }

    /**
     * This method clears the TextViews to clean up the look of the app
     */
    public void clearTextViews() {
        firstPrm1Name.setText("");
        recentPrm1Name.setText("");
        avgPrm1Name.setText("");
        firstPrm2Name.setText("");
        recentPrm2Name.setText("");
        avgPrm2Name.setText("");
        firstPrm3Name.setText("");
        recentPrm3Name.setText("");
        avgPrm3Name.setText("");
        firstParam1.setText("");
        recParam1.setText("");
        avgParam1.setText("");
        firstParam2.setText("");
        recParam2.setText("");
        avgParam2.setText("");
        firstParam3.setText("");
        recParam3.setText("");
        avgParam3.setText("");
        performed.setText("");
    }
}
