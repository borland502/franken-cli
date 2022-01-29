package com.technohouser.frankencli;

import com.technohouser.frankencli.command.HelloWorld;
import com.technohouser.frankencli.command.Reflect;
import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

/**
 * Command line entrypoint
 *
 * @author Jeremy Hettenhouser
 */
@SpringBootApplication
@SpringBootConfiguration
@CommandLine.Command(
        name = "app",
        description = "CLI Application",
        aliases = {"app"},
        header = "APP",
        footer = "(c) Jeremy Hettenhouser",
        mixinStandardHelpOptions = true,
        subcommands = {
                CommandLine.HelpCommand.class,
                HelloWorld.class,
                Reflect.class
        }
)
public class App {

    /**
     * Bootstrap the command
     *
     * @param args the command line args
     */
    public static void main(final String[] args) {
        val defaultColorScheme = CommandLine.Help.defaultColorScheme(CommandLine.Help.Ansi.AUTO);
        val colorScheme = new CommandLine.Help.ColorScheme.Builder(defaultColorScheme)
                .commands(CommandLine.Help.Ansi.Style.bold, CommandLine.Help.Ansi.Style.fg_cyan)
                .build();
        val status = new CommandLine(new App())
                .setColorScheme(colorScheme)
                .execute(args);

        Runtime.getRuntime().halt(status);
    }

}
