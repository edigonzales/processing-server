package ch.so.agi.processing.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.so.agi.processing.model.LandingPage;
import ch.so.agi.processing.model.Link;
import ch.so.agi.processing.model.Tools;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LandingPageApi {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    final static String BASE_URL = "/rest";

    @Value("${service.title}")
    private String title;

    @Value("${service.description}")
    private String description;

    @ResponseBody
    @GetMapping(value = BASE_URL, produces = MediaTypes.APPLICATION_JSON)
    public ResponseEntity<LandingPage> landingPage() {

        List<Link> links = new ArrayList<>();
        String serviceURL = Tools.getHost();
        
        Link link = new Link();
        link.setHref(serviceURL);
        link.setRel("self");
        link.setType(MediaTypes.APPLICATION_JSON);
        link.setTitle("This document");
        links.add(link);

        link = new Link();
        link.setHref(serviceURL + "/api/");
        link.setRel("service");
        link.setType(MediaTypes.APPLICATION_OPENAPI_JSON_3_0);
        link.setTitle("The API definition");
        links.add(link);

        link = new Link();
        link.setHref(serviceURL + "/conformance/");
        link.setRel("conformance");
        link.setType(MediaTypes.APPLICATION_JSON);
        link.setTitle("Conformance classes implemented by this server");
        links.add(link);

        link = new Link();
        link.setHref(serviceURL + "/processes/");
        link.setRel("processes");
        link.setType(MediaTypes.APPLICATION_JSON);
        link.setTitle("The processes offered by this server");
        links.add(link);

        // HTML...
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        LandingPage landingPage = new LandingPage().title(title).description(description).links(links);
        return new ResponseEntity<LandingPage>(landingPage, responseHeaders, HttpStatus.OK);
    }
}
