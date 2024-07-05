package kob.vineflower;

import org.jetbrains.java.decompiler.api.ClassAttributeRegistry;
import org.jetbrains.java.decompiler.main.Fernflower;
import org.jetbrains.java.decompiler.main.decompiler.DirectoryResultSaver;
import org.jetbrains.java.decompiler.main.extern.IFernflowerLogger;
import org.jetbrains.java.decompiler.main.extern.IFernflowerPreferences;

import kob.decompiler.Decompiler;
import java.nio.file.Path;

public final class VineFlowerDecompiler implements Decompiler {
    public void decompile(Path sourcePath,Path outputPath) {
        Fernflower fern = new Fernflower(
                new DirectoryResultSaver(outputPath.toFile()),
                IFernflowerPreferences.getDefaults(),
                IFernflowerLogger.NO_OP
        );

        fern.addSource(sourcePath.toFile());

        fern.decompileContext();
    }

    @Override
    public void doStuff() {
        System.out.println(ClassAttributeRegistry.class.hashCode());
    }
}
