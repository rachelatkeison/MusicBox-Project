package com.rachel.mediaplayer;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final List<Track> tracks = new ArrayList<>();
    private int currentIndex = 0;

    public void addTrack(Track t) {
        if (t != null) tracks.add(t);
    }

    public void removeTrack(Track t) {
        if (t == null) return;
        int index = tracks.indexOf(t);
        if (index != -1) {
            tracks.remove(index);
            if (currentIndex >= tracks.size()) {
                currentIndex = tracks.isEmpty() ? 0 : tracks.size() - 1;
            }
        }
    }

    public Track nextTrack() {
        if (tracks.isEmpty()) return null;
        currentIndex = (currentIndex + 1) % tracks.size();
        return tracks.get(currentIndex);
    }

    public Track currentTrack() {
        if (tracks.isEmpty()) return null;
        return tracks.get(currentIndex);
    }
}
