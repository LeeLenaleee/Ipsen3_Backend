package nl.hsleiden.model;

import javax.persistence.*;

/**
 * @Author Simon van Kouteren
 */
@Entity
@Table(name = "onkosten")
public class OnkostenModel extends BaseModel {

    @Column(name = "onkosten_bedrijf")
    private String onkostenBedrijf;

    @Column(name = "onkosten_datum")
    private String onkostenDatum;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "onkost_id")
    private KostenpostModel onkostenKostenpost;

    @Column(name = "onkosten_omschrijving")
    private String onkostenOmschrijving;

    @Column(name = "onkosten_bruto_kosten")
    private double onkostenBrutoKosten;

    @Column(name = "onkosten_btw_percentage")
    private int onkostenBtwPercentage;

    @Column(name = "onkosten_btw_kosten")
    private double onkostenBtwKosten;

    @Column(name = "onkosten_netto_kosten")
    private double onkostenNettoKosten;

    public String getOnkostenBedrijf() {
        return onkostenBedrijf;
    }

    public void setOnkostenBedrijf(String onkostenBedrijf) {
        this.onkostenBedrijf = onkostenBedrijf;
    }

    public String getOnkostenDatum() {
        return onkostenDatum;
    }

    public void setOnkostenDatum(String onkostenDatum) {
        this.onkostenDatum = onkostenDatum;
    }

    public KostenpostModel getOnkostenKostenpost() {
        return onkostenKostenpost;
    }

    public void setOnkostenKostenpost(KostenpostModel onkostenKostenpost) {
        this.onkostenKostenpost = onkostenKostenpost;
    }

    public String getOnkostenOmschrijving() {
        return onkostenOmschrijving;
    }

    public void setOnkostenOmschrijving(String onkostenOmschrijving) {
        this.onkostenOmschrijving = onkostenOmschrijving;
    }

    public double getOnkostenBrutoKosten() {
        return onkostenBrutoKosten;
    }

    public void setOnkostenBrutoKosten(double onkostenBrutoKosten) {
        this.onkostenBrutoKosten = onkostenBrutoKosten;
    }

    public int getOnkostenBtwPercentage() {
        return onkostenBtwPercentage;
    }

    public void setOnkostenBtwPercentage(int onkostenBtwPercentage) {
        this.onkostenBtwPercentage = onkostenBtwPercentage;
    }

    public double getOnkostenBtwKosten() {
        return onkostenBtwKosten;
    }

    public void setOnkostenBtwKosten(double onkostenBtwKosten) {
        this.onkostenBtwKosten = onkostenBtwKosten;
    }

    public double getOnkostenNettoKosten() {
        return onkostenNettoKosten;
    }

    public void setOnkostenNettoKosten(double onkostenNettoKosten) {
        this.onkostenNettoKosten = onkostenNettoKosten;
    }
}
