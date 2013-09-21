package org.lakaz.hibernatetest.model.mapping;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: dustin
 * Date: 9/21/13
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Employee {
    @Id @GeneratedValue private int id;

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }
    @OneToOne(fetch=FetchType.LAZY)
    private Street street;

}
