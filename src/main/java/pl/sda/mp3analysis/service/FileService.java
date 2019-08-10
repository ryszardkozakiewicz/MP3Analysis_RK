package pl.sda.mp3analysis.service;

import lombok.Data;
import pl.sda.mp3analysis.model.Song;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    private String path;



    public void writeToFile() {


        FileWriter writer;

        try {
            writer = new FileWriter(new File(this.path), true);
            writer.write("dsfd");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
