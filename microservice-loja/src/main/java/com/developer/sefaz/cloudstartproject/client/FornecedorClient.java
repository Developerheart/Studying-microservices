package com.developer.sefaz.cloudstartproject.client;

import com.developer.sefaz.cloudstartproject.records.Endereco;
import com.developer.sefaz.cloudstartproject.records.InfoPedidoDTO;
import com.developer.sefaz.cloudstartproject.records.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping(path = "/info/{estado}", method = RequestMethod.GET)
    Endereco getInfoPorEstado(@PathVariable String estado);

    @RequestMapping(method = RequestMethod.POST, path = "/pedido")
    InfoPedidoDTO realizarPedido(List<Item> itens);

}
