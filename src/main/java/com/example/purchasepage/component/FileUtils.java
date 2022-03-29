package com.example.purchasepage.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Component
@CrossOrigin
public class FileUtils {
    private FileUtils() {}

    //public static final String ProjectImgPath = "file:" + System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img\\projects\\";
      public static final String ProjectImgPath = "/home/SpringBootPlaces/img/projects/";
    public static String upLoadFile(MultipartFile file) throws IOException {
        if(file.isEmpty()){
            return "default.png";
        }
        final byte[] bytes = file.getBytes();
        String randFileName = UUIDUtils.getUUID();
        int len = file.getOriginalFilename().split("\\.").length;
        String suffix = "";
        if (len > 0) {
            suffix = file.getOriginalFilename().split("\\.")[len - 1];
        }
        final Path path = Paths.get(ProjectImgPath + randFileName + "." + suffix);
        Files.write(path, bytes);
        return randFileName + "." + suffix;
    }
}
