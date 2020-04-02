package com.example.simplequizapplication;

public class Question {
    private int question_no;
    private boolean answerId;

    public Question(int question_no, boolean answerId) {
        this.question_no = question_no;
        this.answerId = answerId;
    }

    public int getQuestion_no() {
        return question_no;
    }

    public void setQuestion_no(int question_no) {
        this.question_no = question_no;
    }

    public boolean isAnswerId() {
        return answerId;
    }

    public void setAnswerId(boolean answerId) {
        this.answerId = answerId;
    }
}
