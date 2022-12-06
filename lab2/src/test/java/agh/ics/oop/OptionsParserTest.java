package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {

    @Test
    void ParseProperValueTest()
    {
        String[] args = {"f", "right", "l"};
        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.LEFT};
        assertArrayEquals(expected, OptionsParser.parse(args));
    }
    @Test
    void ParseCapitalizationTest(){
        String[] args = {"f", "Right", "L"};
        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.LEFT};
        assertArrayEquals(expected, OptionsParser.parse(args));
    }

    @Test
    void ParseWrongValueTest(){
        String[] args = {"f","a", "Right", "L", "skjd"};
        Exception ex = assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(args));
        assertTrue(ex.getMessage().contains("is not legal move specification"));
    }
}
