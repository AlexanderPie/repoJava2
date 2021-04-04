package ru.geekbrains;

public class Main {

    public static void main(String[] args) {

        float[] array = new float[10000000];
        final int l = array.length;
        new ArrayChange().doChange1(array, l);
        new ArrayChange().doChange2(array, l);

    }
}
