package fr.plutonia.PlutoniaLauncher.View.LaunchAnim;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import fr.theshark34.swinger.util.WindowMover;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LaunchFrame extends JFrame {
    private static LaunchFrame Instance;
    private LaunchPanel panel;
    public LaunchFrame() throws IOException {
        Instance = this;
        this.setSize(546,675);
        this.setIconImage(getImage("logo_noBG.png"));
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel = new LaunchPanel());

        WindowMover mover = new WindowMover(this);
        this.addMouseListener(mover);
        this.addMouseMotionListener(mover);
        this.setVisible(true);
    }
    public static Image getImage(String FileName) throws IOException {
        InputStream inputStream = LaunchFrame.getInstance().getClass().getClassLoader().getResourceAsStream(FileName);
        return ImageIO.read(inputStream);
    }
    public static BufferedImage getBufferedImage(String FileName) throws IOException{
        InputStream inputStream = LaunchFrame.getInstance().getClass().getClassLoader().getResourceAsStream(FileName);
        return ImageIO.read(inputStream);
    }
    public static void LaunchRpc(){
        final DiscordRPC lib = DiscordRPC.INSTANCE;
        final String appId = "1187921246978060409";
        final String appToken = "e3qLqb7VCq0JdvghoMRO96uGw7_iko3f";
        final DiscordEventHandlers eventHandlers = new DiscordEventHandlers();
        lib.Discord_Initialize(appId,eventHandlers,true,"");
        DiscordRichPresence richPresence = new DiscordRichPresence();
        richPresence.startTimestamp = System.currentTimeMillis()/1000;
        richPresence.details = "**Connecting**";
        richPresence.state = "**Plutonia Launcher**";
        richPresence.smallImageKey = "logo_nobg";

        lib.Discord_UpdatePresence(richPresence);
    }

    private static LaunchFrame getInstance() {
        return Instance;
    }
    public LaunchPanel getPanel() {
        return this.panel;
    }

    public static void main(String[] args) throws IOException {
        Instance = new LaunchFrame();
    }
}
