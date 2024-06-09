package transformer.parsers.impl;

import org.springframework.stereotype.Component;
import transformer.parsers.LetterMapper;
import transformer.parsers.Transformer;
import transformer.parsers.TransformerCompositeKey;

@Component
public class TransformerGroupThree extends TransformerCompositeKey implements Transformer {
    public String operation(String value) {
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
