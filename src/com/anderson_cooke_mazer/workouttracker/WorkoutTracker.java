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
 *  travel to the other two screens
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
