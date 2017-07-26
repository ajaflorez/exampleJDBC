package icon;

import javax.swing.ImageIcon;

public class MyIcon {
    public static ImageIcon iconNew ;
    public static ImageIcon iconEdit ;
    public static ImageIcon iconDelete ;
    public static ImageIcon iconSearch;
    public static ImageIcon iconOpen;
    public static ImageIcon iconSave;
    public static ImageIcon iconExit;

    public MyIcon() {
        iconNew = new ImageIcon(this.getClass().getResource("new.png"));
        iconEdit = new ImageIcon(this.getClass().getResource("edit.png"));
        iconDelete = new ImageIcon(this.getClass().getResource("delete.png"));
        iconSearch = new ImageIcon(this.getClass().getResource("search.png"));
        iconOpen = new ImageIcon(this.getClass().getResource("open.png"));
        iconSave = new ImageIcon(this.getClass().getResource("save.png"));
        iconExit = new ImageIcon(this.getClass().getResource("exit.png"));
    }    
}
