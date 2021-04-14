package ru.geekbrains;

import java.util.Arrays;

public class ArrayChange {

    public void doChange1(float[] a, int l) {

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            a[i] = 1;
        }

        ex(a);

        long time2 = System.currentTimeMillis() - time1;
        System.out.println("Время на 1 поток: " + time2);
    }

    public void doChange2(float[] a, int l) {

        int half = l/2;
        long time1 = System.currentTimeMillis();
        float[] a1 = new float[half];
        float[] a2 = new float[half];

        for (int i = 0; i < a.length; i++) {
            a[i] = 1;
        }

        System.arraycopy(a, 0, a1, 0, half);
        System.arraycopy(a, half, a2, 0, half);

        Thread t1 = new Thread(() -> {ex(a1);});
        Thread t2 = new Thread(() -> {ex(a2);});

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }


        System.arraycopy(a1, 0, a, 0, half);
        System.arraycopy(a2, 0, a, half, half);

        long time2 = System.currentTimeMillis() - time1;

        System.out.println("Время на 2 потока: " + time2);
    }

    private void ex(float[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (float) (a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}

