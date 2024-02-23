package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
//
//in this case the user has given the exact some of money as the product price
//
public class VendingMachine1Test {
HashMap <Product,Integer> productInventory=new HashMap<Product,Integer>();

    {
        productInventory.put(Product.WATER, 3);
        productInventory.put(Product.BUENO, 3);
        productInventory.put(Product.TWIX, 3);

    }
    HashMap <Coins,Integer> coinInventory=new HashMap<Coins,Integer>();

    {        coinInventory.put(Coins.FIVE, 3);
        coinInventory.put(Coins.ONE,3);
        coinInventory.put(Coins.TWO,3);
        coinInventory.put(Coins.TEN, 3);


    }
    HashMap <Coins,Integer> onHoldCoins=new HashMap<Coins,Integer>();

    {
        onHoldCoins.put(Coins.FIVE, 1);


    }

    VendingMachine vendingMachine=new VendingMachine(productInventory,coinInventory,onHoldCoins);

    @Test
    public void attemptToBuyWater(){
        System.out.println("old products stock: "+productInventory);
        System.out.println("old Coins stock: "+coinInventory);

        vendingMachine.buyProduct(Product.WATER);

        System.out.println("new product stock: "+productInventory);
        System.out.println("new Coins stock: "+coinInventory);

    }

}
