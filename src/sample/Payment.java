package sample;

import com.sun.corba.se.impl.orbutil.closure.Constant;

/**
 * Created by DOS on 9/23/2017.
 */
public interface Payment {
     void cardPayment();
     void cashPayment();
     void cancelPayment();
}
