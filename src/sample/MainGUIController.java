package sample;
import javafx.fxml.FXML;
import  javafx.scene.control.Button;

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
    }
}
