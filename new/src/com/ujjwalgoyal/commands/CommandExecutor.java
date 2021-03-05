package com.ujjwalgoyal.commands;

import com.ujjwalgoyal.OutputPrinter;
import com.ujjwalgoyal.model.Command;
import com.ujjwalgoyal.sevice.ParkingLotService;

public abstract class CommandExecutor {
    protected ParkingLotService parkingLotService;
    protected OutputPrinter outputPrinter;

    public CommandExecutor(final ParkingLotService parkingLotService,
                           final OutputPrinter outputPrinter) {
        this.parkingLotService = parkingLotService;
        this.outputPrinter = outputPrinter;
    }


    public abstract boolean validate(Command command);


    public abstract void execute(Command command);
}
