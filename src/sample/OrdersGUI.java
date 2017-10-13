package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.IOException;

/**
 * Created by DOS on 6/3/2017.
 */
class OrdersGUI {

    private static int tableNumber;
    public static int getTableNumber() {
        return tableNumber;
    }
    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }

    public void displayOrdersForm(){
     VBox vBoxOrders = null;
        try {
            vBoxOrders = FXMLLoader.load(getClass().getResource("OrdersGUIFXML.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

     Stage stage = new Stage();
     stage.setTitle("Table"+getTableNumber()+" order form");
     stage.setResizable(false);
     // disable X on the window
     stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
      @Override
     public void handle(WindowEvent event) {
         // consume event
         event.consume();
            }
        });
     stage.setScene(new Scene(vBoxOrders));
     stage.show();
    }
}
