package models;

import io.ebean.DB;
import io.ebean.Ebean;
import io.ebean.Finder;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class QA extends GenericModel{

    private String question;
    private String answer;
    
    public static final Finder<Integer, QA> find = new Finder<>(QA.class);

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
