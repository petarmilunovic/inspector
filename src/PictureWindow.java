import javax.swing.*;
import java.awt.*;

public class PictureWindow extends JFrame {
    private JPanel mainPanel;
    private static Image picture;

    public PictureWindow() {
        this.setTitle("Inspector");
        this.setIconImage(new ImageIcon(System.getProperty("user.dir").concat("/src/logo.png")).getImage());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(547, 375);
        this.setResizable(false);
        this.setLocationRelativeTo(UserInterface.mainPanel);

        mainPanel();

        this.setVisible(true);
    }

    // mainPanel & its components
    public void mainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        mainPanel.setBackground(new Color(245, 246, 250));

        loadImage();

        this.add(mainPanel);
    }



    //loading part picture into partImage
    public static void loadImage() {

        for (Picture i : Picture.pictureList) {
            if (i.getPictureName().equals(UserInterface.tfPictureName.getText())) {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                picture = toolkit.getImage(Picture.filepath + "\\" + i.getPictureName().concat(".jpg"));
                break;
            }
        }
    }

    // displaying picture on the screen
    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_DEFAULT);

        g2.drawImage(picture, 0, 0, 547, 375, this);

    }


}
