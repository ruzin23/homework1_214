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
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof SongRecord)) {
            return false;
        }

        SongRecord song = (SongRecord) obj;

        if (this.title.equals(song.getTitle()) && this.artist.equals(song.getArtist()) &&
                this.minutes == song.getMinutes() && this.seconds == song.getSeconds()) {
            return true;
        }

        return false;

    }


    @Override
    public String toString() {
        return String.format("%-21s%-26s%-19s%d", this.title, this.artist, this.minutes, this.seconds);
    }


}
