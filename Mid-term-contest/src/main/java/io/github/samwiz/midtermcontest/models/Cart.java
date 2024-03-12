package io.github.samwiz.midtermcontest.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Cart
{
    @Setter
    @Getter
    private long id;
    private long userId;
    private String date;
    private List<Product> products;
}
