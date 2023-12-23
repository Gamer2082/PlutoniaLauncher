package fr.plutonia.PlutoniaLauncher.View;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class Frame {
    public static void main(String[] args) {
        LaunchRpc();

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
}
