package fw.helpers;

import fw.ApplicationManager;
import tests.Contact;

public class ContactHelper extends HelperBase {

    private Contact firstContact;

    public ContactHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createContact(Contact contact) {
        initContactCreation();

        fillContact(contact);

        save();
    }

    private void save() {
        manager.getAutoItHelper().click("Save")
                .winWaitAndActivate("AddressBookPortable", "", 5000);
    }

    private void fillContact(Contact contact) {
        manager.getAutoItHelper()
                .send("TBDEdit12", contact.firstName)
                .send("TBDEdit11", contact.lastName);
    }

    private void initContactCreation() {
        manager.getAutoItHelper()
                .winWaitAndActivate("AddressBookPortable", "", 5000)
                .click("Add").winWaitAndActivate("Add Contact", "", 5000);
    }

    public Contact getFirstContact() {


        manager.getAutoItHelper()
                .winWaitAndActivate("Add Contact", "", 5000)
        .click("TlistVIewe1")
        .send("{DOWN}{SPACE}")
        .click("Edit").winWaitAndActivate("Update Contact", "", 5000);

        String firstName = manager.getAutoItHelper()
                .getText("TBedit12");
        String lastName = manager.getAutoItHelper()
                .getText("TBedit11");

        manager.getAutoItHelper().click("Cancel").winWaitAndActivate("AddressBookPortable", "", 5000);

        return new Contact().setFirstName(firstName).setLastName(lastName);
    }
}
