package org.cubit.customtable.util;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;

;

public class EventListener {

    private List<Listener> listeners;

    public EventListener() {
        this.listeners = new ArrayList<>();
    }

    public void register(JavaPlugin plugin) {
        try {
            Method getFileMethod = JavaPlugin.class.getDeclaredMethod("getFile");
            getFileMethod.setAccessible(true);
            File file = (File) getFileMethod.invoke(plugin);
            List<Class<?>> classList = this.getAllClass(file);

            classList.forEach(cl -> {
                if (Listener.class.isAssignableFrom(cl)) {
                    for (Method method : cl.getDeclaredMethods()) {
                        method.setAccessible(true);
                        try {
                            if (method.getAnnotation(EventHandler.class) != null) {
                                Class<? extends Listener> c = cl.asSubclass(Listener.class);
                                Listener listener = c.newInstance();
                                Bukkit.getPluginManager().registerEvents(listener, plugin);
                                this.listeners.add(listener);

                            }
                        }catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }

            });
            Bukkit.getConsoleSender().sendMessage("Plug-in event registration completed");

        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }

    private List<Class<?>> getAllClass(File file) {
        List<Class<?>> classList= new ArrayList<>();
        try {
            java.util.jar.JarFile jf = new java.util.jar.JarFile(file, false);
            Enumeration<JarEntry> entry = jf.entries();
            while (entry.hasMoreElements()) {
                JarEntry zf = entry.nextElement();
                String name = zf.getName();
                if (zf.getName().endsWith(".class") && name.endsWith(".class")) {
                    try {
                        name = name.substring(0, name.length() - 6);
                        name = name.replace("/", ".");
                        classList.add(Class.forName(name));
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classList;
    }
}