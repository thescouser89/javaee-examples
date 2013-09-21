package org.lakaz.hibernatetest.model.mapping;
import javax.persistence.*;
/**
 * Created with IntelliJ IDEA.
 * User: dustin
 * Date: 9/21/13
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */


// @ManyToOne is the owner
// @OneToMany is the ownee
// there is also @Embedded and @Embeddable
// one-to-many unidirectional will use a join table
// many-to-many will also use a join table
@Entity
public class Street {
    @Id @GeneratedValue private int id;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @OneToOne(mappedBy="street")
    private Employee employee;
}
