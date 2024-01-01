package fr.plutonia.PlutoniaLauncher.View.utils.Thread;

import fr.plutonia.PlutoniaLauncher.Launcher;
import fr.plutonia.PlutoniaLauncher.View.Frame;
import fr.plutonia.PlutoniaLauncher.View.LaunchAnim.LaunchFrame;

import java.io.IOException;

public class MainThread implements Runnable{
    public static boolean running = true;

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (running){
            try {
                Frame Frame = new Frame();
                return;
            } catch (IOException e) {
                Launcher.getCrashReporter().catchError(e,"Impossible de démarrer l'application");
            }
        }
    }
    public static void Stop(){
        running = false;
    }
}
