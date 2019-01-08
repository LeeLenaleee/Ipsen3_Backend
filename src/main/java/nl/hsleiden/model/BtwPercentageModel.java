package nl.hsleiden.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "btw_percentage")
public class BtwPercentageModel extends BaseModel{
    @Column(name = "btw_percentage_hoog")
    private String btwPercentageHoog;

    @Column(name = "btw_percentage_laag")
    private String btwPercentageLaag;

    public String getBtwPercentageHoog() {
        return btwPercentageHoog;
    }

    public void setBtwPercentageHoog(String btwPercentageHoog) {
        this.btwPercentageHoog = btwPercentageHoog;
    }

    public String getBtwPercentageLaag() {
        return btwPercentageLaag;
    }

    public void setBtwPercentageLaag(String btwPercentageLaag) {
        this.btwPercentageLaag = btwPercentageLaag;
    }
}
