package com.capgemini.be;

public class GenderDTO {

    private String gender;
    private double probability;

    public GenderDTO() {}

    public GenderDTO(String gender, double probability) {
        this.gender = gender;
        this.probability = probability;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}

