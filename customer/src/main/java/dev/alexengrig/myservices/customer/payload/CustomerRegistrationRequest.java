package dev.alexengrig.myservices.customer.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class CustomerRegistrationRequest {

    private String firstName;
    private String lastName;
    private String email;

}
