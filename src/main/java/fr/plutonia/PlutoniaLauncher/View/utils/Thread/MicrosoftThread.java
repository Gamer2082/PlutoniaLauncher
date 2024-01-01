package fr.plutonia.PlutoniaLauncher.View.utils.Thread;

import fr.litarvan.openauth.microsoft.MicrosoftAuthenticationException;
import fr.plutonia.PlutoniaLauncher.Launcher;

public class MicrosoftThread implements Runnable {
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
        try {
            Launcher.Auth();
            return;
        } catch (MicrosoftAuthenticationException e) {
            Launcher.getCrashReporter().catchError(e,"Impossible de charger la page de connexion");
        }
    }
}
