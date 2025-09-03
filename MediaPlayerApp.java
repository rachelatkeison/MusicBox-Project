package com.rachel.mediaplayer;

import java.util.logging.Logger;

public class MediaPlayerApp {
    private static final Logger LOGGER = Logger.getLogger(MediaPlayerApp.class.getName());

    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        playlist.addTrack(new Track("Track 1", "resources/audio/example1.wav"));
        playlist.addTrack(new Track("Track 2", "resources/audio/example2.wav"));
        playlist.addTrack(new Track("Track 3", "resources/audio/example3.wav"));

        AudioPlayer player = new AudioPlayer();

        LOGGER.info("Starting Interactive Media Player with playlist navigation...");

        Track current = playlist.currentTrack();
        if (current != null) player.play(current);

        Track next = playlist.nextTrack();
        if (next != null) player.play(next);

        if (next != null) {
            playlist.removeTrack(next);
            LOGGER.info("Removed track: " + next.title());
        }

        Track afterRemoval = playlist.currentTrack();
        if (afterRemoval != null) player.play(afterRemoval);

        Track loopTrack;
        while ((loopTrack = playlist.nextTrack()) != null && loopTrack != afterRemoval) {
            player.play(loopTrack);
        }

        LOGGER.info("Playlist demo finished.");
    }
}
