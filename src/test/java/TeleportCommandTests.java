import org.improving.tag.InputOutput;
import org.improving.tag.commands.TeleportCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeleportCommandTests {

    TeleportCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange() {

        io = new TestInputOutput();
        target = new TeleportCommand(io);
    }

    @Test
    public void execute_should_return_phrase() {
        // act
        target.execute(null, null);

        //
        assertEquals("You phase out of existence.",  io.lastText);

    }

    @Test
    public void isValid_should_be_true_when_input_is_dance() {

        // Act
        var result = target.isValid("teleport", null);
        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_dance_with_spaces() {

        // Act
        var result = target.isValid("  teleport   ", null);
        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_dance_with_caps() {

        // Act
        var result = target.isValid("teLEPORt", null);
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


