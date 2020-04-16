package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.QA;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;

public class FAQController extends Controller {

    private final FormFactory formFactory;

    @Inject
    public FAQController(final FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result create(Http.Request request) {
        DynamicForm form = formFactory.form().bindFromRequest(request);
        if(form == null) return badRequest();

        QA qa = new QA();
        qa.setOrderNum(form.get("order_num") == null ? null : Integer.valueOf(form.get("order_num")));
        qa.setQuestion(form.get("question"));
        qa.setAnswer(form.get("Answer"));
        qa.save();
        return ok(qa.getId().toString());
    }

    public Result read(Integer id) {
        QA qa = QA.FIND.byId(id);
        if(qa == null) return badRequest();
        return ok(Json.toJson(qa));
    }

    public Result update(Http.Request request, Integer id){
        DynamicForm form = formFactory.form().bindFromRequest(request);
        QA qa = QA.FIND.byId(id);
        if(form == null || qa == null) return badRequest();

        qa.setOrderNum(form.get("order_num") == null ? null : Integer.valueOf(form.get("order_num")));
        qa.setQuestion(form.get("question"));
        qa.setAnswer(form.get("Answer"));
        qa.save();
        return ok(qa.getId().toString());
    }

    public Result index() {
        JsonNode json = Json.toJson(QA.FIND.all());
        return ok(json);
    }

    public Result delete(Integer id) {
        QA qa = QA.FIND.byId(id);
        if(qa == null) return badRequest();
        qa.delete();
        return ok();
    }


}
