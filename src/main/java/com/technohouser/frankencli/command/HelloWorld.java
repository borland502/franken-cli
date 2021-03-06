package com.technohouser.frankencli.command;

import java.util.List;
import java.util.concurrent.Callable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

/**
 * A command which is used for printing Hello World messages
 *
 * @author brianwyka
 */
@Component
@Slf4j(topic = "OUT")
@CommandLine.Command(
        name = "hello-world",
        description = "Print out Hello World",
        mixinStandardHelpOptions = true
)
@SuppressWarnings("java:S106")
public class HelloWorld implements Callable<Integer> {

    /**
     * The person's name
     */
    @CommandLine.Parameters(
            index = "0",
            arity = "0..1",
            description = "The name of the person to say hello to, specify '-' to use stdin",
            showDefaultValue = CommandLine.Help.Visibility.ALWAYS
    )
    private String name;

    /**
     * Prevent Picocli from throwing an error if someone doesn't add an argument
     */
    @CommandLine.Unmatched
    List<String> unmatched;

    /**
     * Entrypoint to the command
     *
     * @return the program exit code
     */
    @Override
    public Integer call() {
        if (name != null && !name.isBlank()) {
            System.out.println("Hello " + name + "!");
        } else {
            System.out.println("Hello World!");
        }
        return CommandLine.ExitCode.OK;
    }

}
