package org.lakaz.hibernatetest.model;

/**
 * Created with IntelliJ IDEA.
 * User: dustin
 * Date: 9/21/13
 * Time: 2:19 PM
 * To change this template use File | Settings | File Templates.
 */
import javax.persistence.*;

@Entity
public class EnumeratedTypes {
    @Id @GeneratedValue private int id;

    public Test getPlayerType() {
        return playerType;
    }

    public void setPlayerType(Test playerType) {
        this.playerType = playerType;
    }
    // can also annotate it with
    // @Enumerated(STRING) so that
    // it persists the string name
    // instead of the ordinal
    private Test playerType;

}
