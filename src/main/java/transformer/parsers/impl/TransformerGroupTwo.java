package transformer.parsers.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import transformer.parsers.Transformer;
import transformer.parsers.TransformerCompositeKey;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class TransformerGroupTwo extends TransformerCompositeKey implements Transformer {

    @JsonProperty("regex")
    private String regex;

    @JsonProperty("replacement")
    private String replacement;

    public String operation(String value) {
        if (regex == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.replaceAll(replacement);
    }
}
