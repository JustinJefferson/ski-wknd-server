package models;

import io.ebean.Ebean;
import io.ebean.Model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GenericModel extends Model {

    @Id
    private Integer id;

    public GenericModel load() {
        return Ebean.find(this.getClass(), this.getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
