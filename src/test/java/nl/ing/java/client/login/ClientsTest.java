package nl.ing.java.client.login;

import nl.ing.java.client.customer.*;
import nl.ing.java.client.offers.MarketPlaceClient;
import nl.ing.java.client.offers.OffersResponse;
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

        Container detail = customerClient.containerDetail("ashish.jain@ing.com", "3");
    }

    @Test
    @Ignore
    public void marketPlaceClient() throws IOException {
        MarketPlaceClient marketPlaceClient = MarketPlaceClient.build("http://localhost:9091/");
        OffersResponse response = marketPlaceClient.allOffers();
        response = marketPlaceClient.getOffers("Utrecht");
        System.out.println("response = " + response);
    }

    @Test
    @Ignore
    public void changeStatus() throws IOException {
        CustomerClient customerClient = CustomerClient.build("http://localhost:9090/api/");
        boolean isSuccess = customerClient.changeStatus("ashish.jain@ing.com", "2", Status.CARRIER.name().toLowerCase());
        System.out.println("isSuccess = " + isSuccess);
    }
}