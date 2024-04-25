package br.com.luscadevs.msemail.model;

import java.util.Date;

public record Movimento(
        int codigo,
        String nome,
        Date dataHora) {
}
