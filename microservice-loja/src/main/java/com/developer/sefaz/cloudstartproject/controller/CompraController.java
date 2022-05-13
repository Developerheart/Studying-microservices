package com.developer.sefaz.cloudstartproject.controller;


import com.developer.sefaz.cloudstartproject.client.FornecedorClient;
import com.developer.sefaz.cloudstartproject.records.Compra;
import com.developer.sefaz.cloudstartproject.records.Endereco;
import com.developer.sefaz.cloudstartproject.records.InfoPedidoDTO;
import com.developer.sefaz.cloudstartproject.service.CompraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/compra")
public class CompraController {

    private static final Logger logger  = LoggerFactory.getLogger(CompraController.class);

    @Autowired
    private CompraService compraService;

    @Autowired
    private DiscoveryClient eurekaCliente;

    @Autowired
    private FornecedorClient fornecedorClient;

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public InfoPedidoDTO realizarCompra(@RequestBody Compra compra) {
        // remover
        eurekaCliente.getInstances("Fornecedor")
                .forEach(
                        fornecedor -> System.out.println("LOCALHOST: PORT: " + fornecedor.getPort())
                );
        Endereco infoPorEstado = fornecedorClient.getInfoPorEstado(compra.endereco().estado());
        System.out.println(infoPorEstado);
        InfoPedidoDTO infoPedidoDTO = fornecedorClient.realizarPedido(compra.itens());
        logger.info(compra.toString());
        return infoPedidoDTO;
    }



}
