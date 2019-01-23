package nl.hsleiden.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "brief")
public class BriefModel extends BaseModel {
    @Column(name = "datum")
    private String datum;

    @Column(name = "correspondentie")
    private int correspondentie;

    @Column(name = "betreft")
    private String betreft;

    @Column(name = "adressering")
    private String adressering;

    @Column(name = "verhaal", columnDefinition = "TEXT")
    private String verhaal;

    public BriefModel() {
    }

    public BriefModel(String datum, int correspondentie, String betreft, String adressering, String verhaal) {
        this.datum = datum;
        this.correspondentie = correspondentie;
        this.betreft = betreft;
        this.adressering = adressering;
        this.verhaal = verhaal;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getCorrespondentie() {
        return correspondentie;
    }

    public void setCorrespondentie(int correspondentie) {
        this.correspondentie = correspondentie;
    }

    public String getBetreft() {
        return betreft;
    }

    public void setBetreft(String betreft) {
        this.betreft = betreft;
    }

    public String getAdressering() {
        return adressering;
    }

    public void setAdressering(String adressering) {
        this.adressering = adressering;
    }

    public String getVerhaal() {
        return verhaal;
    }

    public void setVerhaal(String verhaal) {
        this.verhaal = verhaal;
    }
}
