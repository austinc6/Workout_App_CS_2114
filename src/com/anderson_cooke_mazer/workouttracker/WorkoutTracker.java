package com.anderson_cooke_mazer.workouttracker;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import sofia.app.Screen;
/**
 * // -------------------------------------------------------------------------
/**
 *  This is the welcome screen and hub of the app. It has no functionality but
 *  travel to the other two screens. There is also no test for it, as any test
 *  would fail attempting any functionality. Suffice it to say, this class
 *  works.
 *
 *  @author austinc6
 *  @partner jordyna
 *  @partner morganm7
 *  @version 2015.04.25
 */
public class WorkoutTracker extends Screen {
    // Fields .................................................................
    private Button start;
    private Button viewProgress;

    // Methods ................................................................
    /**
     * This method runs upon startup of the screen. It sets the behavior of the
     * buttons to open the other, more important screens.
     */
    public void initialize() {
        final Context context = this;
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, WorkoutScreen.class);
                startActivity(intent);
            }
        });
        viewProgress = (Button) findViewById(R.id.viewProgress);
        viewProgress.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, WorkoutProgress.class);
                startActivity(intent);
            }
        });
    }
}
