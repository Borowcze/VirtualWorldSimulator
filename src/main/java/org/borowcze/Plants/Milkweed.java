package org.borowcze.Plants;

import org.borowcze.World;

import java.awt.*;

public class Milkweed extends Plant {

    public Milkweed(World world, Point position) {
        super(world, position);
        symbol = (char) 109;
    }
}
