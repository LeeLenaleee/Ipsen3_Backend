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
    private String correspondentienummer;

    @Column(name = "naamklant")
    private String naamklant;

    @JoinColumn(name = "contact_id")
    @Column(name = "uren")
    private String uren;

    @Column(name = "btwPercentage")
    private String btwPercentage;

    @Column(name = "kostenBruto")
    private String kostenBruto;

    @Column(name = "kostenBTW")
    private String kostenBTW;

    @Column(name = "kostenNetto")
    private String kostenNetto;

    public OfferteModel() {
        //deze moet leeg zijn om de test te kunnen runnen, er moet comment in staan anders is het een code snell :)
    }

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

    public void setBtwPercentage(String btwPercentage) {
        this.btwPercentage = btwPercentage;
    }

    public String getKostenBruto() {
        return kostenBruto;
    }

    public void setKostenBruto(String kostenBruto) {
        this.kostenBruto = kostenBruto;
    }

    public String getKostenBTW() {
        return kostenBTW;
    }

    public void setKostenBTW(String kostenBTW) {
        this.kostenBTW = kostenBTW;
    }

    public String getKostenNetto() {
        return kostenNetto;
    }

    public void setKostenNetto(String kostenNetto) {
        this.kostenNetto = kostenNetto;
    }
}
