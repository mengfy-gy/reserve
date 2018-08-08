package com.ahav.reserve.pojo;

public class Result {
    private  int status = 400;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                '}';
    }
}
