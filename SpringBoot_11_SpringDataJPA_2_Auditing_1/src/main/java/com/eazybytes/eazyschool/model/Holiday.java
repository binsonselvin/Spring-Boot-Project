package com.eazybytes.eazyschool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="holidays")
public class Holiday {

	@Id
    private String day;
    private String reason;
    //converts enum to string
    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type { 
        FESTIVAL, FEDERAL
    }
}
