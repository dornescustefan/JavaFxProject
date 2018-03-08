package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import  javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by DOS on 8/20/2017.
 */
public class MainGUIController  {
    OrdersGUI  Table1 = new OrdersGUI();
    OrdersGUI  Table2 = new OrdersGUI();
    OrdersGUI  Table3 = new OrdersGUI();
    OrdersGUI  Table4 = new OrdersGUI();
    OrdersGUI  Table5 = new OrdersGUI();
    OrdersGUI  Table6 = new OrdersGUI();
    OrdersGUI  Table7 = new OrdersGUI();
    OrdersGUI  Table8 = new OrdersGUI();

    @FXML
    private Button table1;
    @FXML
    private Button table2;
    @FXML
    private Button table3;
    @FXML
    private Button table4;
    @FXML
    private Button table5;
    @FXML
    private Button table6;
    @FXML
    private Button table7;
    @FXML
    private Button table8;
    @FXML
    private MenuItem help;

    public void initialize(){
        table1.setOnAction(event -> {
            Table1.setTableNumber(1);
            Table1.displayOrdersForm();
       });
        table2.setOnAction(event -> {
           Table2.setTableNumber(2);
            Table2.displayOrdersForm();
       });
        table3.setOnAction(event -> {
            Table3.setTableNumber(3);
            Table3.displayOrdersForm();
        });
        table4.setOnAction(event -> {
            Table4.setTableNumber(4);
            Table4.displayOrdersForm();
        });
        table5.setOnAction(event -> {
            Table5.setTableNumber(5);
            Table5.displayOrdersForm();
        });
        table6.setOnAction(event -> {
            Table6.setTableNumber(6);
            Table6.displayOrdersForm();
        });
        table7.setOnAction(event -> {
            Table7.setTableNumber(7);
            Table7.displayOrdersForm();
        });
        table8.setOnAction(event -> {
            Table8.setTableNumber(8);
            Table8.displayOrdersForm();
        });

        help.setOnAction((ActionEvent event) -> {
            Stage stage = new Stage();

            stage.setTitle("How to use..");
            final Group rootGroup = new Group();
            final Scene scene = new Scene(rootGroup, 600, 250);

            final Text text1 = new Text(
                    25, 25,
                    "1. Click on a Table button, a table order form will pop up. "+ System.lineSeparator()
                    +System.lineSeparator()+
                            "2.Choose a pizza from the menu list, choose quantity from drop down list, " +  System.lineSeparator()
                            +"press Add to Order button and Click on the Menu List" + System.lineSeparator()
                    +System.lineSeparator()+
                            "3.Press Place Order Button, the order will appear in the Kitchen window"+ System.lineSeparator()
                    +System.lineSeparator()+
                            "4.On the Kitchen window Click on the order in the Orders List and Press the Cook Button, " + System.lineSeparator()
                            +"then after Click on the order in the Orders List and then on the Ready Button"+ System.lineSeparator()
                    +System.lineSeparator()+
                             "5.On the Table order form press the Order Served Button the" + System.lineSeparator()
                             +"the Pay Order Button "+ System.lineSeparator()
            );
            text1.setFont(Font.font(java.awt.Font.SERIF, 15));
            rootGroup.getChildren().add(text1);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

            /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("How to use");
            alert.setHeaderText(null);
            alert.setContentText("1. Click on a Table button, a table order form will pop up. "+ System.lineSeparator()
                                +"2.Choose a pizza from the menu list, choose quantity from drop down list, press Add to Order button and Click on the Menu List" + System.lineSeparator()
                                +"3.Press Place Order Button, the order will appear in the Kitchen window"+ System.lineSeparator()
                                +"4.In the Kitchen window Click on the order Press the Cook Button and after the Ready Button"+ System.lineSeparator()
                                +"5.On the Table order form press the Order Served Button and after the Pay Order Button "+ System.lineSeparator()
            );

            alert.showAndWait();*/
        });
    }
}
