package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by DOS on 9/28/2017.
 */
public class MenuData {
    //add MenuDataModel elements to menuData
    public ObservableList<MenuDataModel> menuData = FXCollections.observableArrayList(
            new MenuDataModel("Margherita", 0, 8.00),
            new MenuDataModel("Funghi", 0, 11.50),
            new MenuDataModel("Capricciosa", 0, 13.00),
            new MenuDataModel("Quattro Stagioni", 0, 12.00),
            new MenuDataModel("Marinara", 0, 12.00),
            new MenuDataModel("Calzone", 0, 11.00),
            new MenuDataModel("Rucola", 0, 12.5),
            new MenuDataModel("Napolitana", 0, 10.00));
    //function to return the menuData Obervable List
    public ObservableList<MenuDataModel> returnMenuData(){
        return this.menuData;
    }
}
