import kob.decompiler.Decompiler;
import kob.vineflower.VineFlowerDecompiler;

module kob.vineflower {
    requires vineflower;
    requires kob.decompiler;

    provides Decompiler
            with VineFlowerDecompiler;
}