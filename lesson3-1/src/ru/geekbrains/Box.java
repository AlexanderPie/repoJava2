package ru.geekbrains;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList<T> fruits;

    public Box(ArrayList<T> fruits) {
        this.fruits = new ArrayList<>();
    }

    public Box() {

    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public float getWeight(){
        if (!fruits.isEmpty()) {
            return fruits.get(0).getWeight() * fruits.size();
        } else return 0.0f;

    }

    public boolean compare (Box<? extends Fruit> box) {
        return box.getWeight() == this.getWeight();
    }

    public void bulk (Box<T> box) {
        fruits.addAll(box.getFruits());
    }
}


