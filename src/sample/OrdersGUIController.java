package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by DOS on 8/20/2017.
 */

public class OrdersGUIController extends OrdersGUI {

@FXML
private ComboBox<Integer> orderQuantity;
@FXML
private TableView orderTable;
@FXML
private TableColumn tableQuantity;
@FXML
protected TableColumn tableMenuItem;
@FXML
private TableColumn tablePrice;
@FXML
private Label pizzaTypeLabel;
@FXML
private Button addToOrder;
@FXML
private Label orderStatus;
@FXML
private Button placeOrder;
@FXML
private Button orderServed;
@FXML
private Button payOrder;
@FXML
private Button newOrder;

    private   List<String> orderList = FXCollections.observableArrayList();
    private List<Double> orderPaymentList = FXCollections.observableArrayList();
    public static double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ObservableList<String> observableList;
    private TableView<MenuDataModel> table = new TableView<MenuDataModel>();
    private ObservableList<MenuDataModel> menuData = FXCollections.observableArrayList();
    private Calendar now = Calendar.getInstance();
    private static double totalAmount;

    public void initialize(){

        //populate table view with menuData from OrderGUI
        MenuData tableViewData = new MenuData();
        menuData = tableViewData.returnMenuData();
        table.setEditable(true);
        tableMenuItem.setCellValueFactory(
                new PropertyValueFactory<MenuDataModel, String>("menuItem"));
        tablePrice.setCellValueFactory(
                new PropertyValueFactory<MenuDataModel, Double>("price"));
        tableQuantity.setCellValueFactory(
                new PropertyValueFactory<MenuDataModel, Integer>("quantity"));
        orderTable.setItems(menuData);

        //bind pizzaTypeLabel and quantity combo box with the selection on the table view
        orderTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MenuDataModel>() {
        @Override
        public void changed(ObservableValue<? extends MenuDataModel> observable, MenuDataModel oldValue, MenuDataModel newValue) {
           pizzaTypeLabel.textProperty().bind(newValue.menuItemProperty());
              }
        });

        //Populate Combo box for Quantity
        ObservableList<Integer> quantityValues =  FXCollections.observableArrayList(0, 1, 2,3,4,5);
        orderQuantity.getItems().addAll(quantityValues);
        orderQuantity.setPromptText("Quantity");

        //Controller for Add to order Button
        addToOrder.setOnAction(event -> {
            orderTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MenuDataModel>(){
            @Override
            public void changed(ObservableValue<? extends MenuDataModel> observable, MenuDataModel oldValue, MenuDataModel newValue){
            oldValue.setQuantity(orderQuantity.getValue());
            orderTable.getSelectionModel().selectedItemProperty().removeListener(this);
                }
            });
        });

        //Controller for Place Order Button
        placeOrder.setOnAction(event ->{
            orderList= menuData.stream()
                .filter(x -> x.getQuantity()>0)
                .map(menuDataModel -> menuDataModel.getQuantity() +" "+ menuDataModel.getMenuItem())
                .collect(Collectors.toList());
            observableList = FXCollections.observableList(orderList);
            KitchenGUIController.order.add("Table" + getTableNumber() +" "+ orderList.toString());
            orderStatus.setText("Order placed at: " +  now.get(Calendar.HOUR)+":"+now.get(Calendar.MINUTE));
        });

       //Controller for Order Served Button
        orderServed.setOnAction(event -> {orderStatus.setText("Served at: " + now.get(Calendar.HOUR)+":"+now.get(Calendar.MINUTE));
        });

        //Controller for Pay Order Button
        payOrder.setOnAction(event -> {
            orderPaymentList= menuData.stream()
                .filter(x -> x.getQuantity()>0)
                .map(menuDataModel -> menuDataModel.getQuantity()*menuDataModel.getPrice())
                .collect(Collectors.toList());
            setTotalAmount(orderPaymentList.stream().mapToDouble(e->e.doubleValue()).sum());
            orderStatus.setText("Total amount: " + getTotalAmount());
            System.out.println("--------------------------");
            System.out.println("Table: " + getTableNumber());
            System.out.println("Total: " + getTotalAmount());
            System.out.println("--------------------------");
            PaymentAlert pay = new PaymentAlert();
            pay.returnPaymentAlert(this.getTotalAmount());
        });

        //Controller for Exit table Button
        newOrder.setOnAction(event -> {
            Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION, "Exit table?",ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> result = exitAlert.showAndWait();
            if (result.get() == ButtonType.YES){
                Stage stage = (Stage) newOrder.getScene().getWindow();
                stage.close();
                }
        });
    }
}