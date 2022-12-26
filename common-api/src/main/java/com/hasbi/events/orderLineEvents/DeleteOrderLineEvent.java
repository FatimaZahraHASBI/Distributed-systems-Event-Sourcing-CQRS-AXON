package com.hasbi.events.orderLineEvents;

import com.hasbi.events.BaseEvent;

public class DeleteOrderLineEvent extends BaseEvent<String> {
    public DeleteOrderLineEvent(String commandId) {
        super(commandId);
    }
}
