import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
	// write your code here
        Album album = new Album("Bad","M.Jackson");
        album.addSong("Bad",4.2);
        album.addSong("Moon Walker",3.2);
        album.addSong("Man in the Mirror",6.2);
        album.addSong("Thriller",4.33);
        album.addSong("No Matter",4.8);
        album.addSong("Liberian Girl",5.2);
        album.addSong("Peace",2.2);
        album.addSong("Smash",4.2);
        album.addSong("Smooth Criminal",4.32);
        albums.add(album);

        album = new Album("Marshall Mathers","Eminem");
        album.addSong("Slim Shady",3.44);
        album.addSong("Stan",3.56);
        album.addSong("Tears",3.22);
        album.addSong("Hayley",3.88);
        album.addSong("Candles",3.56);
        albums.add(album);

        LinkedList<Song> mixtape = new LinkedList<Song>();
        albums.get(0).addSongToPlaylist("Bad",mixtape);
        albums.get(0).addSongToPlaylist("Moon Walker",mixtape);
        albums.get(0).addSongToPlaylist("Thriller",mixtape);
        albums.get(1).addSongToPlaylist(1,mixtape);
        albums.get(1).addSongToPlaylist(2,mixtape);
        albums.get(1).addSongToPlaylist(3,mixtape);

        play(mixtape);

    }

    public static void play(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size() == 0){
            System.out.println("Playlist "+playlist+" is empty.");
            return;
        } else {
            printHelp();
            System.out.println("Now playing "+listIterator.next().toString());
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("Exiting from playlist.");
                    quit = true;
                    break;
                case 1: //go to next song
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing next track: "+listIterator.next().toString());
                    } else {
                        System.out.println("Currently at the last track in playlist.");
                    }
                    break;
                case 2: //go to previous song
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing the previous track: "+listIterator.previous().toString());
                    } else {
                        System.out.println("Currently at the first track in playlist.");
                    }
                    break;
                case 3: //replay track
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                            System.out.println("Replaying track: "+listIterator.next().toString());
                        } else {
                            listIterator.next();
                            System.out.println("Replaying track: "+listIterator.previous().toString());
                        }
                    }
                    break;
                case 4: //list songs in playlist
                    printPlaylist(playlist);
                    break;
                case 5: //help menu
                    printHelp();
                    break;
            }

        }

    }

    private static void printHelp(){
        System.out.println("Help Menu: List of available actions. \npress");
        System.out.println("0 - to quit. \n" +
                "1 - to skip to next track \n" +
                "2 - to skip to previous track \n" +
                "3 - to replay current track \n" +
                "4 - list all tracks in a playlist \n" +
                "5 - print help menu"
        );
    }

    private static void printPlaylist(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("=================================");
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println("===========END OF LIST===========");
    }






}