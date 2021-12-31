package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.css.RGBColor;
import sample.model.Menge;
import sample.model.Operation;

import java.awt.image.RGBImageFilter;
import java.io.*;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.reflect.Array;
import java.net.URL;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Controller2 {
    Operation operation = new Operation();
    private ObservableList<Menge> auswahlListe;
    private ObservableList<Menge> auswahlListeDiff;
    private ObservableList<Menge> auswahlListeVerein;
    private ObservableList<Menge> auswahlListeDelta;
    private ObservableList<Menge> auswahlListeKomplement;
    private ObservableList<Menge> auswahlListeDurchschnitt;
    private ObservableList<Menge> auswahlListeDeltaAlle;
    ArrayList<Character> alphabet = operation.alphabet;

    // MainPane Elemente
    @FXML
    private CheckBox checkBox0;

    @FXML
    private CheckBox checkBox1;

    @FXML
    private CheckBox checkBox2;

    @FXML
    private CheckBox checkBox3;

    @FXML
    private CheckBox checkBox4;

    @FXML
    private CheckBox checkBox5;

    @FXML
    private CheckBox checkBox6;

    @FXML
    private CheckBox checkBox7;

    @FXML
    private CheckBox checkBox8;

    @FXML
    private CheckBox checkBox9;

    @FXML
    private ListView<Menge> listViewManagement;

    @FXML
    private Button loeschenBtn;

    @FXML
    private Canvas canvas;

    @FXML
    private Button deltaBtn;

    @FXML
    private Button differenzBtn;

    @FXML
    private Button durchschnittBtn;

    @FXML
    private Button erstellenBtn;

    @FXML
    private Button komplementBtn;

    @FXML
    private Label lbNoteWork;

    @FXML
    private Label lblErgebnis;

    @FXML
    private Button managmentBtn;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu menuFile;

    @FXML
    private Menu menuHelp;

    @FXML
    private MenuItem menuItemClose;

    @FXML
    private MenuItem menuItemHelp;

    @FXML
    private AnchorPane paneManagment;

    @FXML
    private AnchorPane paneWorkspace;

    @FXML
    private Label pnlLblStatus;

    @FXML
    private Pane pnlStatus;

    @FXML
    private Button potenzmengeBtn;

    @FXML
    private Button vereinigungBtn;

    @FXML
    private Button workspaceBtn;

    @FXML
    private ListView<Integer> listZahlen;

    @FXML
    private Button berechneDiffBtn;

    @FXML
    private AnchorPane diffPane;

    @FXML
    private TextField txtFeldLetterDiff;

    @FXML
    private AnchorPane paneDifferenz;

    @FXML
    private ListView<Menge> listViewManagement1;

    @FXML
    private ListView<Menge> listViewManagement2;

    @FXML
    private Label lbNoteWork1;

    @FXML
    private Label lbNoteWork2;

    @FXML
    private TextArea txtErgebnis;

    @FXML
    private Button berechneKompBtn;

    @FXML
    private AnchorPane paneKomplement;

    @FXML
    private TextField txtFeldLetterKomp;

    @FXML
    private Button berechnePotenzBtn;

    @FXML
    private Label lbNoteWork3;

    @FXML
    private ListView<Menge> listViewManagement3;

    @FXML
    private AnchorPane panePotenz;

    @FXML
    private TextField txtFeldLetterPotenz;

    @FXML
    private Button berechneDeltaBtn;

    @FXML
    private Label lbNoteWork4;

    @FXML
    private ListView<Menge> listViewManagement4;

    @FXML
    private AnchorPane paneDelta;

    @FXML
    private TextField txtFeldLetterDeltaB;

    @FXML
    private TextField txtFeldLetterDeltaC;


    @FXML
    private Button berechneBtnDetaAlles;

    @FXML
    private CheckBox selectDelta;

    @FXML
    private Button berechneVereinBtn;

    @FXML
    private ListView<Menge> listViewManagement5;

    @FXML
    private AnchorPane paneVereinigung;

    @FXML
    private CheckBox selectVerein;

    @FXML
    private TextField txtFeldLetterVereinB;

    @FXML
    private TextField txtFeldLetterVereinC;

    @FXML
    private Label lblLetterDiff;

/*
    @FXML
    private CheckBox selectDifferenz;
*/

    @FXML
    private TextField txtFeldLetterDiffB;

    @FXML
    private TextField txtFeldLetterDiffC;

    @FXML
    private Button berechneDurchschnittBtn;

    @FXML
    private AnchorPane paneDurchschnitt;

    @FXML
    private CheckBox selectDurchschnitt;

    @FXML
    private TextField txtFeldLetterDurchschnittB;

    @FXML
    private TextField txtFeldLetterDurchschnittC;

    @FXML
    private ListView<Menge> listViewManagement7;

    @FXML
    private ListView<Menge> listViewManagement6;

    @FXML
    private MenuItem menuItemExport;

    @FXML
    private MenuItem menuItemImport;

    @FXML
    private AnchorPane main;

    @FXML
    private Canvas canvasLogo;

    @FXML
    void handleClicks() {
        erstellenBtn.setOnAction(event -> handleErstellen(event)); // leitet auf die Methode handelErstellen rüber
        loeschenBtn.setOnAction(event -> handleLoeschen()); // leitet auf die Methode handelLoeschen rüber
        workspaceBtn.setOnAction(event -> handleSwitch(event));// leitet auf die Methode handelSwitch rüber
        managmentBtn.setOnAction(event -> handleSwitch(event));
        differenzBtn.setOnAction(event -> handleSwitch(event));
        komplementBtn.setOnAction(event -> handleSwitch(event));
        potenzmengeBtn.setOnAction(event -> handleSwitch(event));
        menuItemClose.setOnAction(event-> handleClose());
        menuItemImport.setOnAction(event -> {
            try {
                handleLoad();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        menuItemExport.setOnAction(event-> {
            try {
                handleSave();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        deltaBtn.setOnAction(event -> handleSwitch(event));
        vereinigungBtn.setOnAction(event -> handleSwitch(event));
        durchschnittBtn.setOnAction(event -> handleSwitch(event));
        berechneDiffBtn.setOnAction(event -> handleSwitch(event));
        berechnePotenzBtn.setOnAction(event -> handlePotenzmenge());
        berechneKompBtn.setOnAction(event -> handleKomplement());

        //selectDelta.setOnAction(event -> handleSwitch(event));
        if(selectDelta.isSelected()){
            berechneDeltaBtn.setOnAction(event -> handleDeltaAllgemein());
            auswahlListeDelta = FXCollections.observableList(new ArrayList<>());
        }
        if(!selectDelta.isSelected()){
            berechneDeltaBtn.setOnAction(event -> handleDelta());
        }

        if(selectVerein.isSelected()){
            //berechneVereinBtn.setOnAction(event -> handleVereinigung());
        }
        if(!selectVerein.isSelected()){
            berechneVereinBtn.setOnAction(event -> handleVereinigungChars());
        }
            //berechneDiffBtn.setOnAction(event -> handleDifferenz());
            berechneDiffBtn.setOnAction(event -> handleDifferenzChars());
            berechneDiffBtn.setVisible(true);

        if(selectDurchschnitt.isSelected()){
           // berechneDurchschnittBtn.setOnAction(event -> handleDurchschnitt());
        }
        if(!selectDurchschnitt.isSelected()){
            berechneDurchschnittBtn.setOnAction(event -> handleDurchschnittChars());
        }
        listZahlen.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listZahlen.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        auswahlListe = FXCollections.observableList(new ArrayList<>());
        auswahlListeDiff = FXCollections.observableList(new ArrayList<>());
        auswahlListeVerein = FXCollections.observableList(new ArrayList<>());
        auswahlListeDelta = FXCollections.observableList(new ArrayList<>());
        auswahlListeDurchschnitt = FXCollections.observableList(new ArrayList<>());
        auswahlListeKomplement = FXCollections.observableList(new ArrayList<>());
        auswahlListeDeltaAlle = FXCollections.observableList(new ArrayList<>());

    }

    private void handleClose() {
        System.exit(0);
    }

    private void handleSwitch(ActionEvent event) {
        if (event.getSource() == workspaceBtn) {
            System.out.println("Workspace clicked");
            pnlLblStatus.setText("Workspace");
            paneWorkspace.toFront();
            paneManagment.setVisible(false);
            paneDifferenz.setVisible(false);
            paneWorkspace.setVisible(true);
            paneKomplement.setVisible(false);
            panePotenz.setVisible(false);
            paneDelta.setVisible(false);
            paneVereinigung.setVisible(false);
            paneDurchschnitt.setVisible(false);

            vereinigungBtn.setVisible(true);
            deltaBtn.setVisible(true);
            durchschnittBtn.setVisible(true);
            komplementBtn.setVisible(true);
            potenzmengeBtn.setVisible(true);
            differenzBtn.setVisible(true);
        }
        if (event.getSource() == managmentBtn) {
            System.out.println("Managment clicked");
            pnlLblStatus.setText("Management");
            paneManagment.toFront();
            paneManagment.setVisible(true);
            paneWorkspace.setVisible(false);
            paneDifferenz.setVisible(false);
            paneKomplement.setVisible(false);
            panePotenz.setVisible(false);
            paneDelta.setVisible(false);
            paneVereinigung.setVisible(false);
            paneDurchschnitt.setVisible(false);

            paneWorkspace.setVisible(false);
            vereinigungBtn.setVisible(false);
            deltaBtn.setVisible(false);
            durchschnittBtn.setVisible(false);
            komplementBtn.setVisible(false);
            potenzmengeBtn.setVisible(false);
            differenzBtn.setVisible(false);
        }
        if (event.getSource() == differenzBtn) {
            System.out.println("differenz Button clicked");
            pnlLblStatus.setText("Differenzberechnung");
            paneDifferenz.toFront();
            paneManagment.setVisible(false);
            paneWorkspace.setVisible(false);
            paneDifferenz.setVisible(true);
            paneKomplement.setVisible(false);
            panePotenz.setVisible(false);
            paneDelta.setVisible(false);
            paneVereinigung.setVisible(false);
            paneDurchschnitt.setVisible(false);

            vereinigungBtn.setVisible(true);
            deltaBtn.setVisible(true);
            durchschnittBtn.setVisible(true);
            komplementBtn.setVisible(true);
            potenzmengeBtn.setVisible(true);


            berechneDiffBtn.setVisible(true);

        }
        if (event.getSource() == komplementBtn) {
            System.out.println("Komplement Button clicked");
            pnlLblStatus.setText("Komplement");
            paneKomplement.toFront();
            paneManagment.setVisible(false);
            paneDifferenz.setVisible(false);
            paneWorkspace.setVisible(false);
            paneKomplement.setVisible(true);
            panePotenz.setVisible(false);
            paneDelta.setVisible(false);
            paneVereinigung.setVisible(false);
            paneDurchschnitt.setVisible(false);

            vereinigungBtn.setVisible(true);
            deltaBtn.setVisible(true);
            durchschnittBtn.setVisible(true);
            komplementBtn.setVisible(true);
            potenzmengeBtn.setVisible(true);
            differenzBtn.setVisible(true);

        }

        if (event.getSource() == potenzmengeBtn) {
            System.out.println("Potenzmengen Button clicked");
            pnlLblStatus.setText("Potenzmenge");
            paneKomplement.toFront();
            paneManagment.setVisible(false);
            paneDifferenz.setVisible(false);
            paneWorkspace.setVisible(false);
            paneKomplement.setVisible(false);
            panePotenz.setVisible(true);
            paneDelta.setVisible(false);
            paneVereinigung.setVisible(false);
            paneDurchschnitt.setVisible(false);

            vereinigungBtn.setVisible(true);
            deltaBtn.setVisible(true);
            durchschnittBtn.setVisible(true);
            komplementBtn.setVisible(true);
            potenzmengeBtn.setVisible(true);
            differenzBtn.setVisible(true);

        }

        if (event.getSource() == deltaBtn) {
            System.out.println("Delta Button clicked");
            pnlLblStatus.setText("Delta-Berechnung");
            paneKomplement.toFront();
            paneManagment.setVisible(false);
            paneDifferenz.setVisible(false);
            paneWorkspace.setVisible(false);
            paneKomplement.setVisible(false);
            panePotenz.setVisible(false);
            paneVereinigung.setVisible(false);
            paneDelta.setVisible(true);
            paneDurchschnitt.setVisible(false);


            vereinigungBtn.setVisible(true);
            deltaBtn.setVisible(true);
            durchschnittBtn.setVisible(true);
            komplementBtn.setVisible(true);
            potenzmengeBtn.setVisible(true);
            differenzBtn.setVisible(true);


            berechneDeltaBtn.setVisible(true);

        }
        if (event.getSource() == vereinigungBtn) {
            System.out.println("Vereinigung Button clicked");
            pnlLblStatus.setText("Vereinigung-Berechnung");
            paneKomplement.toFront();
            paneVereinigung.setVisible(true);
            paneManagment.setVisible(false);
            paneDifferenz.setVisible(false);
            paneWorkspace.setVisible(false);
            paneKomplement.setVisible(false);
            panePotenz.setVisible(false);
            paneDelta.setVisible(false);
            paneDurchschnitt.setVisible(false);

            vereinigungBtn.setVisible(true);
            deltaBtn.setVisible(true);
            durchschnittBtn.setVisible(true);
            komplementBtn.setVisible(true);
            potenzmengeBtn.setVisible(true);
            differenzBtn.setVisible(true);


            berechneVereinBtn.setVisible(true);

        }

        if (event.getSource() == durchschnittBtn) {
            System.out.println("Durchschnitt Button clicked");
            pnlLblStatus.setText("Durchschnitt-Berechnung");
            paneKomplement.toFront();
            paneManagment.setVisible(false);
            paneDifferenz.setVisible(false);
            paneWorkspace.setVisible(false);
            paneKomplement.setVisible(false);
            panePotenz.setVisible(false);
            paneDelta.setVisible(false);
            paneVereinigung.setVisible(false);
            paneDurchschnitt.setVisible(true);


            vereinigungBtn.setVisible(true);
            deltaBtn.setVisible(true);
            durchschnittBtn.setVisible(true);
            komplementBtn.setVisible(true);
            potenzmengeBtn.setVisible(true);
            differenzBtn.setVisible(true);


            berechneDurchschnittBtn.setVisible(true);

        }
    }



    private void handleErstellen(ActionEvent event) {
        System.out.println("Erstellen");
        List<Integer> zahl = listZahlen.getSelectionModel().getSelectedItems();
        ArrayList<Integer> werte = new ArrayList<>();
        Character name = ' ';
        String message = "";


        if(auswahlListe.isEmpty()){
            name= alphabet.get(0);
        }else if(auswahlListe.size() == 1){
            name= alphabet.get(1);
        }
        else if(auswahlListe.size() == 2){
            name= alphabet.get(2);
        }
        else if(auswahlListe.size() == 3){
            name= alphabet.get(3);
        }
        else if(auswahlListe.size() == 4){
            name= alphabet.get(4);
        }
        else if(auswahlListe.size() == 5){
            name= alphabet.get(5);
        }
        werte.addAll(zahl);
        Menge m1 = new Menge(name, werte);
        operation.mengeErstellen(m1);
        auswahlListe.add(m1);
        auswahlListeDiff.add(m1);
        auswahlListeVerein.add(m1);
        auswahlListeKomplement.add(m1);
        auswahlListeDurchschnitt.add(m1);
        auswahlListeDelta.add(m1);
        auswahlListeDeltaAlle.add(m1);

        System.out.println(auswahlListe.isEmpty());
        handleZeichen();
        updateList();
        lbNoteWork.setText("Note: Eine Menge wurde erfolgreich erstellt");
        System.out.println(auswahlListe);
    }

    private void handleZeichen(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        if (auswahlListe.size() == 1) {
            gc.strokeOval(200,100,200, 200);
            gc.stroke();
        }
        if (auswahlListe.size() == 2) {
            gc.strokeOval(340,100,200, 200);
            gc.stroke();
        }
        if (auswahlListe.size() == 3) {
            gc.strokeOval(270,20,200, 200);
            gc.stroke();
        }
        if (auswahlListe.size() == 4) {
            gc.strokeOval(270,180,200, 200);
            gc.stroke();
        }
        if (auswahlListe.size() == 5) {
            gc.strokeOval(220,50,200, 200);
            gc.stroke();
        }
        if (auswahlListe.size() == 6) {
            gc.strokeOval(330,170,200, 200);
            gc.stroke();
        }

    }

    /*private void handleZeichenLogo(){
        GraphicsContext gc = canvasLogo.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        if (auswahlListe.size() == 4) {
            gc.strokeOval(270,180,200, 200);
            gc.stroke();
        }

    }*/

    private void handleZeichenFürLoad() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        GraphicsContext gc1 = canvas.getGraphicsContext2D();
        GraphicsContext gc2 = canvas.getGraphicsContext2D();
        GraphicsContext gc3 = canvas.getGraphicsContext2D();
        GraphicsContext gc4 = canvas.getGraphicsContext2D();
        GraphicsContext gc5 = canvas.getGraphicsContext2D();

        if (auswahlListe.size() == 1) {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 800, 800);

            gc.strokeOval(200,100,200, 200);
            gc.stroke();
        }
        if (auswahlListe.size() == 2) {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 800, 800);

            gc.strokeOval(200,100,200, 200);
            gc.stroke();
            gc1.strokeOval(340,100,200, 200);
            gc1.stroke();
        }
        if (auswahlListe.size() == 3) {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 800, 800);

            gc.strokeOval(200,100,200, 200);
            gc.stroke();
            gc1.strokeOval(340,100,200, 200);
            gc1.stroke();
            gc2.strokeOval(270,20,200, 200);
            gc2.stroke();
        }
        if (auswahlListe.size() == 4) {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 800, 800);

            gc.strokeOval(200,100,200, 200);
            gc.stroke();
            gc1.strokeOval(340,100,200, 200);
            gc1.stroke();
            gc2.strokeOval(270,20,200, 200);
            gc2.stroke();
            gc3.strokeOval(270,180,200, 200);
            gc3.stroke();
        }
        if (auswahlListe.size() == 5) {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 800, 800);

            gc.strokeOval(200,100,200, 200);
            gc.stroke();
            gc1.strokeOval(340,100,200, 200);
            gc1.stroke();
            gc2.strokeOval(270,20,200, 200);
            gc2.stroke();
            gc3.strokeOval(270,180,200, 200);
            gc3.stroke();
            gc4.strokeOval(220,50,200, 200);
            gc4.stroke();
        }
        if (auswahlListe.size() == 6) {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 800, 800);

            gc.strokeOval(200,100,200, 200);
            gc.stroke();
            gc1.strokeOval(340,100,200, 200);
            gc1.stroke();
            gc2.strokeOval(270,20,200, 200);
            gc2.stroke();
            gc3.strokeOval(270,180,200, 200);
            gc3.stroke();
            gc4.strokeOval(220,50,200, 200);
            gc4.stroke();
            gc5.strokeOval(330,170,200, 200);
            gc5.stroke();
        }

    }

    private void handleLoeschen() {
        Menge mengenZuLoeschen =  listViewManagement.getSelectionModel().getSelectedItem();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        operation.mengeLöschen(mengenZuLoeschen);
        updateList();
        lbNoteWork.setText("Note: Eine Menge wurde erfolgreich geloescht");
        auswahlListe.remove(mengenZuLoeschen);

        if (auswahlListe.size() < 1 && auswahlListe.size() >=0) {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 800, 800);

            gc.stroke();
        }
        if (auswahlListe.size() < 2&& auswahlListe.size() >=1) {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 800, 800);

            gc.strokeOval(200,100,200, 200); //1
            gc.stroke();
        }
        if (auswahlListe.size() < 3 && auswahlListe.size() >=2) {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 800, 800);

            gc.strokeOval(200,100,200, 200); //1
            gc.strokeOval(340,100,200, 200); //2
            gc.stroke();
        }
        if (auswahlListe.size() < 4 && auswahlListe.size() >=3) {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 800, 800);

            gc.strokeOval(200,100,200, 200); //1
            gc.strokeOval(340,100,200, 200); //2
            gc.strokeOval(270,20,200, 200); //3
            gc.stroke();
        }
        if (auswahlListe.size() < 5 && auswahlListe.size() >=4) {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 800, 800);

            gc.strokeOval(200,100,200, 200); //1
            gc.strokeOval(340,100,200, 200); //2
            gc.strokeOval(270,20,200, 200); //3
            gc.strokeOval(270,180,200, 200); //4
            gc.stroke();
        }
        if (auswahlListe.size() < 6 && auswahlListe.size() >=5) {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 800, 800);

            gc.strokeOval(200,100,200, 200); //1
            gc.strokeOval(340,100,200, 200); //2
            gc.strokeOval(270,20,200, 200); //3
            gc.strokeOval(270,180,200, 200); //4
            gc.strokeOval(220,50,200, 200); //5
            gc.stroke();
        }

        System.out.println(auswahlListe);
    }

    /*private void handleDifferenz(){
        System.out.println("Differenz");
        Character c = txtFeldLetterDiffC.getCharacters().charAt(0);
        if(!alphabet.contains(c)) {
            lbNoteWork1.setText("Es muss einer Ihrer Buchstaben sein");
            throw new IllegalArgumentException("Es muss einer Ihrer Buchstaben sein");
        }
        String ergebnis = String.valueOf(operation.differenzBerechnenAlpabtic(c));
        System.out.println( "Ausgabe Ergebnis(Differenz) :" + ergebnis);
        txtErgebnis.setText("Differenz Ergebnis: " +ergebnis);
    }*/

    /*private void handleVereinigung(){
        System.out.println("Vereinigung");

        String ergebnis = String.valueOf(operation.vereignigung());
        System.out.println( "Ausgabe Ergebnis(Vereinigung):" + ergebnis);
        txtErgebnis.setText("Vereinigung Ergebnis: " +ergebnis);
    }*/

    /*private void handleDurchschnitt(){
        System.out.println("Durchschnitt");

        String ergebnis = String.valueOf(operation.durchschnitt());
        System.out.println( "Ausgabe Ergebnis(Durchschnitt):" + ergebnis);
        txtErgebnis.setText("Durchschnitt Ergebnis: " +ergebnis);
    }*/

    private void handleKomplement(){
        System.out.println("Komplement");
        Character c = txtFeldLetterKomp.getCharacters().charAt(0);
        if(!alphabet.contains(c)) {
            lbNoteWork2.setText("Es muss einer Ihrer Buchstaben sein");
            throw new IllegalArgumentException("Es muss einer Ihrer Buchstaben sein");
        }
        String ergebnis = String.valueOf(operation.komplement(c));
        System.out.println( "Ausgabe Ergebnis(Komplement) :" + ergebnis);
        txtErgebnis.setText("Komplement Ergebnis: " + ergebnis);
    }

    private void handlePotenzmenge(){
        System.out.println("Potenzmenge");
        Character c = txtFeldLetterPotenz.getCharacters().charAt(0);
        if(!alphabet.contains(c)) {
            lbNoteWork3.setText("Es muss einer Ihrer Buchstaben sein");
            throw new IllegalArgumentException("Es muss einer Ihrer Buchstaben sein");
        }
        String ergebnis = String.valueOf(operation.potenz(c));
        System.out.println( "Ausgabe Ergebnis(Potenz) :" + ergebnis);
        txtErgebnis.setText("Potenzmengen Ergebnis: " + ergebnis);
    }

    private void handleDelta(){
        System.out.println("Delta");
        Character c = txtFeldLetterDeltaC.getCharacters().charAt(0);
        Character b = txtFeldLetterDeltaB.getCharacters().charAt(0);

        if(!alphabet.contains(c) || !alphabet.contains(b)) {
            lbNoteWork3.setText("Es muss einer Ihrer Buchstaben sein");
            throw new IllegalArgumentException("Es muss einer Ihrer Buchstaben sein");
        }
        String ergebnis = String.valueOf(operation.delta(c,b));
        System.out.println( "Ausgabe Ergebnis(Delta) :" + ergebnis);
        txtErgebnis.setText("Delta Ergebnis: " + ergebnis);
    }

    private void handleDeltaAllgemein(){
        System.out.println("Delta Allgemein ");

        String ergebnis = String.valueOf(operation.deltaAllgemein());
        System.out.println( "Ausgabe Ergebnis(Delta Allgeimein):" + ergebnis);
        txtErgebnis.setText("Delta allgemein Ergebnis: " +ergebnis);
    }

    private void handleVereinigungChars() {
        System.out.println("Vereinigung");
        Character c = txtFeldLetterVereinC.getCharacters().charAt(0);
        Character b = txtFeldLetterVereinB.getCharacters().charAt(0);

        if(!alphabet.contains(c) || !alphabet.contains(b)) {
            lbNoteWork3.setText("Es muss einer Ihrer Buchstaben sein");
            throw new IllegalArgumentException("Es muss einer Ihrer Buchstaben sein");
        }
        String ergebnis = String.valueOf(operation.vereignigungFürZwei(c,b));
        System.out.println( "Ausgabe Ergebnis(Vereinigung fuer zwei Mengen) :" + ergebnis);
        txtErgebnis.setText("Vereinigung fuer zwei Mengenergebnis: " + ergebnis);
    }

    private void handleDifferenzChars() {
        System.out.println("Differenz fuer zwei");
        Character c = txtFeldLetterDiffC.getCharacters().charAt(0);
        Character b = txtFeldLetterDiffB.getCharacters().charAt(0);
        if(!alphabet.contains(c)) {
            lbNoteWork1.setText("Es muss einer Ihrer Buchstaben sein");
            throw new IllegalArgumentException("Es muss einer Ihrer Buchstaben sein");
        }
        String ergebnis = String.valueOf(operation.differenzFürZwei(c,b));
        System.out.println(operation.differenzFürZwei(c,b));
        System.out.println( "Ausgabe Ergebnis(Differenz fuer zwei) :" + ergebnis);
        txtErgebnis.setText("Differenz fuer zwei Ergebnis: " +ergebnis);
    }

    private void handleDurchschnittChars() {
        System.out.println("Durchschnitt fuer zwei");
        Character c = txtFeldLetterDurchschnittC.getCharacters().charAt(0);
        Character b = txtFeldLetterDurchschnittB.getCharacters().charAt(0);
        if(!alphabet.contains(c)) {
            lbNoteWork1.setText("Es muss einer Ihrer Buchstaben sein");
            throw new IllegalArgumentException("Es muss einer Ihrer Buchstaben sein");
        }
        String ergebnis = String.valueOf(operation.durchschnittFürZwei(c,b));
        System.out.println( "Ausgabe Ergebnis(Durchschnitt fuer zwei) :" + ergebnis);
        txtErgebnis.setText("Durchschnitt fuer zwei Ergebnis: " +ergebnis);
    }

    public void updateList() {
        System.out.println("updatelist");
        listViewManagement.getItems().setAll(operation.updateList());
        listViewManagement1.getItems().setAll(operation.updateList());
        listViewManagement2.getItems().setAll(operation.updateList());
        listViewManagement3.getItems().setAll(operation.updateList());
        listViewManagement5.getItems().setAll(operation.updateList());
        listViewManagement6.getItems().setAll(operation.updateList());
        listViewManagement7.getItems().setAll(operation.updateList());
    }

    private void handleSave() throws IOException {
        System.out.println("speichern");
        FileChooser fc = new FileChooser();
        fc.setTitle("speichere Mengen");
        File selectedFile = fc.showSaveDialog(main.getScene().getWindow());
        if (selectedFile != null) {
            System.out.println(selectedFile.getName());
            operation.save1(selectedFile);
            System.out.println("Das speichern war erfolgreich");
            lbNoteWork.setText("Das speichern war erfolgreich");
        }else {
            lbNoteWork.setText("Das speichern war nicht erfolgreich");
        }
    }

    private void handleLoad() throws IOException {
        System.out.println("load");
        FileChooser fc = new FileChooser();
        fc.setTitle("Lade Mengen...");
        File selectedFile = fc.showOpenDialog(main.getScene().getWindow());

        if (selectedFile != null) {
            auswahlListe.clear();
            auswahlListe.addAll(operation.load1(selectedFile));
            handleZeichenFürLoad();
            updateList();
            System.out.println("Das Laden war erfolgreich");
            lbNoteWork.setText("Das Laden war erfolgreich");
        } else {
            lbNoteWork.setText("Das Laden war nicht erfolgreich");;
        }
    }
}


