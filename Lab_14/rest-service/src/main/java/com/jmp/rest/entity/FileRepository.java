package com.jmp.rest.entity;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created on 3/23/2016.
 */
public class FileRepository {

    private static ConcurrentHashMap<Integer, File> userLogoRepository = new ConcurrentHashMap();

    public static File getLogoByUserID(int userID) {
        return userLogoRepository.get(userID);
    }

    public static void putLogo(int userID, File image) {
        userLogoRepository.put(userID, image);
    }


}
