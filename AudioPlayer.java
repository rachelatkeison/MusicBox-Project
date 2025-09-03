package com.rachel.mediaplayer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

public class AudioPlayer {
    private static final Logger LOGGER = Logger.getLogger(AudioPlayer.class.getName());

    public void play(Track track) {
        if (track == null) {
            LOGGER.warning("Track is null, skipping playback.");
            return;
        }

        File file = new File(track.filePath());
        if (!file.exists()) {
            LOGGER.severe("File not found: " + track.filePath());
            return;
        }

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            CountDownLatch latch = new CountDownLatch(1);

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    LOGGER.info("Finished: " + track.title());
                    latch.countDown();
                    clip.close();
                }
            });

            LOGGER.info("Playing: " + track.title());
            clip.start();

            latch.await();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            LOGGER.severe("Audio playback error: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
