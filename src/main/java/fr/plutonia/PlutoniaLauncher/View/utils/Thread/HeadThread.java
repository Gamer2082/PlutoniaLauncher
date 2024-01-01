package fr.plutonia.PlutoniaLauncher.View.utils.Thread;

import fr.plutonia.PlutoniaLauncher.Launcher;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HeadThread implements Runnable{
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
        String playerName = Launcher.getName(); // Remplacez par le nom du joueur

        try {
            String uuid = getUUID(playerName);
            String skinURL = getSkinURL(uuid);

            System.out.println("Skin URL: " + skinURL);

            // Afficher la tête du joueur (remplacez avec votre propre logique d'affichage)
            // Exemple : Utilisation d'une bibliothèque graphique comme javax.swing.ImageIcon
            // ImageIcon icon = new ImageIcon(new URL(skinURL));
            // JLabel label = new JLabel(icon);
            // JFrame frame = new JFrame();
            // frame.getContentPane().add(label);
            // frame.pack();
            // frame.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String getUUID(String playerName) throws IOException {
        URL uuidURL = new URL("https://api.mojang.com/users/profiles/minecraft/" + playerName);
        HttpURLConnection connection = (HttpURLConnection) uuidURL.openConnection();
        connection.setRequestMethod("GET");

        try (InputStream inputStream = connection.getInputStream();
             Scanner scanner = new Scanner(inputStream)) {

            if (scanner.hasNext()) {
                String response = scanner.next();
                JSONObject json = new JSONObject(response);
                return json.getString("id");
            }

            throw new IOException("Unable to get UUID for player: " + playerName);
        }
    }

    private static String getSkinURL(String uuid) throws IOException {
        URL profileURL = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + uuid);
        HttpURLConnection connection = (HttpURLConnection) profileURL.openConnection();
        connection.setRequestMethod("GET");

        try (InputStream inputStream = connection.getInputStream();
             Scanner scanner = new Scanner(inputStream)) {

            if (scanner.hasNext()) {
                String response = scanner.next();
                JSONObject json = new JSONObject(response);

                JSONObject properties = json.getJSONArray("properties").getJSONObject(0);
                JSONObject texture = new JSONObject(properties.getString("value"));

                return texture.getJSONObject("textures").getJSONObject("SKIN").getString("url");
            }

            throw new IOException("Unable to get skin URL for UUID: " + uuid);
        }
    }
}
