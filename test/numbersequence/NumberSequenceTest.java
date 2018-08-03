package numbersequence;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NumberSequenceTest {

    @Parameterized.Parameter
    public int[] fInput;

    @Parameterized.Parameter
    public int[] fExpected;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[]{10, 2}, new int[]{}}, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
        });
    }


    
    public void numberSequenceCreator() {
        NumberSequence numberSequence = NumberSequence.numberSequenceCreator(fInput[0], fInput[1]);
//        int[] actual
//        assertEquals();
    }
}