package com.tmdb.utils;

import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    public  Properties prop;

    public  Properties initProperties() throws IOException {
        prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\Deepanshu\\IdeaProjects\\TMDB_BYNDER\\src\\main\\resources\\config.properties");
        prop.load(ip);
        return prop;
    }


}
