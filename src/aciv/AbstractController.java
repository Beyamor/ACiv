package aciv;

import java.awt.event.*;

public class AbstractController
    implements ActionListener {

    public AbstractView view;
    public AbstractModel model;

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
