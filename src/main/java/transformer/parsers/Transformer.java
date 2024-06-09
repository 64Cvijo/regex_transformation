package transformer.parsers;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import transformer.parsers.impl.TransformerGroupOne;
import transformer.parsers.impl.TransformerGroupThree;
import transformer.parsers.impl.TransformerGroupTwo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "groupId")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TransformerGroupOne.class, name = "1"),
        @JsonSubTypes.Type(value = TransformerGroupTwo.class, name = "2"),
        @JsonSubTypes.Type(value = TransformerGroupThree.class, name = "3")
})
public interface Transformer {

    String operation(String currentValue);
}
