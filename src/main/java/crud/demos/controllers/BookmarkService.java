package crud.demos.controllers;

import act.controller.annotation.UrlContext;
import crud.controllers.Crud;
import crud.demos.models.Bookmark;

@UrlContext("api/v1/bookmarks")
public class BookmarkService extends Crud<Long, Bookmark> {// extends SimpleRestfulServiceBase<Integer, Bookmark, JPADao<Integer, Bookmark>> {
}