package nl.hsleiden.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @Author Simon van Kouteren
 */
@Entity
@Table(name = "onkosten")
public class OnkostenModel extends BaseModel{

    @Column(name = "onkosten_bedrijf")
    private String onkostenBedrijf;

    @Column(name = "onkosten_datum")
    private Date onkostenDatum;

    @Column(name = "onkosten_kostenpost")
    private String onkostenKostenpost;

    @Column(name = "onkosten_omschrijving")
    private String onkostenOmschrijving;

    @Column(name = "onkosten_bruto_kosten")
    private int onkostenBrutoKosten;

    @Column(name = "onkosten_btw_percentage")
    private int onkostenBtwPercentage;

    @Column(name = "onkosten_btw_kosten")
    private int onkostenBtwKosten;

    @Column(name = "onkosten_netto_kosten")
    private int onkostenNettoKosten;


    public String getOnkostenBedrijf() {
        return onkostenBedrijf;
    }

    public void setOnkostenBedrijf(String onkostenBedrijf) {
        this.onkostenBedrijf = onkostenBedrijf;
    }

    public Date getOnkostenDatum() {
        return onkostenDatum;
    }

    public void setOnkostenDatum(Date onkostenDatum) {
        this.onkostenDatum = onkostenDatum;
    }

    public String getOnkostenKostenpost() {
        return onkostenKostenpost;
    }

    public void setOnkostenKostenpost(String onkostenKostenpost) {
        this.onkostenKostenpost = onkostenKostenpost;
    }

    public String getOnkostenOmschrijving() {
        return onkostenOmschrijving;
    }

    public void setOnkostenOmschrijving(String onkostenOmschrijving) {
        this.onkostenOmschrijving = onkostenOmschrijving;
    }

    public int getOnkostenBrutoKosten() {
        return onkostenBrutoKosten;
    }

    public void setOnkostenBrutoKosten(int onkostenBrutoKosten) {
        this.onkostenBrutoKosten = onkostenBrutoKosten;
    }

    public int getOnkostenBtwPercentage() {
        return onkostenBtwPercentage;
    }

    public void setOnkostenBtwPercentage(int onkostenBtwPercentage) {
        this.onkostenBtwPercentage = onkostenBtwPercentage;
    }

    public int getOnkostenBtwKosten() {
        return onkostenBtwKosten;
    }

    public void setOnkostenBtwKosten(int onkostenBtwKosten) {
        this.onkostenBtwKosten = onkostenBtwKosten;
    }

    public int getOnkostenNettoKosten() {
        return onkostenNettoKosten;
    }

    public void setOnkostenNettoKosten(int onkostenNettoKosten) {
        this.onkostenNettoKosten = onkostenNettoKosten;
    }
}
