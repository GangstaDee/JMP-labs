package com.jmp.reader;

import java.io.File;

public interface Reader {

	File retrieveResource(String fileName);
	
	Object read(File file);
}
