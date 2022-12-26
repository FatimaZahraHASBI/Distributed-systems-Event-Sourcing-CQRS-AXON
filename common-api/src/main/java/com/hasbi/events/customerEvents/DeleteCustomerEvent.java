package com.hasbi.events.customerEvents;

import com.hasbi.events.BaseEvent;

public class DeleteCustomerEvent extends BaseEvent<String> {
    public DeleteCustomerEvent(String commandId) {
        super(commandId);
    }
}
