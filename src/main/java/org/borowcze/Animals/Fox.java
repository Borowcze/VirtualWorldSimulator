package org.borowcze.Animals;

import lombok.NoArgsConstructor;
import org.borowcze.World;

import java.awt.*;

public class Fox extends Animal {
    public Fox(World world, Point position) {
        super(world, position);
        strength = 3;
        initiative = 7;
        symbol = (char) 70;
    }

    @Override
    public void action() {
        super.action();
    }
}
