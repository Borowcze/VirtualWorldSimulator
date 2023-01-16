package org.borowcze.Animals;

import org.borowcze.Organism;
import org.borowcze.World;

import java.awt.*;

public abstract class Animal extends Organism {

    public Animal(World world, Point position) {
        super(world, position);
    }

    @Override
    public void action() {

    }

    @Override
    public void collision() {

    }

    @Override
    public char draw() {
        return symbol;
    }
}
