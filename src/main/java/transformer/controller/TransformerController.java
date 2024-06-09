package transformer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import transformer.common.RequestElement;
import transformer.service.TransformerService;


import java.util.List;

@RestController
@RequestMapping("/transform")
@Slf4j
@RequiredArgsConstructor
public class TransformerController {

    private final TransformerService transformerService;

    @RequestMapping(
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public List<Pair<String, String>> transform(@RequestBody List<RequestElement> request) {
        return transformerService.run(request);
    }
}
