package pl.sda.mp3analysis;

import pl.sda.mp3analysis.model.Song;
import pl.sda.mp3analysis.service.SongService;

import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) {

        List<Song> songList = new ArrayList<>();
        SongService songService = new SongService();

        String dirString = "e:\\ProjektyJAVA\\Programowanie2\\MP3Analysis_RK\\mp3";

        songList = songService.getSongList(dirString);

        System.out.println(songList);


//        FileService fileService = new FileService();

       // fileService.setPath("/mp3");








    }
}
