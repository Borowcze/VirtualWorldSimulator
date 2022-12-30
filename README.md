# Virtual World Simulator
The goal of this project is to implement a virtual world simulator program that has the structure of a two-dimensional grid of any size NxM specified by the user. This world will have simple forms of life with different behaviours. Each organism occupies exactly one field in the array, and each field can contain at most one organism (in case of collision, one of them should be removed or moved).

The simulator will be turn-based. In each turn, all organisms existing in the world will perform an action appropriate to their type. Some will move (animal organisms), while others will be stationary (plant organisms). In the case of a collision (one organism is on the same field as another), one organism will win by killing (e.g., wolf) or chasing away (e.g., turtle) the competitor. The order of organism movements in a turn depends on their initiative. Animals with the highest initiative will move first. In the case of animals with the same initiative, the order is determined by the principle of seniority (the longer-lived one moves first). The outcome of a meeting depends on the strength of the organism, although there will be exceptions to this rule (see Table 2). In case of equal strength, the organism that attack wins. A special type of animal will be Human. Unlike animals, humans do not move randomly. The direction of their movement is determined before the start of the turn using arrow keys or the appropriate letters on the keyboard. Humans also have a special ability (see Table 4) that can be activated with a separate button. The activated ability remains active for 5 consecutive turns, after which it is deactivated. After deactivation, the ability cannot be activated for another 5 turns. When the program is started, a few organisms should appear on the board. In addition to displaying the current state of the board, the program should also print information about the results of battles, consumption of plants, and other events happening in the world.

The following notes do not cover all the details and are only guidelines for implementing the project in accordance with object-oriented programming rules.

<br>

A class called World should be created to manage the game and organisms. It should include methods such as:
- performTurn()
- drawWorld()

and fields such as:
- organisms	

<br>

An abstract class called Organism should also be created. Basic fields:
- strength
- initiative
- location (x,y)
- world - reference to the world in which the organism is located

Basic methods:
- action() → determines the behavior of the organism during the turn,
- collision() → determines the behavior of the organism during contact/collision with another organism,
- drawing() → causes the symbolic representation of the organism to be drawn.

<br>

The Organism class should be abstract. It should be inherited by two further abstract classes: Plant and Animal. In the Animal class, common behaviours for all/most animals should be implemented, mainly:
- basic form of movement in the action() method → each typical animal moves to a randomly selected, adjacent field in its turn,
- reproduction within the collision() method → in the case of collision with an organism of the same species, there is no fight, both animals remain in their places, and a third animal of the same species appears next to them.

<br>

The Human class should be an extension of the Animal class. It does not have its own intelligence (it is controlled by the player) and does not reproduce (the player will be the only Human on the map).

<br>

_Table 1. Characteristics of the Human class._

| strength | initiative | specifics of the action() method                                                                                                                                                                                                                                                                  |    specifics of the collision() method|
|----------|------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------|
| 5        | 4          | Human beings move in the same way as animals, but the direction of their movement is not random and corresponds to the arrow pressed by the player on the keyboard. In other words, if the player presses the left arrow, (when it is their turn) the character will move one field to the left. |Human beings have a special ability (see Table 4) that can be activated by a separate button on the keyboard. Upon activation, this ability affects the behavior of the collision() method for five consecutive turns. Then the ability is turned off and cannot be activated again for five turns.|

Implement 5 classes of animals. The types of animals are defined in the following table.


_Table 2. List of animals appearing in the virtual world._

| Id  | animal   | strength | initiative | specifics of the action() method | specifics of the collision() method |
|-----|----------|----------|------------|----------------------------------|-------------------------------------|
| 1   | wolf     | 9        | 5          | none                             | none                                |
| 2   | sheep    | 4        | 4          | none                             | none                                |
| 3   | fox      | 3        | 7          |Good smell: a fox will never move to a field occupied by an organism stronger than itself.| none|
| 4   | tortoise | 2        | 1          |In 75% of cases, it does not change its position.|It defends against attacks from animals with strength <5. The attacker must return to their previous field.|
| 5   | antelope | 4        | 4          |The range of movement is 2 fields.|There is a 50% chance of escaping before a fight. In that case, it moves to an unoccupied neighboring field.|

In the Plant class, implement behaviors common to all/most plants, mainly:

- simulation of plant spread in the action() method → with a certain probability, each plant can "sow" a new plant of the same species on a random, neighboring field.

 
All plants have zero initiative.

Implement 4 classes of plants. The types of plants are defined in the following table.

_Table 3. List of plants appearing in the virtual world._

| Id  | animal       | strength | specifics of the action() method | specifics of the collision() method |
|-----|--------------|----------|----------------------------------|-------------------------------|
| 1   | grass        | 0        | none                             |none|
| 2   | milkweed     | 0        |It makes three attempts to spread in one turn.|none|
| 3   | guarana      | 0        | none                             |It increases the strength of the animal that ate this plant by 3.|
| 4   | wolf berries | 99       | none                             |The animal that ate this plant dies.|


<br>
Create a World class that includes objects of the Organism class. Implement the course of a turn by calling the action() methods for all organisms and the collision() method for organisms on the same field. Remember that the order in which the action() method is called depends on the initiative (or age, in the case of equal values of initiative) of the organism.

Organisms have the ability to influence the state of the world. Therefore, there is a need to pass the action() and collision() methods a parameter specifying an object of the World class.
Try to make the World class define as public components only those fields and methods that are needed by other objects of the application to operate. Try to include the remaining functionality of the world in private components.

_Table 4. Human special abilities._

| Id  | abilities      | features                                                                                                                                                            | 
|-----|----------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1   | Immortality    | Human cannot be killed. In the event of a confrontation with a stronger opponent, he moves to a randomly chosen adjacent field.                                     |
| 2   | Magic Potion   | The strength of a human increases to 10 in the first turn of the skill's action. In each subsequent turn it decreases by "1" until it returns to its initial state. |
| 3   | Antelope Speed | Human moves two fields instead of one for the first 3 turns of the skill's action. For the remaining 2 turns, there is a 50% chance that the skill will work.       | 
| 4   | Alzure Shield  | Human deters all animals. An animal that stands on a human's field is moved to a random adjacent field.                                                             |
| 5   | Annihilation   | Human destroys all plants and animals on fields adjacent to his position.                                                                                           |

<br>

### **Project guidelines:**

Visualize the world in the console. Each organism is represented by a different ASCII symbol. Pressing one of the keys moves to the next turn, clears the console, and reprints the appropriate symbols representing the changed state of the game. At least one line of text in the console is reserved for reporting results of events such as eating or the outcome of a fight.

**Classes and objects:**
1. Use classes and objects in the project, it is not allowed to write "loose" functions (other than the main function).
2. Logical division into name spaces - each name space in a separate module (file).
3. Methods that do not use an object should be static. Do not abuse them. 
4. At least one abstract class.

**Encapsulation:**
1. All class fields should be private or protected.
2. Selected classes should have get and set methods for components or only get, or no direct access.

**Inheritance:**
1. At least 1 base class from which several derived classes inherit directly (in the same generation).
2. Multiple use of code (code in the base class used by objects of derived classes).
3. Overriding a base class method.
4. Explicit call of methods from the base class despite their overrides in the derived class.

**Other requirements:**
1. The state of all objects should be read and saved to a file.
2. Demonstrate exception handling and implement sample custom exceptions.

**Programming style:**
1. Follow the rules related to programming style, primarily:
   - consistency in naming variables and types,
   - consistency in the use of tabulation (indentation) and spaces,
   - limited function size,
   - maintaining consistency in the organization of source code within a class (e.g. uniform order of public->protected->private).