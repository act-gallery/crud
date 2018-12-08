package crud.demos.controllers;

import act.app.util.SimpleRestfulServiceBase;
import act.controller.annotation.UrlContext;
import act.db.jpa.JPADao;
import crud.controllers.Crud;
import crud.demos.models.Bookmark;
import org.osgl.mvc.annotation.GetAction;

import javax.inject.Inject;

@UrlContext("api/v1/bookmarks")
public class BookmarkService extends Crud<Long, Bookmark> {// extends SimpleRestfulServiceBase<Integer, Bookmark, JPADao<Integer, Bookmark>> {

    @Inject
    public JPADao<Integer, Bookmark> dao;

    @GetAction("test")
    public Bookmark testCreate() {
        Bookmark b5 = new Bookmark();
        b5.name = "test5";
        b5.url = "url5";
        return dao.save(b5);
    }
}