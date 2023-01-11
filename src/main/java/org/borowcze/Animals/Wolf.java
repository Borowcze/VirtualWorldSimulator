package org.borowcze.Animals;

import org.borowcze.Animal;
import org.borowcze.World;

public class Wolf extends Animal {

    public Wolf(World world, int width, int height) {
        super(world, width, height);
        strength = 9;
        initiative = 5;
    }
}
