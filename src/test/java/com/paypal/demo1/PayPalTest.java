package com.paypal.demo1;

import com.paypal.api.payments.CreditCard;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.junit.Test;

/**
 * Created by garychen on 2017/7/5.
 */
public class PayPalTest {

    @Test
    public void test01(){
        //Replace these values with your clientId and secret. You can use these to get started right now.
        String clientId = "AcWqBkA-BwLgG5Wn3buL4SrPCeW63b36kRBD9gToa6gVlukMmU1SPn8qORDSYl4eU5JfcspZ_8QaiyT1";
        String clientSecret = "EFSEJ_oIfTQ3AXdrqdSmRexk8QerUOzIEMQ4VH6mP30wkMQ50TwMCGDoLPFsKEnqOyHyiycdm3aYjymm";
        CreditCard card = new CreditCard()
                .setType("visa")
                .setNumber("4417119669820331")
                .setExpireMonth(11)
                .setExpireYear(2019)
                .setFirstName("辉")
                .setLastName("陈");

        try {
            APIContext context = new APIContext(clientId, clientSecret, "sandbox");
            card.create(context);
            System.out.println(card.toJSON());
        } catch (PayPalRESTException e) {
            System.err.println(e.getDetails());
        }
    }
}
