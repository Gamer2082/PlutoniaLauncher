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
    private static final String ForgeVersion = "43.3.5";
    private static final String VaniaVersion = "1.19.2";
    private static GameInfos gameInfos = new GameInfos("PlutoniaLauncher",new GameVersion(ForgeVersion, GameType.V1_13_HIGHER_FORGE) , new GameTweak[]{GameTweak.FORGE});
    private static Path path = gameInfos.getGameDir();
    public static File crashFile = new File(String.valueOf(path),".crashes");
    private static CrashReporter crashReporter = new CrashReporter(String.valueOf(crashFile),path);
    private static AuthInfos authInfos;
    private static String Name;

    public static void Auth() throws MicrosoftAuthenticationException {
        MicrosoftAuthenticator authenticator = new MicrosoftAuthenticator();
        MicrosoftAuthResult result = authenticator.loginWithWebview();
        authInfos = new AuthInfos(result.getProfile().getName(),result.getAccessToken(),result.getProfile().getId());
        setName(result.getProfile().getName());

    }
    public static void update() throws Exception {
        VanillaVersion vanillaVersion = new VanillaVersion.VanillaVersionBuilder().withName(VaniaVersion).build();
        UpdaterOptions updaterOptions = new UpdaterOptions.UpdaterOptionsBuilder().build();

        AbstractForgeVersion version = new ForgeVersionBuilder(ForgeVersionBuilder.ForgeVersionType.NEW).withForgeVersion(ForgeVersion).build();

        FlowUpdater updater = new FlowUpdater.FlowUpdaterBuilder().withVanillaVersion(vanillaVersion).withUpdaterOptions(updaterOptions).withModLoaderVersion(version).build();
        updater.update(path);

    }
    public static void launch() throws Exception {
        NoFramework noFramework = new NoFramework(path,authInfos,GameFolder.FLOW_UPDATER);
        noFramework.launch(VaniaVersion,ForgeVersion, NoFramework.ModLoader.FORGE);
    }

    public static CrashReporter getCrashReporter() {
        return crashReporter;
    }

    public static String getName() {
        return Name;
    }

    public static void setName(String name) {
        Name = name;
    }
}
