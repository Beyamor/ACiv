package GameElements;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.image.RGBImageFilter;

/**
 *
 * @author jmohr
 */
class PlayerColorFilter extends RGBImageFilter {

    private final int GB_THRESHOLD = 0x0;  //how dark/light magenta can become
    private final int RG_THRESHOLD = 0x0;  //how dark/light magenta can become

    private final int RB_THRESHOLD = 0x60;//how far it can deviate from magenta

    private Color color;

    private int r;  //tile rgb
    private int g;
    private int b;
    private int a;

    private int cr; //color rgb
    private int cg;
    private int cb;


    public PlayerColorFilter(Color color) {
        //keep the color
        this.color = color;
    }

    @Override
    public int filterRGB(int x, int y, int rgb) {
                //break rgb into elements
                b = rgb & 0x000000FF;
                g = rgb & 0x0000FF00;
                r = rgb & 0x00FF0000;
                a = rgb & 0xFF000000;

                //break color into elements (and shift to be 0-255)
                cb = color.getRGB() & 0x0000FF;
                cg = (color.getRGB() & 0x00FF00)>>8;
                cr = (color.getRGB() & 0xFF0000)>>16;

                //luminosity of the tile (taken from magenta channel)
                double lum = ((double)b + (double)(r>>16)) / (2*0xFF);

                //if the color is non-transparent
                if(a != 0
                        //and difference between red and blue is below threshold
                        && Math.abs((r>>16)-b)< RB_THRESHOLD
                        //and difference between blue and green is above threshold
                        && (b-(g>>8) > GB_THRESHOLD)
                        //and difference between red and green is above threshold
                        && ((r>>16)-(g>>8)) > RG_THRESHOLD){

                    //multiply the luminosity by the rgb values,then shifting into
                    //correct domains so they can be 'or'-ed together
                    cb = (int)(cb*lum);
                    cg = (int)(cg*lum)<<8;
                    cr = ((int)(cr*lum))<<16;

                    //return the composition of the color
                    return (a|cr|cg|cb);
                }
                //or return the color itself
                return (a|r|g|b);
    }

}
