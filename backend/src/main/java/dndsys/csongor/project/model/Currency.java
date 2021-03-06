package dndsys.csongor.project.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="currencies")
public class Currency extends BaseEntity {
    @NaturalId
    private String name;

    public Currency(){}

    public Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
