package com.ujjwalgoyal.commands;

import com.ujjwalgoyal.OutputPrinter;
import com.ujjwalgoyal.model.Command;
import com.ujjwalgoyal.sevice.ParkingLotService;

public class ExitCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "exit";

    public ExitCommandExecutor(
            final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(final Command command) {
        return command.getParams().isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final Command command) {
        outputPrinter.end();
    }
}
