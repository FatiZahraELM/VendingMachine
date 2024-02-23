package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

//
//in this case the machine hasn't enough change
//
public class VendingMachine5Test {

        HashMap<Product,Integer> productInventory=new HashMap<Product,Integer>();

        {
            productInventory.put(Product.WATER, 3);
            productInventory.put(Product.BUENO, 3);
            productInventory.put(Product.TWIX, 3);

        }
        HashMap <Coins,Integer> coinInventory=new HashMap<Coins,Integer>();

        {        coinInventory.put(Coins.FIVE, 0);
            coinInventory.put(Coins.ONE,1);
            coinInventory.put(Coins.TWO,1);
            coinInventory.put(Coins.TEN, 1);


        }
        HashMap <Coins,Integer> onHoldCoins=new HashMap<Coins,Integer>();

        {
            onHoldCoins.put(Coins.TEN, 1);



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
