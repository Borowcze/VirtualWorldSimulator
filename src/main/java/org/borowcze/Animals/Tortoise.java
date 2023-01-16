package org.borowcze.Animals;

import lombok.NoArgsConstructor;
import org.borowcze.World;

import java.awt.*;

public class Tortoise extends Animal {

    public Tortoise(World world, Point position) {
        super(world, position);
        strength = 2;
        initiative = 1;
        symbol = (char) 84;
    }

}
