package com.onseo.online_shop.service;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String saveFile(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String fileName = System.currentTimeMillis() + " - " + file.getOriginalFilename();
                File newFile = new File(fileName);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
                stream.write(bytes);
                stream.close();

                return newFile.getAbsolutePath();
        } else {
            throw new FileUploadException("file is empty");
        }
    }
}
