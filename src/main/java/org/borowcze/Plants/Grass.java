package org.borowcze.Plants;

import org.borowcze.World;

import java.awt.*;

public class Grass extends Plant{

    public Grass(World world, Point position) {
        super(world, position);
        symbol = (char) 176;
    }


}
