package nl.hsleiden;

import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.*;

/**
 * De Klasse verantwoordelijk voor het maken van een facturen en offertes in PDF.
 * @author Jacco
 */
public class PDFWriter {
    public File maakFactuur(String datum, String omschrijving, String brutoKosten, String btwKosten,
                                   String nettoKosten, String btwPercentage, String factuurNummer,Stage stage) throws IOException {
        File file = new File("nl/hsleiden/pdfFiles/templates/factuurtemplate.pdf");
        PDDocument pdDocument = PDDocument.load(file);

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

            datumField.setValue(datum);
            datum2Field.setValue(datum);
            omschrijvingField.setValue(omschrijving);
            brutoKostenField.setValue(brutoKosten);
            btwKostenField.setValue(btwKosten);
            nettoKostenField.setValue(nettoKosten);
            btwPercentageField.setValue(btwPercentage);
            factuurNummerField.setValue(factuurNummer);

            datumField.setReadOnly(true);
            datum2Field.setReadOnly(true);
            omschrijvingField.setReadOnly(true);
            brutoKostenField.setReadOnly(true);
            btwKostenField.setReadOnly(true);
            nettoKostenField.setReadOnly(true);
            btwPercentageField.setReadOnly(true);
            factuurNummerField.setReadOnly(true);

        }
        return new File(pdDocument);
    }

    public void maakOfferte(String datum, String corespondentieNummer, String naamKlant, String offerteNummer, String uren,
                                   String btwPercentage, String kostenBruto, String kostenBTW, String kostenNetto, Stage stage) throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)","*.pdf");
        fileChooser.getExtensionFilters().add(extensionFilter);
        fileChooser.setTitle("Open Offerte Template");

        PDDocument pdDocument = PDDocument.load(fileChooser.showOpenDialog(stage));

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


            fileChooser.setTitle("Save Offerte");
            File file = fileChooser.showSaveDialog(stage);

            pdDocument.save(file);
            pdDocument.close();
        }
    }

    public void maakBrief(String datum, String brief, String ontvanger, String adress,Stage stage) throws IOException {
        InputStream input = getClass().getResourceAsStream("/pdfFiles/templates/brief.pdf");
        PDDocument pdDocument = PDDocument.load(input);

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

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter =
                new FileChooser.ExtensionFilter("PDF Files (*.pdf)","*.pdf");
        fileChooser.getExtensionFilters().add(extensionFilter);
        fileChooser.setTitle("Save Brief");
        File file = fileChooser.showSaveDialog(stage);

        try {
            pdDocument.save(file);
        }catch (Exception e){
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Error");
            alert2.setHeaderText("Er is iets mis gegaan bij het opslaan");
            alert2.setContentText("Grote kans dat of de template niet gevonden is of dat het opslaan gecaneld is");
        }

        pdDocument.close();
    }
}
