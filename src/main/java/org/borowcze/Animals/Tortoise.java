package org.borowcze.Animals;

import org.borowcze.Animal;
import org.borowcze.World;

public class Tortoise extends Animal {

    public Tortoise(World world, int width, int height) {
        super(world, width, height);
        strength = 2;
        initiative = 1;
    }

}
