package ceasercypherfx;

import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CeaserCypherFXController {

    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    private TextField userField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField keyField;
    
    @FXML
    private TextArea cypherTextArea;
    
    @FXML
    private TextArea decypherTextArea;
            
    
    String alphabet="abcdefghijklmnopqrstuvwxyz";
    int count = 0;
    int key = 0;
    char[] crypted = new char [100];
    
        @FXML
    void encryptButtonePushed(ActionEvent event) {
        
        String user = userField.getText();
        String password = passwordField.getText();
        
        String keyParse = keyField.getText();
        key = Integer.parseInt(keyParse);
        
        try{
        for(int i = 0; i < password.length(); i++){
                if(password.charAt(i) == 32){
                    crypted[i] = 32;
                }
                for(int j = 0; j < alphabet.length(); j++){
                    if(password.charAt(i) == alphabet.charAt(j)){
                        count = (j + key) % 26;
                        crypted[i] = alphabet.charAt(count);
                    }
                }
            }
        String both = user + "\n " + crypted;
        cypherTextArea.setText(both);
        
        }catch(Exception ex){
            System.out.println("Error ex: " + Arrays.toString(ex.getStackTrace()));
        }
        
    }

    @FXML
    void decryptButtonPushed(ActionEvent event) {

    }
    
    @FXML
    void clearButtonPressed(ActionEvent event) {
        cypherTextArea.clear();
        userField.clear();
        passwordField.clear();
        keyField.clear();
        decypherTextArea.clear();
        
    }



}


/*
            InputStreamReader in = new InputStreamReader(System.in);   //read from keyboard method
                BufferedReader keyboard = new BufferedReader(in);

                try{
            String alphabet="abcdefghijklmnopqrstuvwxyz";
            int key=0;
            int cnt=0;
            String plaintext;
            char crypted[] = new char [100];

            System.out.println("Insert the message:  ");
            plaintext=keyboard.readLine();
            System.out.println("Insert the key:  ");
            key= Integer.parseInt(keyboard.readLine());

            for(int i=0;i<plaintext.length();i++){
                if(plaintext.charAt(i)==32){
                    crypted[i]=32;
                }
                for(int j=0;j<alphabet.length();j++){
                    if(plaintext.charAt(i)==alphabet.charAt(j)){
                        cnt=(j+key)%26;
                        crypted[i]=alphabet.charAt(cnt);
                    }
                }
            }
        String chiper = new String(crypted);
        System.out.print("Chipered message:   "+chiper);
                    //program here
                }catch(Exception e ){
                    System.out.print("error ");

*/