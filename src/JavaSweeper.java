import javax.swing.*;
import java.awt.*;
import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

public class JavaSweeper extends JFrame {
    private Game game;
    private final int COLS = 9;
    private final int ROWS = 9;
    private final int BOMBS = 9;
    private final int IMAGE_SIZE = 50;
    private JPanel panel;
    public static void main(String[] args) {
        new JavaSweeper();
    }
    private JavaSweeper(){
        game = new Game(COLS,ROWS,BOMBS);
        game.start();
        setImages();
        initPanel();
        initFrame();
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord:Ranges.getAllCoords()){
                    g.drawImage((Image) game.getBox(coord).image,coord.x*IMAGE_SIZE,coord.y*IMAGE_SIZE,this);
                }



            }
        };
        panel.setPreferredSize(new Dimension(Ranges.getSize().x *IMAGE_SIZE,
                Ranges.getSize().y*IMAGE_SIZE));
        add(panel);
    }
    private void setImages(){
        for (Box box : Box.values()){
            box.image = getImage(box.name().toLowerCase());
        }
        setIconImage(getImage("icon"));
    }
    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Sweeper");
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private Image getImage(String name){
        String fileName = "Swipper/"+name+".png";
        ImageIcon icon=new ImageIcon(getClass().getResource(fileName));
        return icon.getImage();
    }
}
