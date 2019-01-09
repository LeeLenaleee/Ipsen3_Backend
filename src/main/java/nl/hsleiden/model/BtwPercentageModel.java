package nl.hsleiden.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "btw_percentage")
public class BtwPercentageModel extends BaseModel{
    @Column(name = "btw_percentage_hoog")
    private int btwPercentageHoog;

    @Column(name = "btw_percentage_laag")
    private int btwPercentageLaag;

    public int getBtwPercentageHoog() {
        return btwPercentageHoog;
    }

    public void setBtwPercentageHoog(int btwPercentageHoog) {
        this.btwPercentageHoog = btwPercentageHoog;
    }

    public int getBtwPercentageLaag() {
        return btwPercentageLaag;
    }

    public void setBtwPercentageLaag(int btwPercentageLaag) {
        this.btwPercentageLaag = btwPercentageLaag;
    }
}
