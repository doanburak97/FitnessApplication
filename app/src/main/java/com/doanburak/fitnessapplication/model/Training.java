package com.doanburak.fitnessapplication.model;

public class Training {

    private String userId;
    private String email;
    private String trainingType;
    private int set;
    private int repeat;
    private String description;

    public Training(){

    }

    public Training(String userId, String email, String trainingType, int set, int repeat, String description){

        this.setUserId(userId);
        this.email = email;
        this.trainingType = trainingType;
        this.set = set;
        this.repeat = repeat;
        this.description = description;

    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
