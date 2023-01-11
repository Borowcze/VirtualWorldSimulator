package org.borowcze;

public abstract class Organism {
    protected int strength;
    protected int initiative;
    protected int position[][];
    protected int age;
    protected boolean alive;
    protected World world = new World();
    protected int width;
    protected int height;

    public Organism(World world, int width, int height) {
        this.world = world;
        this.width = width;
        this.height = height;
    }

    public abstract void action();

    public abstract void collision();

    public abstract void draw();

}
