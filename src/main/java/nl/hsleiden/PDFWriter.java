package nl.hsleiden;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.File;
import java.io.IOException;


/**
 * De Klasse verantwoordelijk voor het maken van een facturen en offertes in PDF.
 *
 * @author Jacco
 */
public class PDFWriter {
    private static String template = "./src/main/java/nl/hsleiden/pdfFiles/templates/";
    private static String tempfileLoc = "./src/main/java/nl/hsleiden/pdfFiles/temp/";

    public static File maakFactuur(String datum, String omschrijving, String brutoKosten, String btwKosten,
                                   String nettoKosten, String btwPercentage, String factuurNummer) {

        File file = new File(template + "factuurtemplate.pdf");
        PDDocument pdDocument = null;
        try {
            pdDocument = PDDocument.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Tim zecht: aardapel");
        }

        PDDocumentCatalog pdDocumentCatalog = pdDocument.getDocumentCatalog();
        PDAcroForm pdAcroForm = pdDocumentCatalog.getAcroForm();

        if (pdAcroForm != null) {
            PDField datumField = pdAcroForm.getField("datum");
            PDField omschrijvingField = pdAcroForm.getField("omschrijving");
            PDField brutoKostenField = pdAcroForm.getField("bruto");
            PDField btwKostenField = pdAcroForm.getField("btwprijs");
            PDField nettoKostenField = pdAcroForm.getField("netto");
            PDField btwPercentageField = pdAcroForm.getField("btwpercentage");
            PDField factuurNummerField = pdAcroForm.getField("factuurNummer");
            PDField datum2Field = pdAcroForm.getField("datum2");

            try {


                datumField.setValue(datum);
                datum2Field.setValue(datum);
                omschrijvingField.setValue(omschrijving);
                brutoKostenField.setValue(brutoKosten);
                btwKostenField.setValue(btwKosten);
                nettoKostenField.setValue(nettoKosten);
                btwPercentageField.setValue(btwPercentage);
                factuurNummerField.setValue(factuurNummer);
            } catch (IOException e) {
                e.printStackTrace();
            }

            datumField.setReadOnly(true);
            datum2Field.setReadOnly(true);
            omschrijvingField.setReadOnly(true);
            brutoKostenField.setReadOnly(true);
            btwKostenField.setReadOnly(true);
            nettoKostenField.setReadOnly(true);
            btwPercentageField.setReadOnly(true);
            factuurNummerField.setReadOnly(true);

        }
        File temp = new File(tempfileLoc + "temp.pdf");
        try {
            pdDocument.save(temp);
            pdDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static File maakOfferte(String datum, String corespondentieNummer, String naamKlant, String offerteNummer, String uren,
                                   String btwPercentage, String kostenBruto, String kostenBTW, String kostenNetto) throws IOException {
        File file = new File(template + "offertetemplate.pdf");
        PDDocument pdDocument = PDDocument.load(file);

        PDDocumentCatalog pdDocumentCatalog = pdDocument.getDocumentCatalog();
        PDAcroForm pdAcroForm = pdDocumentCatalog.getAcroForm();

        if (pdAcroForm != null) {
            PDField datumField = pdAcroForm.getField("datum");
            PDField corespondentieNummerField = pdAcroForm.getField("corespondentieNummer");
            PDField naamKlantField = pdAcroForm.getField("naamKlant");
            PDField offerteNummerField = pdAcroForm.getField("offerteNummer");
            PDField urenField = (PDField) pdAcroForm.getField("uren");
            PDField btwPercentageField = pdAcroForm.getField("btwPercentage");
            PDField kostenBrutoField = pdAcroForm.getField("kostenBruto");
            PDField kostenBTWField = pdAcroForm.getField("kostenBTW");
            PDField kostenNettoField = pdAcroForm.getField("kostenNetto");


            datumField.setValue(datum);
            corespondentieNummerField.setValue(corespondentieNummer);
            naamKlantField.setValue(naamKlant);
            offerteNummerField.setValue(offerteNummer);
            urenField.setValue(uren);
            btwPercentageField.setValue(btwPercentage);
            kostenBrutoField.setValue(kostenBruto);
            kostenBTWField.setValue(kostenBTW);
            kostenNettoField.setValue(kostenNetto);


            datumField.setReadOnly(true);
            corespondentieNummerField.setReadOnly(true);
            naamKlantField.setReadOnly(true);
            offerteNummerField.setReadOnly(true);
            urenField.setReadOnly(true);
            btwPercentageField.setReadOnly(true);
            kostenBrutoField.setReadOnly(true);
            kostenBTWField.setReadOnly(true);
            kostenNettoField.setReadOnly(true);
        }
        File temp = new File(tempfileLoc + "temp.pdf");
        pdDocument.save(temp);
        pdDocument.close();
        return temp;
    }

    public static File maakBrief(String datum, String brief, String ontvanger, String adress) throws IOException {
        File file = new File(template + "brief.pdf");
        PDDocument pdDocument = PDDocument.load(file);

        PDDocumentCatalog pdDocumentCatalog = pdDocument.getDocumentCatalog();
        PDAcroForm pdAcroForm = pdDocumentCatalog.getAcroForm();

        if (pdAcroForm != null) {
            PDField date = pdAcroForm.getField("datum");
            PDField recierver = pdAcroForm.getField("geadreseerde");
            PDField adres = pdAcroForm.getField("adress");
            PDField letter = pdAcroForm.getField("text");

            date.setValue(datum);
            recierver.setValue(ontvanger);
            adres.setValue(adress);
            letter.setValue(brief);

            date.setReadOnly(true);
            recierver.setReadOnly(true);
            adres.setReadOnly(true);
            letter.setReadOnly(true);
        }
        File temp = new File(tempfileLoc + "temp.pdf");
        pdDocument.save(temp);
        pdDocument.close();
        return temp;
    }

}
