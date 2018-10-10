package com.example.demoESB.endpoint;

import java.util.List;

import javax.annotation.Resource;

import com.example.demoESB.entities.Cliente;
import com.example.demoESB.model.Customer;
import com.example.demoESB.repository.ClienteJPARepositorio;
import com.example.demoESB.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


@Component
@Qualifier("inboundEndpoint")
public class InboundEndpoint {
    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    @Resource
    CustomerService custService;


    @Qualifier("get")
    public Message<?> get(Message<?> msg) {
        log.info("GET method");
        List<Customer> custLst = custService.getAll();
        return MessageBuilder.withPayload(custLst).copyHeadersIfAbsent(msg.getHeaders())
                .setHeader("http_statusCode", HttpStatus.OK).build();
    }

    @Qualifier("post")
    public void post(Message<Customer> msg){
        log.info("POST method");
        custService.insert(msg.getPayload());
    }

    @Qualifier("put")
    public void put(Message<Customer> msg){
        log.info("PUT method");
        custService.change(msg.getPayload());
    }

    @Qualifier("delete")
    public void delete(Message<String>msg){
        log.info("DELETE method");
        int id = Integer.valueOf(msg.getPayload());
        custService.delete(id);
    }
}
