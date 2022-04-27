package Task7;

import Task7.Cryptor.Cryptor;
import Task7.Plugin.BasePlugin;
import Task7.Plugin.PluginLoader;

public class MainApp {

    public static void main(String[] args) {
        String classPath = ".\\Plugins\\";

        PluginLoader pluginLoader = new PluginLoader(classPath);
        BasePlugin basePlugin2 = (BasePlugin) pluginLoader.load("Plugin2.class");
        basePlugin2.printPluginName();

        Cryptor.crypt(classPath+"Plugin1.class",classPath+"Plugin1Crypted.class");

        BasePlugin basePlugin1CryptTest=(BasePlugin)pluginLoader.load("Plugin1Crypted.class",true);
        basePlugin1CryptTest.printPluginName();
    }

}
