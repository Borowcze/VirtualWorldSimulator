package org.borowcze.Animals;

import org.borowcze.Animal;
import org.borowcze.World;

public class Fox extends Animal {
    public Fox(World world, int width, int height) {
        super(world, width, height);
        strength = 3;
        initiative = 7;
    }

    @Override
    public void action() {
        super.action();
    }
}
