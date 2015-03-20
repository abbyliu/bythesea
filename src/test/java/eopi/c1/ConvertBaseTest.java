package eopi.c1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertBaseTest {

    @Test
    public void testConvertBase() throws Exception {
        ConvertBase c = new ConvertBase();
        assertEquals("1a9", c.convertBase("617", 7, 13));
    }
}