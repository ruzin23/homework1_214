
import java.util.Optional;

public class PlayList {

    private final static int max = 50;

    private SongRecord[] songRecords;

    private int size = 0;

    public PlayList(SongRecord[] songRecords) {
        this.songRecords = songRecords;
    }

    public PlayList() {
        this.songRecords = new SongRecord[max];
    }

    @Override
    public boolean equals(Object obj) {
        // If the object is compared with itself then return true
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


    public void removeSong(int position) throws IllegalArgumentException {

        if (position > max) throw new IllegalArgumentException("position is not within the valid range");
        for (int i = 0; i < max - 1; i++) {
            if (i >= position) {
                this.songRecords[i] = this.songRecords[i + 1];
            }

        }
        size--;
    }

    public PlayList getSongsByArtist(PlayList originalList, String artist) {

        SongRecord[] recordsByArtists = new SongRecord[max];
        int recordIndex = 0;
        int recordSize = 0;
        for (SongRecord record : originalList.getSongRecords()) {
            if (record.getArtist().equals(artist)) {
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


    public SongRecord getSong(int pos) {
        if (pos < 0 || pos > max)
            throw new IllegalArgumentException("The song position is in invalid range . Please enter a valid positio (1-50)");
        return this.getSongRecords()[pos];
    }

    public void printAllSongs() {
        int pos = 0;
        for (SongRecord song : this.getSongRecords()) {
            if (Optional.ofNullable(song).isPresent()) {
                System.out.println(pos + ".) " + song.toString() + "\n");
            }
            pos++;
        }
    }

}
