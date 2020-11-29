package crud.controllers;

import crud.demos.models.Content;
import org.osgl.mvc.annotation.PostAction;

import javax.validation.Valid;

public class Gh1129 {
    @PostAction("test")
    public String test(@Valid Content obj) {
        return "test";
    }
}
