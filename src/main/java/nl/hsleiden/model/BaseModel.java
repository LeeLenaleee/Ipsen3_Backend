package nl.hsleiden.model;

import javax.persistence.*;

/**
 * @author Kasper
 * Represents a base model, which has a primary identifier key.
 */
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}