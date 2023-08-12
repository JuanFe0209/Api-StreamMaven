package org.example.mapping.dtos;

import org.example.domain.enums.ClientType;

public record CustomerDto(Long id,
                          String name,
                          ClientType tier){

}
