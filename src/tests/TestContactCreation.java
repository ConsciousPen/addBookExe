package tests;

import fw.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestContactCreation extends TestBase {

    @Test
    public void createContactValidData() {
        Contact contact = new Contact().setFirstName("first name").setLastName("last name");
        app.getContactHelper().createContact(contact);
        Contact createdContact = app.getContactHelper().getFirstContact();
        Assert.assertEquals(contact,createdContact);
    }
}
