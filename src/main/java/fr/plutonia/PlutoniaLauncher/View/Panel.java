package fr.plutonia.PlutoniaLauncher.View;

import fr.theshark34.swinger.event.SwingerEvent;
import fr.theshark34.swinger.event.SwingerEventListener;
import fr.theshark34.swinger.textured.STexturedButton;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Panel extends JPanel implements SwingerEventListener {

    private Image background = Frame.getImage("background.png");
    private Image plutoniaFrameNAme = Frame.getImage("plotoniaNameIco.png");
    private Image ico = Frame.getImage("logo_noBg.ico.png");
    private Image Title = Frame.getImage("title.png");
    private STexturedButton play = new STexturedButton(Frame.getBufferedImage("play.png"),Frame.getBufferedImage("play.png"));
    private STexturedButton close = new STexturedButton(Frame.getBufferedImage("close.png"));
    private STexturedButton min = new STexturedButton(Frame.getBufferedImage("line.png"));

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
        g.drawImage(plutoniaFrameNAme,849,96,this);
        g.drawImage(Title,289,197,this);
        //play button
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
        this.add(min);
        this.add(close);
    }

    @Override
    public void onEvent(SwingerEvent swingerEvent) {


    }
}
