package nl.ing.java.client.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@AllArgsConstructor
@NotNull
@Getter
public class CustomerResponse {
    private Collection<ContainerResponse> containers;
}
