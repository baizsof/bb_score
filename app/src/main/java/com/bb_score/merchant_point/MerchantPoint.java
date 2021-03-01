package com.bb_score.merchant_point;

public class MerchantPoint {
    private final String name;
    private final String linkPoint;

    public MerchantPoint(String name, String linkPoint) {
        this.name = name;
        this.linkPoint = linkPoint;
    }

    public String getName() {
        return name;
    }

    public String getLinkPoint() {
        return linkPoint;
    }
}
