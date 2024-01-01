package fr.plutonia.PlutoniaLauncher.View.LaunchAnim;


import fr.plutonia.PlutoniaLauncher.View.utils.Thread.MicrosoftThread;
import fr.theshark34.swinger.event.SwingerEvent;
import fr.theshark34.swinger.event.SwingerEventListener;
import fr.theshark34.swinger.textured.STexturedButton;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static fr.plutonia.PlutoniaLauncher.View.LaunchAnim.LaunchFrame.getBufferedImage;
import static fr.plutonia.PlutoniaLauncher.View.LaunchAnim.LaunchFrame.getImage;

public class LaunchPanel extends JPanel implements SwingerEventListener {

    private Image bg = getImage("Loginbackground.png");
    private STexturedButton microsoft = new STexturedButton(getBufferedImage("microsoft.png"),getBufferedImage("microsoft.png"));
    public LaunchPanel() throws IOException{
        this.setLayout(null);
    }
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(bg,0,0,this.getWidth(),this.getHeight(),this);

        microsoft.setBounds(100,100);
        microsoft.setLocation(31,516);
        microsoft.setText("Prenium");
        microsoft.addEventListener(this);


        this.add(microsoft);
    }
    @Override
    public void onEvent(SwingerEvent swingerEvent) {
        if (swingerEvent.getSource() == microsoft){
            Thread micT = new Thread(new MicrosoftThread());
            micT.start();
        }
    }
}
