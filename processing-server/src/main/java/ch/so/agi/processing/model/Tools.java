package ch.so.agi.processing.model;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class Tools {

    public static String getHost() {
        return ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
    }

}
