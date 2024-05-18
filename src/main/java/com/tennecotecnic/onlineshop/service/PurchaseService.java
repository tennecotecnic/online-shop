package com.tennecotecnic.onlineshop.service;

import com.tennecotecnic.onlineshop.model.product.Product;
import com.tennecotecnic.onlineshop.model.purchase.Purchase;
import com.tennecotecnic.onlineshop.model.purchase.PurchasePosition;
import com.tennecotecnic.onlineshop.repository.PurchaseFileRepository;
import java.io.IOException;
import java.util.Collection;


public class PurchaseService {


    private LoginService loginService;
    private PurchaseFileRepository purchaseFileRepository = new PurchaseFileRepository();


    public PurchaseService(LoginService loginService){
        this.loginService = loginService;
    }

    private void createPurchase(Integer userId) {            //метод без проверки залогинен ли юзер,
            Purchase purchase = new Purchase(userId);        //т.к. он приватный, по крайней мере пока что
            purchaseFileRepository.create(purchase);
    }

    public void addPurchasePosition(Integer userId, Product product, Integer quantity) throws IOException {
        if(loginService.checkLogin(userId)) {
            Purchase purchase = getLastUnpaidByUserId(userId);
            PurchasePosition purchasePosition = new PurchasePosition(product, quantity);
            Collection<PurchasePosition> purchaseCollection = purchase.getPositions();
            purchaseCollection.add(purchasePosition);
            purchase.setPositions(purchaseCollection);
            purchaseFileRepository.update(purchase);
        }
    }


    public Purchase getLastUnpaidByUserId(Integer userId) throws IOException {
        Purchase purchase = null;
        if(loginService.checkLogin(userId)) {
            Collection<Purchase> purchaseCollection = purchaseFileRepository.getAllByUserId(userId);
            for (Purchase purchaseForEach : purchaseCollection) {
                if (purchaseForEach.getStatus() == Purchase.Status.UNPAID) {
                    purchase = purchaseForEach;
                } else {
                    createPurchase(userId);
                    getLastUnpaidByUserId(userId);
                }
            }
        }
            return purchase;
    }





    //public void printBill(Integer purchaseId) {}

}
