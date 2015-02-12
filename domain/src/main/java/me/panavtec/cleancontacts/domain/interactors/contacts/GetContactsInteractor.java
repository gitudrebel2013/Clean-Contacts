package me.panavtec.cleancontacts.domain.interactors.contacts;

import me.panavtec.cleancontacts.domain.EventBus;
import me.panavtec.cleancontacts.domain.interactors.Interactor;
import me.panavtec.cleancontacts.domain.entities.Contact;
import me.panavtec.cleancontacts.domain.interactors.contacts.events.GetContactsEvent;
import me.panavtec.cleancontacts.domain.interactors.contacts.exceptions.CantRetrieveContactsException;
import me.panavtec.cleancontacts.domain.repository.ContactsRepository;

import java.util.List;

public class GetContactsInteractor implements Interactor {

    private EventBus bus;
    private ContactsRepository repository;

    public GetContactsInteractor(EventBus bus, ContactsRepository repository) {
        this.bus = bus;
        this.repository = repository;
    }

    @Override public void execute() {
        GetContactsEvent event = new GetContactsEvent();
        try {
            List<Contact> contacts = repository.obtainContacts();
            event.setContacts(contacts);
        } catch (CantRetrieveContactsException e) {
            event.setError(e);
        }
        bus.post(event);
    }

}
