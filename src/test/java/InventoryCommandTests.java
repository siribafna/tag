import org.improving.tag.InputOutput;
import org.improving.tag.commands.InventoryCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryCommandTests {

    InventoryCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange() {

        io = new TestInputOutput();
        target = new InventoryCommand(io);
    }

    @Test
    public void execute_should_return_phrase() {
        // act
        target.execute(null, null);

        //
        assertEquals("You are carrying nothing.",  io.lastText);

    }

    @Test
    public void isValid_should_be_true_when_input_is_dance() {

        // Act
        var result = target.isValid("inventory", null);
        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_dance_with_spaces() {

        // Act
        var result = target.isValid("  inventory   ", null);
        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_dance_with_caps() {

        // Act
        var result = target.isValid("inveNTORY", null);
        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_foobar() {

        var result = target.isValid("foobar", null);
        // Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_null() {

        var result = target.isValid(null, null);
        // Assert
        assertFalse(result);
    }
}

