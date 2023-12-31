package utils;

import java.io.*;

/*
 * Name        : ObjectManager
 * Date        : 2023-11-08
 * description : this class manage object like, byte to object, object to byte
 */
public class ObjectManager
{
    public static <T> T toObject(byte[] bytes, Class<T> type)
            throws IOException, ClassNotFoundException
    {
        InputStream is = new ByteArrayInputStream(bytes);
        try (ObjectInputStream ois = new ObjectInputStream(is))
        {
            return type.cast(ois.readObject());
        }
    }

    public static byte[] toByteArray(Object obj)
    {
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        try (ObjectOutputStream ois = new ObjectOutputStream(boas))
        {
            ois.writeObject(obj);
            return boas.toByteArray();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
