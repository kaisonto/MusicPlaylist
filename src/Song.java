public class Song {
    private String songTitle;
    private double songLength;

    public Song(String songName, double songLength) {
        this.songTitle = songName;
        this.songLength = songLength;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public double getSongLength() {
        return songLength;
    }


    @Override
    public String toString() {
        return "song: "+songTitle+" - "+songLength;
    }
}
