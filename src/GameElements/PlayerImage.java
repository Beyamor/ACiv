package GameElements;

import java.awt.Image;

/**
 *
 * @author jmohr
 */
public class PlayerImage {
    private transient Image extractors;
    private transient Image cities;
    private transient Image units;
    private transient Image shield;

    public PlayerImage(){

    }

    public void setExtractors(Image extractors){
        this.extractors = extractors;
    }

    public void setCities(Image cities){
        this.cities = cities;
    }

    public void setUnits(Image units){
        this.units = units;
    }

    public void setShield(Image shield)
    {
        this.shield = shield;
    }


    public Image getExtractors(){
        return this.extractors;
    }

    public Image getUnits(){
        return this.units;
    }

    public Image getCities(){
        return this.cities;
    }

    public Image getShield(){
        return this.shield;
    }
    
}
