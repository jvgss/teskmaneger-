package com.empresa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrdemDeServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @NotNull
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    @NotNull
    private Servico servico;

    @NotNull
    @Temporal(TemporalType.DATE)
    private LocalDate dataInicio;

    @NotNull
    @Temporal(TemporalType.DATE)
    private LocalDate dataTermino;

    @NotNull
    private String status;

}
