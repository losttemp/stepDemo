package com.example.administrator.utils;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public class SaveFileUtils {

    /**
     * 
     * @param fileName
     * @param object
     */
    public static void saveFail(Context context, String fileName, Object object) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(
                    context.getFilesDir(), fileName));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteFail(Context context, String fileName) {
        File file = new File(context.getFilesDir(), fileName);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static Object getObject(Context context, String fileName) {
        try {

            FileInputStream fis = new FileInputStream(new File(
                    context.getFilesDir(), fileName));
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object object = ois.readObject();
            fis.close();
            ois.close();
            return object;
        } catch (StreamCorruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static String getString(Context context, String fileName) {
        try {
            FileInputStream fis = new FileInputStream(new File(
                    context.getFilesDir(), fileName));
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            String chunk = "";
            while ((bytesRead = fis.read(buffer)) != -1) {
                chunk = chunk + new String(buffer, 0, bytesRead);
            }
            fis.close();
            return chunk;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public static void saveString(Context context, String fileName, String json) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(
                    context.getFilesDir(), fileName));
            fos.write(json.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
