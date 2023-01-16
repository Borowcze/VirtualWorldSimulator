package org.borowcze.Animals;

import org.borowcze.World;

import java.awt.*;

public class Human extends Animal {

    public Human(World world, Point position) {
        super(world, position);
        strength = 5;
        initiative = 5;
        symbol = (char) 72;
    }

    @Override
    public void action() {

    }

    @Override
    public void collision() {

    }

    @Override
    public char draw() {

        return 0;
    }
}
