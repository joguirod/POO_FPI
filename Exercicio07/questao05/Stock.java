package Exercicio07.questao05;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Stock {
    private List<Product> products = new ArrayList<Product>();

    public void insert(Product product, Date currentDate){
        if(checkPerId(product.getId()) == null){
            boolean sameNameExist = false;
            for(int i = 0; i < products.size(); i++){
                if (product.getName().equals(products.get(i).getName())){
                    sameNameExist = true;
                    break;
                }
                if (!sameNameExist && !(product instanceof PerishableProduct)) products.add(product);
                else if (!sameNameExist){
                    if (((PerishableProduct) product).notExpired(currentDate)) products.add(product);
                }
            }
        }
    }

    public Product checkPerId(int wantedId){
        for (Product product : products){
            if(product.getId() == wantedId){
                return product;
            }
        }
        return null;
    }

    public int indexSearch(int wantedId){
        int wantedIndex = -1;
        for(int i = 0; i < products.size(); i++){
            if (products.get(i).getId() == wantedId){
                wantedIndex = i;
            }
        }
        return wantedIndex;
    }

    public void deleteProduct(int wantedId){
        int wantedIndex = indexSearch(wantedId);

        if(wantedIndex != -1){
            for (int i = wantedIndex; i < products.size(); i++){
                products.set(i, products.get(i + 1));
            }
            products.remove(products.size() - 1);
        }
    }

    public void replace(int wantedId, int replaceQty){
        Product product = checkPerId(wantedId);
        if (product != null) {
            product.replace(replaceQty);
        }
    }

    public void reduce(int wantedId, int reduceQty){
        Product product = checkPerId(wantedId);
        if (product != null) {
            product.reduce(reduceQty);
        }
    }

    public void showExpiredProducts(){
        for(Product product : products){
            if (product instanceof PerishableProduct){
                System.out.println("Name: " + product.getName() + "\nID: " + product.getId());
            }
        }
    }
}
