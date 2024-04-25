package br.com.luscadevs.msemail.model;

import java.util.Date;
import java.util.List;

public record Processo(
                String numeroProcesso,
                String classe,
                String sistema,
                String formato,
                String tribunal,
                Date dataHoraUltimaAtualizacao,
                String grau,
                Date dataAjuizamento,
                List<Movimento> movimentos,
                String id,
                int nivelSigilo,
                String orgaoJulgador,
                List<String> assuntos) {
}
