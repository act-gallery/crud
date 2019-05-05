package crud.demos.controllers;

import act.controller.annotation.UrlContext;
import crud.controllers.CrudJpa;
import crud.demos.models.Content;
import crud.demos.models.User;
import crud.util.RequestData;
import org.osgl.mvc.annotation.PostAction;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@UrlContext("api/v1/content")
public class ContentService extends CrudJpa<Long, Content> {

    @Inject
    BookmarkService bookmarkService;

    @Inject
    UserController userService;

    @Override
    protected Content showHook(@Valid Content obj, RequestData d) {
        Map<String, Object> ctg = new HashMap<>();
        Map<String, Object> parentCtg = new HashMap<>();
        parentCtg.put("name", "parentCtg");
        parentCtg.put("order", 3);

        ctg.put("name", "ctg");
        ctg.put("order", 1);
        ctg.put("parent", parentCtg);

        obj.inner = ctg;

        User user = new User();
        user.name = "user1";
        user.age = 15;

        obj.author = user;

        userService.list(null, d);

        return obj;
    }

    @PostAction("test")
    public String test(@Valid Content obj) {
        Map<String, Object> ctg = new HashMap<>();
        Map<String, Object> parentCtg = new HashMap<>();
        parentCtg.put("name", "parentCtg");
        parentCtg.put("order", 3);

        ctg.put("name", "ctg");
        ctg.put("order", 1);
        ctg.put("parent", parentCtg);

        obj.inner = ctg;

        User user = new User();
        user.name = "user1";
        user.age = 15;

        obj.author = user;
        return "test";
    }
}
