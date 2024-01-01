package fr.plutonia.PlutoniaLauncher.View;


import fr.plutonia.PlutoniaLauncher.View.utils.Thread.HeadThread;

public class PlayerSkinFetcher {
    public static void main(String[] args) {
        Thread Ht = new Thread(new HeadThread());
        Ht.start();
    }

}

