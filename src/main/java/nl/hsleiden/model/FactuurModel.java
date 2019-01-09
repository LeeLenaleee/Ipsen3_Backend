package nl.hsleiden.model;


import javax.persistence.*;

@Entity
@Table (name = "factuur")
public class FactuurModel extends BaseModel{
    @Column(name = "datum")
    private String datum;

    @Column(name = "aflever_datum")
    private String aflever_datum;

    @Column(name = "factuur_omschrijving")
    private String factuur_omschrijving;

    @Column(name = "bruto_kosten")
    private String bruto_kosten;

    @Column(name = "btw_percentage")
    private String btw_percentage;

    @Column(name = "btw_kosten")
    private String btw_kosten;

    @Column(name = "netto_kosten")
    private String netto_kosten;

   /* public FactuurModel(String datum, String aflever_datum, String factuur_omschrijving, String bruto_kosten, String btw_percentage, String btw_kosten, String netto_kosten) {
        this.datum = datum;
        this.aflever_datum = aflever_datum;
        this.factuur_omschrijving = factuur_omschrijving;
        this.bruto_kosten = bruto_kosten;
        this.btw_percentage = btw_percentage;
        this.btw_kosten = btw_kosten;
        this.netto_kosten = netto_kosten;
    }*/

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getAflever_datum() {
        return aflever_datum;
    }

    public void setAflever_datum(String aflever_datum) {
        this.aflever_datum = aflever_datum;
    }

    public String getFactuur_omschrijving() {
        return factuur_omschrijving;
    }

    public void setFactuur_omschrijving(String factuur_omschrijving) {
        this.factuur_omschrijving = factuur_omschrijving;
    }

    public double getBruto_kosten() {
        return bruto_kosten;
    }

    public void setBruto_kosten(double bruto_kosten) {
        this.bruto_kosten = bruto_kosten;
    }

    public int getBtw_percentage() {
        return btw_percentage;
    }

    public void setBtw_percentage(int btw_percentage) {
        this.btw_percentage = btw_percentage;
    }

    public double getBtw_kosten() {
        return btw_kosten;
    }

    public void setBtw_kosten(double btw_kosten) {
        this.btw_kosten = btw_kosten;
    }

    public double getNetto_kosten() {
        return netto_kosten;
    }

    public void setNetto_kosten(double netto_kosten) {
        this.netto_kosten = netto_kosten;
    }
}
