package proiect.fis.tripALME.model;

public class Rooms {
    private String number;
    private String price;
    private String descriprion;
    private String newcategory;
    private String newdescription;

    public Rooms(String descriprion, String price, String number, String newcategory, String newdescription) {
        this.descriprion = descriprion;
        this.price = price;
        this.number = number;
        this.newcategory = newcategory;
        this.newdescription = newdescription;
    }

    public String getDescriprion() {
        return descriprion;
    }

    public String getNumber() {
        return number;
    }

    public String getPrice() {
        return price;
    }

    public String getNewcategory() {
        return newcategory;
    }

    public void setNewcategory(String newcategory) {
        this.newcategory = newcategory;
    }

    public String getNewdescription() {
        return newdescription;
    }

    public void setNewdescription(String newdescription) {
        this.newdescription = newdescription;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
