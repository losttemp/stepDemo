package com.example.administrator.utils;

import java.text.DecimalFormat;

/**
 * 用于计算计步消耗数据的工具类
 */
public class CalculationUtils {

    public static int getCalories(Boolean sex, int height, int weight, int age) {
        int KiloCalorie;
        if (sex) {
            KiloCalorie = (int) (66.473 + 5.0033 * height + 13.751 * weight - 6.755 * age);
        } else {
            KiloCalorie = (int) (655.0955 + 1.8496 * height + 9.563 * weight - 4.6756 * age);
        }
        return KiloCalorie;
    }

    public static float getKilometre(int steps) {
        float kilometre = (float) (steps * 0.7 / 1000);
        if (steps < 0) {
            kilometre = (float) 0.0;
        }
        return kilometre;
    }

    public static float getEnergy(int steps) {
        float energy = (float) (steps / 35.39127);
        return energy;
    }

    public static float getCircle(float Kilometre) {
        float circle = Kilometre / 4;
        return circle;
    }

    public static float getCalories(float kiloCalories) {
        float bowl = kiloCalories / 232;
        return bowl;
    }

    public static String floatToStr(float f) {
        DecimalFormat fnum = new DecimalFormat("##0.0");
        String dd = fnum.format(f);
        return dd;
    }

    public static float getAltitude(float v) {
        return (float) (44330 * (1 - Math.exp(Math.log((v / 1013.25)) / 5.255)));
    }
}
