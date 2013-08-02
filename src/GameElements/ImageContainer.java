/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GameElements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author jmohr
 */
public class ImageContainer {
    private ImageTag imageTag;

    private Image terrain;
    private Image rivers;
    private Image roads;
    private Image resources;

    private Image fog;
    private Image mask;

    private Image Alien_Extractors;
    private Image Alien_Cities;
    private Image Alien_Units;

    private Image Health_Bar;
    private Image Shield;

    private Image Focus;

    public ImageContainer(List<Player> Players){

        terrain = new ImageIcon(this.getClass().getResource(ImageTag.TERRAIN.getFilePath())).getImage();
        rivers = new ImageIcon(this.getClass().getResource(ImageTag.RIVERS.getFilePath())).getImage();
        roads = new ImageIcon(this.getClass().getResource(ImageTag.ROADS.getFilePath())).getImage();
        resources = new ImageIcon(this.getClass().getResource(ImageTag.RESOURCES.getFilePath())).getImage();

        fog = new ImageIcon(this.getClass().getResource(ImageTag.FOG.getFilePath())).getImage();
        mask = new ImageIcon(this.getClass().getResource(ImageTag.MASK.getFilePath())).getImage();

        Alien_Extractors = new ImageIcon(this.getClass().getResource(imageTag.ALIEN_EXTRACTORS.getFilePath())).getImage();
        Alien_Cities = new ImageIcon(this.getClass().getResource(imageTag.ALIEN_CITIES.getFilePath())).getImage();
        Alien_Units = new ImageIcon(this.getClass().getResource(imageTag.ALIEN_UNITS.getFilePath())).getImage();

        Health_Bar = new ImageIcon(this.getClass().getResource(imageTag.HEALTH_BAR.getFilePath())).getImage();
        Shield = new ImageIcon(this.getClass().getResource(imageTag.SHIELD.getFilePath())).getImage();

        Focus = new ImageIcon(this.getClass().getResource(imageTag.FOCUS.getFilePath())).getImage();


        for(Player p : Players){
            PlayerImage pi = p.getPlayerImage();

            pi.setCities(colorBanners(Alien_Cities,p.playerColor));
            pi.setExtractors(colorBanners(Alien_Extractors,p.playerColor));
            pi.setUnits(colorBanners(Alien_Units,p.playerColor));
            pi.setShield(colorBanners(Shield,p.playerColor));
        }

    }

    public Image getImage(ImageTag imageTag, Player player){
        switch (imageTag){
            case TERRAIN:
                return terrain;
            case RIVERS:
                return rivers;
            case ROADS:
                return roads;
            case RESOURCES:
                return resources;

            case FOG:
                return fog;

            case MASK:
                return mask;

            case ALIEN_UNITS:
                if(player == null)
                {
                    return Alien_Units;
                }
                return player.playerImage.getUnits();
            case ALIEN_CITIES:
                if(player == null)
                {
                    return Alien_Cities;
                }
                return player.playerImage.getCities();
            case ALIEN_EXTRACTORS:
                if(player == null)
                {
                    return Alien_Extractors;
                }
                return player.playerImage.getExtractors();

            case HEALTH_BAR:
                return Health_Bar;

            case SHIELD:
                return player.playerImage.getShield();

            case FOCUS:
                return Focus;

            default:
                return null;
        }
    }

    public Image colorBanners(Image image, Color color){
        if(image == null)
        {
            return null;
        }

        //create a buffered image, of type argb
        BufferedImage biTemp = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_ARGB);

        //make a graphics 2d from it, then write that over image
        Graphics2D g2dtemp = biTemp.createGraphics();
        g2dtemp.drawImage(image, 0, 0, null);
        g2dtemp.dispose();

        //our filter
        RGBImageFilter imageFilter = new PlayerColorFilter(color);

        //use an Image Producer to filter it, then return the image made from the filter
        ImageProducer iptemp = new FilteredImageSource(biTemp.getSource(),imageFilter);
        return Toolkit.getDefaultToolkit().createImage(iptemp);
    }

    public Image colorHealth(Image image, int percent)
    {
        if(image == null)
        {
            return null;
        }

        //create a buffered image, of type argb
        BufferedImage biTemp = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_ARGB);

        //make a graphics 2d from it, then write that over image
        Graphics2D g2dtemp = biTemp.createGraphics();
        g2dtemp.drawImage(image, 0, 0, null);
        g2dtemp.dispose();

        //our filter
        RGBImageFilter imageFilter = new HPFilter(percent);

        //use an Image Producer to filter it, then return the image made from the filter
        ImageProducer iptemp = new FilteredImageSource(biTemp.getSource(),imageFilter);
        return Toolkit.getDefaultToolkit().createImage(iptemp);
    }

}
