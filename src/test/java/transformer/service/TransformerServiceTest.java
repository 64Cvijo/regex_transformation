package transformer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.util.Pair;
import transformer.common.RequestElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TransformerServiceTest {


    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TransformerService transformerService;

    @Test
    public void testTransformEndpoint() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + "inputForTesting.json");
        String inputJson = new String(resource.getInputStream().readAllBytes());
        List<RequestElement> request = objectMapper.readValue(inputJson, objectMapper.getTypeFactory().constructCollectionType(List.class, RequestElement.class));

        List<Pair<String, String>> expectedOutput = new ArrayList<>();
        expectedOutput.add(Pair.of("Grepling123", "Grepling"));
        expectedOutput.add(Pair.of("Hello World", "Hello_World"));
        expectedOutput.add(Pair.of("Hello World", "Hll Wrld"));
        expectedOutput.add(Pair.of("Привет, мир! Γειά σου Κόσμε!", "Privet, mir! Geiά sοy Kosme!"));
        expectedOutput.add(Pair.of("Bla 123 Bla", "Bla__Bla"));
        expectedOutput.add(Pair.of("Hello World! Привет, мир! Γειά σου Κόσμε!", "Hll_Wrld!_Privet,_mir!_Geiά_sοy_Kosme!"));
        expectedOutput.add(Pair.of("Bla, Bla!", "Bla Bla"));
        expectedOutput.add(Pair.of("Bla    Bla", "Bla Bla"));
        expectedOutput.add(Pair.of("Hello 123 World", "Hello--World"));
        expectedOutput.add(Pair.of("Hello, Привет!", "Hi, Privet!"));

        List<Pair<String, String>> result = transformerService.run(request);

        assertEquals(expectedOutput, result);
    }
}
