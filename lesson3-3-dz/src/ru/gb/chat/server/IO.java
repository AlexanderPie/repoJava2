package ru.gb.chat.server;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class IO {
    public static void main(String[] args) {

    }

    void readLastNLines(File file, int count) {
        int readLines = 0;
        StringBuilder sb = new StringBuilder();

        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            long fileLength = file.length() - 1;
            raf.seek(fileLength);

            for (long ptr = fileLength; ptr >= 0 ; ptr--) {
                raf.seek(ptr);
                char ch = raf.readChar();

                if (ch == '\n') {
                    readLines++;
                    if (readLines == count) {
                        break;
                    }
                }
                sb.append(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        sb.reverse();

        System.out.println(sb.toString());
    }
}

