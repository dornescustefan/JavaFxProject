package sample;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by DOS on 8/5/2017.
 */

public class MenuDataModel {
    private final SimpleStringProperty menuItem;
    private final SimpleIntegerProperty quantity;
    private final SimpleDoubleProperty price;

    public MenuDataModel(String mItem, Integer mQuantity, Double mPrice) {
        this.menuItem = new SimpleStringProperty(mItem);
        this.quantity = new SimpleIntegerProperty(mQuantity);
        this.price = new SimpleDoubleProperty(mPrice);
    }

    public String getMenuItem() {
        return menuItem.get();
    }

    public SimpleStringProperty menuItemProperty() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem.set(menuItem);
    }

    public Integer getQuantity() {
        return quantity.get();
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity.set(quantity);
    }

    public Double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(Double price) {
        this.price.set(price);
    }
}
