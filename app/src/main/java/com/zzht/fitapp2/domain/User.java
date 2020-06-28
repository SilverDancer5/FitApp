package com.zzht.fitapp2.domain;

public class User {

    private int userId;
    private String nickname;
    private String authToken;
    private String phone;
    private int sex;
    private String birthday;
    private Double high;
    private double BMI;
    private  double intakeCC;
    private double consumeCC;
    private double consumeREE;
    private  double standardWeight;
    private double maxHeart;

    public User() {
    }

    public User(String nickname, int sex, double BMI) {
        this.nickname = nickname;
        this.sex = sex;
        this.BMI = BMI;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public double getBMI() {
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public double getIntakeCC() {
        return intakeCC;
    }

    public void setIntakeCC(double intakeCC) {
        this.intakeCC = intakeCC;
    }

    public double getConsumeCC() {
        return consumeCC;
    }

    public void setConsumeCC(double consumeCC) {
        this.consumeCC = consumeCC;
    }

    public double getConsumeREE() {
        return consumeREE;
    }

    public void setConsumeREE(double consumeREE) {
        this.consumeREE = consumeREE;
    }

    public double getStandardWeight() {
        return standardWeight;
    }

    public void setStandardWeight(double standardWeight) {
        this.standardWeight = standardWeight;
    }

    public double getMaxHeart() {
        return maxHeart;
    }

    public void setMaxHeart(double maxHeart) {
        this.maxHeart = maxHeart;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", nickname='" + nickname + '\'' +
                ", authToken='" + authToken + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", birthday='" + birthday + '\'' +
                ", high='" + high + '\'' +
                ", BMI=" + BMI +
                ", intakeCC=" + intakeCC +
                ", consumeCC=" + consumeCC +
                ", consumeREE=" + consumeREE +
                ", standardWeight=" + standardWeight +
                ", maxHeart=" + maxHeart +
                '}';
    }
}
