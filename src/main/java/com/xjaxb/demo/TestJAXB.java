package com.xjaxb.demo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Created by garychen on 2017/5/25.
 */
public class TestJAXB {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setId(1000);
        customer.setName("moon");
        customer.setAge(18);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(customer, System.out);

            //jaxbMarshaller.
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
