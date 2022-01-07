package dev.alexengrig.sample.customer.payload;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
