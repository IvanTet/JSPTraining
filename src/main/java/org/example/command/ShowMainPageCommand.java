package org.example.command;

public enum ShowMainPageCommand implements Command {
    INSTANCE;
    private static final String FORWARD_TO_MAIN_PAGE = "/WEB-INF/jsp/main.jsp";

    @Override
    public CommandResponse execute(CommandRequest request){
        return new CommandResponse() {
            @Override
            public boolean isRedirect() {
                return false;
            }

            @Override
            public String getPath() {
                return FORWARD_TO_MAIN_PAGE;

            }
        };
    }
}
