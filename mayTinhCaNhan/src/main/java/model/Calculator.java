package model;

public class Calculator {
    public static float cong(float num1, float num2) {
        return num1 + num2;
    }

    public static float tru(float num1, float num2) {
        return num1 - num2;
    }

    public static float nhan(float num1, float num2) {
        return num1 * num2;
    }

    public static float chia(float num1, float num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else throw new RuntimeException("Can't divide by zero");
    }
}
