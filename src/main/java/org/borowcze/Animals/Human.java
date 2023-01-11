package org.borowcze.Animals;

import org.borowcze.Animal;
import org.borowcze.World;

public class Human extends Animal {

    public Human(World world, int width, int height) {
        super(world, width, height);
        strength = 5;
        initiative = 5;
        age = 1;
    }

    @Override
    public void action() {

    }

    @Override
    public void collision() {

    }

    @Override
    public void draw() {

    }
}
