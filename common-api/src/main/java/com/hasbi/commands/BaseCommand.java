package com.hasbi.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseCommand<T> {
    @Getter
    @TargetAggregateIdentifier
    private T commandId;

    public BaseCommand(T commandId) {
        this.commandId = commandId;
    }
}
