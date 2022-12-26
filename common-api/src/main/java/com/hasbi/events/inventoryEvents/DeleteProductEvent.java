package com.hasbi.events.inventoryEvents;

import com.hasbi.events.BaseEvent;

public class DeleteProductEvent extends BaseEvent<String> {
    public DeleteProductEvent(String commandId) {
        super(commandId);
    }
}
