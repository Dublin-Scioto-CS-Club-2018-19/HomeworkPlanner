package com.DSHS.HwPlanner.Main;

/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Activity for entering a word.
 */

public class NewAssignmentActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.assignmentlistsql.REPLY";

    // add more for entering assignment details
    private  EditText mEditAssignmentView;
    private EditText mEditAssignmentDescription;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_assignment);

        // add more for entering assignment details
        mEditAssignmentView = findViewById(R.id.edit_assignment);
        mEditAssignmentDescription = findViewById(R.id.edit_assignment_description);

        // spinners

        // month spinner
        String[] arrayMonths = new String[] {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"
        };

        final Spinner spinner_month = findViewById(R.id.spinner_month_assignment);
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arrayMonths);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_month.setAdapter(monthAdapter);

        // day spinner
        String[] arrayDays = new String[] {
                "1", "2",  "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
                "30", "31"
        };
        final Spinner spinner_day = findViewById(R.id.spinner_day_assignment);
        ArrayAdapter<String> dayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arrayDays);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_day.setAdapter(dayAdapter);


        // save button
        final Button button = findViewById(R.id.button_save_assignment);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditAssignmentView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String assignment = mEditAssignmentView.getText().toString();
                    // description
                    if (!TextUtils.isEmpty(mEditAssignmentDescription.getText())) {
                        assignment += "\n" + mEditAssignmentDescription.getText().toString();
                    }
                    // date block
                    assignment += " ";
                    // day
                    if (!TextUtils.isEmpty(spinner_day.getSelectedItem().toString())){
                        assignment += "Day:" + spinner_day.getSelectedItem().toString() + " ";
                    }
                    // month
                    if (!TextUtils.isEmpty(spinner_month.getSelectedItem().toString())){
                        assignment += "Month:" + spinner_month.getSelectedItem().toString() + " ";
                    }

                    replyIntent.putExtra(EXTRA_REPLY, assignment);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

    }
}

