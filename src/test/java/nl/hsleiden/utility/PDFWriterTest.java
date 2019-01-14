package nl.hsleiden.utility;

import nl.hsleiden.model.BriefModel;
import nl.hsleiden.model.FactuurModel;
import nl.hsleiden.model.OfferteModel;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

import static org.junit.Assert.assertEquals;

/***
 * @author Jacco
 */
public class PDFWriterTest  {
    FactuurModel factuurModel;
    OfferteModel offerteModel;
    BriefModel briefModel;

    @Before
    public void setUp(){
        factuurModel = new FactuurModel("14-01-2019","14-01-2019","Albert 2.0 gemaakt",10,10,1.0,11.0);
        factuurModel.setId(1);
        offerteModel = new OfferteModel("14-01-2019","1","pjeter","5","5","5","5","5");
        offerteModel.setId(1);
        briefModel = new BriefModel("14-01-2019","123","pjeter","zernikdreef 11","deze story is toooooooo dam good fuur you");
        briefModel.setId(1);
    }

    @After
    public void tearDown(){
        factuurModel = null;
        offerteModel = null;
        briefModel = null;
    }

    @Test
    public void maakFactuurTest(){
        File verwachteResultaat = new File("./src/test/java/nl/hsleiden/utility/factuur.pdf");
        File daadwerkelijkeResultaat = PDFWriter.maakFactuur(factuurModel);
        String daadwerkelijkeResultaat2 = null;
        String verwachteResultaat2 = null;
        try {
            daadwerkelijkeResultaat2 = FileUtils.readFileToString(daadwerkelijkeResultaat,"utf-8");
            verwachteResultaat2 = FileUtils.readFileToString(verwachteResultaat,"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(daadwerkelijkeResultaat2, verwachteResultaat2);
    }

    @Test
    public void maakOfferteTest(){
        File verwachteResultaat = new File("./src/test/java/nl/hsleiden/utility/offerte.pdf");
        File daadwerkelijkeResultaat = PDFWriter.maakOfferte(offerteModel);
        String daadwerkelijkeResultaat2 = null;
        String verwachteResultaat2 = null;
        try {
            daadwerkelijkeResultaat2 = FileUtils.readFileToString(daadwerkelijkeResultaat,"utf-8");
            verwachteResultaat2 = FileUtils.readFileToString(verwachteResultaat,"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(daadwerkelijkeResultaat2, verwachteResultaat2);
    }

    @Test
    public void maakBriefTest(){
        File verwachteResultaat = new File("./src/test/java/nl/hsleiden/utility/brief.pdf");
        File daadwerkelijkeResultaat = PDFWriter.maakBrief(briefModel);
        String daadwerkelijkeResultaat2 = null;
        String verwachteResultaat2 = null;
        try {
            daadwerkelijkeResultaat2 = FileUtils.readFileToString(daadwerkelijkeResultaat,"utf-8");
            verwachteResultaat2 = FileUtils.readFileToString(verwachteResultaat,"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(daadwerkelijkeResultaat2, verwachteResultaat2);
    }
}
