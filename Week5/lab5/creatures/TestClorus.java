package creatures;
import huglife.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;

public class TestClorus {
    @Test
    public void testReplicate() {
        Clorus old = new Clorus(2);
        Clorus baby = old.replicate();
        assertEquals(old.energy(),baby.energy(),0);
    }

    @Test
    public void testAttack() {
        Plip p = new Plip(0.3);
        Clorus c = new Clorus(1.1);
        c.attack(p);
        assertEquals(c.energy(), 1.4, 0.01);
    }

    @Test
    public void testChoose() {
        // No empty adjacent spaces; stay.
        Clorus p = new Clorus(1.2);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        Action actual = p.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);
        assertEquals(expected, actual);

        //Only one empty neighbor , no plips , energy greater than one . it must replicate
        Clorus p1 = new Clorus(1.2);
        HashMap<Direction, Occupant> oneEmpty = new HashMap<Direction, Occupant>();
        oneEmpty.put(Direction.TOP, new Empty());
        oneEmpty.put(Direction.BOTTOM, new Impassible());
        oneEmpty.put(Direction.LEFT, new Impassible());
        oneEmpty.put(Direction.RIGHT, new Impassible());

        Action actual1 = p1.chooseAction(oneEmpty);
        Action expected1 = new Action(Action.ActionType.REPLICATE, Direction.TOP);
        assertEquals(expected1, actual1);

        //Only one empty neighbor , no plips , energy less than one . it must move
        Clorus p2 = new Clorus(0.2);
        HashMap<Direction, Occupant> oneEmptyMove = new HashMap<Direction, Occupant>();
        oneEmptyMove.put(Direction.TOP, new Empty());
        oneEmptyMove.put(Direction.BOTTOM, new Impassible());
        oneEmptyMove.put(Direction.LEFT, new Impassible());
        oneEmptyMove.put(Direction.RIGHT, new Impassible());

        Action actual2 = p2.chooseAction(oneEmptyMove);
        Action expected2 = new Action(Action.ActionType.MOVE, Direction.TOP);
        assertEquals(expected2, actual2);

        //One plip is seen
        Plip x = new Plip(1.0);
        Clorus c = new Clorus(0.5);
        HashMap<Direction, Occupant> plipSeen = new HashMap<Direction, Occupant>();
        plipSeen.put(Direction.TOP, new Empty());
        plipSeen.put(Direction.LEFT, x);
        plipSeen.put(Direction.RIGHT, new Empty());
        plipSeen.put(Direction.BOTTOM, new Empty());

        Action theActual = c.chooseAction(plipSeen);
        Action theExpected = new Action(Action.ActionType.ATTACK, Direction.LEFT);
        assertEquals(theActual, theExpected);
    }
}
