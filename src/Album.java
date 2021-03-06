import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String album;
    private String artist;
//    private ArrayList<Song> songs;
    private SongList songs;

    public Album(String album, String artist) {
        this.album = album;
        this.artist = artist;
//        this.songs = new ArrayList<Song>();
        this.songs = new SongList();
    }

//    private Song findSong(String songTitle){
//        for(Song checkedSong: this.songs){
//            if(checkedSong.getSongTitle() == songTitle){
//                return checkedSong;
//            }
//        }
//        return  null;
//    }

    public boolean addSong(String songTitle, double songLength){
    return this.songs.add(new Song(songTitle,songLength));
/*
    if (findSong(songTitle) == null) {
        this.songs.add(new Song(songTitle,songLength));
        return true;
        }
        return false;
*/
    }

    public boolean addSongToPlaylist(int trackNumber, LinkedList<Song> playlist){
//        int index = trackNumber-1;
//
//        if (index >= 0 && index <= this.songs.size()) {
//            playlist.add(this.songs.get(index));
//            return true;
//        }

        Song checkedSong = this.songs.findSong(trackNumber);
        if (checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }

        System.out.println("Track "+trackNumber+" not found in album.");
        return false;
    }

    public boolean addSongToPlaylist(String songTitle, LinkedList<Song> playlist){
//        Song checkedSong = findSong(songTitle);
//        if (checkedSong != null){
//            playlist.add(checkedSong);
//            return true;
//        }

        Song checkedSong = this.songs.findSong(songTitle);
        if (checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }

        System.out.println("Song title "+songTitle+" was not found in this album.");
        return false;
    }

    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        public boolean add(Song song){
            if(songs.contains(song)){
                return false;
            }
            return true;
        }

        private Song findSong(String songTitle){
            for(Song checkedSong: this.songs){
                if (checkedSong.getSongTitle().equals(songTitle)){
                    return checkedSong;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber){
            int index = trackNumber-1;
            if ((index > 0) && index<songs.size()){
                return songs.get(index);
            }
            return null;
        }

    }

}
