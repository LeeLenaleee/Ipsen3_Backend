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
    private String onkosten_bedrijf;

    @Column(name = "onkosten_datum")
    private Date onkosten_datum;

    @Column(name = "onkosten_kostenpost")
    private String onkosten_kostenpost;

    @Column(name = "onkosten_omschrijving")
    private String onkosten_omschrijving;

    @Column(name = "onkosten_bruto_kosten")
    private int onkosten_bruto_kosten;

    @Column(name = "onkosten_btw_percentage")
    private int onkosten_btw_percentage;

    @Column(name = "onkosten_btw_kosten")
    private int onkosten_btw_kosten;

    @Column(name = "onkosten_netto_kosten")
    private int onkosten_netto_kosten;

    public String getOnkosten_bedrijf() {
        return onkosten_bedrijf;
    }

    public void setOnkosten_bedrijf(String onkosten_bedrijf) {
        this.onkosten_bedrijf = onkosten_bedrijf;
    }

    public Date getOnkosten_datum() {
        return onkosten_datum;
    }

    public void setOnkosten_datum(Date onkosten_datum) {
        this.onkosten_datum = onkosten_datum;
    }

    public String getOnkosten_kostenpost() {
        return onkosten_kostenpost;
    }

    public void setOnkosten_kostenpost(String onkosten_kostenpost) {
        this.onkosten_kostenpost = onkosten_kostenpost;
    }

    public String getOnkosten_omschrijving() {
        return onkosten_omschrijving;
    }

    public void setOnkosten_omschrijving(String onkosten_omschrijving) {
        this.onkosten_omschrijving = onkosten_omschrijving;
    }

    public int getOnkosten_bruto_kosten() {
        return onkosten_bruto_kosten;
    }

    public void setOnkosten_bruto_kosten(int onkosten_bruto_kosten) {
        this.onkosten_bruto_kosten = onkosten_bruto_kosten;
    }

    public int getOnkosten_btw_percentage() {
        return onkosten_btw_percentage;
    }

    public void setOnkosten_btw_percentage(int onkosten_btw_percentage) {
        this.onkosten_btw_percentage = onkosten_btw_percentage;
    }

    public int getOnkosten_btw_kosten() {
        return onkosten_btw_kosten;
    }

    public void setOnkosten_btw_kosten(int onkosten_btw_kosten) {
        this.onkosten_btw_kosten = onkosten_btw_kosten;
    }

    public int getOnkosten_netto_kosten() {
        return onkosten_netto_kosten;
    }

    public void setOnkosten_netto_kosten(int onkosten_netto_kosten) {
        this.onkosten_netto_kosten = onkosten_netto_kosten;
    }

    public OnkostenModel() {}

}
