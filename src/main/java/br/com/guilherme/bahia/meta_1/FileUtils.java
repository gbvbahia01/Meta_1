/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guilherme.bahia.meta_1;

import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Path;
/**
 *
 * @author Guilherme
 */
public class FileUtils {
    
    public static String currentFolder(String nameFile){
        Path folder = Paths.get("");
        String absFolder = folder.toAbsolutePath().toString();
        return nameFile == null ? absFolder : absFolder + File.separator + nameFile;
    }
}
