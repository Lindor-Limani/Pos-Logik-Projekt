package sample.controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import sample.model.FadeTransition;

public class ControllerLoading implements Initializable {

        @FXML
        private AnchorPane anchorPanes;

        @FXML
        private Canvas canvasLogo;

        @FXML
        private Label lblInPane;

        @FXML
        private Label lblLoad;

        @FXML
        private AnchorPane mainPane;

        @FXML
        private Pane p1;

        @FXML
        private Pane p10;

        @FXML
        private Pane p11;

        @FXML
        private Pane p12;

        @FXML
        private Pane p13;

        @FXML
        private Pane p14;

        @FXML
        private Pane p15;

        @FXML
        private Pane p16;

        @FXML
        private Pane p17;

        @FXML
        private Pane p18;

        @FXML
        private Pane p19;

        @FXML
        private Pane p2;

        @FXML
        private Pane p20;

        @FXML
        private Pane p21;

        @FXML
        private Pane p22;

        @FXML
        private Pane p23;

        @FXML
        private Pane p24;

        @FXML
        private Pane p25;

        @FXML
        private Pane p3;

        @FXML
        private Pane p4;

        @FXML
        private Pane p5;

        @FXML
        private Pane p6;

        @FXML
        private Pane p7;

        @FXML
        private Pane p8;

        @FXML
        private Pane p9;

        @FXML
        private Pane paneTxt;


        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            FadeTransition.applyFadeTransition(mainPane, Duration.seconds(5), (e) -> {
                try{
                    Parent fxml = FXMLLoader.load(getClass().getResource("../view/Test.fxml"));
                    mainPane.getChildren().removeAll();
                    mainPane.getChildren().setAll(fxml);

                }catch (IOException ex){
                    Logger.getLogger(ControllerLoading.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
    }
}
