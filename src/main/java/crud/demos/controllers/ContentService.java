package crud.demos.controllers;

import act.controller.annotation.UrlContext;
import crud.controllers.MorphiaCrud;
import crud.demos.models.Content;
import org.bson.types.ObjectId;

@UrlContext("api/v1/content")
public class ContentService extends MorphiaCrud<ObjectId, Content> {
}
