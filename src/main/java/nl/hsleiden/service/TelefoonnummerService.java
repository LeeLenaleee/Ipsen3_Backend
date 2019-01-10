package nl.hsleiden.service;

import nl.hsleiden.model.TelefoonnummerModel;
import nl.hsleiden.persistence.TelefoonnummerDAO;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TelefoonnummerService extends BaseService<TelefoonnummerModel, TelefoonnummerDAO> {

    @Inject
    public TelefoonnummerService(TelefoonnummerDAO dao) {
        super(dao);
    }
}
