package com.filesplitter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Path.of;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class FileSplitterController {

    @PostMapping("/split")
    public ResponseEntity<List<String>> splitFile(@RequestParam("file") MultipartFile file,
                                                  @RequestParam("chunkSize") int chunkSize) {
        if (file.isEmpty() || chunkSize <= 0) {
            return ResponseEntity.badRequest().build();
        }

        List<String> chunkNames = new ArrayList<>();
        try (InputStream inputStream = file.getInputStream()) {
            byte[] buffer = new byte[chunkSize];
            int bytesRead;
            int partNumber = 0;
            String originalFilename = file.getOriginalFilename();
            String baseName = originalFilename != null ? originalFilename.substring(0, originalFilename.lastIndexOf('.')) : "file";
            String extension = originalFilename != null ? originalFilename.substring(originalFilename.lastIndexOf('.')) : "";

            while ((bytesRead = inputStream.read(buffer)) > 0) {
                String chunkName = baseName + "." + partNumber + extension;
                Path chunkPath = of("uploads", chunkName);
                Files.createDirectories(chunkPath.getParent());
                try (OutputStream outputStream = Files.newOutputStream(chunkPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                chunkNames.add(chunkName);
                partNumber++;
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(chunkNames);
    }
}
