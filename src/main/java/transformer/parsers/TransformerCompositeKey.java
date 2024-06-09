package transformer.parsers;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
public class TransformerCompositeKey implements Serializable {

    @NonNull
    private String groupId;
    @NonNull
    private String transformerId;

}
