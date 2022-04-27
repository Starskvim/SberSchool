package Task7.Plugin;

import Task7.Cryptor.Cryptor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PluginLoader extends ClassLoader {
    private final String pluginFolder;

    public PluginLoader(String pluginFolder) {
        this.pluginFolder = pluginFolder;
    }

    @Override
    protected Class<?> findClass(String className) {
        byte[] classInBytesArray = loadClassAsBytesArray(className);
        if (classInBytesArray != null) {
            return defineClass(null, classInBytesArray, 0, classInBytesArray.length);
        }
        return null;
    }

    private byte[] loadClassAsBytesArray(String classPath) {
        try {
            return Files.readAllBytes(Paths.get(classPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public BasePlugin load(String pluginClassName) {
        try {
            return (BasePlugin) findClass(pluginFolder+pluginClassName).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public BasePlugin load(String pluginClassName, boolean isCrypted){
        if(!isCrypted) return load(pluginClassName);
        String newPluginFileName = pluginClassName.split("\\.")[0]+"_decrypted_.class";
        Cryptor.decrypt(pluginFolder+pluginClassName,pluginFolder+newPluginFileName);
        BasePlugin tmp = load(newPluginFileName);
        try {
            Files.delete(Paths.get(pluginFolder+newPluginFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmp;
    }
}
