package com.srayasmin.projetomc.domain.enums;

public enum EstadoPagamento {
    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int cod;
    private String descricao;

    private EstadoPagamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    // Getters
    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    // Método que recebe um código e retorna um objeto do tipo EstadoPagamento
    public static EstadoPagamento toEnum(Integer cod) {
        // Se o código for nulo, retorna nulo
        if (cod == null) {
            return null;
        }
        for (EstadoPagamento x : EstadoPagamento.values()) {
            // Se o código for igual ao código do objeto x, retorna o objeto x
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
