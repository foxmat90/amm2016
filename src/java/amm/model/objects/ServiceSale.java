/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model.objects;

/**
 *
 * @author foxma
 */
public class ServiceSale {

    String name;
    String description;
    String risk;
    String pic;
    int numbers;
    float price;
    String link;

    public ServiceSale() {
        this.name = "";
        this.description = "";
        this.risk = "";
        this.pic = "";
        this.numbers = 0;
        this.link = "";
        this.price = 0;
    }

    public String getNameService() {
        return this.name;
    }

    public void setNameService(String newName) {
        this.name = newName;
    }

    public String getDescriptionService() {
        return this.description;
    }

    public void setDescriptionService(String newDescription) {
        this.description = newDescription;
    }

    public String getRiskService() {
        return this.risk;
    }

    public void setRiskService(String newRisk) {
        this.risk = newRisk;
    }

    public String getPicService() {
        return this.pic;
    }

    public void setPicService(String newPic) {
        this.pic = newPic;
    }

    public int getNumbersService() {
        return this.numbers;
    }

    public void setNumbersService(int newNumbers) {
        this.numbers = newNumbers;
    }

    public String getLnkService() {
        return this.link;
    }

    public void setLinkService(String newLink) {
        this.link = newLink;
    }
    
       public float getPriceService() {
        return this.price;
    }

    public void setPriceService(float newPrice) {
        this.price = newPrice;
    }
}
