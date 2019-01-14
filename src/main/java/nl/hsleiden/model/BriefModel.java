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
    private String correspondentie;

    @Column(name = "betreft")
    private String betreft;

    @Column(name = "adresering")
    private String adresering;

    @Column(name = "verhaal", columnDefinition = "TEXT")
    private String verhaal;

    public BriefModel() {
    }

    public BriefModel(String datum, String correspondentie, String betreft, String adresering, String verhaal) {
        this.datum = datum;
        this.correspondentie = correspondentie;
        this.betreft = betreft;
        this.adresering = adresering;
        this.verhaal = verhaal;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getCorrespondentie() {
        return correspondentie;
    }

    public void setCorrespondentie(String correspondentie) {
        this.correspondentie = correspondentie;
    }

    public String getBetreft() {
        return betreft;
    }

    public void setBetreft(String betreft) {
        this.betreft = betreft;
    }

    public String getAdresering() {
        return adresering;
    }

    public void setAdresering(String adresering) {
        this.adresering = adresering;
    }

    public String getVerhaal() {
        return verhaal;
    }

    public void setVerhaal(String verhaal) {
        this.verhaal = verhaal;
    }
}
