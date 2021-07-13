public class SongRecord {

    private String title;

    private String artist;

    private int minutes;

    private int seconds;

    //Paramterized constructor
    public SongRecord(String title, String artist, int minutes, int seconds) {
        this.title = title;
        this.artist = artist;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    //Default constructor
    public SongRecord() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "Song title : " + this.title + "\n" + "Artist : " + this.artist + "\n" + "minutes : " + this.minutes + "\n" + "seconds: " + this.seconds + "\n";
    }


}
