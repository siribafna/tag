
import org.improving.tag.InputOutput;
        import org.improving.tag.commands.JumpCommand;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

    public class JumpCommandTests {

    JumpCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange() {

        io = new TestInputOutput();
        target = new JumpCommand(io);
    }

    @Test
    public void execute_should_return_phrase() {
        // act
        target.execute(null);

        //
        assertEquals("You jump around.",  io.lastText);

    }

    @Test
    public void isValid_should_be_true_when_input_is_dance() {

        // Act
        var result = target.isValid("jump");
        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_dance_with_spaces() {

        // Act
        var result = target.isValid("  jump   ");
        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_dance_with_caps() {

        // Act
        var result = target.isValid("JumP");
        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_foobar() {

        var result = target.isValid("foobar");
        // Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_null() {

        var result = target.isValid(null);
        // Assert
        assertFalse(result);
    }
}
