package com.developer.sefaz.cloudstartproject.service;


import com.developer.sefaz.cloudstartproject.records.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {


    @Autowired
    private RestTemplate client;
    public ResponseEntity<String> realizaCompra(Compra compra) {
        String estado = compra.endereco().estado();
        return client.exchange("http://Fornecedor/fornecedor/" + estado, HttpMethod.GET, null, String.class);
    }
}
