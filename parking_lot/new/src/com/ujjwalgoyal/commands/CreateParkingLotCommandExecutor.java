package com.ujjwalgoyal.commands;

import com.ujjwalgoyal.OutputPrinter;
import com.ujjwalgoyal.model.Command;
import com.ujjwalgoyal.model.Parking.strategy.NaturalOrderParkingStrategy;
import com.ujjwalgoyal.model.ParkingLot;
import com.ujjwalgoyal.sevice.ParkingLotService;
import com.ujjwalgoyal.validator.IntegerValidator;

import java.util.List;

public class CreateParkingLotCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(
            final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(final Command command) {
        final List<String> params = command.getParams();
        if (params.size() != 1) {
            return false;
        }
        return IntegerValidator.isInteger(params.get(0));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final Command command) {
        final int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
        final ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
        parkingLotService.createParkingLot(parkingLot, new NaturalOrderParkingStrategy());
        outputPrinter.printWithNewLine(
                "Created a parking lot with " + parkingLot.getCapacity() + " slots");
    }
}
