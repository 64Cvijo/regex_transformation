package transformer.service;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import transformer.TransformerApplication;
import transformer.common.RequestElement;
import transformer.parsers.Transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransformerService {

    public List<Pair<String, String>> run(List<RequestElement> request){
        List<Pair<String, String>> results = new ArrayList<>();

        results = request.stream()
                .map(reqElem -> Pair.of(reqElem.getValue(), goThroughTransformations(reqElem)))
                .collect(Collectors.toList());

        return results;
    }

    public String goThroughTransformations(RequestElement requestElement) {
        List<Transformer> transformerList = requestElement.getTransformerList();
        return transformerList.stream()
                .reduce(requestElement.getValue(),
                        (currentValue, transformer) -> transformer.operation(currentValue),
                        (v1, v2) -> v2);  // Combiner function is not used in sequential streams
    }
}
