package org.borowcze;

import org.borowcze.Animals.*;
import org.borowcze.Plants.Grass;
import org.borowcze.Plants.Guarana;
import org.borowcze.Plants.Milkweed;
import org.borowcze.Plants.WolfBerries;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class World {
    protected int worldWidth;
    protected int worldHeight;
    protected List<Organism> organismsList = new ArrayList<>();
    protected List<Point> emptySpotsList = new ArrayList<>();
    protected List<Class> organismsClassList = new ArrayList<>(Arrays.asList(
            Antelope.class, Fox.class, Sheep.class, Tortoise.class, Wolf.class,
            Grass.class, Guarana.class, Milkweed.class, WolfBerries.class
    ));
    protected char[][] worldBoard;
    protected static World world = new World();
    private final Random RANDOM = new Random();

    public World() {
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public void setWorldWidth(int worldWidth) {
        this.worldWidth = worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    public void setWorldHeight(int worldHeight) {
        this.worldHeight = worldHeight;
    }

    protected void performTurn() {
    }

    protected void drawWorld() {

        for (int i = 0; i < worldHeight; i++) {
            for (int j = 0; j < worldWidth - 1; j++) {
                System.out.print("|" + worldBoard[i][j] + "|");
            }
            System.out.println();

        }
    }

    protected static void runGame() throws IOException {
        Menu.mainMenu();
    }

    protected void initializeWorld() {
        world.initializeEmptyWorld();
        System.out.println(initializeOrganisms());
        drawWorld();
    }

    protected void initializeEmptyWorld() {
        worldBoard = new char[worldWidth][worldHeight];
        for (int i = 0; i < worldWidth; i++) {
            for (int j = 0; j < worldHeight; j++) {
                worldBoard[i][j] = '_';
                emptySpotsList.add(new Point(i,j));
            }
        }
    }

    protected List<Organism> initializeOrganisms() {
        int maxOrganismsToGenerate = maxNumberOfOrganismsToGenerate();
        organismsClassList
                .forEach(o -> addOrganismsToList(o, RANDOM.nextInt(2, maxOrganismsToGenerate + 1)));
        return organismsList;
    }

    private int maxNumberOfOrganismsToGenerate() {
        return (int) ((worldWidth * worldHeight * 0.5) / 10);
    }

    private Point getRandomEmptySpotEndRemoveFromList() {
        Point emptySpot = emptySpotsList.get(RANDOM.nextInt(emptySpotsList.size()));
        emptySpotsList.remove(emptySpot);
        return emptySpot;
    }

    protected void addEmptySpotToTheList(Point newEmptySpot) {
        emptySpotsList.add(newEmptySpot);
    }

    private void addOrganismsToList(Class organismClass, int numberOfOrganisms) {
        for (int i = 0; i < numberOfOrganisms; i++) {
            try {
                organismsList.add((Organism) organismClass.getDeclaredConstructor(World.class, Point.class)
                        .newInstance(world, getRandomEmptySpotEndRemoveFromList()));
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                     InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

}
