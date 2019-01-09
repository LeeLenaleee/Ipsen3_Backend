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

}
