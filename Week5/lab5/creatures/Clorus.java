package creatures;

import huglife.Action;
import huglife.Creature;
import huglife.Direction;
import huglife.Occupant;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Clorus extends Creature {
    private int r;
    private int g;
    private int b;

    public Clorus(double e) {
        super("clorus");
        r = 34;
        g = 0;
        b = 231;
        energy = e;
    }

    public Clorus() {
        this(1);
    }

    public Color color() {
        return color(r, g, b);
    }

    public void attack(Creature c) {
        this.energy += c.energy();
    }

    public void move() {
        // TODO
        energy -= 0.03;
        energy = Math.max(energy, 0);
    }

    public void stay() {
        // TODO
        energy -= 0.01;
        energy = Math.max(energy, 0);
    }

    public Clorus replicate() {
        Clorus babyClorus = new Clorus(0.5*energy);
        energy = 0.5 * energy;
        return babyClorus;
    }

    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        List<Direction> emptyNeighbors = new ArrayList<>();
        List<Direction> plipNeighbors = new ArrayList<>();
        for (Direction key : neighbors.keySet()) {
            if (neighbors.get(key).name().equals("empty")) {
                emptyNeighbors.add(key);
            }
            else if (neighbors.get(key).name().equals("plip")) {
                plipNeighbors.add(key);
            }
        }

        // Rule 1
        if (emptyNeighbors.isEmpty()) {
            return  new Action(Action.ActionType.STAY);
        }

        // Rule 2
        if (!plipNeighbors.isEmpty()) {
            int randomIndex = new Random().nextInt(plipNeighbors.size());
            return  new Action(Action.ActionType.ATTACK, plipNeighbors.get(randomIndex));
        }

        // Rule 3
        if (energy >= 1.0) {
            int randomIndex = new Random().nextInt(emptyNeighbors.size());
            return  new Action(Action.ActionType.REPLICATE, emptyNeighbors.get(randomIndex));
        }

        // Rule 4
        int randomIndex = new Random().nextInt(emptyNeighbors.size());
        return  new Action(Action.ActionType.MOVE, emptyNeighbors.get(randomIndex));
    }
}

