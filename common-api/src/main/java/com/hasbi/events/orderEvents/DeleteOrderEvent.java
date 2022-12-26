package com.hasbi.events.orderEvents;

import com.hasbi.events.BaseEvent;

public class DeleteOrderEvent extends BaseEvent<String> {
    public DeleteOrderEvent(String commandId) {
        super(commandId);
    }
}
