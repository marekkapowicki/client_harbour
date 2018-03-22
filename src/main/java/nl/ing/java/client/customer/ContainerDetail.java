package nl.ing.java.client.customer;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class ContainerDetail {
    private String status;
    private List<ActionDTO> actions;
}
