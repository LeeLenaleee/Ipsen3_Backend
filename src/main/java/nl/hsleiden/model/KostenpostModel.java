package nl.hsleiden.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "kostenpost")
public class KostenpostModel extends BaseModel {
    @Column(name = "kostenpost_kostenpost")
    private String kostenpost;

    public KostenpostModel() {

    }

    public KostenpostModel(String kostenpost) {
        this.kostenpost = kostenpost;
    }

    public String getKostenpost() {
        return kostenpost;
    }

    public void setKostenpost(String kostenpost) {
        this.kostenpost = kostenpost;
    }
}