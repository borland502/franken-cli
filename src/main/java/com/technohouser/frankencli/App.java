package com.technohouser.frankencli;

import com.technohouser.frankencli.command.HelloWorld;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

/**
 * Command line entrypoint
 *
 * @author Jeremy Hettenhouser
 */
@SpringBootApplication
public class App implements CommandLineRunner, ExitCodeGenerator
{

    private final CommandLine.IFactory factory;
    private final HelloWorld helloWorld;
    private int exitCode;

    public App(IFactory factory, HelloWorld helloWorld)
    {
        this.factory = factory;
        this.helloWorld = helloWorld;
    }

    /**
     * Bootstrap the command
     *
     * @param args the command line args
     */
    public static void main(final String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(App.class, args)));
    }

    @Override
    public void run(String... args) throws Exception
    {
        // let picocli parse command line args and run the business logic
        exitCode = new CommandLine(helloWorld, factory).execute(args);
    }

    @Override
    public int getExitCode()
    {
        return exitCode;
    }
}
