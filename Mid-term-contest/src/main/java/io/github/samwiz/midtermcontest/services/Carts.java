package io.github.samwiz.midtermcontest.services;

import io.github.samwiz.midtermcontest.models.Cart;

import java.util.List;

public interface Carts
{
    public List<Cart> getAll();
    public Cart getById(long id);
    public List<Cart> getByDate(String startdate, String enddate);
    public List<Cart> getByUser(long userid);
    public Cart addToCart(Cart newCart);
    public Cart updateCart(Long id, Cart updatedCart);
    public Cart deleteCart(long id);
}
