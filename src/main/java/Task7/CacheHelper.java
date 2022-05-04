package Task7;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class CacheHelper {

    private final Method method;

    public Method getMethod() {
        return method;
    }

    public CacheHelper(Method method) {
        this.method = method;
    }

    public boolean isCached() {
        return (method.isAnnotationPresent(MyCache.class));
    }

    public boolean isCachedInFile() {
        return method.getAnnotation(MyCache.class).cacheType() == CacheType.IN_FILE;
    }

    public String getFileNamePrefix() {
        return method.getAnnotation(MyCache.class).fileNamePrefix();
    }

    public boolean isZip() {
        return (method.getAnnotation(MyCache.class).zip());
    }

    public boolean resultIsList() {
        return Arrays.asList(method.getReturnType().getInterfaces()).indexOf(List.class) == -1;
    }

    public Class<?>[] idenityArgs() {
        return (method.getAnnotation(MyCache.class).identityBy());
    }

    public int listList() {
        return (method.getAnnotation(MyCache.class).listList());
    }


    public String getResourceCacheName(Object[] args) {
        StringBuilder fileName = new StringBuilder(getFileNamePrefix());
        Class<?>[] parameters = getMethod().getParameterTypes();
        if (idenityArgs().length == 0) {
            for (int i = 0; i < parameters.length; i++) {
                fileName.append("_").append(parameters[i].getName()).append('_').append(args[i].hashCode());
            }
            return fileName.toString();
        }

        int[] identityVal = new int[idenityArgs().length];
        Class<?>[] identifyByFields = idenityArgs();
        int counter = 0;
        for (int i = 0; i < parameters.length && counter < identifyByFields.length; i++) {
            if (parameters[i].equals(identifyByFields[counter])) {
                identityVal[counter] = i;
                counter++;
            }
        }

        for (int arg : identityVal) {
            fileName.append("_").append(parameters[arg].getName()).append("h_").append(args[arg].hashCode());
        }

        fileName.append(isZip() ? ".zip" : ".data");
        return fileName.toString();
    }


    public Object trimList(Object result) {

        if (listList() == 0 || !resultIsList()) {
            return result;
        }
        System.out.println("Trimming list...");
        List<?> listResult = (List<?>) result;
        return listResult.subList(0, listList());
    }


    private void saveToFile(Object result, File file) throws Exception {
        try (FileOutputStream fileStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileStream)) {
            objectOutputStream.writeObject(result);
        } catch (NotSerializableException e) {
            throw new NotSerializableException("Error! " + getMethod().getName() + " can not be serialized in file!");
        }
    }


    private void saveToZip(Object result, File file) throws Exception {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(fileOutputStream);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(gZIPOutputStream)) {
            objectOutputStream.writeObject(result);
        } catch (NotSerializableException e) {
            throw new NotSerializableException("Error! " + getMethod().getName() + " can not be serialized in file!");
        }
    }

    public void saveToDisk(Object result, File file, boolean isZipped) throws Exception {
        if(isZipped){
            saveToZip(result,file);
        }
        else {
            saveToFile(result,file);
        }
    }

    private Object getCache(File file) throws Exception {
        System.out.println("Getting from normal file...");
        try {
            try (FileInputStream cacheFileStream = new FileInputStream(file);
                 ObjectInputStream cacheRead = new ObjectInputStream(cacheFileStream)) {
                return cacheRead.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new ClassNotFoundException("Object not Found");
            } catch (InvalidClassException e) {
                e.printStackTrace();
                throw new InvalidClassException("InvalidClass");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileNotFoundException("Cache File Not Found");
        } catch (InvalidClassException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Error with cache file");
        }
    }

    private Object getCacheFromZip(File file) throws Exception {
        System.out.println("Getting from zipped file...");
        try {
            try (FileInputStream cacheFileStream = new FileInputStream(file);
                 GZIPInputStream cacheZipFileStream = new GZIPInputStream(cacheFileStream);
                 ObjectInputStream cacheRead = new ObjectInputStream(cacheZipFileStream)) {
                return cacheRead.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new ClassNotFoundException("Object not Found");
            } catch (InvalidClassException e) {
                e.printStackTrace();
                throw new InvalidClassException("InvalidClass");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileNotFoundException("Cache File Not Found");
        } catch (InvalidClassException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Error with cache file");
        }
    }

    public Object getCacheFromDisk(File file, boolean isZipped) throws Exception {
        if(isZipped){
            return getCacheFromZip(file);
        }
        else {
            return getCache(file);
        }
    }
}
