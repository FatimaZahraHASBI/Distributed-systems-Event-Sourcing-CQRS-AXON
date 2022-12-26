package com.hasbi.events.categorieEvents;

import com.hasbi.events.BaseEvent;

public class DeleteCategorieEvent extends BaseEvent<String> {

    public DeleteCategorieEvent(String commandId) {
        super(commandId);
    }
}
