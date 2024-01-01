package fr.plutonia.PlutoniaLauncher.View;

import fr.plutonia.PlutoniaLauncher.Launcher;
import fr.theshark34.swinger.event.SwingerEvent;
import fr.theshark34.swinger.event.SwingerEventListener;
import fr.theshark34.swinger.textured.STexturedButton;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Panel extends JPanel implements SwingerEventListener {

    private Image background = Frame.getImage("background.png");
    private Image plutoniaFrameNAme = Frame.getImage("plotoniaNameIco.png");
    private STexturedButton play = new STexturedButton(Frame.getBufferedImage("play.png"),Frame.getBufferedImage("play.png"));
    private STexturedButton close = new STexturedButton(Frame.getBufferedImage("close.png"));
    private STexturedButton min = new STexturedButton(Frame.getBufferedImage("line.png"));

    public Panel() throws IOException {
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // wight - 321 / height - 8
        // BG
        g.drawImage(background,0,0,this.getWidth(),this.getHeight(),this);
        g.drawImage(plutoniaFrameNAme,528,84,this);
        //play button
        play.setBounds(123,106);
        play.setLocation(917,566);
        play.addEventListener(this);
        // close button
        close.setBounds(20,20);
        close.setLocation(1033,10);
        close.addEventListener(this);
        // min button
        min.setBounds(20,20);
        min.setLocation(1003,10);
        min.addEventListener(this);
        // windows button

        // addItems
        this.add(min);
        this.add(play);
        this.add(close);
    }

    @Override
    public void onEvent(SwingerEvent swingerEvent) {
        if (swingerEvent.getSource() == close){

        } else if (swingerEvent.getSource() ==min) {

        } else if (swingerEvent.getSource() == play) {
            try {
                Launcher.update();
            } catch (Exception e) {
                Launcher.getCrashReporter().catchError(e,"Impossible de mettre à jour le launcher");
            }
            try {
                Launcher.launch();
            } catch (Exception e) {
                Launcher.getCrashReporter().catchError(e,"Impossible de lancer le launcher");
            }

        }

    }
}
