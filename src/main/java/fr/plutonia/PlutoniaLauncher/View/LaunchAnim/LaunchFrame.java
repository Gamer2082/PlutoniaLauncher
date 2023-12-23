package fr.plutonia.PlutoniaLauncher.View.LaunchAnim;

import fr.theshark34.swinger.util.WindowMover;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class LaunchFrame extends JFrame {
    private static LaunchFrame Instance;
    public LaunchFrame() throws IOException {
        Instance = this;
        this.setSize(500,500);
        this.setIconImage(getImage("logo_noBG.png"));
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        WindowMover mover = new WindowMover(this);
        this.addMouseListener(mover);
        this.addMouseMotionListener(mover);
        this.setVisible(true);
    }
    public static Image getImage(String FileName) throws IOException {
        InputStream inputStream = LaunchFrame.getInstance().getClass().getClassLoader().getResourceAsStream(FileName);
        return ImageIO.read(inputStream);
    }

    private static LaunchFrame getInstance() {
        return Instance;
    }

    public static void main(String[] args) throws IOException {
        Instance = new LaunchFrame();
    }
}
