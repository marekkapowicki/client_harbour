package nl.ing.java.client.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class CustomerResponse {
    private Collection<Container> containers;
}
