package com.zzht.fitapp2;

import java.io.Serializable;

public class Plans implements Serializable {
    private String goalType;
    private String goalValue;
    private String goalTime;
    private String currTime;

    private int num;

    public Plans(String goalType, String goalValue, String goalTime, String currTime) {
        this.goalType = goalType;
        this.goalValue = goalValue;
        this.goalTime = goalTime;
        this.currTime = currTime;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }

    public void setGoalValue(String goalValue) {
        this.goalValue = goalValue;
    }

    public void setGoalTime(String goalTime) {
        this.goalTime = goalTime;
    }

    public void setCurrTime(String currTime) {
        this.currTime = currTime;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getGoalType() {
        return goalType;
    }

    public String getGoalValue() {
        return goalValue;
    }

    public String getGoalTime() {
        return goalTime;
    }

    public String getCurrTime() {
        return currTime;
    }

    public int getNum() {
        return num;
    }
}
