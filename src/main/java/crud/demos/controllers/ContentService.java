package crud.demos.controllers;

import act.controller.annotation.UrlContext;
import crud.controllers.CrudJpa;
import crud.demos.models.Content;

@UrlContext("api/v1/content")
public class ContentService extends CrudJpa<Long, Content> {
}
