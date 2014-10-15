package uk.co.valtech.gridletters;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static uk.co.valtech.gridletters.domain.Units.*;

public class OsgbPointToReferenceTest {
    private OsgbPointToReference instance;

    @Before
    public void setUp() throws Exception {
        instance = new OsgbPointToReference();
    }


    @Test
    public void originShouldBeTranslatedCorrectly() throws Exception {
        int eastings = 0;
        int northings = 0;
        String expectedGrid = "SV0000000000";

        assertThat("Grid reference of: "+eastings+", "+northings+" failed",
                instance.convert(eastings, northings), is(expectedGrid));
    }

    @Test
    public void positivePointFarFromOrigin() throws Exception {
        int eastings  = 3 * KM_2500 + 5 * KM_100 + 1 * KM_10 + 2 * KM_1 + 3 * M_100 + 4 * M_10 + 5 * M_1;
        int northings = 2 * KM_2500 + 2 * KM_100 + 6 * KM_10 + 7 * KM_1 + 8 * M_100 + 9 * M_10 + 0 * M_1;
        String expectedGrid = "TL1234567890";

        assertThat("Grid reference of: "+eastings+", "+northings+" failed",
                instance.convert(eastings, northings), is(expectedGrid));
    }
}