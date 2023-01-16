package org.borowcze;

import java.awt.*;

public abstract class Organism {
    protected World world;
    protected int strength;
    protected int initiative;
    protected Point position;
    protected int age;
    protected char symbol;
    protected boolean alive;

    public Organism(World world, Point position) {
        this.world = world;
        this.position = position;
        this.age = 1;
    }

    public abstract void action();

    public abstract void collision();

    public abstract char draw();

}
