package nl.hsleiden.model;

import javax.persistence.*;

@Entity
@Table(name = "offerte")
public class OfferteModel extends BaseModel{
    @Column(name = "opdracht_omschrijving")
    private String datum;

    @Column(name = "opdracht_afrondingsdatum")
    private String correspondentienummer;

    @Column(name = "opdracht_kosten")
    private String naamklant;

    @Column(name ="contact_id2")
    private String uren;

    @Column(name ="contact_id3")
    private String btwPercentage;

    @Column(name ="contact_id4")
    private String kostenBruto;

    @Column(name ="contact_id5")
    private String kostenBTW;

    @Column(name ="contact_id6")
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
