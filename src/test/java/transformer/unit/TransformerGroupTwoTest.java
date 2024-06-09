package transformer.unit;

import org.junit.jupiter.api.Test;
import transformer.parsers.impl.TransformerGroupTwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransformerGroupTwoTest {

    @Test
    void testReplaceDigitsWithX() {
        TransformerGroupTwo transformer = new TransformerGroupTwo();
        transformer.setTransformerId(1);
        transformer.setRegex("\\d");
        transformer.setReplacement("X");

        String input = "Hello123 and so on 64";
        String expectedOutput = "HelloXXX and so on XX";
        String actualOutput = transformer.operation(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testWhitespaceReplacement() {
        TransformerGroupTwo transformer = new TransformerGroupTwo();
        transformer.setTransformerId(2);
        transformer.setRegex("\\s");
        transformer.setReplacement("_");

        String input = "If there are some spaces, they should be replaced!";
        String expectedOutput = "If_there_are_some_spaces,_they_should_be_replaced!";
        String actualOutput = transformer.operation(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testCharacterReplacement() {
        TransformerGroupTwo transformer = new TransformerGroupTwo();
        transformer.setTransformerId(3);
        transformer.setRegex("[aeiouAEIOU]");
        transformer.setReplacement("-");

        String input = "This is a test string with some vowels";
        String expectedOutput = "Th-s -s - t-st str-ng w-th s-m- v-w-ls";
        String actualOutput = transformer.operation(input);

        assertEquals(expectedOutput, actualOutput);
    }
}
