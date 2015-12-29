package org.telegram.service.timer;

import org.telegram.service.timer.process.IChangesProcessor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

/**
 * Created on 27.12.2015.
 */
public class FolderWatchService implements Runnable {

    private Path pathToWatch;

    private List<IChangesProcessor> processors = new ArrayList<>();

    public void run() {

        File directory = new File("################");
        pathToWatch = directory.toPath();

        try (WatchService watcher = pathToWatch.getFileSystem().newWatchService()) {

            pathToWatch.register(watcher,ENTRY_MODIFY);

            while (true) {
                WatchKey key = watcher.take();
                WatchEvent.Kind kind;

                for (WatchEvent<?> watchEvent : key.pollEvents()) {

                    kind = watchEvent.kind();
                    if (ENTRY_MODIFY.equals(kind)) {

                        File modifiedFile = ((WatchEvent<Path>) watchEvent).context().toFile();
                        if (!modifiedFile.getName().endsWith(".jar")) {
                            continue;
                        }

                        for(IChangesProcessor p : processors) {
                            p.onUpdate(directory,modifiedFile);
                        }
                    }
                }

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void addChangesProcessor(IChangesProcessor p) {
        processors.add(p);
    }

}
