package edu.examples;

public class MarineShip implements Ship {
    public void go() {
        System.out.println("Sea surface");
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}