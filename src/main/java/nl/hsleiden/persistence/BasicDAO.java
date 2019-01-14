package nl.hsleiden.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface BasicDAO<T> {
    Session currentSession();
}
