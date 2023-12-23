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
    private STexturedButton close = new STexturedButton(Frame.getBufferedImage("close.png"));
    private STexturedButton min = new STexturedButton(Frame.getBufferedImage("line.png"));
    private STexturedButton microsoft = new STexturedButton(Frame.getBufferedImage("play.png"),Frame.getBufferedImage("play.png"));
    private Image ico = Frame.getImage("logo_noBg.ico.png");
    public Panel() throws IOException {
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // BG
        g.drawImage(background,0,0,this.getWidth(),this.getHeight(),this);
        // ico
        g.drawImage(ico,13,12,this);
        //play button
        play.setBounds(163,106);
        play.setLocation(1082,632);
        play.addEventListener(this);
        // close button
        close.setBounds(20,20);
        close.setLocation(1258,12);
        close.addEventListener(this);
        // min button
        min.setBounds(20,20);
        min.setLocation(1208,12);
        min.addEventListener(this);
        // windows button

        // addItems
        this.add(play);
        this.add(min);
        this.add(close);
    }

    @Override
    public void onEvent(SwingerEvent swingerEvent) {


    }
}
