
import org.improving.tag.Game;
import org.improving.tag.commands.SetCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SetNameTests {
    SetCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange() {

        io = new TestInputOutput();
        target = new SetCommand(io);

    }

    @Test
    public void execute_should_display_all_words_but_atSetNameEquals() {
        // act

        target.execute("@set name=Fluefedor", new Game(null, null));

        // assert
        assertEquals("Your name is now Fluefedor.", io.lastText);
    }

    @Test
    public void execute_should_display_all_words_but_atSetNameEquals_with_spaces() {
        // act
        target.execute("     @set name=Fluefedor    ", new Game(null, null));
        // assert
        assertEquals("Your name is now Fluefedor.", io.lastText);
    }

    @Test
    public void isValid_should_be_true_when_input_is_setName() {

        // Act
        var result = target.isValid("@set name=Fluefedor", null);
        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_setName_with_spaces() {

        // Act
        var result = target.isValid("@set name=Fluefedor ", null);
        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_setName_with_caps() {

        // Act
        var result = target.isValid("@Set nAmE=FLUEfedor", null);
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

    @Test
    public void isValid_should_be_false_when_input_is_only_word() {

        var result = target.isValid("@set", null);
        // Assert
        assertFalse(result);
    }

}
