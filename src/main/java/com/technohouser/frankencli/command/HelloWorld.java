package com.technohouser.frankencli.command;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Component;
import picocli.CommandLine;

/**
 * A command which is used for printing Hello World messages
 *
 * @author brianwyka
 */
@Component
@CommandLine.Command(
        name = "hello-world",
        description = "Print out Hello World"
)
@SuppressWarnings("java:S106")
public class HelloWorld implements Callable<Integer> {

    /**
     * Entrypoint to the command
     *
     * @return the program exit code
     */
    @Override
    public Integer call() {
        System.out.println("Hello world");

        return CommandLine.ExitCode.OK;
    }

}
