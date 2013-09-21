package org.lakaz.hibernatetest.model;

import javax.persistence.*;

import java.util.Date;
@Entity
public class ToDo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="SUMMARY")
  private String summary;
  @Basic(fetch=FetchType.LAZY)
  private String description;

  // use @Temporal when using java.util.Date instead
  // of java.sql.Date
  @Temporal(TemporalType.DATE)
  private Date date;

  // not persistent
  @Transient private int haha;

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "################ Todo [summary=" + summary + ", description=" + description
        + "] ###########################";
  }

}