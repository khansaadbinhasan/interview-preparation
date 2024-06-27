package interviews.loadshareSDET3;

import java.util.LinkedList;
import java.util.List;

public class Profile {
//    interviews.loadshareSDET3.PhoneNumbers phoneNumbers = new interviews.loadshareSDET3.PhoneNumbers();
    List<PhoneNumbers> phoneNumbersList = new LinkedList<>();

    public List<PhoneNumbers> getPhoneNumbersList() {
        return phoneNumbersList;
    }

    public void setPhoneNumbersList(List<PhoneNumbers> phoneNumbersList) {
        this.phoneNumbersList = phoneNumbersList;
    }
}
