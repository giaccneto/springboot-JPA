package com.bookstore.jpa.dtos;

import java.util.Set;
import java.util.UUID;

public record BookRecorDto(String title,
                           UUID publisherId,
                           Set<UUID> authorIds,
                           String reviewComment){
}
