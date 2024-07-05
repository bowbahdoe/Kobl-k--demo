package kob.app;

import kob.decompiler.Decompiler;

import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.nio.file.Path;
import java.util.ServiceLoader;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ModuleFinder finder = ModuleFinder.of(
                Path.of("libs"),
                Path.of("build/jar/kob.vineflower.jar")
        );

        ModuleLayer parent = ModuleLayer.boot();

        Configuration cf = parent.configuration().resolve(
                finder,
                ModuleFinder.of(),
                Set.of("kob.vineflower")
        );

        ClassLoader scl = ClassLoader.getSystemClassLoader();

        ModuleLayer layer = parent.defineModulesWithOneLoader(cf, scl);

        System.out.println(layer);

        var decompiler = ServiceLoader.load(layer, Decompiler.class)
                .findFirst()
                .orElseThrow();

    }
}
