package nl.hsleiden.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kostenpost")
public class KostenpostModel extends BaseModel {
    @Column(name = "kostenpost_kostenpost")
    private String kostenkost;

    public KostenpostModel() {

    }
    
    public KostenpostModel(String kostenkost) {
        this.kostenkost = kostenkost;
    }

    public String getKostenkost() {
        return kostenkost;
    }

    public void setKostenkost(String kostenkost) {
        this.kostenkost = kostenkost;
    }
}
