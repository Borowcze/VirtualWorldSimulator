package org.borowcze;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        World.runGame();

        System.out.println("Hello world!");
        ArrayList<Point> arrayList = new ArrayList<>();
        arrayList.add(new Point(0,1));
        arrayList.add(new Point(1,2));
        arrayList.add(new Point(3,5));

        Random random = new Random();
        int randomNumber = random.nextInt(arrayList.size());
        System.out.println(randomNumber);
        System.out.println(arrayList.get(randomNumber));
        System.out.println(arrayList.get(randomNumber).x +" "+ arrayList.get(randomNumber).y);
    }
}