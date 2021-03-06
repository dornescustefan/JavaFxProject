package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

/**
 * Created by DOS on 9/28/2017.
 */
public class PaymentAlert implements Payment{
    @Override
    public void cardPayment() {
        System.out.println("--------------------------");
        System.out.println("Paying by card...");
        System.out.println("Please insert your card!");
        System.out.println("--------------------------");
    }
    @Override
    public void cashPayment() {
        System.out.println("--------------------------");
        System.out.println("Paying cash...");
        System.out.println("Please show the cash...!");
        System.out.println("--------------------------");
    }
    @Override
    public void cancelPayment() {
        System.out.println("--------------------------");
        System.out.println("Payment choice needed...");
        System.out.println("--------------------------");
    }
      public void  returnPaymentAlert(double totalAmount ) {
        Alert paymentAlert = new Alert(Alert.AlertType.CONFIRMATION);
        paymentAlert.setTitle("Payment");
        paymentAlert.setHeaderText("Total amount: " + totalAmount);
        paymentAlert.setContentText("Please choose payment option");
        ButtonType cardPayment = new ButtonType("Pay by Card");
        ButtonType cashPayment = new ButtonType("Pay Cash");
        ButtonType cancel = new ButtonType("Cancel");
        paymentAlert.getButtonTypes().setAll(cardPayment, cashPayment, cancel);
        Optional<ButtonType> result = paymentAlert.showAndWait();
        if (result.get() == cardPayment) {
            cardPayment();
        } else if (result.get() == cashPayment) {
            cashPayment();
        } else if (result.get() == cancel) {
             cancelPayment();
        } else {
            cancelPayment();
        }
    }
}
