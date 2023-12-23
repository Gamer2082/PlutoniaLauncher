package fr.plutonia.PlutoniaLauncher.View;

import fr.theshark34.swinger.event.SwingerEvent;
import fr.theshark34.swinger.event.SwingerEventListener;
import fr.theshark34.swinger.textured.STexturedButton;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Panel extends JPanel implements SwingerEventListener {

    private Image background = Frame.getImage("background.png");
    private STexturedButton play = new STexturedButton(Frame.getBufferedImage("play.png"),Frame.getBufferedImage("play.png"));

    public Panel() throws IOException {
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background,0,0,this.getWidth(),this.getHeight(),this);
        play.setBounds(163,106);
        play.setLocation(1082,632);
        play.addEventListener(this);
        this.add(play);
    }

    @Override
    public void onEvent(SwingerEvent swingerEvent) {

    }
}
