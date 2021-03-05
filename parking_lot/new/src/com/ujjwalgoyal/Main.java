package com.ujjwalgoyal;

import com.ujjwalgoyal.commands.CommandExecutorFactory;
import com.ujjwalgoyal.exception.InvalidModeException;
import com.ujjwalgoyal.mode.InteractiveMode;
import com.ujjwalgoyal.sevice.ParkingLotService;

import java.io.IOException;

public class Main {
    public static void main(final String[] args) throws IOException {
        final OutputPrinter outputPrinter = new OutputPrinter();
        final ParkingLotService parkingLotService = new ParkingLotService();
        final CommandExecutorFactory commandExecutorFactory =
                new CommandExecutorFactory(parkingLotService);

        if (isInteractiveMode(args)) {
            new InteractiveMode(commandExecutorFactory, outputPrinter).process();
        }else {
            throw new InvalidModeException();
        }
    }
    private static boolean isInteractiveMode(final String[] args) {
        return args.length == 0;
    }
}
