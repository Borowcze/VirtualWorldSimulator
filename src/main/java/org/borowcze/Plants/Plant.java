package org.borowcze.Plants;

import org.borowcze.Organism;
import org.borowcze.World;

import java.awt.*;

public class Plant extends Organism {

    public Plant(World world, Point position) {
        super(world, position);
        initiative = 0;
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
