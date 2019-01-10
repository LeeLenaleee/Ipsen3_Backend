package nl.hsleiden.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "factuur")
public class FactuurModel extends BaseModel {
    @Column(name = "datum")
    private String datum;

    @Column(name = "aflever_datum")
    private String afleverDatum;

    @Column(name = "factuur_omschrijving")
    private String factuurOmschrijving;

    @Column(name = "bruto_kosten")
    private double brutoKosten;

    @Column(name = "btw_percentage")
    private int btwPercentage;

    @Column(name = "btw_kosten")
    private double btwKosten;

    @Column(name = "netto_kosten")
    private double nettoKosten;

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getAfleverDatum() {
        return afleverDatum;
    }

    public void setAfleverDatum(String afleverDatum) {
        this.afleverDatum = afleverDatum;
    }

    public String getFactuurOmschrijving() {
        return factuurOmschrijving;
    }

    public void setFactuurOmschrijving(String factuurOmschrijving) {
        this.factuurOmschrijving = factuurOmschrijving;
    }

    public double getBrutoKosten() {
        return brutoKosten;
    }

    public void setBrutoKosten(double brutoKosten) {
        this.brutoKosten = brutoKosten;
    }

    public int getBtwPercentage() {
        return btwPercentage;
    }

    public void setBtwPercentage(int btwPercentage) {
        this.btwPercentage = btwPercentage;
    }

    public double getBtwKosten() {
        return btwKosten;
    }

    public void setBtwKosten(double btwKosten) {
        this.btwKosten = btwKosten;
    }

    public double getNettoKosten() {
        return nettoKosten;
    }

    public void setNettoKosten(double nettoKosten) {
        this.nettoKosten = nettoKosten;
    }
}
