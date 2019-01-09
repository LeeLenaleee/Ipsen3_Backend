package nl.hsleiden.service;

import nl.hsleiden.model.BriefModel;
import nl.hsleiden.persistence.BriefDAO;
import nl.hsleiden.utility.PDFWriter;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.NotFoundException;
import java.io.File;
import java.util.Optional;

@Singleton
public class BriefService extends BaseService<BriefModel, BriefDAO> {
    @Inject
    public BriefService(BriefDAO dao){super(dao); }
//    public File getById(int briefId) {
//        Optional<BriefModel> brief = briefDAO.getByBriefId(briefId);
//        if(brief.isPresent()){
//            return PDFWriter.maakBrief(brief.get());
//        }else throw new NotFoundException("Not found");
//    }
}
