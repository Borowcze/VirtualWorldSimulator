package org.borowcze.Animals;

import org.borowcze.Animal;
import org.borowcze.World;

public class Sheep extends Animal {

    public Sheep(World world, int width, int height) {
        super(world, width, height);
        strength = 4;
        initiative = 4;
    }
}
