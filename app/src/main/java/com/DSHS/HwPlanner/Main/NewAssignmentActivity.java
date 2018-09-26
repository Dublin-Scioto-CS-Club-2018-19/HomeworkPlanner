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
import android.widget.Button;
import android.widget.EditText;

/**
 * Activity for entering a word.
 */

public class NewAssignmentActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.assignmentlistsql.REPLY";

    private  EditText mEditAssignmentView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_assignment);
        mEditAssignmentView = findViewById(R.id.edit_assignment);

        final Button button = findViewById(R.id.button_save_assignment);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditAssignmentView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String assignment = mEditAssignmentView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, assignment);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}

