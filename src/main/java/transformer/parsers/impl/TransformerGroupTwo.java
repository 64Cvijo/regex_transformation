package transformer.parsers.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import transformer.parsers.Transformer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Data
@RequiredArgsConstructor
public class TransformerGroupTwo implements Transformer {

    @JsonProperty("transformerId")
    private Integer transformerId;

    @JsonProperty("regex")
    private String regex;

    @JsonProperty("replacement")
    private String replacement;

    @Override
    public String operation(String value) {
        if (regex == null || replacement == null || value == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.replaceAll(replacement);
    }
}
