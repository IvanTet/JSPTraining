package org.example.command;

public enum CommandRegistry {

    MAIN_PAGE(ShowMainPageCommand.INSTANCE),
    DEFAULT(ShowMainPageCommand.INSTANCE);
    private final Command command;

    CommandRegistry(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public static Command of(String name) {
        for (CommandRegistry constant: values()) {
           if( constant.name().equals(name)){
               return constant.command;
           }
        }
        return DEFAULT.command;
    }

}
