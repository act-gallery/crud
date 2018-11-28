package crud.demos.controllers;

import act.controller.annotation.UrlContext;
import crud.controllers.Crud;
import crud.demos.models.User;
import org.osgl.mvc.annotation.GetAction;

@UrlContext("api/v1/users")
public class UserController extends Crud<Long, User> {

    @GetAction("test")
    public User testCreate() throws Exception {
        User u1 = new User();
        u1.name = "test12";
        u1.age = 32;
        throw new Exception("error occured");
        //return dao.save(u1);
    }
}
