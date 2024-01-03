package ch.so.agi.processing.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class ProcessesApi {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    final static String BASE_URL = LandingPageApi.BASE_URL + "/processes";

    @GetMapping(value = BASE_URL, produces = MediaTypes.APPLICATION_JSON)
    @ResponseBody
    ProcessCollection getProcesses() {
        
    }

}
