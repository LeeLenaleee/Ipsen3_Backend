package nl.hsleiden.utility;

import nl.hsleiden.model.BriefModel;
import nl.hsleiden.model.FactuurModel;
import nl.hsleiden.model.OfferteModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * De Klasse verantwoordelijk voor het maken van een facturen en offertes in PDF.
 *
 * @author Jacco
 */
public final class PDFWriter {
    private static final Logger LOGGER = Logger.getLogger(PDFWriter.class.getName());
    private static final String DATUMFIELDACROFROM = "datum";
    private static String template = "./src/main/java/nl/hsleiden/pdfFiles/templates/";
    private static String tempfileLoc = "./src/main/java/nl/hsleiden/pdfFiles/temp/temp.pdf";
    private static PDDocument pdDocument;

    private PDFWriter() {
        //not called
    }

    private static void loadDoc(File file) {
        try {
            pdDocument = PDDocument.load(file);
        } catch (IOException e) {
            LOGGER.log(Level.FINE, e.toString(), e);
        }
    }

    private static File safe() {
        File temp = new File(tempfileLoc);
        try {
            pdDocument.save(temp);
            pdDocument.close();
        } catch (IOException e) {
            LOGGER.log(Level.FINE, e.toString(), e);
        }
        return temp;
    }

    private static void makePrivate(PDField[] array) {
        for (PDField x : array) {
            x.setReadOnly(true);
        }
    }

    public static File maakFactuur(FactuurModel factuur) {
        File file = new File(template + "factuurtemplate.pdf");
        loadDoc(file);

        PDDocumentCatalog pdDocumentCatalog = pdDocument.getDocumentCatalog();
        PDAcroForm pdAcroForm = pdDocumentCatalog.getAcroForm();

        if (pdAcroForm != null) {
            PDField datumField = pdAcroForm.getField(DATUMFIELDACROFROM);
            PDField omschrijvingField = pdAcroForm.getField("omschrijving");
            PDField brutoKostenField = pdAcroForm.getField("bruto");
            PDField btwKostenField = pdAcroForm.getField("btwprijs");
            PDField nettoKostenField = pdAcroForm.getField("netto");
            PDField btwPercentageField = pdAcroForm.getField("btwpercentage");
            PDField factuurNummerField = pdAcroForm.getField("factuurNummer");
            PDField datum2Field = pdAcroForm.getField("datum2");

            try {
                datumField.setValue(factuur.getAfleverDatum());
                datum2Field.setValue(factuur.getDatum());
                omschrijvingField.setValue(factuur.getFactuurOmschrijving());
                brutoKostenField.setValue(Double.toString(factuur.getBrutoKosten()));
                btwKostenField.setValue(Double.toString(factuur.getBtwKosten()));
                nettoKostenField.setValue(Double.toString(factuur.getNettoKosten()));
                btwPercentageField.setValue(Double.toString(factuur.getBtwPercentage()));
                factuurNummerField.setValue(Integer.toString(factuur.getId()));
            } catch (IOException e) {
                LOGGER.log(Level.FINE, e.toString(), e);
            }
            PDField[] fieldArray = {datum2Field, datumField, omschrijvingField, brutoKostenField, btwKostenField, nettoKostenField, btwPercentageField, factuurNummerField};
            makePrivate(fieldArray);

        }
        return safe();
    }

    public static File maakOfferte(OfferteModel offerte) {
        File file = new File(template + "offertetemplate.pdf");
        loadDoc(file);

        PDDocumentCatalog pdDocumentCatalog = pdDocument.getDocumentCatalog();
        PDAcroForm pdAcroForm = pdDocumentCatalog.getAcroForm();

        if (pdAcroForm != null) {
            PDField datumField = pdAcroForm.getField(DATUMFIELDACROFROM);
            PDField corespondentieNummerField = pdAcroForm.getField("corespondentieNummer");
            PDField naamKlantField = pdAcroForm.getField("naamKlant");
            PDField offerteNummerField = pdAcroForm.getField("offerteNummer");
            PDField urenField = pdAcroForm.getField("uren");
            PDField btwPercentageField = pdAcroForm.getField("btwPercentage");
            PDField kostenBrutoField = pdAcroForm.getField("kostenBruto");
            PDField kostenBTWField = pdAcroForm.getField("kostenBTW");
            PDField kostenNettoField = pdAcroForm.getField("kostenNetto");

            try {
                datumField.setValue(offerte.getDatum());
                corespondentieNummerField.setValue(Integer.toString(offerte.getCorrespondentienummer()));
                naamKlantField.setValue(offerte.getNaamklant());
                offerteNummerField.setValue(Integer.toString(offerte.getId()));
                urenField.setValue(Double.toString(offerte.getUren()));
                btwPercentageField.setValue(Double.toString(offerte.getBtwPercentage()));
                kostenBrutoField.setValue(Double.toString(offerte.getKostenBruto()));
                kostenBTWField.setValue(Double.toString(offerte.getKostenBTW()));
                kostenNettoField.setValue(Double.toString(offerte.getKostenNetto()));
            } catch (IOException e) {
                LOGGER.log(Level.FINE, e.toString(), e);
            }
            PDField[] fieldArray = {datumField, corespondentieNummerField, naamKlantField, offerteNummerField, urenField, btwPercentageField, kostenBrutoField, kostenBTWField, kostenNettoField};
            makePrivate(fieldArray);
        }
        return safe();
    }

    public static File maakBrief(BriefModel brief) {
        File file = new File(template + "brief.pdf");
        loadDoc(file);

        PDDocumentCatalog pdDocumentCatalog = pdDocument.getDocumentCatalog();
        PDAcroForm pdAcroForm = pdDocumentCatalog.getAcroForm();

        if (pdAcroForm != null) {
            PDField date = pdAcroForm.getField(DATUMFIELDACROFROM);
            PDField recierver = pdAcroForm.getField("geadreseerde");
            PDField adres = pdAcroForm.getField("adress");
            PDField letter = pdAcroForm.getField("text");

            try {
                date.setValue(brief.getDatum());
                recierver.setValue(brief.getBetreft());
                adres.setValue(brief.getAdressering());
                letter.setValue(brief.getVerhaal());
            } catch (IOException e) {
                LOGGER.log(Level.FINE, e.toString(), e);
            }
            PDField[] fieldArray = {date, recierver, adres, letter};
            makePrivate(fieldArray);
        }
        return safe();
    }

}
