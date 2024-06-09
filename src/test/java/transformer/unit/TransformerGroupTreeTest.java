package transformer.unit;

import org.junit.jupiter.api.Test;
import transformer.parsers.impl.TransformerGroupThree;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransformerGroupTreeTest {

    @Test
    void testCyrillicToLatinMapping() {
        TransformerGroupThree transformer = new TransformerGroupThree();
        transformer.setTransformerId(1);

        String input = "Привет, мир!";
        String expectedOutput = "Privet, mir!";
        String actualOutput = transformer.operation(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testGreekToLatinMapping() {
        TransformerGroupThree transformer = new TransformerGroupThree();
        transformer.setTransformerId(2);

        String input = "Γεια σου Κόσμε!";
        String expectedOutput = "Geia sοy Kosme!";
        String actualOutput = transformer.operation(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testCombination() {
        TransformerGroupThree transformer = new TransformerGroupThree();
        transformer.setTransformerId(3);

        String input = "Hello, World! Γεια σου Κόσμε! Привет, мир!";
        String expectedOutput = "Hello, World! Geia sοy Kosme! Privet, mir!";
        String actualOutput = transformer.operation(input);

        assertEquals(expectedOutput, actualOutput);
    }
}
