
import java.util.Optional;

public class PlayList implements Cloneable {


//instance variables
    private final static int max = 50;

    private SongRecord[] songRecords;

    private int size = 0;

    public PlayList(SongRecord[] songRecords) {
        this.songRecords = songRecords;
    }

    public PlayList() {
        this.songRecords = new SongRecord[max];
    }


    //overriding the equals method of object PlayList
    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PlayList)) {
            return false;
        }
        PlayList playList = (PlayList) obj;
        if (this.songRecords.length == playList.getSongRecords().length) {
            int numberOfSongs = this.songRecords.length;
            for (int i = 0; i < numberOfSongs; i++) {
                if (!(playList.getSongRecords()[i].equals(this.songRecords[i]))) {
                    return false;
                }
            }
            return true;
        } else
            return false;
    }

    // deep cloning the mutable list
    @Override
    public Object clone() {
        SongRecord[] records = new SongRecord[this.max];
        for (int i = 0; i < max; i++) {
            records[i] = this.songRecords[i];
        }
        return new PlayList(records);
    }

    public int getMax() {
        return max;
    }

    public SongRecord[] getSongRecords() {
        return songRecords;
    }

    public void setSongRecords(SongRecord[] songRecords) {
        this.songRecords = songRecords;
    }

    public int getSize() {
        return size;
    }

    /**
     *
     * @param songRecord
     * @param position
     * this method adds a song to our singleton playList , checks for fullcapcity exception , and illegal argument exception
     * which is later caught in the main
     *
     */
    public void addSong(SongRecord songRecord, int position) {
        if (position < 0 || position > max)
            throw new IllegalArgumentException("position is not within valid range");

        if (size >= max)
            throw new FullPlayListException("No more room for songs . Play;ist reached its max capacity");

        if (!Optional.ofNullable(songRecords[position]).isPresent()) {
            System.out.println("no clash");
            songRecords[position] = songRecord;
            size++;
        } else {
            SongRecord[] newRecordList = new SongRecord[50];
            for (int i = 0; i < max; i++) {
                if (i < position) {
                    newRecordList[i] = songRecords[i];
                } else if (i == position)
                    newRecordList[i] = songRecord;
                else {
                    newRecordList[i] = songRecords[i - 1];
                }
            }
            this.setSongRecords(newRecordList);
            size++;
        }
    }

    /**
     * this method removes a song from the playList by accepting a int position . The position corresponds to the index of the array
     * if the index is oit of bounf it throws illegal argument exception
     * @param position
     * @throws IllegalArgumentException
     */
    public void removeSong(int position) throws IllegalArgumentException {

        if (position > max) throw new IllegalArgumentException("position is not within the valid range");
        for (int i = 0; i < max ; i++) {
            if (i >= position) {
                if (position == max - 1) {
                    this.songRecords[i] = null;
                } else {
                    this.songRecords[i] = this.songRecords[i + 1];
                }
            }
        }
        size--;
    }

    /**
     * this method get songs by a given artist. Accepts a string input for artist name and traverses the playlist to pick
     * songs that matches the artist name using equal operator for strings  it also ignores null values so as to not return nullpointerexceptiona
     * and if there is no match found returns a null value
     * @param originalList
     * @param artist
     * @return
     */
    public PlayList getSongsByArtist(PlayList originalList, String artist) {

        SongRecord[] recordsByArtists = new SongRecord[max];
        int recordIndex = 0;
        int recordSize = 0;
        for (SongRecord record : originalList.getSongRecords()) {
            if (Optional.ofNullable(record).isPresent() && record.getArtist().equals(artist)) {
                recordsByArtists[recordIndex] = record;
                recordSize++;
            }
            recordIndex++;
        }
        if (recordSize == 0)
            return null;
        else
            return new PlayList(recordsByArtists);
    }

    /**
     * this method accepts int position as an input to return the song in the playlist a that index of the array
      * @param pos
     * @return
     */
    public SongRecord getSong(int pos) {
        if (pos < 0 || pos > max)
            throw new IllegalArgumentException("The song position is in invalid range . Please enter a valid positio (1-50)");
        return this.getSongRecords()[pos];
    }

    /**
     * this void method simply traverses over the playlist concatenating strings returned by all the SongRecords to String method which basically
     *return their member field and value of the object
     */
    public void printAllSongs() {
        int pos = 0;
        for (SongRecord song : this.getSongRecords()) {
            if (Optional.ofNullable(song).isPresent()) {
                System.out.println(pos + ".) " + song.toString() + "\n");
            }
            pos++;
        }
    }

    public String toString() {
        String s = "";
        for (SongRecord song : this.getSongRecords()) {
            if (Optional.ofNullable(song).isPresent()) {
                s = s + song.toString() + "\n";
            }
        }
        return s;
    }
}
