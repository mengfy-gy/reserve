package com.ahav.reserve.pojo;

public class Token {
    private int deReserveId = 3;
    private String deReserve;

    public int getDeReserveId() {
        return deReserveId;
    }

    public void setDeReserveId(int deReserveId) {
        this.deReserveId = deReserveId;
    }

    public String getDeReserve() {
        return deReserve;
    }

    public void setDeReserve(String deReserve) {
        this.deReserve = deReserve;
    }

    @Override
    public String toString() {
        return "token{" +
                "deReserveId=" + deReserveId +
                ", deReserve='" + deReserve + '\'' +
                '}';
    }
}
