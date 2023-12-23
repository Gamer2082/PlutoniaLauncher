package fr.plutonia.PlutoniaLauncher.View;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import fr.plutonia.PlutoniaLauncher.Launcher;
import fr.theshark34.swinger.util.WindowMover;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Frame extends JFrame {

    private static Frame Instance;
    private Panel panel;

    public Frame() throws IOException {
        Instance = this;
        this.setTitle("Plutonia MC");
        this.setIconImage(getImage("logo_noBg.png"));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1293,800);
        this.setContentPane(panel = new Panel());
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        WindowMover mover = new WindowMover(this);
        this.addMouseListener(mover);
        this.addMouseMotionListener(mover);
        this.setVisible(true);
    }

    public Panel getPanel() {
        return this.panel;
    }
    public static Image getImage(String FileName) throws IOException {
        InputStream inputStream = Frame.getInstance().getClass().getClassLoader().getResourceAsStream(FileName);
        return ImageIO.read(inputStream);
    }
    public static BufferedImage getBufferedImage(String FileName) throws IOException{
        InputStream inputStream = Frame.getInstance().getClass().getClassLoader().getResourceAsStream(FileName);
        return ImageIO.read(inputStream);
    }

    private static Frame getInstance() {
        return Instance;
    }



    public static void LaunchRpc(){
        final DiscordRPC lib = DiscordRPC.INSTANCE;
        final String appId = "1187921246978060409";
        final String appToken = "e3qLqb7VCq0JdvghoMRO96uGw7_iko3f";
        final DiscordEventHandlers eventHandlers = new DiscordEventHandlers();
        lib.Discord_Initialize(appId,eventHandlers,true,"");
        DiscordRichPresence richPresence = new DiscordRichPresence();
        richPresence.startTimestamp = System.currentTimeMillis()/1000;
        richPresence.details = "Joue a Plutonia, le nouveau serveur faction de référence. Réjoin nous :*\"https://discord.gg/gF7NEDCUwS\"* ou sur **Plutonia.fr**";
        richPresence.state = "**Plutonia Launcher**";
        richPresence.smallImageKey = "logo_nobg";

        lib.Discord_UpdatePresence(richPresence);
    }
    public static void main(String[] args) throws IOException {
        Launcher.crashFile.mkdir();
        LaunchRpc();
        Instance = new Frame();

    }

}
