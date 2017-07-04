package io.pello.cleanbank;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App 
{
    public static void main( String[] args )
    {
    	Injector injector = Guice.createInjector(new AppModule());

        ConsoleUI consoleUI = injector.getInstance(ConsoleUI.class);
        injector.injectMembers(consoleUI);

        consoleUI.startApp();
    }
}
