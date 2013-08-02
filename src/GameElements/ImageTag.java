/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GameElements;

/**
 *
 * @author jmohr
 */
public enum ImageTag {
    TERRAIN("../Images/terrain.png"),
    RIVERS("../Images/placeholder.png"),             //"../Images/rivers.png"),
    ROADS("../Images/placeholder.png"),              //"../Images/roads.png"),
    RESOURCES("../Images/placeholder.png"),          //("../Images/resources.png"),

    FOG("../Images/fog.png"),
    MASK("../Images/mask.png"),

    ALIEN_EXTRACTORS("../Images/placeholder.png"),   //("../Images/alien_extractors.png"),
    ALIEN_CITIES("../Images/alien_cities.png"),       //("../Images/alien_cities.png"),
    ALIEN_UNITS("../Images/alien_units.png"),

    HEALTH_BAR("../Images/health.png"),
    SHIELD("../Images/shield.png"),
    FOCUS("../Images/focus.png");



    private String filePath;
    ImageTag(String filePath) {
        this.filePath = filePath;
    }
    
    public String getFilePath(){
        return filePath;
    }

}
