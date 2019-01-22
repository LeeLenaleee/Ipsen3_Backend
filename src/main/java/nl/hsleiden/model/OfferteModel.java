package nl.hsleiden.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "offerte")
public class OfferteModel extends BaseModel {
    @Column(name = "datum")
    private String datum;

    @Column(name = "correspondentienummer")
    private int correspondentienummer;

    @Column(name = "naamklant")
    private String naamklant;

    @JoinColumn(name = "contact_id")
    @Column(name = "uren")
    private double uren;

    @Column(name = "btwPercentage")
    private double btwPercentage;

    @Column(name = "kostenBruto")
    private double kostenBruto;

    @Column(name = "kostenBTW")
    private double kostenBTW;

    @Column(name = "kostenNetto")
    private double kostenNetto;

    public OfferteModel() {
        //deze moet leeg zijn om de test te kunnen runnen, er moet comment in staan anders is het een code snell :)
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getCorrespondentienummer() {
        return correspondentienummer;
    }

    public void setCorrespondentienummer(int correspondentienummer) {
        this.correspondentienummer = correspondentienummer;
    }

    public String getNaamklant() {
        return naamklant;
    }

    public void setNaamklant(String naamklant) {
        this.naamklant = naamklant;
    }

    public double getUren() {
        return uren;
    }

    public void setUren(double uren) {
        this.uren = uren;
    }

    public double getBtwPercentage() {
        return btwPercentage;
    }

    public void setBtwPercentage(double btwPercentage) {
        this.btwPercentage = btwPercentage;
    }

    public double getKostenBruto() {
        return kostenBruto;
    }

    public void setKostenBruto(double kostenBruto) {
        this.kostenBruto = kostenBruto;
    }

    public double getKostenBTW() {
        return kostenBTW;
    }

    public void setKostenBTW(double kostenBTW) {
        this.kostenBTW = kostenBTW;
    }

    public double getKostenNetto() {
        return kostenNetto;
    }

    public void setKostenNetto(double kostenNetto) {
        this.kostenNetto = kostenNetto;
    }
}
