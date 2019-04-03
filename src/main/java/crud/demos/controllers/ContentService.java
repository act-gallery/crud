package crud.demos.controllers;

import act.controller.annotation.UrlContext;
import crud.controllers.CrudJpa;
import crud.demos.models.Content;

import java.util.HashMap;
import java.util.Map;

@UrlContext("api/v1/content")
public class ContentService extends CrudJpa<Long, Content> {
    @Override
    protected Content showHook(Content obj) {
        Map<String, Object> ctg = new HashMap<>();
        Map<String, Object> parentCtg = new HashMap<>();
        parentCtg.put("name", "parentCtg");
        parentCtg.put("order", 3);

        ctg.put("name", "ctg");
        ctg.put("order", 1);
        ctg.put("parent", parentCtg);

        obj.inner = ctg;

        return obj;
    }
}
