package pl.sda.mp3analysis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    //private String name;
    private String artist;
    private String year;
    private String album;
    private String title;
    private long size;



    @Override
    public String toString() {
        return "Song{" +
                "artist='" + artist + '\'' +
                ", \nyear='" + year + '\'' +
                ", \nalbum='" + album + '\'' +
                ", \ntitle='" + title + '\'' +
                ", \nsize='" + size + '\'' +
                '}';
    }
}
