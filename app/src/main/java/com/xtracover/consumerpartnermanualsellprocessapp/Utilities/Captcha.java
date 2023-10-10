package com.xtracover.consumerpartnermanualsellprocessapp.Utilities;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.List;
import java.util.Random;

public abstract class Captcha {
    protected Bitmap image;
    protected String answer = "";
    private int width;
    protected int height;
    protected int x = 0;
    protected int y = 0;
    protected static List usedColors;

    protected abstract Bitmap image();

    public static int color() {
        Random r = new Random();
        int number;
        do {
            number = r.nextInt(9);
        } while (usedColors.contains(number));
        usedColors.add(number);
        switch (number) {
            case 0:
                return Color.CYAN;
            case 1:
                return Color.BLUE;
            case 2:
                return Color.GRAY;
            case 3:
                return Color.BLACK;
            default:
                return Color.WHITE;
        }
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        if (width > 0 && width < 10000) {
            this.width = width;
        } else {
            this.width = 300;
        }
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        if (height > 0 && height < 10000) {
            this.height = height;
        } else {
            this.height = 100;
        }
    }

    public Bitmap getImage() {
        return this.image;
    }

    public boolean checkAnswer(String ans) {
        return ans.equals(this.answer);
    }
}
