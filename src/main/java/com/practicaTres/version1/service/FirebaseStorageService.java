
package com.practicaTres.version1.service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com#
    final String BucketName = "arboles-c55fe.appspot.com";

    //Esta es la ruta básica de este proyecto Arboles
    final String rutaSuperiorStorage = "Arboles";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
//    //El nombre del archivo Json
    final String archivoJsonFile = "arboles-c55fe-firebase-adminsdk-kwptu-49e931b0ab.json";
}
