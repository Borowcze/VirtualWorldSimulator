package org.borowcze.Animals;

import lombok.NoArgsConstructor;
import org.borowcze.World;

import java.awt.*;

public class Antelope extends Animal {

    public Antelope(World world, Point position) {
        super(world, position);
        strength = 4;
        initiative = 4;
        symbol = (char) 65;
    }


}
