package models;

import io.ebean.DB;
import io.ebean.Ebean;
import io.ebean.Finder;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class QA extends GenericModel{

    @Column(name="order_num")
    private Integer orderNum;
    private String question;
    private String answer;
    
    public static final Finder<Integer, QA> FIND = new Finder<>(QA.class);

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

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
