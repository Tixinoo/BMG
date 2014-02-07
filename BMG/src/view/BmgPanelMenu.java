package view;

import javax.swing.JPanel;

/**
 * @Class BmgPanelMenu, which ...
 * @Author Maxime Blaise
 */
public class BmgPanelMenu extends JPanel {

    /**
     * Constructor which creates menu bar.
     */
    public BmgPanelMenu(BmgFrame fen) {
        super();

        //Creation of menu bar, and add to panel.
        BmgMenuBar menu = new BmgMenuBar(fen);
        this.add(menu);
    }
}
