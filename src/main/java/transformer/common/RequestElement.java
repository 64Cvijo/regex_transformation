package transformer.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import transformer.parsers.Transformer;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestElement {

    @JsonProperty("value")
    private String value;

    @JsonProperty("transformerList")
    private List<Transformer> transformerList;
}
