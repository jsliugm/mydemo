package com.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JAVA对象&Byte数组之间转化
 * @author liqqc
 */
public class ObjectUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectUtils.class);

    public static void main(String[] args) {

    }

    /**
     * 对象转Byte数组
     *
     * @param obj
     * @return
     */
    public static<T> byte[] objectToByteArray(T obj) {
        byte[] bytes = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            bytes = byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            LOGGER.error("objectToByteArray failed, " + e);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    LOGGER.error("close objectOutputStream failed, " + e);
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    LOGGER.error("close byteArrayOutputStream failed, " + e);
                }
            }

        }
        return bytes;
    }

    /**
     * Byte数组转对象
     *
     * @param bytes
     * @return
     */
    public static <T> T byteArrayToObject(byte[] bytes) {
        T obj = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            obj = (T)objectInputStream.readObject();
        } catch (Exception e) {
            LOGGER.error("byteArrayToObject failed, " + e);
        } finally {
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    LOGGER.error("close byteArrayInputStream failed, " + e);
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    LOGGER.error("close objectInputStream failed, " + e);
                }
            }
        }
        return (T)obj;
    }
}