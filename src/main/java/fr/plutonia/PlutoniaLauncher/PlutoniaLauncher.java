package fr.plutonia.PlutoniaLauncher;

import fr.plutonia.PlutoniaLauncher.View.utils.Thread.ConnectThread;
import fr.plutonia.PlutoniaLauncher.View.utils.Thread.MainThread;

import java.io.IOException;

public class PlutoniaLauncher {
    private static ConnectThread connectThread = new ConnectThread();
    private static Thread Ct = new Thread(connectThread);
    private static MainThread mainThread = new MainThread();
    private static Thread Mt = new Thread(mainThread);

    public static void main(String[] args) throws IOException {
        if (Launcher.getName() == null){
            Ct.start();
            if (Launcher.getName() != null){
                connectThread.Stop();
                Mt.start();
            }
        }
    }
}
