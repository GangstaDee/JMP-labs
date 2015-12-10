package com.jmp.navigator;

import com.jmp.entity.animal.Animal;

public interface Navigator {

	void moveAnimal(String input);
	
	void setAnimal(Animal animal);
	
	String getNextCommand();
	
	void updateNextCommand();
		
}
