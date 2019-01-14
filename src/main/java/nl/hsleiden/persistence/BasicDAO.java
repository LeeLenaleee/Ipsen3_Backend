package nl.hsleiden.persistence;

import org.hibernate.Session;

public interface BasicDAO<T> {
    Session currentSession();
}
