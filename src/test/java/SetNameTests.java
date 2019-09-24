
import org.improving.tag.Game;
import org.improving.tag.Player;
import org.improving.tag.commands.SetCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class SetNameTests {
    SetCommand target;
    TestInputOutput io;
    Game game;
    @BeforeEach
    public void arrange() {
        io = new TestInputOutput();
        target = new SetCommand(io);
        game = mock(Game.class); // giving mock all the properties of class, making a mock version of it to test in, kind of
        //like a fake mock to use for the test
        /*
        Player player = new Player();
        player.setName("hi");
        player.setHitPoints(50);

        when(game.getPlayer()).thenReturn(player); // verifying that when game.getPlayer is called, it is returning the statement
    */
    }

    @Test
    public void execute_should_display_all_words_but_atSetNameEquals() {
        Player player = new Player(null); // passing in null because tests are only testing the name set, not paramenters
        player.setName("hi");
        player.setHitPoints(50);
        player = spy(player); // spying on the player
        when(game.getPlayer()).thenReturn(player);
        //act
        target.execute("@set name=Fluefedor",game);
        // assert
        verify(player).setName("Fluefedor");
    }

    @Test
    public void isValid_should_be_true_when_input_is_setName() {
        // Act
        var result = target.isValid("@set name=Fluefedor", null);
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
