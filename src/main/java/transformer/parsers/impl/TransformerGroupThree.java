package transformer.parsers.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import transformer.parsers.LetterMapper;
import transformer.parsers.Transformer;

@Component
@Data
@RequiredArgsConstructor
public class TransformerGroupThree implements Transformer {

    @JsonProperty("transformerId")
    private Integer transformerId;
    @Override
    public String operation(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        StringBuilder result = new StringBuilder();

        for (char c : value.toCharArray()) {
            if (LetterMapper.cyrillicToLatinMap.containsKey(c)) {
                result.append(LetterMapper.cyrillicToLatinMap.get(c));
            } else if (LetterMapper.greekToLatinMap.containsKey(c)) {
                result.append(LetterMapper.greekToLatinMap.get(c));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
