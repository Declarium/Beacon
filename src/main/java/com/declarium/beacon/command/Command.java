package com.declarium.beacon.command;

import java.lang.annotation.*;

/**
 * An annotation used to mark a method as accessible
 * via a command, whereby the parameters are used to
 * define the command details.
 *
 * @author Jay Carr
 * @version 1.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {

    /**
     * The name of the command which runs the method.
     *
     * @return the command name
     */
    String name();

    /**
     * The argument(s) used to access this command,
     * if this command is a sub-command.
     *
     * @return the sub-command argument(s)
     */
    String[] arguments() default {};

    /**
     * The description of the command, which is used
     * within command usage messages.
     *
     * @return the command description
     */
    String description();

    /**
     * The usage of the command, with regard to its
     * applicable parameters, which is used within
     * command usage messages.
     *
     * @return the command usage
     */
    String usage() default "";

    /**
     * The permission required to use the command.
     *
     * @return the permission required
     */
    String permission() default "";

    /**
     * The minimum amount of arguments required to
     * execute the command.
     *
     * @return the minimum arguments required
     */
    int minArgs() default 0;

    /**
     * Whether the command can be used within the
     * console.
     *
     * @return whether the command is accessible
     *         to the console
     */
    boolean console() default true;
}