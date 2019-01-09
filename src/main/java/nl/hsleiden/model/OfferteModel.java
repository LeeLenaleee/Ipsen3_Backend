package nl.hsleiden.model;

import javax.persistence.*;

@Entity
@Table(name = "offerte")
public class OfferteModel extends BaseModel{
<<<<<<< HEAD
    @Column(name = "datum")
    private String datum;

    @Column(name = "correspondentienummer")
    private String correspondentienummer;

    @Column(name = "naamklant")
    private String naamklant;

    @Column(name ="uren")
    private String uren;

    @Column(name ="btwPercentage")
    private String btwPercentage;

    @Column(name ="kostenBruto")
    private String kostenBruto;

    @Column(name ="kostenBTW")
    private String kostenBTW;

    @Column(name ="kostenNetto")
    private String kostenNetto;

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getCorrespondentienummer() {
        return correspondentienummer;
    }

    public void setCorrespondentienummer(String correspondentienummer) {
        this.correspondentienummer = correspondentienummer;
    }

    public String getNaamklant() {
        return naamklant;
    }

    public void setNaamklant(String naamklant) {
        this.naamklant = naamklant;
    }

    public String getUren() {
        return uren;
    }

    public void setUren(String uren) {
        this.uren = uren;
    }

    public String getBtwPercentage() {
        return btwPercentage;
    }

    public void setOpdrachtOmschrijving(String opdrachtOmschrijving) {
        this.opdrachtOmschrijving = opdrachtOmschrijving;
    }

    public String getOpdrachtAfrondingsDatum() {
        return opdrachtAfrondingsDatum;
    }

    public void setOpdrachtAfrondingsDatum(String opdrachtAfrondingsDatum) {
        this.opdrachtAfrondingsDatum = opdrachtAfrondingsDatum;
    }

    public double getOpdrachtKosten() {
        return opdrachtKosten;
    }

    public void setOpdrachtKosten(double opdrachtKosten) {
        this.opdrachtKosten = opdrachtKosten;
    }

    public ContactPersoonModel getContactId() {
        return contactId;
    }

    public void setContactId(ContactPersoonModel contactId) {
        this.contactId = contactId;
    }
}
