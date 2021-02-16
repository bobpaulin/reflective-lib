package com.bobpaulin.graal.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import com.bobpaulin.graal.component.Something;

public class LibraryMain {

	public void executeSomething() throws ClassNotFoundException, FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		Something something = somethingFactory();
		something.something();
	}
	
	
	Something somethingFactory() throws ClassNotFoundException, FileNotFoundException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Properties somethingConfig = new Properties();
		somethingConfig.load(new FileInputStream("application.properties"));
		Class somethingClass = Class.forName(somethingConfig.getProperty("activeSomething"));
		Something theSomething = (Something) somethingClass.getDeclaredConstructor().newInstance();
		return theSomething;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		LibraryMain main = new LibraryMain();
		main.executeSomething();
	}
}
