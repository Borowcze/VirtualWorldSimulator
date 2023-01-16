package org.borowcze.Animals;

import lombok.NoArgsConstructor;
import org.borowcze.World;

import java.awt.*;

public class Wolf extends Animal {

    public Wolf(World world, Point position) {
        super(world, position);
        strength = 9;
        initiative = 5;
        symbol = (char) 87;
    }
}
