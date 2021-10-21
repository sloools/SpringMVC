package me.song.mvcfirst.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long cd;
    private String name;
    private Integer price;
    private boolean salePsblFlg;

}
