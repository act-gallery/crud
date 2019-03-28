package crud.demos.controllers;

import act.controller.annotation.UrlContext;
import crud.controllers.CrudMorphia;
import crud.demos.models.Bookmark;
import org.bson.types.ObjectId;

@UrlContext("api/v1/bookmark")
public class BookmarkService extends CrudMorphia<ObjectId, Bookmark> {
    // extends SimpleRestfulServiceBase<Integer, Bookmark, JPADao<Integer, Bookmark>> {

}