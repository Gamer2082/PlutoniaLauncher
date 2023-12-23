package fr.plutonia.PlutoniaLauncher;

import fr.flowarg.flowupdater.FlowUpdater;
import fr.flowarg.flowupdater.utils.UpdaterOptions;
import fr.flowarg.flowupdater.versions.AbstractForgeVersion;
import fr.flowarg.flowupdater.versions.ForgeVersionBuilder;
import fr.flowarg.flowupdater.versions.VanillaVersion;
import fr.flowarg.openlauncherlib.NoFramework;
import fr.litarvan.openauth.microsoft.MicrosoftAuthResult;
import fr.litarvan.openauth.microsoft.MicrosoftAuthenticationException;
import fr.litarvan.openauth.microsoft.MicrosoftAuthenticator;
import fr.theshark34.openlauncherlib.minecraft.*;
import fr.theshark34.openlauncherlib.util.CrashReporter;

import java.io.File;
import java.nio.file.Path;

public class Launcher {
    private static GameInfos gameInfos = new GameInfos("PlutoniaLauncher",new GameVersion("1.20.1", GameType.V1_13_HIGHER_FORGE) , new GameTweak[]{GameTweak.FORGE});
    private static Path path = gameInfos.getGameDir();
    private static File crashFile = new File(String.valueOf(path),".crashReporter");
    private static CrashReporter crashReporter = new CrashReporter(String.valueOf(crashFile),path);
    private static AuthInfos authInfos;

    public static void Auth() throws MicrosoftAuthenticationException {
        MicrosoftAuthenticator authenticator = new MicrosoftAuthenticator();
        MicrosoftAuthResult result = authenticator.loginWithWebview();
        authInfos = new AuthInfos(result.getProfile().getName(),result.getAccessToken(),result.getProfile().getId());


    }
    public static void update() throws Exception {
        VanillaVersion vanillaVersion = new VanillaVersion.VanillaVersionBuilder().withName("1.20.1").build();
        UpdaterOptions updaterOptions = new UpdaterOptions.UpdaterOptionsBuilder().build();

        AbstractForgeVersion version = new ForgeVersionBuilder(ForgeVersionBuilder.ForgeVersionType.NEW).withForgeVersion("47.2.18").build();

        FlowUpdater updater = new FlowUpdater.FlowUpdaterBuilder().withVanillaVersion(vanillaVersion).withUpdaterOptions(updaterOptions).withModLoaderVersion(version).build();
        updater.update(path);

    }
    public static void launch() throws Exception {
        NoFramework noFramework = new NoFramework(path,authInfos,GameFolder.FLOW_UPDATER);
        noFramework.launch("1.20.1","47.2.18", NoFramework.ModLoader.FORGE);
    }

    public static CrashReporter getCrashReporter() {
        return crashReporter;
    }
}
