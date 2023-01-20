package com.technohouser.frankencli;

import com.technohouser.frankencli.command.HelloWorld;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@SpringBootApplication
public class App implements CommandLineRunner, ExitCodeGenerator {

    private IFactory factory;
    private HelloWorld helloWorld;
    private int exitCode;

    // constructor injection
    App(IFactory factory, HelloWorld helloWorld) {
        this.factory = factory;
        this.helloWorld = helloWorld;
    }

    @Override
    public void run(String... args) {
        // let picocli parse command line args and run the business logic
        exitCode = new CommandLine(helloWorld, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }

    public static void main(String[] args) {
        // let Spring instantiate and inject dependencies
        System.exit(SpringApplication.exit(SpringApplication.run(App.class, args)));
    }
}