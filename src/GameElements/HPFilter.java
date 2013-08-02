package GameElements;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.image.RGBImageFilter;

/**
 *
 * @author jmohr
 */
class HPFilter extends RGBImageFilter {

    private int percent;

    private int r;  //red green and alpha channels
    private int g;
    private int a;



    public HPFilter(int percent) {
        this.percent = percent;
    }

    @Override
    public int filterRGB(int x, int y, int rgb) {

                g = 0x0000FF00;
                r = 0x00FF0000;
                a = rgb & 0xFF000000;

                if(percent >= 50)
                {
                    r = 0;
                    if(percent < 80)
                    {
                        r = (int)((0xFF)* (1f - ((percent-50)/30f))  )* 0x10000;
                    }

                }
                else
                {
                    g = 0;
                    if(percent > 30)
                    {
                        g = (int)((0xFF)* ((percent - 30)/30f) )* 0x100;
                    }
                    
                }

                //return color
                return (a|r|g);
    }

}
