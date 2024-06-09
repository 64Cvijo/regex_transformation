package transformer.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import transformer.parsers.Transformer;

import java.util.List;

@Data
public class RequestElement {

    @JsonProperty("value")
    String value;

    List<Transformer> transformerList;
}
