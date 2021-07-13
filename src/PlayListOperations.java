
import java.util.Scanner;

public class PlayListOperations {

    private static PlayList playList = new PlayList();


    public static void printMenu() {
        System.out.println("Add Song[A,a] : ");
        System.out.println("Print Song By Artist[B,b] : ");
        System.out.println("Get Song[G,g]  : ");
        System.out.println("Remove Song[R,r] : ");
        System.out.println("Print All Song[P,p] : ");
        System.out.println("Size[S,s] : ");
        System.out.println("Quit[Q,q] : ");

    }

//allows user to take string input in reusable fashion
    public static String takeInputString() {
        Scanner scanner = new Scanner(System.in);
        String menuOption = scanner.nextLine();
        return menuOption;
    }

// allows user to take input of an integer value in a reusable fashion
    public static int takeInputInt() {
        Scanner intScanner = new Scanner(System.in);
        return intScanner.nextInt();
    }

    //simply a static method to take user input and call addSong method on the playList
    public static void addSong() {
        System.out.println("Enter the Song Title : ");
        String songTitle = takeInputString();
        System.out.println("Enter the song artist: ");
        String artist = takeInputString();
        System.out.println("Enter the song length minutes: ");
        int lengthMinutes = takeInputInt();
        System.out.println("Enter the song length seconds: ");
        int lengthSeconds = takeInputInt();
        System.out.println("Enter the position: ");
        int pos = takeInputInt();
        SongRecord song = new SongRecord(songTitle, artist, lengthMinutes, lengthSeconds);
        playList.addSong(song, pos);
    }

    public static void getSong() {
        System.out.println("Enter the position of song in playlist: ");
        playList.getSong(takeInputInt());
    }

    public static void removeSong() {
        System.out.println("Enter the position of the song to be removed : ");
        playList.removeSong(takeInputInt());
    }


    public static void processMenuOption(String input) {
        input = input.toUpperCase();
        switch (input) {

            case "A": {
                addSong();
                break;
            }
            case "P": {
                System.out.println("     " + String.format("%-21s%-26s%-19s%7s", "title", "artist", "minutes", "seconds"));
                playList.printAllSongs();
                break;
            }
            case "R": {
                removeSong();
                break;
            }
            case "S": {
                int s = playList.getSize();
                if (s == 1) {
                    System.out.println("there is only 1 song in the playlist");
                } else {
                    System.out.println("there are " + s + " songs in the playList ");
                }
                break;

            }
            case "G": {
                System.out.println("Enter position of the song : ");
                System.out.println(playList.getSong(takeInputInt()).toString());
                break;
            }
            case "B": {
                System.out.println("Enter the artist name to get all the songs by the artists ");
                PlayList playListByArtist = playList.getSongsByArtist(playList,takeInputString());
                System.out.println(playListByArtist != null? playListByArtist.toString():"There are no songs by the enetered artist");
                break;
            }
            case "Q": {
                System.out.println("Now exiting......");
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Invalid Option. Select a valid option");
                printMenu();
                processMenuOption(takeInputString());
                break;
            }
        }


    }


    public static void main(String args[]) {

        while (true) {
            try {
                printMenu();
                processMenuOption(takeInputString());
                System.out.println("press enter to continue ....");
                takeInputString();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}
