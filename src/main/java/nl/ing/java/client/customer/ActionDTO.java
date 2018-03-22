package nl.ing.java.client.customer;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class ActionDTO {
    private String description;
    private Boolean completed;
}
