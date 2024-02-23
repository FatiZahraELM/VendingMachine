package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class VendingMachine {

        private HashMap<Product, Integer> productInventory;
        private HashMap<Coins, Integer> coinsInventory;
        private HashMap<Coins, Integer> onHoldCoins;

    public void setProductInventory(HashMap<Product, Integer> productInventory) {
        this.productInventory = productInventory;
    }

    public void setCoinsInventory(HashMap<Coins, Integer> coinsInventory) {
        this.coinsInventory = coinsInventory;
    }

    public void setOnHoldCoins(HashMap<Coins, Integer> onHoldCoins) {
        this.onHoldCoins = onHoldCoins;
    }

    public void addProductToInventory(Product product, Integer quantity) {
            productInventory.put(product,quantity);
        }
        public void addCoinsToInventary(Coins coin,Integer quantity){
            coinsInventory.put(coin,quantity);
        }

    public VendingMachine(HashMap<Product, Integer> productInventory, HashMap<Coins, Integer> coinsInventory, HashMap<Coins, Integer> onHoldCoins) {
        this.productInventory = productInventory;
        this.coinsInventory = coinsInventory;
        this.onHoldCoins = onHoldCoins;
    }

    public void buyProduct(Product product) {

            double givenCoins=0;
            double totalPrice=product.getPrice();
            for(Coins coin : onHoldCoins.keySet()){
                givenCoins+=coin.getValue()*onHoldCoins.get(coin);
            }
            ArrayList change=generateChange(givenCoins-totalPrice);
            if(generateChange(givenCoins-totalPrice)==null){
                System.out.println("change not enough");
            } else
            if(totalPrice<=givenCoins  ){
                if (productInventory.get(product)>0) {
                    extractProduct(product);
                    System.out.println("Provided: "+givenCoins);
                    for(Coins coin : onHoldCoins.keySet()) {
                        addCoinsToInventary(coin,coinsInventory.get(coin)+onHoldCoins.get(coin));
                    }
                    System.out.println("change: "+generateChange(givenCoins-totalPrice));
                    System.out.println("Enjoy your " +product.getName() );

                    onHoldCoins.clear();

                } else System.out.println("product not available");

            }
            else System.out.println("money not enough");

        }

    private void extractProduct(Product product) {
            int newQuantity=productInventory.get(product)-1;
            productInventory.put(product,newQuantity);
    }

    public ArrayList generateChange(double change){

        ArrayList coinsToGenerate = new ArrayList();
        int rest= (int) change;

            while (rest > 0) {
                Coins rightCoin = selectCoin(rest);
                if (rightCoin == null)  return null;
                else{
                    int quantity = coinsInventory.get(rightCoin);
                    rest = rest - rightCoin.getValue();

                    coinsToGenerate.add(coinsToGenerate.size(), rightCoin);
                    coinsInventory.put(rightCoin, quantity - 1);


                }

            }
            if(coinsToGenerate.isEmpty())
                coinsToGenerate.add(0);

             return coinsToGenerate ;
        }

    private Coins selectCoin(int rest) {
        if(rest>=Coins.TEN.getValue() && coinsInventory.get(Coins.TEN)>0) return Coins.TEN;
        if(rest>=Coins.FIVE.getValue() && coinsInventory.get(Coins.FIVE)>0) return Coins.FIVE;
        if(rest>=Coins.TWO.getValue() && coinsInventory.get(Coins.TWO)>0) return Coins.TWO;
        if(rest>=Coins.ONE.getValue() && coinsInventory.get(Coins.ONE)>0) return Coins.ONE;
        return null;
    }


    public void refund(){
            onHoldCoins.clear();
        }
}
