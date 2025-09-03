# Music Box
This is an interactive media player that is able to demonstrate:

- Multi-track WAV audio playback
- Playlist management using:
    - currentTrack()
    - nextTrack()
    - removeTrack()
- Event-driven playback using: 
  - javax.sound.sampled.Clip
- Logging of track events for a transparent runtime feedback
- Java 21 feature record Track: for immutable track data
- Runnable as a single JAR, no external modules required

## Requires Java 21:

- Java 21 (Microsoft OpenJDK 21.0.8)
- OS: macOS, Linux, or Windows
- Audio format: WAV only

---

## Start the Music:

```bash
java -jar build/libs/InteractiveMediaPlayer-1.0.jar
