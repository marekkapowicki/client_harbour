package nl.ing.java.client.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class Container {
    private String containerId;
    private String name;
    private String size;
    private String location;
    private String info;
    private ContainerDetail containerDetail;
}
