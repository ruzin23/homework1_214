
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


    public static String takeInputString() {
        Scanner scanner = new Scanner(System.in);
        String menuOption = scanner.nextLine();
        return menuOption;
    }


    public static int takeInputInt(){
        Scanner intScanner = new Scanner(System.in);
        return intScanner.nextInt();
    }

    public static void addSong()
    {
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
        SongRecord song = new SongRecord(songTitle,artist,lengthMinutes,lengthSeconds);
        playList.addSong(song,pos);
    }

    public static void getSong()
    {
        System.out.println("Enter the position of song in playlist: ");
        playList.getSong(takeInputInt());
    }

    public static void removeSong()
    {
        System.out.println("Enter the position of the song to be removed : ");
        playList.removeSong(takeInputInt());
    }


    public static void  processMenuOption(String input) {
        input = input.toUpperCase();
        switch (input) {

            case "A": {
                addSong();
                break;
            }
            case "P": {
                 playList.printAllSongs();
                 break;
            }
            case "R": {
                   removeSong();
                break;
            }
            case "S": {
                System.out.println("Size = : " + playList.getSize());
                break;

            }
            case "G": {
                System.out.println("Enter position of the song : ");
                playList.getSong(takeInputInt());
                break;

            }
            case "B": {
                break;


            }
            case "Q": {
                System.out.println("Now exiting......");
                System.exit(0);
                break;
            }
            default:{
                System.out.println("Invalid Option. Select a valid option");
                printMenu();
                processMenuOption(takeInputString());
                break;
            }
        }


    }


    public static void main(String args[]) {

        while(true) {
            printMenu();
            processMenuOption(takeInputString());
            System.out.println("press any key to continue ....");
            takeInputString();
        }
    }
}
