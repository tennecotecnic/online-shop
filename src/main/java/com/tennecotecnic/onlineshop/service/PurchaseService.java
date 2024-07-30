package com.tennecotecnic.onlineshop.service;

import com.tennecotecnic.onlineshop.model.product.Product;
import com.tennecotecnic.onlineshop.model.purchase.Purchase;
import com.tennecotecnic.onlineshop.model.purchase.PurchasePosition;
import com.tennecotecnic.onlineshop.repository.PurchaseFileRepository;
import com.tennecotecnic.onlineshop.util.MyStringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


public class PurchaseService {


    private LoginService loginService;
    private PurchaseFileRepository purchaseFileRepository = new PurchaseFileRepository();


    public PurchaseService(LoginService loginService) {
        this.loginService = loginService;
    }

    private void createPurchase(Integer userId) {            //метод без проверки залогинен ли юзер,
        Purchase purchase = new Purchase(userId);        //т.к. он приватный, по крайней мере пока что
        purchaseFileRepository.create(purchase);
    }

//    public void addPurchasePosition(Integer userId, Product product, float quantity) throws IOException {
//        if (loginService.checkLogin(userId)) {
//            Purchase purchase = getLastUnpaidByUserId(userId);
//            PurchasePosition purchasePosition = new PurchasePosition(product, quantity);
//            Collection<PurchasePosition> purchaseCollection = purchase.getPositions();
//            purchaseCollection.add(purchasePosition);
//            purchase.setPositions(purchaseCollection);
//            purchase.setTotalSumm(purchase.getTotalSumm() + product.getPrice() * quantity);
//            purchaseFileRepository.update(purchase);
//        }
//    }



    public void updatePurchasePosition(Integer userId, Product product, float quantity) throws IOException {
        if (loginService.checkLogin(userId)) {
            boolean isPositionFound = false;
            Purchase purchase = getLastUnpaidByUserId(userId);
            ArrayList<PurchasePosition> purchaseList = (ArrayList<PurchasePosition>) purchase.getPositions();
                for (int i = 0; i < purchaseList.size(); i++) {
                    if (purchaseList.get(i).getProductId() == product.getId()) {
                        isPositionFound = true;
                        float positionCost = purchaseList.get(i).getCost();
                        if (quantity == 0) {
                            purchaseList.remove(i);
                            purchase.setTotalSumm(purchase.getTotalSumm() - positionCost);
                        } else {
                            PurchasePosition updatePurchasePosition = new PurchasePosition(product, quantity);
                            purchaseList.set(i, updatePurchasePosition);
                            purchase.setTotalSumm(purchase.getTotalSumm() - positionCost + updatePurchasePosition.getCost());
                        }
                    }
                }
                if (!isPositionFound){
                    PurchasePosition purchasePosition = new PurchasePosition(product, quantity);
                    purchaseList.add(purchasePosition);
                    purchase.setPositions(purchaseList);
                    purchase.setTotalSumm(purchase.getTotalSumm() + product.getPrice() * quantity);
                    purchaseFileRepository.update(purchase);
                }
            purchase.setPositions(purchaseList);
            purchaseFileRepository.update(purchase);
        }
    }


    private Purchase getLastUnpaidByUserId(Integer userId) throws IOException {
        Purchase purchase = null;
            Collection<Purchase> purchaseCollection = purchaseFileRepository.getAllByUserId(userId);
            for (Purchase purchaseForEach : purchaseCollection) {
                if (purchaseForEach.getStatus() == Purchase.Status.UNPAID) {
                    purchase = purchaseForEach;
                } else {
                    createPurchase(userId);
                    getLastUnpaidByUserId(userId);
                }
            }
        return purchase;
    }


    public void updatePurchaseStatus(Integer userId, Integer purchaseId, Purchase.Status newStatus) throws IOException{
        if (loginService.checkLogin(userId)) {
            Purchase purchase = purchaseFileRepository.findById(purchaseId);
            purchase.setStatus(newStatus);
            purchaseFileRepository.update(purchase);
        }
    }


    public void printBill(Integer purchaseId) {
        Purchase purchase = purchaseFileRepository.findById(purchaseId);
        ArrayList<PurchasePosition> purchaseList = (ArrayList<PurchasePosition>) purchase.getPositions();
        System.out.println("                   Bill №" + purchaseId);
        for (PurchasePosition position : purchaseList) {
            System.out.println(MyStringUtil.cutstring(position.getDescription(), 9)
                    + MyStringUtil.cutstring(position.getProductPrice() + "", 9)
                    + MyStringUtil.cutstring(position.getQuantity() + "", 9)
                    + MyStringUtil.cutstring(position.getCost() + "", 9));
        }
        System.out.println("TOTAL                      " + purchase.getTotalSumm());
    }
}
