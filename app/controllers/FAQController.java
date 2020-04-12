package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.QA;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.util.List;

public class FAQController extends Controller {

    public Result save(Http.Request request){
        JsonNode json = request.body().asJson();
        if(json == null) return badRequest();

        QA qa = new QA();
        qa.setQuestion(json.findPath("question").textValue());
        qa.setAnswer(json.findPath("answer").textValue());
        qa.save();
        return ok(qa.getId().toString());
    }

    public Result index() {
        JsonNode json = Json.toJson(QA.find.all());
        return ok(json);
    }

    public Result saveIndex(Http.Request request) {
        JsonNode json = request.body().asJson();
        if(json == null) return badRequest();
//        List<QA> list = Json.fromJson(json, List.class);

        return ok();
    }

    public Result indexAt(Http.Request request, Integer id) {
        return ok(Json.toJson(QA.find.byId(id)));
    }


}
