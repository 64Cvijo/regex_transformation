package transformer.unit;

import org.junit.jupiter.api.Test;
import transformer.parsers.impl.TransformerGroupOne;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransformerGroupOneTest {

    @Test
    void testDigitsRemoval() {
        TransformerGroupOne transformer = new TransformerGroupOne();
        transformer.setTransformerId(1);
        transformer.setRegex("\\d");

        String input = "Hello123 and so on 64";
        String expectedOutput = "Hello and so on ";
        String actualOutput = transformer.operation(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testVowelRemoval() {
        TransformerGroupOne transformer = new TransformerGroupOne();
        transformer.setTransformerId(2);
        transformer.setRegex("[aeiouAEIOU]");

        String input = "If there is some vowels, it is ok to delete them!";
        String expectedOutput = "f thr s sm vwls, t s k t dlt thm!";
        String actualOutput = transformer.operation(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testSpecialCharacterRemoval() {
        TransformerGroupOne transformer = new TransformerGroupOne();
        transformer.setTransformerId(3);
        transformer.setRegex("[!,.]");

        String input = "Hello, World!";
        String expectedOutput = "Hello World";
        String actualOutput = transformer.operation(input);

        assertEquals(expectedOutput, actualOutput);
    }
}
