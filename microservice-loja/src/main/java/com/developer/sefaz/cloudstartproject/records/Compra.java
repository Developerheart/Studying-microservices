package com.developer.sefaz.cloudstartproject.records;

import java.util.List;

public record Compra(List<Item> itens, Endereco endereco) {

    @Override
    public String toString() {
        return "Compra{" +
                "itens=" + itens +
                ", endereco=" + endereco +
                '}';
    }
}
