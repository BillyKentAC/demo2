package com.example.demoESB.endpoint;

import com.example.demoESB.entities.Cliente;
import com.example.demoESB.repository.ClienteJPARepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Qualifier("inboundEndpoint")
public class InboundEndpointCliente {


    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    @Resource
    ClienteJPARepositorio clienteJPARepositorio;

    @Qualifier("geta")
    public Message<?> geta(Message<?> msg) {
        log.info("GET method clientes");
        List<Cliente> clienteList = clienteJPARepositorio.findAll();
        return MessageBuilder.withPayload(clienteList).copyHeadersIfAbsent(msg.getHeaders())
                .setHeader("http_statusCode", HttpStatus.OK).build();
    }
}
