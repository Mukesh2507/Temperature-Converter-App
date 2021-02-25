package com.internshala.tempconverterapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain  extends Application {


    public static void main (String[]args){
launch(args);
    }
    @Override
    public void init() throws Exception{
        System.out.println("init");
        super.init();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("Start");




        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();
        MenuBar menuBar = createMenu();
    rootNode.getChildren().add(0,menuBar);
        Scene scene = new Scene(rootNode, 300, 275);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temp Converter");
        primaryStage.show();
    }

    private MenuBar createMenu() {

//file menu
        Menu fileMenu = new Menu("File ");
        MenuItem newMenuItem =new MenuItem("new");
        newMenuItem.setOnAction(event ->
        {
            System.out.println("new Menu item clicked");});
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem quiteMenuItem = new Menu("Quite");
        quiteMenuItem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quiteMenuItem);

        //help menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutMenuItem = new MenuItem("aboutApp");
        aboutMenuItem.setOnAction(event1 -> {
        aboutApp();
        });
        helpMenu.getItems().addAll(aboutMenuItem);


//menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;


    }

    private void aboutApp() {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My first Desktop app");
        alertDialog.setHeaderText("Learning javafx");
        alertDialog.setContentText("i am just a begginer but soon i will be pro");
        alertDialog.show();
        ButtonType yesBtn = new ButtonType("yes");
        ButtonType noBtn = new ButtonType("no");
        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
        Optional<ButtonType> clickedBtn =alertDialog.showAndWait();
        if(clickedBtn.isPresent() && clickedBtn.get()==yesBtn){
            System.out.println("yes Button clicked");
        }else{
            System.out.println("no button clicked");
        }
    }
    @Override
    public void stop() throws Exception{
        System.out.println("stop");
        super.stop();
    }
}
