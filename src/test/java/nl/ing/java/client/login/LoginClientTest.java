package nl.ing.java.client.login;

import org.junit.Test;

import java.io.IOException;


public class LoginClientTest {

    @Test
    public void login() throws IOException {
        LoginClient loginClient = LoginClient.build("http://10.1.3.229:9090/api/");
        loginClient.login("ashish.jain@ing.com","somePassword");
    }
}