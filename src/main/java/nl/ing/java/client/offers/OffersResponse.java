package nl.ing.java.client.offers;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class OffersResponse {

    private Collection<OfferResponse> offers;
}

