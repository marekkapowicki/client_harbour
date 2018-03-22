package nl.ing.java.client.offers;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OfferResponse {

    private Long id;

    private String destination;

    private BigDecimal price;

    private Integer durationInDays;

    private String transportType;


}
