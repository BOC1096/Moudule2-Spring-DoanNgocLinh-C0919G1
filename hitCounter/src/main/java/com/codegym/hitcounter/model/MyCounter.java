package com.codegym.hitcounter.model;

public class MyCounter {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public MyCounter() {
    }

    public MyCounter(int count) {
        this.count = count;
    }
    public int increment(){
        return count++;
    }
}