package org.telegram.service.timer.process;

import java.io.File;

/**
 * Created on 30.12.2015.
 */
public interface IChangesProcessor {

    void onUpdate(File directory, File modifiedFile);
}
