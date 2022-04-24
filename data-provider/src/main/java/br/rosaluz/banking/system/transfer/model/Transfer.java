package br.rosaluz.banking.system.transfer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @NotNull
    private Long accountOrigin;

    public long getId() {
        return id;
    }

    public Long getAccountOrigin() {
        return accountOrigin;
    }

    public Long getAccountDestination() {
        return accountDestination;
    }

    public Double getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    @NotNull
    private Long accountDestination;
    @NotNull
    private Double value;
    @NotNull
    private String type;

}
