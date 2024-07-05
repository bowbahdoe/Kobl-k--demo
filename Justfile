clean:
    rm -rf build

install:

compile: clean
    javac \
      --module-source-path "modules/*/src" \
      --module kob.app,kob.decompiler,kob.vineflower \
      -d build/javac \
      --module-path libs

    jar --create \
        --file build/jar/kob.app.jar \
        --main-class kob.app.Main \
        -C build/javac/kob.app .

    jar --create \
      --file build/jar/kob.decompiler.jar \
      -C build/javac/kob.decompiler .

    jar --create \
      --file build/jar/kob.vineflower.jar \
      -C build/javac/kob.vineflower .


run: compile
    java \
        --module-path build/jar/kob.app.jar:build/jar/kob.decompiler.jar \
        --module kob.app/kob.app.Main
