package io.github.samwiz.midtermcontest.services;

import io.github.samwiz.midtermcontest.models.Cart;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreCart implements Carts
{
    private final RestTemplate restTemplate;

    public FakeStoreCart(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<Cart> getAll()
    {
        String url = "https://fakestoreapi.com/carts";
        ResponseEntity<List<Cart>> response;
        response = this.restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Cart>>() {});

        return response.getBody();
    }
    @Override
    public Cart getById(long id)
    {
        String url = "https://fakestoreapi.com/carts/" + id;
        return this.restTemplate.getForObject(url, Cart.class);
    }
    @Override
    public List<Cart> getByDate(String startdate, String enddate)
    {
        String url = "https://fakestoreapi.com/carts?startdate="+startdate+"&enddate="+enddate;
        ResponseEntity<List<Cart>> response;
        response = this.restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Cart>>() {});
        return response.getBody();
    }
    @Override
    public List<Cart> getByUser(long userid)
    {
        String url = "https://fakestoreapi.com/carts/user/"+userid;
        ResponseEntity<List<Cart>> response;
        response = this.restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Cart>>() {});
        return response.getBody();
    }

    @Override
    public Cart addToCart(Cart newCart)
    {
        String url = "https://fakestoreapi.com/carts";
        return this.restTemplate.postForObject(url,newCart,Cart.class);
    }

    @Override
    public Cart updateCart(Long id, Cart updatedCart)
    {
        String url = "https://fakestoreapi.com/carts/"+ id;
        ResponseEntity<Cart> response = this.restTemplate.exchange(url,HttpMethod.PUT, new HttpEntity<>(updatedCart),Cart.class);
        return response.getBody();
    }
    @Override
    public Cart deleteCart(long id)
    {
        String url = "https://fakestoreapi.com/carts/"+id;
        ResponseEntity<Cart> response = this.restTemplate.exchange(url,HttpMethod.DELETE, null,Cart.class);
        return response.getBody();
    }
}


