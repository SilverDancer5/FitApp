package com.zzht.fitapp2.domain;

public class Figure {
    private int figureid;
    private int uid;
    private String figure_data;
    private double weight;
    private  double chest;
    private double waist;
    private double leftarm;
    private double rightarm;
    private double shoulder;
    public Figure() {
    }

    public int getFigureid() {
        return figureid;
    }

    public void setFigureid(int figureid) {
        this.figureid = figureid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFigure_data() {
        return figure_data;
    }

    public void setFigure_data(String figure_data) {
        this.figure_data = figure_data;
    }

    public Figure(int uid, double weight, double chest, double waist, double leftarm, double rightarm, double shoulder) {
        this.uid = uid;
        this.weight = weight;
        this.chest = chest;
        this.waist = waist;
        this.leftarm = leftarm;
        this.rightarm = rightarm;
        this.shoulder = shoulder;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public double getLeftarm() {
        return leftarm;
    }

    public void setLeftarm(double leftarm) {
        this.leftarm = leftarm;
    }

    public double getRightarm() {
        return rightarm;
    }

    public void setRightarm(double rightarm) {
        this.rightarm = rightarm;
    }

    public double getShoulder() {
        return shoulder;
    }

    public void setShoulder(double shoulder) {
        this.shoulder = shoulder;
    }


    @Override
    public String toString() {
        return "Figure{" +
                "figureid=" + figureid +
                ", uid=" + uid +
                ", figure_data=" + figure_data +
                ", weight=" + weight +
                ", chest=" + chest +
                ", waist=" + waist +
                ", leftarm=" + leftarm +
                ", rightarm=" + rightarm +
                ", shoulder=" + shoulder +
                '}';
    }
}
