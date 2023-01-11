package org.borowcze;

public abstract class Animal extends Organism {

    public Animal(World world, int width, int height) {
        super(world, width, height);

    }

    @Override
    public void action() {

    }

    @Override
    public void collision() {

    }

    @Override
    public void draw() {
        System.out.println("draw");
    }
}
