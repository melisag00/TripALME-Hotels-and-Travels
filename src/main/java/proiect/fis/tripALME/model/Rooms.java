package proiect.fis.tripALME.model;

public class Rooms {
    private String number;
    private String price;
    private String descriprion;


    public Rooms(String descriprion, String price, String number) {
        this.descriprion = descriprion;
        this.price = price;
        this.number = number;
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
