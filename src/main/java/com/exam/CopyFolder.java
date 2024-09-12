package com.exam;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFolder {

    public static void main(String[] args) throws IOException {

        Path D = Paths.get("");
        Path E = Paths.get("D:/workspace1");

        Files.createDirectories(E);

        Files.walkFileTree(D, new SimpleFileVisitor<Path>(){

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path ep = E.resolve(D.relativize(file));
                Files.copy(file, ep, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path newDir = E.resolve(D.relativize(dir));
                Files.copy(dir, newDir, StandardCopyOption.COPY_ATTRIBUTES);
                return FileVisitResult.CONTINUE;
            }

        });
    }

}
