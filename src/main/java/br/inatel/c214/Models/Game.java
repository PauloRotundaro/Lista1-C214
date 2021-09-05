package br.inatel.c214.Models;

import lombok.Data;

@Data
public class Game {
    private int rank;
    private int year;
    public String genre;
    private String name;
    private String platform;
    public String publisher;
    public String na_sales;
    public String eu_sales;
    public String jp_sales;
    public String other_sales;
    public String global_sales;
}
