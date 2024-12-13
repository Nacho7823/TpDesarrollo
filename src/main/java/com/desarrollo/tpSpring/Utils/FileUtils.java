/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author imsac
 */
public class FileUtils {
    public static String cargarArchivo(String nombreArchivo) throws IOException {
        Path path = (Path) Paths.get(new ClassPathResource(nombreArchivo).getURI());
        return new String(Files.readAllBytes((java.nio.file.Path) path));
    }
}
