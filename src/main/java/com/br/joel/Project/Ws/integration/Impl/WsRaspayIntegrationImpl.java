package com.br.joel.Project.Ws.integration.Impl;


import com.br.joel.Project.Ws.DTO.wsRaspay.CustomerModelDTO;
import com.br.joel.Project.Ws.DTO.wsRaspay.OrderDTO;
import com.br.joel.Project.Ws.DTO.wsRaspay.PaymentDTO;
import com.br.joel.Project.Ws.integration.WsRaspayIntegration;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {


    private RestTemplate restTemplate;


    public WsRaspayIntegrationImpl() {
        restTemplate = new RestTemplate();
    }
    @Override
    public CustomerModelDTO createCustomerModelDto(CustomerModelDTO dto) {
       try
       {

           HttpHeaders httpHeaders = getHttpHeaders();


           String url = "http://localhost:8081/ws-raspay/v1/customer";

           HttpEntity<CustomerModelDTO> request= new HttpEntity<>(dto, httpHeaders);
           ResponseEntity<CustomerModelDTO> responseEntity =

                   restTemplate.exchange( url, HttpMethod.POST, request, CustomerModelDTO.class);

                   return responseEntity.getBody();


       }catch (Exception e) {

           throw  e;
       }
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {

        try {
            HttpHeaders httpHeaders = getHttpHeaders();
            String url = "http://localhost:8081/ws-raspay/v1/order";

            HttpEntity<OrderDTO> orderDTOHttpEntity = new HttpEntity<>(orderDTO, httpHeaders);
            ResponseEntity<OrderDTO> orderDTOResponseEntity=
                    restTemplate.exchange(url, HttpMethod.POST, orderDTOHttpEntity, OrderDTO.class);

            return  orderDTOResponseEntity.getBody();


        }catch (Exception e) {
            throw  e;

        }




    }

    @Override
        public Boolean createPayment(PaymentDTO paymentDTO) {

        try {
            HttpHeaders httpHeaders = getHttpHeaders();
            String url = "http://localhost:8081/ws-raspay/v1/payment/credit-card/";


            HttpEntity<PaymentDTO> request = new HttpEntity<>(paymentDTO,httpHeaders);

            ResponseEntity<Boolean> respose =

                    restTemplate.exchange(url, HttpMethod.POST, request, Boolean.class);



            return respose.getBody();




        }catch (Exception e) {
            throw  e;

        }
    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        String credential = "rasmooplus:r@sm00";
        byte[] credential64 = credential.getBytes();
        byte[] base64 = Base64.encodeBase64(credential64);
        String base64Creds= new String(base64);

        httpHeaders.add("Authorization", "Basic "+ base64Creds );
        return httpHeaders;
    }


}
