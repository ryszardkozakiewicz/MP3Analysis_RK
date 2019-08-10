package pl.sda.mp3analysis.service;

import com.mpatric.mp3agic.*;
import pl.sda.mp3analysis.model.Song;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SongService {


    public Song getSongData(String fileName) {

        Song song = new Song();

        Mp3File mp3file = null;
        try {
            mp3file = new Mp3File(fileName);
        } catch (IOException | UnsupportedTagException |InvalidDataException e ) {
            e.printStackTrace();
        
        }

        if (mp3file.hasId3v1Tag()) {
            ID3v1 id3v1Tag = mp3file.getId3v1Tag();

            song.setArtist(id3v1Tag.getArtist());
            song.setTitle(id3v1Tag.getTitle());
            song.setAlbum(id3v1Tag.getAlbum());
            song.setYear(id3v1Tag.getYear());
            song.setSize(mp3file.getLength());
        }

        return song;
    }

    public List<Song> getSongList(String dirString) {

        List<Song> songList = new ArrayList<>();

        Path dir = Paths.get(dirString);

        try (DirectoryStream<Path> stream =
                     Files.newDirectoryStream(dir, "*.mp3")) {
            for (Path entry : stream) {
                songList.add(getSongData(dir + "\\" + entry.getFileName().toString()));
            }
        } catch (IOException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can // only be thrown by newDirectoryStream.
            System.err.println(x);

        }

        return songList;

    }


}
