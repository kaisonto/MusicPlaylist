import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String album;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String album, String artist) {
        this.album = album;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    private Song findSong(String songTitle){
        for(Song checkedSong: this.songs){
            if(checkedSong.getSongTitle() == songTitle){
                return checkedSong;
            }
        }
        return  null;
    }

    public boolean addSong(String songTitle, double songLength){
    if (findSong(songTitle) == null) {
        this.songs.add(new Song(songTitle,songLength));
        return true;
        }
        return false;
    }

    public boolean addSongToPlaylist(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber-1;

        if (index >= 0 && index <= this.songs.size()) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("Track "+trackNumber+" not found in album.");
        return false;
    }

    public boolean addSongToPlaylist(String songTitle, LinkedList<Song> playlist){
        Song checkedSong = findSong(songTitle);
        if (checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("Song title "+songTitle+" was not found in this album.");
        return false;
    }



}
