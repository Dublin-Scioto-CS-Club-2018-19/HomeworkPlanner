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

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * A basic class representing an entity that is a row in a one-column database table.
 *
 * @ Entity - You must annotate the class as an entity and supply a table name if not class name.
 * @ PrimaryKey - You must identify the primary key.
 * @ ColumnInfo - You must supply the column name if it is different from the variable name.
 *
 * See the documentation for the full rich set of annotations.
 * https://developer.android.com/topic/libraries/architecture/room.html
 */

@Entity(tableName = "assignment_table")
public class Assignment {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String AssignmentName;

    private int dueMonth;

    private int dueDay;

    private int priority;

    private String subject;

    private String description;

    public Assignment(int id, String assignment, int dueMonth, int dueDay, int priority, String subject, String description) {
        this.AssignmentName = assignment;
        this.dueMonth = dueMonth;
        this.dueDay = dueDay;
        this.priority = priority;
        this.subject = subject;
        this.description = description;
    }

    public Assignment() {}

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public void setAssignmentName(String assignment) {
        this.AssignmentName = assignment;
    }

    public void setDueMonth(int dueMonth) {
        this.dueMonth = dueMonth;
    }

    public void setDueDay(int dueDay) {
        this.dueDay = dueDay;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignmentName(){
        return AssignmentName;
    }

    public int getId() {
        return id;
    }

    public int getDueMonth() {
        return dueMonth;
    }

    public int getDueDay() {
        return dueDay;
    }

    public int getPriority() {
        return priority;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }


}