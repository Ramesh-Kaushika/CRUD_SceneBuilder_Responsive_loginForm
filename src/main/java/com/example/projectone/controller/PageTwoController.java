package com.example.projectone.controller;

import com.example.projectone.HelloApplication;
import com.example.projectone.cm.CustomerCM;
import com.example.projectone.services.ProgressTask;
import com.example.projectone.tm.CustomerTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PageTwoController implements Initializable {


    public AnchorPane root2;
    public TextField txtName;
    public TextField txtAge;
    public Label lblName;
    public Label lblAge;
    public Label lblAgeAfter;
    public ComboBox <CustomerCM> cmdSample;
    public CheckBox chckbxAL;
    public RadioButton rbMale;
    public CheckBox chckbxScholarship;
    public CheckBox chckbxOL;
    public RadioButton rbOther;
    public RadioButton rbFemale;
    public DatePicker dpDate;
    public TableView <CustomerTM> tbTableView;
    public ProgressBar prgrsLoading;
    public Label lblFirstName;
    public Button btnsubmitID;
    public PasswordField pswdID;
    public TextField txtPasswordShow;
    public CheckBox cbPasswordShower;
    public TableColumn<CustomerTM,Integer> tbIDColumn;
    public TableColumn<CustomerTM,String> tbName;
    public TableColumn <CustomerTM,String>tbContact;
    public TableColumn <CustomerTM,Button>tbOption;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
                   /* String [] data = {"Data 01","Data 02","Data 03"};
        ObservableList<String> dataList = FXCollections.observableArrayList(data);
        cmdSample.setItems(dataList);*/

        CustomerCM cm1 = new CustomerCM();
        cm1.setId("C-001");
        cm1.setName("Ramesh");
        cm1.setMobileNo("0765341860");

        CustomerCM cm2 = new CustomerCM();
        cm2.setId("C-002");
        cm2.setName("Kaushika");
        cm2.setMobileNo("076454637");

        CustomerCM cm3 = new CustomerCM();
        cm3.setId("C-003");
        cm3.setName("De Silva");
        cm3.setMobileNo("076521273");
        
        CustomerCM [] arr = {cm1,cm2,cm3};

        ObservableList<CustomerCM> customers = FXCollections.observableArrayList(arr);
        cmdSample.setItems(customers);

        setConverter();
        visualizeData();
    }

    public void setConverter(){

        cmdSample.setConverter(new StringConverter<CustomerCM>() {
            @Override
            public String toString(CustomerCM customerCM) {

                return customerCM == null ? "" : customerCM.getId()+ ":" + customerCM.getName();
            }

            @Override
            public CustomerCM fromString(String s) {
                return null;
            }
        });
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) this.root2.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSubmit(ActionEvent actionEvent) {

        String name = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());

    lblName.setText(name);
    lblAge.setText(String.valueOf(age));
    lblAgeAfter.setText(String.valueOf(age + 5));
    lblName.setStyle("-fx-text-fill: red");
    lblAge.setStyle("-fx-text-fill: red");
    txtName.clear();
    txtAge.clear();
    String text = pswdID.getText();

        System.out.println(name);
        System.out.println(text);
        System.out.println(age);


     /*   LocalDate value = dpDate.getValue();
        System.out.println(value);*/


        dpDate.setValue(LocalDate.now());
        System.out.println(LocalDate.now());
        lblFirstName.setText(String.valueOf(LocalDate.now()));

       /* LocalDate now = LocalDate.now();
        lblFirstName.setText(now.toString());*/


        boolean chk1 = chckbxScholarship.isSelected();
        if (chk1){
            System.out.println(chckbxScholarship.getText()+" is Selected");
        }
        boolean chk2 = chckbxAL.isSelected();
        if (chk2){
            System.out.println(chckbxAL.getText()+" is Selected");
        }
        boolean chk3 = chckbxOL.isSelected();
        if (chk3){
            System.out.println(chckbxOL.getText()+" is Selected");
        }

/*
        if (rbMale.isSelected()){
            value = rbMale.getText();
        } else if (rbFemale.isSelected()) {
            value = rbFemale.getText();
        } else if (rbOther.isSelected()) {
            value = rbOther.getText();

        }*/
        String value = "";


        value = rbMale.isSelected() ? rbMale.getText() : rbFemale.isSelected() ? rbFemale.getText() : rbOther.isSelected() ? rbOther.getText() : "";

        System.out.println(value);

    }

    public void pswdIDOnKeyReleased(KeyEvent keyEvent) {

        String text = pswdID.getText();
        txtPasswordShow.setText(text);
        txtPasswordShow.clear();


    }

    public void txtShowPasswordOnKeyReleased2(KeyEvent keyEvent) {
        String text = txtPasswordShow.getText();
        pswdID.setText(text);
        pswdID.clear();
    }

    public void cbPasswordShowerOnAction(ActionEvent actionEvent) {
        boolean selected = cbPasswordShower.isSelected();
        txtPasswordShow.setVisible(selected);
        txtPasswordShow.clear();
        pswdID.clear();

    }

    public void cmbOnAction(ActionEvent actionEvent) {
       // CustomerCM value = cmdSample.getValue();
        CustomerCM selectedItem = cmdSample.getSelectionModel().getSelectedItem();
        int selectedIndex = cmdSample.getSelectionModel().getSelectedIndex();
       // cmdSample.getSelectionModel(). select every model like this
        if (selectedItem == null){
            return;
        }
        System.out.println("Selected "+selectedItem.getId()+","+selectedItem.getName()+","+selectedItem.getMobileNo());

    }

    public void btnProgressOnAction(ActionEvent actionEvent) {

        ProgressTask progressTask = new ProgressTask();
        prgrsLoading.progressProperty().bind(progressTask.progressProperty());
        Thread thread = new Thread(progressTask);
        thread.start();



    }

    public void btnDataLoadOnAction(ActionEvent actionEvent) {


        CustomerTM tb1 = new CustomerTM();
        tb1.setId(1);
        tb1.setName("Ramesh");
        tb1.setContactNo("0765341860");
        Button btn1 = new Button("Remove");
        btn1.setOnAction(actionEvent1 ->
                tbTableView.getItems().remove(tb1));
        tb1.setOption(btn1);

        CustomerTM tb2 = new CustomerTM();
        tb2.setId(2);
        tb2.setName("Kaushika");
        tb2.setContactNo("0763546788");
        Button btn2 = new Button("Remove");
        btn2.setOnAction(actionEvent1 ->
                tbTableView.getItems().remove(tb2));
        tb2.setOption(btn2);

        CustomerTM tb3 = new CustomerTM();
        tb3.setId(3);
        tb3.setName("De Silva");
        tb3.setContactNo("0763655466");
        Button btn3 = new Button("Remove");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                tbTableView.getItems().remove(tb3);
            }
        });
        tb3.setOption(btn3);

        CustomerTM [] arr = {tb1,tb2,tb3};

    ObservableList<CustomerTM> customerData = FXCollections.observableArrayList(arr);
        tbTableView.setItems(customerData);



                }

public void visualizeData(){
        tbIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tbContact.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tbOption.setCellValueFactory(new PropertyValueFactory<>("option"));
        }

        }
