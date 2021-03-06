package kata.berlin.clock;

/**
 * Created by Thomas on 7/6/2015.
 */

import kata.berlin.clock.core.ChronologicalSignals;
import kata.berlin.clock.formatter.BerlinUhrFormatterImpl;
import kata.berlin.clock.formatter.IComposite;
import kata.berlin.clock.formatter.IChronologicalFormatter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class BerlinUhrFormatterImplSecondsTest {
    private IChronologicalFormatter chronologicalFormatter;

    @BeforeMethod
    public void beforeMethod() {
        chronologicalFormatter = new BerlinUhrFormatterImpl();
    }

    public void shouldIndicateRedSignalWhenSecondsAreEven() {
        final String second = new String("22");

        final IComposite actualFormatted = chronologicalFormatter.formatSecond(second);

        assertEquals(actualFormatted.compose(), ChronologicalSignals.RED.getSignal(), "Signal should be RED -> R");
    }

    public void shouldIndicateOffSignalWhenSecondsAreOdd() {
        final String second = new String("15");

        final IComposite actualFormatted = chronologicalFormatter.formatSecond(second);

        assertEquals(actualFormatted.compose(), ChronologicalSignals.OFF.getSignal(), "Signal should be OFF -> O");
    }

    public void shouldIndicateEmptySignalWhenSecondsAreEmpty() {
        final String second = new String("");

        final IComposite actualFormatted = chronologicalFormatter.formatSecond(second);

        assertEquals(actualFormatted, IComposite.VOID_FORMAT, "Should have returned void format.");
    }

    public void shouldIndicateEmptySignalWhenSecondsAreNull() {
        final IComposite actualFormatted = chronologicalFormatter.formatSecond(null);

        assertEquals(actualFormatted, IComposite.VOID_FORMAT, "Should have returned void format.");
    }
}
