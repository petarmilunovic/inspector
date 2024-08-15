import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserInterface extends JFrame {

    public static JPanel mainPanel;
    private JLabel createdBy;
    public static JTextField tfPictureName;
    private JButton btnFind;

    public UserInterface() {

        this.setTitle("Inspector");
        this.setIconImage(new ImageIcon(System.getProperty("user.dir").concat("/src/logo.png")).getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(290, 150);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        mainPanel();

        this.setVisible(true);
    }

    // mainPanel & its components
    public void mainPanel() {

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        mainPanel.setBackground(new Color(245, 246, 250));

        // part number field
        tfPictureName = new JTextField();
        tfPictureName.setBackground(new Color(245, 246, 250));
        tfPictureName.setPreferredSize(new Dimension(140, 45));
        tfPictureName.setBorder(BorderFactory.createTitledBorder("Enter image name"));
        // registers enter as mouse click on next button
        tfPictureName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnFind.doClick();
                }
            }
        });

        // next button
        btnFind = new JButton("Find");
        btnFind.setBackground(new Color(245, 246, 250));
        btnFind.setPreferredSize(new Dimension(140, 30));
        btnFind.addActionListener(e -> {

            boolean imageFound = false;
            for (Picture part : Picture.pictureList) {
                if (part.getPictureName().equals(tfPictureName.getText().trim())) {
                    System.out.println("Match found!");

                    imageFound = true;
                    new PictureWindow();
                    break;
                }
            }
            if (!imageFound) {
                JOptionPane.showMessageDialog(btnFind, "Image not found.",
                        "Invalid image name", JOptionPane.ERROR_MESSAGE);
            }
        });

        // registers enter as mouse click
        btnFind.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnFind.doClick();
                }
            }
        });

        // created by label
        createdBy = new JLabel("created by yours truly");
        createdBy.setFont(new Font("Arial", Font.ITALIC, 9));
        createdBy.setPreferredSize(new Dimension(150, 15));
        createdBy.setHorizontalAlignment(0);

        mainPanel.add(tfPictureName);
        mainPanel.add(btnFind);
        mainPanel.add(createdBy);

        this.add(mainPanel);
    }

}








