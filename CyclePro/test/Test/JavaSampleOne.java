/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entitie.Evenement.*;
import Entitie.Evenement.Participants;
import Service.Evenement.*;
import Entitie.Evenement.Classe;
import Utils.DataSource;
import java.sql.Date;
import java.util.List;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.exception.*;
import com.paypal.base.rest.*;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class JavaSampleOne {

    public static void main(String[] args) {

        String clientId = "3PZ2YUUSZNWKP44R";
        String clientSecret = "AJGNZ4CfKBZXDrzG0vCoTfw2mZHWAEfTArQt5BSLmv9HUg-OmxUPbWXQ";

        Amount amount = new Amount();
      
        amount.setCurrency("USD");
        amount.setTotal("1.00");

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setTransactions(transactions);

        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("https://example.com/cancel");
        redirectUrls.setReturnUrl("https://example.com/return");
        payment.setRedirectUrls(redirectUrls);
        try {
            APIContext apiContext = new APIContext(clientId, clientSecret, "sandbox");
            Payment createdPayment = payment.create(apiContext);
            // For debug purposes only: System.out.println(createdPayment.toString());
        } catch (PayPalRESTException e) {
            // Handle errors
        } catch (Exception ex) {
            // Handle errors
        }
    }

}
