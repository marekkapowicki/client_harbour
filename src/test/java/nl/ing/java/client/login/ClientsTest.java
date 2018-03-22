package nl.ing.java.client.login;

import nl.ing.java.client.customer.CustomerClient;
import nl.ing.java.client.customer.CustomerResponse;
import nl.ing.java.client.customer.PortClient;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;


public class ClientsTest {

    @Test
    @Ignore
    public void login() throws IOException {
        LoginClient loginClient = LoginClient.build("http://10.1.3.229:9090/api/");
        loginClient.login("ashish.jain@ing.com","somePassword");
    }

    @Test
    @Ignore
    public void port() throws IOException {
        PortClient portClient = PortClient.build("http://localhost:8888/port/api/");
        portClient.getAll();
    }

    @Test
    @Ignore
    public void getCustomerByEmail() throws IOException {
        CustomerClient customerClient = CustomerClient.build("http://localhost:9090/api/");
        CustomerResponse response = customerClient.getContainersByEmail("ashish.jain@ing.com");

    }
}