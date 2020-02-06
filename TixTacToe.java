package tixtactoe;

import joystick.JInputJoystick;
import net.java.games.input.Component;
import static net.java.games.input.Component.Identifier.Axis.X;
import static net.java.games.input.Component.Identifier.Axis.Y;
import static net.java.games.input.Component.Identifier.Button._0;
import static net.java.games.input.Component.Identifier.Button._1;
import static net.java.games.input.Component.Identifier.Button._10;
import static net.java.games.input.Component.Identifier.Button._11;
import static net.java.games.input.Component.Identifier.Button._2;
import static net.java.games.input.Component.Identifier.Button._3;
import static net.java.games.input.Component.Identifier.Button._4;
import static net.java.games.input.Component.Identifier.Button._5;
import static net.java.games.input.Component.Identifier.Button._6;
import static net.java.games.input.Component.Identifier.Button._7;
import static net.java.games.input.Component.Identifier.Button._8;
import static net.java.games.input.Component.Identifier.Button._9;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import static java.lang.Math.random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.media.*;
import javafx.stage.*;

public class TixTacToe extends Application {

    static int menuPos, newPos, setPos, gamePos;
    static int vsMode, diff, winLose;
    static int p1Wins, p2Wins;
    static int music, sfx, theme;
    Random random = new Random();
    static  IntegerProperty  key = new SimpleIntegerProperty(15);
    static int turnCounter = 0;
    static boolean first = true;
    static String[] turn = {"X", "O"};
    static String[] gamePlays = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
    Label newLabel = new Label("    New Game");
    Label conLabel = new Label("     Continue");
    Label setLabel = new Label("      Settings");
    Label extLabel = new Label("         Exit");
    Label comLabel = new Label("  Vs. Computer");
    Label plyLabel = new Label("     Vs. Player");
    Label easyLable = new Label(" Easy");
    Label mediLable = new Label(" Medium");
    Label hardLable = new Label(" Hard");
    Label musicLable = new Label("Music :");
    Label sfxLable = new Label("SFX :");
    Label themeLable = new Label("Theme: ");
    Slider mvolLable = new Slider(0, 100, 20);
    Slider svolLable = new Slider(0, 100, 20);
    RadioButton mOnRad = new RadioButton();
    RadioButton mOffRad = new RadioButton();
    RadioButton sOnRad = new RadioButton();
    RadioButton sOffRad = new RadioButton();
    RadioButton th1Rad = new RadioButton();
    RadioButton th2Rad = new RadioButton();
    RadioButton th3Rad = new RadioButton();
    Rectangle place1 = new Rectangle(0, 0, 100, 100);
    Rectangle place2 = new Rectangle(0, 0, 100, 100);
    Rectangle place3 = new Rectangle(0, 0, 100, 100);
    Rectangle place4 = new Rectangle(0, 0, 100, 100);
    Rectangle place5 = new Rectangle(0, 0, 100, 100);
    Rectangle place6 = new Rectangle(0, 0, 100, 100);
    Rectangle place7 = new Rectangle(0, 0, 100, 100);
    Rectangle place8 = new Rectangle(0, 0, 100, 100);
    Rectangle place9 = new Rectangle(0, 0, 100, 100);
    Label place1Label = new Label("");
    Label place2Label = new Label("");
    Label place3Label = new Label("");
    Label place4Label = new Label("");
    Label place5Label = new Label("");
    Label place6Label = new Label("");
    Label place7Label = new Label("");
    Label place8Label = new Label("");
    Label place9Label = new Label("");
    Media musicMedia = new Media(new File("music.mp3").toURI().toString());
    Media soundMedia = new Media(new File("Sound.mp3").toURI().toString());
    static File file = new File("save.sav");
    Color selectColor = new Color(1, 0, 0, 1);
    /////////////Controllers/////////////////
     int sticksCounter;
     Controller[] ca;
     Controller[] controllers;
     Controller FirstStick = null;
     Controller SecondStick = null;
     Component[] components = null;
     Component[] components2 = null;
    ///////////////////Fonts///////////////
     Font optionsFont;
     Font miniFont;
     Font gameFont;
    //////////////////Sounds*//////////
     MediaPlayer musicPlayer;
     MediaPlayer sfxPlayer;
    ///////////////Importing Pictures///////
     Image IntroBackground;
     Image newBackground;
     Image mediumBackground;
     Image hardBackground;
     Image setBackground;
    ///////////////Importing Icons////////////
     Image IntroImg;
     Image soundOnImg;
     Image soundOffImg;
     Image arrowsImg;
     Image circleImg;
     Image crossImg;
     Image r1Img;
     Image l1Img;
     Image th1Img;
     Image th2Img;
     Image th3Img;
    //////////////Intro//////////////////
     StackPane introPane;
    ////////////Main Menu Nodes////////////
     Label mainArrow;
     Label mainCross;
     Label mainCircle;
    /////////////Main Menu Panes/////////////////////
     FlowPane mainFlow;
     BorderPane mainPane;
     FlowPane mainhelpFlow;
     GridPane mainGrid;
    ////////////New Menu Nodes////////////
     Label newArrow;
     Label newCross;
     Label newCircle;
    /////////////New Menu Panes/////////////////////
     FlowPane newFlow;
     FlowPane diffFlow;
     BorderPane newPane;
     FlowPane newhelpFlow;
     GridPane newGrid;
    ////////////Game Menu Nodes////////////
     Label turnLabel;
     Label p1winsLabel;
     Label p2winsLabel;
     Label gameArrow;
     Label gameCross;
     Label gameCircle;
    /////////////Game Menu Panes/////////////////////
     GridPane xoGrid;
     StackPane gamePane;
     StackPane place1Stack;
     StackPane place2Stack;
     StackPane place3Stack;
     StackPane place4Stack;
     StackPane place5Stack;
     StackPane place6Stack;
     StackPane place7Stack;
     StackPane place8Stack;
     StackPane place9Stack;
     FlowPane gamehelpFlow;
     GridPane gameGrid;
     Label setArrow;
     Label setEtc;
     Label setCircle;
    /////////////Dialogue////////////////
    GridPane winDrawLose;
    Label wdlLabel;
    Label msgLabel;
    Label yesLabel;
    Label noLabel;
    Image drwImg;
    ImageView msgBackground;
    StackPane wdlPane;
    /////////////Settings Menu Panes/////////////////////
     FlowPane settingsFlow;
     FlowPane musicFlow;
     FlowPane sfxFlow;
     FlowPane themeFlow;
     FlowPane sethelpFlow;
     GridPane setGrid;
    /////////////Scenes////////////////////
     Scene introScene;
     Scene mainScene;
     Scene newScene;
     Scene gameScene;
     Scene settingsScene;

    public static void main(String[] args) {
        menuPos = newPos = setPos = gamePos = 0;
        winLose = 0;
        vsMode = diff = 0;
        p1Wins = p2Wins = 0;
        music = sfx = theme = 1;

        Application.launch(args);
    }

    public void start(Stage myStage) throws Exception {
        controller initiiateController = new controller();
        myStage.getIcons().add(new Image(TixTacToe.class.getResourceAsStream("Cross.icon")));
        ///////////////////Fonts///////////////
        optionsFont = new Font("Elephant", 40);
        miniFont = new Font("Arial", 20);
        gameFont = new Font("Verdana", 60);
        //////////////Importing Sounds//////////
        musicPlayer = new MediaPlayer(musicMedia);
        musicPlayer.setAutoPlay(true);
        musicPlayer.setVolume(mvolLable.getValue() / 100);
        sfxPlayer = new MediaPlayer(soundMedia);
        sfxPlayer.setVolume(svolLable.getValue() / 100);
        ///////////////Importing Pictures///////
        IntroBackground = new Image(getClass().getResourceAsStream("settings.gif"), 400, 300, false, false);
        newBackground = new Image(getClass().getResourceAsStream("newbackground.gif"), 800, 600, false, false);
        mediumBackground = new Image(getClass().getResourceAsStream("mediumbackground.gif"), 800, 600, false, false);
        hardBackground = new Image(getClass().getResourceAsStream("hardbackground.gif"), 800, 600, false, false);
        setBackground = new Image(getClass().getResourceAsStream("settingsbackground.gif"), 800, 600, false, false);
        ///////////////Importing Icons8////////////
        IntroImg = new Image(getClass().getResourceAsStream("Intro.png"), 400, 300, false, false); 
        soundOnImg = new Image(getClass().getResourceAsStream("SoundOn.png"));
        soundOffImg = new Image(getClass().getResourceAsStream("SoundOff.png"));
        r1Img = new Image(getClass().getResourceAsStream("R1.png"));
        l1Img = new Image(getClass().getResourceAsStream("L1.png"));
        th1Img = new Image(getClass().getResourceAsStream("RED.jpg"));
        th2Img = new Image(getClass().getResourceAsStream("BLUE.jpg"));
        th3Img = new Image(getClass().getResourceAsStream("GREEN.jpg"));  
        crossImg = new Image(getClass().getResourceAsStream("Cross.png"));
        arrowsImg = new Image(getClass().getResourceAsStream("Arrows.png"));
        circleImg = new Image(getClass().getResourceAsStream("Circle.png"));
        //////////////Intro//////////////////
        introPane = new StackPane(new ImageView(IntroBackground), new ImageView(IntroImg));
        ////////////Main Menu Nodes////////////
        newLabel.setFont(optionsFont);
        conLabel.setFont(optionsFont);
        setLabel.setFont(optionsFont);
        extLabel.setFont(optionsFont);
        menuHighlight();
        mainArrow = new Label("Move ");
        mainCross = new Label("Choose ");
        mainCircle = new Label("Exit ");
        mainArrow.setFont(miniFont);
        mainCross.setFont(miniFont);
        mainCircle.setFont(miniFont);
        /////////////Main Menu Panes/////////////////////
        mainFlow = new FlowPane(Orientation.VERTICAL);
        mainFlow.getChildren().addAll(newLabel, conLabel, setLabel, extLabel);
        mainPane = new BorderPane(mainFlow);
        mainhelpFlow = new FlowPane(new ImageView(arrowsImg), mainArrow, new ImageView(crossImg), mainCross, new ImageView(circleImg), mainCircle);
        mainhelpFlow.setMaxWidth(300);
        mainGrid = new GridPane();
        mainGrid.setHgap(240);
        mainGrid.setVgap(83);
        mainGrid.add(mainPane, 1, 1);
        mainGrid.add(mainhelpFlow, 1, 2);
        ////////////New Menu Nodes////////////
        comLabel.setFont(optionsFont);
        plyLabel.setFont(optionsFont);
        easyLable.setFont(miniFont);
        mediLable.setFont(miniFont);
        hardLable.setFont(miniFont);
        newHighlight();
        newArrow = new Label("Move ");
        newCross = new Label("Choose ");
        newCircle = new Label("Back ");
        newArrow.setFont(miniFont);
        newCross.setFont(miniFont);
        newCircle.setFont(miniFont);
        /////////////New Menu Panes/////////////////////
        newFlow = new FlowPane(Orientation.VERTICAL);
        diffFlow = new FlowPane(Orientation.VERTICAL);
        newFlow.getChildren().addAll(comLabel, plyLabel);
        newPane = new BorderPane(newFlow);
        newPane.setRight(diffFlow);
        newhelpFlow = new FlowPane(new ImageView(arrowsImg), newArrow, new ImageView(crossImg), newCross, new ImageView(circleImg), newCircle);
        newhelpFlow.setMaxWidth(300);
        newGrid = new GridPane();
        newGrid.setHgap(240);
        newGrid.setVgap(83);
        newGrid.add(newPane, 1, 1);
        newGrid.add(newhelpFlow, 1, 2);
        ////////////Game Menu Nodes////////////
        turnLabel = new Label("                    " + turn[0]);
        turnLabel.setFont(optionsFont);
        p1winsLabel = new Label("Wins: " + p1Wins + " ");
        p1winsLabel.setFont(miniFont);
        p2winsLabel = new Label("Wins: " + p2Wins + " ");
        p2winsLabel.setFont(miniFont);
        gameArrow = new Label("Move ");
        gameCross = new Label("Place ");
        gameCircle = new Label("Back ");
        gameArrow.setFont(miniFont);
        gameCross.setFont(miniFont);
        gameCircle.setFont(miniFont);
        /////////////Game Menu Panes/////////////////////
        xoGrid = new GridPane();
        xoGrid.setHgap(2);
        xoGrid.setVgap(2);
        place1Label.setFont(gameFont);
        place2Label.setFont(gameFont);
        place3Label.setFont(gameFont);
        place4Label.setFont(gameFont);
        place5Label.setFont(gameFont);
        place6Label.setFont(gameFont);
        place7Label.setFont(gameFont);
        place8Label.setFont(gameFont);
        place9Label.setFont(gameFont);
        place1Label.setTextFill(Color.WHITE);
        place2Label.setTextFill(Color.WHITE);
        place3Label.setTextFill(Color.WHITE);
        place4Label.setTextFill(Color.WHITE);
        place5Label.setTextFill(Color.WHITE);
        place6Label.setTextFill(Color.WHITE);
        place7Label.setTextFill(Color.WHITE);
        place8Label.setTextFill(Color.WHITE);
        place9Label.setTextFill(Color.WHITE);
        place1Stack = new StackPane(place1, place1Label);
        place2Stack = new StackPane(place2, place2Label);
        place3Stack = new StackPane(place3, place3Label);
        place4Stack = new StackPane(place4, place4Label);
        place5Stack = new StackPane(place5, place5Label);
        place6Stack = new StackPane(place6, place6Label);
        place7Stack = new StackPane(place7, place7Label);
        place8Stack = new StackPane(place8, place8Label);
        place9Stack = new StackPane(place9, place9Label);
        xoGrid.add(place1Stack, 0, 0);
        xoGrid.add(place2Stack, 1, 0);
        xoGrid.add(place3Stack, 2, 0);
        xoGrid.add(place4Stack, 0, 1);
        xoGrid.add(place5Stack, 1, 1);
        xoGrid.add(place6Stack, 2, 1);
        xoGrid.add(place7Stack, 0, 2);
        xoGrid.add(place8Stack, 1, 2);
        xoGrid.add(place9Stack, 2, 2);
        gameHighlight();
        gamehelpFlow = new FlowPane(new Label("                        "), new ImageView(arrowsImg), gameArrow, new ImageView(crossImg), gameCross, new ImageView(circleImg), gameCircle);
        gameGrid = new GridPane();
        gameGrid.setHgap(125);
        gameGrid.setVgap(104);
        gameGrid.add(turnLabel, 1, 0);
        gameGrid.add(new FlowPane(new Label("               "), xoGrid), 1, 1);
        gameGrid.add(p1winsLabel, 0, 2);
        gameGrid.add(gamehelpFlow, 1, 2);
        gameGrid.add(p2winsLabel, 2, 2);
        gamePane = new StackPane(new ImageView(mediumBackground), gameGrid);
        ////////////Settings Menu Nodes//////////////////  
        mOnRad.setGraphic(new ImageView(soundOnImg));
        mOffRad.setGraphic(new ImageView(soundOffImg));
        sOnRad.setGraphic(new ImageView(soundOnImg));
        sOffRad.setGraphic(new ImageView(soundOffImg));
        th1Rad.setGraphic(new ImageView(th1Img));
        th2Rad.setGraphic(new ImageView(th2Img));
        th3Rad.setGraphic(new ImageView(th3Img));
        musicLable.setFont(optionsFont);
        sfxLable.setFont(optionsFont);
        themeLable.setFont(optionsFont);
        setHighlight();
        mOnRad.setFocusTraversable(false);
        mOffRad.setFocusTraversable(false);
        sOnRad.setFocusTraversable(false);
        sOffRad.setFocusTraversable(false);
        th1Rad.setFocusTraversable(false);
        th2Rad.setFocusTraversable(false);
        th3Rad.setFocusTraversable(false);
        mvolLable.setFocusTraversable(false);
        svolLable.setFocusTraversable(false);
        mvolLable.setShowTickMarks(true);
        svolLable.setShowTickMarks(true);
        mOnRad.setSelected(true);
        mOffRad.setSelected(false);
        sOnRad.setSelected(true);
        sOffRad.setSelected(false);
        th1Rad.setSelected(true);
        th2Rad.setSelected(false);
        th3Rad.setSelected(false);
        setArrow = new Label("Move + Change ");
        setEtc = new Label("Switch ");
        setCircle = new Label("Back ");
        setArrow.setFont(miniFont);
        setEtc.setFont(miniFont);
        setCircle.setFont(miniFont);
        /////////////Settings Menu Panes/////////////////////
        settingsFlow = new FlowPane(Orientation.VERTICAL);
        musicFlow = new FlowPane(Orientation.HORIZONTAL);
        sfxFlow = new FlowPane(Orientation.HORIZONTAL);
        themeFlow = new FlowPane(Orientation.HORIZONTAL);
        musicFlow.getChildren().addAll(new Label("            "), mOffRad, new Label("  "), mOnRad);
        sfxFlow.getChildren().addAll(new Label("            "), sOffRad, new Label("   "), sOnRad);
        themeFlow.getChildren().addAll(new Label("          "), th1Rad, new Label("    "), th2Rad, new Label("    "), th3Rad);
        settingsFlow.getChildren().addAll(musicLable, musicFlow, mvolLable, sfxLable, sfxFlow, svolLable, themeLable, themeFlow);
        sethelpFlow = new FlowPane(new ImageView(arrowsImg), setArrow, new ImageView(l1Img), new ImageView(r1Img), setEtc, new ImageView(circleImg), setCircle);
        sethelpFlow.setMaxWidth(400);
        setGrid = new GridPane();
        setGrid.setHgap(200);
        setGrid.setVgap(80);
        setGrid.add(settingsFlow, 1, 1);
        setGrid.add(sethelpFlow, 1, 2);
        /////////////Dialogue//////////////////
        wdlLabel = new Label("Draw");
        wdlLabel.setFont(optionsFont);
        wdlLabel.setTextFill(Color.WHITE);
        msgLabel = new Label("Do you want to play again?");
        msgLabel.setFont(optionsFont);
        msgLabel.setTextFill(Color.WHITE);
        yesLabel = new Label("Yes");
        yesLabel.setFont(miniFont);
        yesLabel.setTextFill(Color.WHITE);
        noLabel  = new Label("No");
        noLabel.setFont(miniFont);
        noLabel.setTextFill(Color.WHITE);
        drwImg = new Image(getClass().getResourceAsStream("Dwon.jpg"), 520, 180, false, false);
        winDrawLose = new GridPane();
        winDrawLose.setAlignment(Pos.CENTER);
        winDrawLose.add(wdlLabel, 1, 0);
        winDrawLose.add(msgLabel, 1, 1);
        winDrawLose.add(new FlowPane(new ImageView(crossImg),yesLabel,new Label("                             "),new ImageView(circleImg),noLabel), 1, 2);
        wdlPane = new StackPane(new ImageView(drwImg),winDrawLose);
        wdlPane.getStyleClass().add("msgText");
        /////////////Scenes////////////////////
        introScene = new Scene(introPane, 400, 300);
        mainScene = new Scene(new StackPane(new ImageView(hardBackground), mainGrid), 800, 600);
        newScene = new Scene(new StackPane(new ImageView(newBackground), newGrid), 800, 600);
        gameScene = new Scene(gamePane, 800, 600);
        settingsScene = new Scene(new StackPane(new ImageView(setBackground), setGrid), 800, 600);
        //////////////Handling all JoyStick's Actions/////////////////
            final ChangeListener changeListener = new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue,Object newValue) 
            {
                Platform.runLater(new Runnable() {
                 @Override
                  public void run() 
                  {
                      if(myStage.getScene()==introScene)
                      {
                        myStage.setScene(mainScene);
                        myStage.getScene().getStylesheets().add(getClass().getResource("myStyle"+theme+".css").toString());
                        mainhelpFlow.getStyleClass().add("help");
                        mainPane.getStyleClass().add("myText");
                        myStage.setX(300);
                        myStage.setY(80);
                        menuHighlight();  
                        }
                      else if (myStage.getScene()==mainScene)
                      {
                          if (key.getValue()== 2) {
                            sfxPlayer.stop();
                            sfxPlayer.play();
                            menuPos++;
                            if (menuPos == 4) {
                                menuPos = 0;
                            }
                        } else if (key.getValue() == 3) {
                            sfxPlayer.stop();
                            sfxPlayer.play();
                            menuPos--;
                            if (menuPos == -1) {
                                menuPos = 3;
                            }
                        } else if (key.getValue() == 4) {
                            sfxPlayer.stop();
                            sfxPlayer.play();
                            Platform.exit();
                            vsMode = 5;
                        } else if (key.getValue() == 5) {
                            sfxPlayer.stop();
                            sfxPlayer.play();
                            switch (menuPos) {
                                case 0:
                                    myStage.setScene(newScene);
                                    myStage.getScene().getStylesheets().add(getClass().getResource("myStyle" + theme + ".css").toString());
                                    newhelpFlow.getStyleClass().add("help");
                                    newFlow.getStyleClass().add("myText");
                                    newHighlight();
                                    break;
                                case 1:
                                    try {
                                        loadGame();
                                    } catch (Exception ex) {
                                    }
                                    myStage.setScene(gameScene);
                                    setHighlight();
                                    myStage.getScene().getStylesheets().add(getClass().getResource("myStyle" + theme + ".css").toString());
                                    gamehelpFlow.getStyleClass().add("help");
                                    turnLabel.getStyleClass().add("myText");
                                    p1winsLabel.setText("Wins: " + p1Wins + " ");
                                    p2winsLabel.setText("Wins: " + p2Wins + " ");
                                    turnLabel.setText("                    "+ turn[turnCounter] + "");
                                    place1Label.setText(gamePlays[0]);
                                    place2Label.setText(gamePlays[1]);
                                    place3Label.setText(gamePlays[2]);
                                    place4Label.setText(gamePlays[3]);
                                    place5Label.setText(gamePlays[4]);
                                    place6Label.setText(gamePlays[5]);
                                    place7Label.setText(gamePlays[6]);
                                    place8Label.setText(gamePlays[7]);
                                    place9Label.setText(gamePlays[8]);
                                    break;
                                case 2:
                                    myStage.setScene(settingsScene);
                                    setHighlight();
                                    myStage.getScene().getStylesheets().add(getClass().getResource("myStyle" + theme + ".css").toString());
                                    settingsFlow.getStyleClass().add("myText");
                                    sethelpFlow.getStyleClass().add("help");
                                    break;
                                case 3:
                                    Platform.exit();
                                    vsMode = 5;
                                    break;
                            }
                            }
                            menuHighlight();
                            }
                      else if (myStage.getScene()==newScene)
                      {
                          if (vsMode == 0) {
                            if (key.getValue() == 2) {
                                sfxPlayer.stop();
                                sfxPlayer.play();
                                newPos++;
                                if (newPos == 2) {
                                    newPos = 0;
                                }
                            } else if (key.getValue()== 3) {
                                sfxPlayer.stop();
                                sfxPlayer.play();
                                newPos--;
                                if (newPos == -1) {
                                    newPos = 1;
                                }
                            } else if (key.getValue()== 4) {
                                sfxPlayer.stop();
                                sfxPlayer.play();
                                if (vsMode == 0) {
                                    myStage.setScene(mainScene);
                                    menuHighlight();
                                    myStage.getScene().getStylesheets().add(getClass().getResource("myStyle" + theme + ".css").toString());
                                    mainhelpFlow.getStyleClass().add("help");
                                    mainPane.getStyleClass().add("myText");

                                }
                            } else if (key.getValue()== 5) ///Choosing difficulty
                            {
                                sfxPlayer.stop();
                                sfxPlayer.play();
                                switch (newPos) {
                                    case 0:
                                        diffFlow.getChildren().addAll(easyLable, mediLable, hardLable);
                                        diff = vsMode = 1;
                                        break;
                                    case 1:
                                        myStage.setScene(gameScene);
                                        gameHighlight();
                                        myStage.getScene().getStylesheets().add(getClass().getResource("myStyle" + theme + ".css").toString());
                                        gamehelpFlow.getStyleClass().add("help");
                                        p1winsLabel.setText("Wins: " + p1Wins + " ");
                                        p2winsLabel.setText("Wins: " + p2Wins + " ");
                                        vsMode = 2;
                                        break;
                                }
                            }
                        } else if (vsMode == 1) {
                            if (key.getValue() == 2) {
                                sfxPlayer.stop();
                                sfxPlayer.play();
                                diff++;
                                if (diff == 4) {
                                    diff = 1;
                                }
                            } else if (key.getValue() == 3) {
                                sfxPlayer.stop();
                                sfxPlayer.play();
                                diff--;
                                if (diff == 0) {
                                    diff = 3;
                                }
                            } else if (key.getValue() == 4) {
                                sfxPlayer.stop();
                                sfxPlayer.play();
                                diff = 0;
                                vsMode = 0;
                                diffFlow.getChildren().removeAll(easyLable, mediLable, hardLable);
                            } else if (key.getValue()== 5) {
                                sfxPlayer.stop();
                                sfxPlayer.play();
                                myStage.setScene(gameScene);
                                gameHighlight();
                                myStage.getScene().getStylesheets().add(getClass().getResource("myStyle" + theme + ".css").toString());
                                gamehelpFlow.getStyleClass().add("help");
                                p1winsLabel.setText("Wins: " + p1Wins + " ");
                                p2winsLabel.setText("Wins: " + p2Wins + " ");
                            }
                        }
                        newHighlight();
                        difficultySelect();
                      }
                      else if(myStage.getScene()==gameScene)    
                      {
                          sfxPlayer.stop();
                          sfxPlayer.play();
                    if (key.getValue()== 2) {
                        gamePos += 3;
                        if (gamePos >= 9) {
                            gamePos -= 9;
                        }
                    } else if (key.getValue()== 3) {
                        gamePos -= 3;
                        if (gamePos < 0) {
                            gamePos += 9;
                        }
                    } else if (key.getValue()== 0) {
                        gamePos++;
                        if (gamePos == 9) {
                            gamePos = 0;
                        }
                    } else if (key.getValue()== 1) {
                        gamePos--;
                        if (gamePos == -1) {
                            gamePos = 8;
                        }
                    } else if (key.getValue()== 4) {
                        try {
                            saveGame();
                        } catch (Exception ex) {
                        }
                        for (int i = 0; i < 9; i++) {
                            gamePlays[i] = " ";
                        }
                        place1Label.setText(gamePlays[0]);
                        place2Label.setText(gamePlays[1]);
                        place3Label.setText(gamePlays[2]);
                        place4Label.setText(gamePlays[3]);
                        place5Label.setText(gamePlays[4]);
                        place6Label.setText(gamePlays[5]);
                        place7Label.setText(gamePlays[6]);
                        place8Label.setText(gamePlays[7]);
                        place9Label.setText(gamePlays[8]);
                        vsMode = diff = p1Wins = p2Wins = turnCounter = 0;
                        turnLabel.getStyleClass().add("myText");
                        turnLabel.setText("                    "+ turn[turnCounter] + "");
                        diffFlow.getChildren().removeAll(easyLable, mediLable, hardLable);
                        myStage.setScene(newScene);
                        menuHighlight();
                    } else if (key.getValue()== 5) {
                        if(winLose ==0){
                        if (gamePlays[gamePos].equals(" ")) {
                        gamePlays[gamePos] = turn[turnCounter];
                        if (turnCounter == 0) {
                            turnCounter = 1;
                        } else {
                            turnCounter = 0;
                        }
                        turnLabel.getStyleClass().add("myText");
                        turnLabel.setText("                    " + turn[turnCounter] + "");
                        place1Label.setText(gamePlays[0]);
                        place2Label.setText(gamePlays[1]);
                        place3Label.setText(gamePlays[2]);
                        place4Label.setText(gamePlays[3]);
                        place5Label.setText(gamePlays[4]);
                        place6Label.setText(gamePlays[5]);
                        place7Label.setText(gamePlays[6]);
                        place8Label.setText(gamePlays[7]);
                        place9Label.setText(gamePlays[8]);                                             
                    checkScoreUser();
                    checkScoreComp();
                   if(vsMode==1 && turnCounter ==1)
                   {
                       switch(diff)
                        {
                               case 1:
                                   compTurneasy();
                                   break;
                               case 2:
                                   compTurnmed();
                                   break;
                               case 3:
                                   compTurnhard();
                                   break;
                       }
                        if (turnCounter == 0) {turnCounter = 1;} 
                        else {turnCounter = 0;}
                        turnLabel.getStyleClass().add("myText");
                        turnLabel.setText("                    " + turn[turnCounter] + "");
                        place1Label.setText(gamePlays[0]);
                        place2Label.setText(gamePlays[1]);
                        place3Label.setText(gamePlays[2]);
                        place4Label.setText(gamePlays[3]);
                        place5Label.setText(gamePlays[4]);
                        place6Label.setText(gamePlays[5]);
                        place7Label.setText(gamePlays[6]);
                        place8Label.setText(gamePlays[7]);
                        place9Label.setText(gamePlays[8]);   
                        checkScoreComp();
                        checkScoreUser();
                   }                   
                   }
                   
                   p1winsLabel.setText("Wins: " + p1Wins + " ");
                   p2winsLabel.setText("Wins: " + p2Wins + " ");
                }
                    else if (winLose == 1)
                    {
                        gamePane.getChildren().remove(wdlPane);
                        winLose = 0;
                    }
                }
                gameHighlight();
                      }
                      else if (myStage.getScene() == settingsScene) 
                      {
                           if (key.getValue()== 2) {
                            setPos++;
                            if (setPos == 3) {
                                setPos = 0;
                            }
                            sfxPlayer.stop();
                            sfxPlayer.play();
                        } else if (key.getValue()== 3) {
                            setPos--;
                            if (setPos == -1) {
                                setPos = 2;
                            }
                            sfxPlayer.stop();
                            sfxPlayer.play();
                        } else if (key.getValue()== 4) {
                            myStage.setScene(mainScene);
                            menuHighlight();
                            myStage.getScene().getStylesheets().add(getClass().getResource("myStyle" + theme + ".css").toString());
                            mainhelpFlow.getStyleClass().add("help");
                            mainPane.getStyleClass().add("myText");
                            sfxPlayer.stop();
                            sfxPlayer.play();
                        } else if (key.getValue()== 7) {
                            sfxPlayer.stop();
                            sfxPlayer.play();
                            switch (setPos) {
                                case 0:
                                    musicPlayer.pause();
                                    mOnRad.setSelected(false);
                                    mOffRad.setSelected(true);
                                    music = 1;
                                    break;
                                case 1:
                                    sfxPlayer.setVolume(0);
                                    sOnRad.setSelected(false);
                                    sOffRad.setSelected(true);
                                    sfx = 1;
                                    break;
                                case 2:
                                    if (theme > 1) {
                                        theme--;
                                        themeSelect();
                                        for (int i = 1; i < 4; i++) {
                                            myStage.getScene().getStylesheets().removeAll(getClass().getResource("myStyle" + i + ".css").toString());
                                        }
                                        myStage.getScene().getStylesheets().add(getClass().getResource("myStyle" + theme + ".css").toString());
                                    }
                                    break;
                            }
                        } else if (key.getValue()== 8) {
                            sfxPlayer.stop();
                            sfxPlayer.play();
                            switch (setPos) {
                                case 0:
                                    musicPlayer.play();
                                    mOnRad.setSelected(true);
                                    mOffRad.setSelected(false);
                                    music = 0;
                                    break;
                                case 1:
                                    sfxPlayer.setVolume(svolLable.getValue() / 100);
                                    sOnRad.setSelected(true);
                                    sOffRad.setSelected(false);
                                    sfx = 0;
                                    break;
                                case 2:
                                    if (theme < 3) {
                                        theme++;
                                        for (int i = 1; i < 4; i++) {
                                            myStage.getScene().getStylesheets().removeAll(getClass().getResource("myStyle" + i + ".css").toString());
                                        }
                                        themeSelect();
                                        myStage.getScene().getStylesheets().add(getClass().getResource("myStyle" + theme + ".css").toString());
                                    }
                                    break;
                            }
                        } else if (key.getValue()== 0) {
                            sfxPlayer.stop();
                            sfxPlayer.play();
                            switch (setPos) {
                                case 0:
                                    if (mvolLable.getValue() < 100) {
                                        mvolLable.adjustValue((mvolLable.getValue()) + 10);
                                        musicPlayer.setVolume(mvolLable.getValue() / 100);
                                    }
                                    break;
                                case 1:
                                    if (svolLable.getValue() < 100) {
                                        svolLable.adjustValue((svolLable.getValue()) + 10);
                                        sfxPlayer.setVolume(svolLable.getValue() / 100);
                                        sOnRad.setSelected(true);
                                        sOffRad.setSelected(false);
                                    }
                                    break;
                            }
                        } else if (key.getValue()== 1) {
                            sfxPlayer.stop();
                            sfxPlayer.play();
                            switch (setPos) {
                                case 0:
                                    if (mvolLable.getValue() > 0) {
                                        mvolLable.adjustValue((mvolLable.getValue()) - 10);
                                        musicPlayer.setVolume(mvolLable.getValue() / 100);
                                    }
                                    break;
                                case 1:
                                    if (svolLable.getValue() > 0) {
                                        svolLable.adjustValue((svolLable.getValue()) - 10);
                                        sfxPlayer.setVolume(svolLable.getValue() / 100);
                                        sOnRad.setSelected(true);
                                        sOffRad.setSelected(false);
                                    }
                                    break;
                            }
                        }
                        setHighlight();
                              }

                          }
                    });
                
            }
          };
        key.addListener(changeListener);
        ///////////////Start The GUI////////////////
        myStage.setResizable(false);
        myStage.setTitle("X vs O");
        myStage.initStyle(StageStyle.TRANSPARENT);
        myStage.setScene(introScene);
        myStage.getScene().getStylesheets().add(getClass().getResource("myStyle" + theme + ".css").toString());
        mainhelpFlow.getStyleClass().add("help");
        mainPane.getStyleClass().add("myText");
        myStage.show();
    }

    public void menuHighlight() {
        switch (menuPos) {
            case 0:
                newLabel.setTextFill(selectColor);
                conLabel.setTextFill(Color.BLACK);
                setLabel.setTextFill(Color.BLACK);
                extLabel.setTextFill(Color.BLACK);
                break;
            case 1:
                newLabel.setTextFill(Color.BLACK);
                conLabel.setTextFill(selectColor);
                setLabel.setTextFill(Color.BLACK);
                extLabel.setTextFill(Color.BLACK);
                break;
            case 2:
                newLabel.setTextFill(Color.BLACK);
                conLabel.setTextFill(Color.BLACK);
                setLabel.setTextFill(selectColor);
                extLabel.setTextFill(Color.BLACK);
                break;
            default:
                newLabel.setTextFill(Color.BLACK);
                conLabel.setTextFill(Color.BLACK);
                setLabel.setTextFill(Color.BLACK);
                extLabel.setTextFill(selectColor);
                break;
        }
    }

    public void newHighlight() {
        switch (newPos) {
            case 0:
                comLabel.setTextFill(selectColor);
                plyLabel.setTextFill(Color.BLACK);

                break;
            case 1:
                comLabel.setTextFill(Color.BLACK);
                plyLabel.setTextFill(selectColor);
                break;
        }
    }

    public void setHighlight() {
        switch (setPos) {
            case 0:
                musicLable.setTextFill(selectColor);
                sfxLable.setTextFill(Color.BLACK);
                themeLable.setTextFill(Color.BLACK);
                break;
            case 1:
                musicLable.setTextFill(Color.BLACK);
                sfxLable.setTextFill(selectColor);
                themeLable.setTextFill(Color.BLACK);
                break;
            case 2:
                musicLable.setTextFill(Color.BLACK);
                sfxLable.setTextFill(Color.BLACK);
                themeLable.setTextFill(selectColor);
                break;
        }
    }

    public void gameHighlight() {
        switch (gamePos) {
            case 0:
                place1.setFill(selectColor);
                place2.setFill(Color.BLACK);
                place3.setFill(Color.BLACK);
                place4.setFill(Color.BLACK);
                place5.setFill(Color.BLACK);
                place6.setFill(Color.BLACK);
                place7.setFill(Color.BLACK);
                place8.setFill(Color.BLACK);
                place9.setFill(Color.BLACK);
                break;
            case 1:
                place1.setFill(Color.BLACK);
                place2.setFill(selectColor);
                place3.setFill(Color.BLACK);
                place4.setFill(Color.BLACK);
                place5.setFill(Color.BLACK);
                place6.setFill(Color.BLACK);
                place7.setFill(Color.BLACK);
                place8.setFill(Color.BLACK);
                place9.setFill(Color.BLACK);
                break;
            case 2:
                place1.setFill(Color.BLACK);
                place2.setFill(Color.BLACK);
                place3.setFill(selectColor);
                place4.setFill(Color.BLACK);
                place5.setFill(Color.BLACK);
                place6.setFill(Color.BLACK);
                place7.setFill(Color.BLACK);
                place8.setFill(Color.BLACK);
                place9.setFill(Color.BLACK);
                break;
            case 3:
                place1.setFill(Color.BLACK);
                place2.setFill(Color.BLACK);
                place3.setFill(Color.BLACK);
                place4.setFill(selectColor);
                place5.setFill(Color.BLACK);
                place6.setFill(Color.BLACK);
                place7.setFill(Color.BLACK);
                place8.setFill(Color.BLACK);
                place9.setFill(Color.BLACK);
                break;
            case 4:
                place1.setFill(Color.BLACK);
                place2.setFill(Color.BLACK);
                place3.setFill(Color.BLACK);
                place4.setFill(Color.BLACK);
                place5.setFill(selectColor);
                place6.setFill(Color.BLACK);
                place7.setFill(Color.BLACK);
                place8.setFill(Color.BLACK);
                place9.setFill(Color.BLACK);
                break;
            case 5:
                place1.setFill(Color.BLACK);
                place2.setFill(Color.BLACK);
                place3.setFill(Color.BLACK);
                place4.setFill(Color.BLACK);
                place5.setFill(Color.BLACK);
                place6.setFill(selectColor);
                place7.setFill(Color.BLACK);
                place8.setFill(Color.BLACK);
                place9.setFill(Color.BLACK);
                break;
            case 6:
                place1.setFill(Color.BLACK);
                place2.setFill(Color.BLACK);
                place3.setFill(Color.BLACK);
                place4.setFill(Color.BLACK);
                place5.setFill(Color.BLACK);
                place6.setFill(Color.BLACK);
                place7.setFill(selectColor);
                place8.setFill(Color.BLACK);
                place9.setFill(Color.BLACK);
                break;
            case 7:
                place1.setFill(Color.BLACK);
                place2.setFill(Color.BLACK);
                place3.setFill(Color.BLACK);
                place4.setFill(Color.BLACK);
                place5.setFill(Color.BLACK);
                place6.setFill(Color.BLACK);
                place7.setFill(Color.BLACK);
                place8.setFill(selectColor);
                place9.setFill(Color.BLACK);
                break;
            case 8:
                place1.setFill(Color.BLACK);
                place2.setFill(Color.BLACK);
                place3.setFill(Color.BLACK);
                place4.setFill(Color.BLACK);
                place5.setFill(Color.BLACK);
                place6.setFill(Color.BLACK);
                place7.setFill(Color.BLACK);
                place8.setFill(Color.BLACK);
                place9.setFill(selectColor);
                break;
        }
    }

    public void difficultySelect() {
        switch (diff) {
            case 1: {
                easyLable.setTextFill(selectColor);
                mediLable.setTextFill(Color.BLACK);
                hardLable.setTextFill(Color.BLACK);
                break;
            }
            case 2: {
                easyLable.setTextFill(Color.BLACK);
                mediLable.setTextFill(selectColor);
                hardLable.setTextFill(Color.BLACK);
                break;
            }
            case 3: {
                easyLable.setTextFill(Color.BLACK);
                mediLable.setTextFill(Color.BLACK);
                hardLable.setTextFill(selectColor);
                break;
            }
        }
    }

    public void themeSelect() {
        switch (theme) {
            case 1:
                th1Rad.setSelected(true);
                th2Rad.setSelected(false);
                th3Rad.setSelected(false);
                selectColor = new Color(1, 0, 0, 1);
                break;
            case 2:
                th1Rad.setSelected(false);
                th2Rad.setSelected(true);
                th3Rad.setSelected(false);
                selectColor = new Color(0, 0, 1, 1);
                break;
            case 3:
                th1Rad.setSelected(false);
                th2Rad.setSelected(false);
                th3Rad.setSelected(true);
                selectColor = new Color(0, 1, 0, 1);
                break;
        }
    }

    public void saveGame() throws Exception {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.append(Integer.toString(vsMode));
        fileWriter.append(Integer.toString(diff));
        fileWriter.append(Integer.toString(p1Wins));
        fileWriter.append(Integer.toString(p2Wins));
        fileWriter.append(Integer.toString(gamePos));
        fileWriter.append(Integer.toString(turnCounter));
        for (int i = 0; i < 9; i++) {
            fileWriter.append(gamePlays[i]);
        }
        fileWriter.close();
    }

    public void loadGame() throws Exception {
        FileInputStream fileInput = new FileInputStream(file);
        int size = fileInput.available();
        byte[] saveData = new byte[size];
        fileInput.read(saveData);
        String Data = new String(saveData);
        vsMode = (Data.charAt(0)) - '0';
        diff = (Data.charAt(1)) - '0';
        p1Wins = (Data.charAt(2)) - '0';
        p2Wins = (Data.charAt(3)) - '0';
        gamePos = (Data.charAt(4)) - '0';
        turnCounter = (Data.charAt(5)) - '0';
        for (int i = 0; i < 9; i++) {
            gamePlays[i] = Data.substring(6 + i, 7 + i);
        }
        fileInput.close();
    }

    public void gameReset() throws Exception {
        gamePane.getChildren().add(wdlPane);
        winLose = 1;
        //gamePane.getChildren().remove(wdlPane);
        gamePos = 0;
        turnCounter = 0;
        for (int i = 0; i < 9; i++) {
            gamePlays[i] = " ";
        }
        place1Label.setText(gamePlays[0]);
        place2Label.setText(gamePlays[1]);
        place3Label.setText(gamePlays[2]);
        place4Label.setText(gamePlays[3]);
        place5Label.setText(gamePlays[4]);
        place6Label.setText(gamePlays[5]);
        place7Label.setText(gamePlays[6]);
        place8Label.setText(gamePlays[7]);
        place9Label.setText(gamePlays[8]);
    }

    public String gameWinner() throws Exception {
        for (int i = 0; i < 9; i++) {
            if (!gamePlays[i].equals(" ")) {
                if (gamePlays[i].equals(gamePlays[i + 1]) && gamePlays[i + 1].equals(gamePlays[i + 2]) && ((i == 0) || (i == 3) || (i == 6))) {
                    return gamePlays[i];
                }
                if (gamePlays[i].equals(gamePlays[i + 3]) && gamePlays[i + 3].equals(gamePlays[i + 6]) && ((i == 0) || (i == 1) || (i == 2))) {
                    return gamePlays[i];
                }
                if (gamePlays[i].equals(gamePlays[i + 2]) && gamePlays[i + 2].equals(gamePlays[i + 4]) && (i == 2)) {
                    return gamePlays[i];
                }
                if (gamePlays[i].equals(gamePlays[i + 4]) && gamePlays[i + 4].equals(gamePlays[i + 8]) && (i == 0)) {
                    return gamePlays[i];
                }
            }
            int k = 8;
            for (int j = 0; j < 9; j++) {
                if (gamePlays[j].equals("X") || gamePlays[j].equals("O")) {
                    k--;
                } else {
                    break;
                }
                if (k == 0) {
                    return "D";
                }
            }
        }
        return " ";
    }

    public class controller extends Thread {

        controller() {
            ca = ControllerEnvironment.getDefaultEnvironment().getControllers();
            controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
            for (int i = 0; i < controllers.length; i++) {
                if (controllers[i].getType() == Controller.Type.STICK) {
                    // Found a Joystick
                    if (FirstStick == null) {
                        FirstStick = controllers[i];
                    } else if (SecondStick == null) {
                        SecondStick = controllers[i];
                        break;
                    }
                }

            }
            if (FirstStick == null && SecondStick == null) {
                sticksCounter = 0;
                System.exit(0);
            }
            if (FirstStick != null) {
                sticksCounter = 1;
            }
            if (SecondStick != null) {
                sticksCounter = 2;                
            }
            
            start();
            
        }

        public void run() {
            while (sticksCounter != 0) {
                try {
                    key.set(getKey(FirstStick));                    
                    Thread.sleep(50);
                    if (sticksCounter == 2 && vsMode == 2)
                    {key.set(getKey(SecondStick));Thread.sleep(50);}   
                    if (vsMode == 5)
                    {this.stop();}
                } catch (InterruptedException ex) {
                }
            }
        }

        public int getKey(Controller Stick) {
            Stick.poll();
            int button = 15;
            Component[] components = null;
            components = Stick.getComponents();

            for (int i = 0; i < components.length; i++) {
                if (components[i].isAnalog()) {

                    if (components[i].getIdentifier() == X) {
                        if (components[i].getPollData() >= .7f) {
                            button = 0;
                        } else if (components[i].getPollData() <= -.7f) {
                            button = 1;
                        }
                    }
                    if (components[i].getIdentifier() == Y) {
                        if (components[i].getPollData() >= .7f) {
                            button = 2;
                        } else if (components[i].getPollData() <= -.7f) {
                            button = 3;
                        }

                    }

                } else {
                    if (components[i].getPollData() >= .7f) {
                        if (components[i].getIdentifier() == _0) {
                            button = 3;
                        } else if (components[i].getIdentifier() == _1) {
                            button = 4;
                        } else if (components[i].getIdentifier() == _2) {
                            button = 5;
                        } else if (components[i].getIdentifier() == _3) {
                            button = 6;
                        } else if (components[i].getIdentifier() == _4) {
                            button = 7;
                        } else if (components[i].getIdentifier() == _5) {
                            button = 8;
                        } else if (components[i].getIdentifier() == _6) {
                            button = 9;
                        } else if (components[i].getIdentifier() == _7) {
                            button = 10;
                        } else if (components[i].getIdentifier() == _8) {
                            button = 11;
                        } else if (components[i].getIdentifier() == _9) {
                            button = 12;
                        } else if (components[i].getIdentifier() == _10) {
                            button = 13;
                        } else if (components[i].getIdentifier() == _11) {
                            button = 14;
                        }
                    }
                }
            }
            return button;
        }
    }
    
    public void compTurneasy() {
        int x = random.nextInt(8);
        int flag = 0;

        while (flag == 0) {
            if (gamePlays[x] == " ") {
                gamePlays[x] = turn[turnCounter];
                flag = 1;
            } else {
                x = random.nextInt(8);  
                flag = 0;
            }
        }
    }
    
    public void compTurnmed() {
        //////////////////////////BLOCKING STATES///////////////////////////////////
         if (gamePlays[0] == "X" && gamePlays[1] == "X" && gamePlays[2] != "O") {
            gamePlays[2] = "O";
            gameHighlight();
        } else if (gamePlays[3] == "X" && gamePlays[4] == "X" && gamePlays[5] != "O") {
            gamePlays[5] = "O";
        } else if (gamePlays[6] == "X" && gamePlays[7] == "X" && gamePlays[8] != "O") {
            gamePlays[8] = "O";
            gameHighlight();
        } else if (gamePlays[0] == "X" && gamePlays[3] == "X" && gamePlays[6] != "O") {
            gamePlays[6] = "O";
            gameHighlight();
        } else if (gamePlays[1] == "X" && gamePlays[4] == "X" && gamePlays[7] != "O") {
            gamePlays[7] = "O";
            gameHighlight();
        } else if (gamePlays[2] == "X" && gamePlays[5] == "X" && gamePlays[8] != "O") {
            gamePlays[8] = "O";
            gameHighlight();
        } else if (gamePlays[2] == "X" && gamePlays[1] == "X" && gamePlays[0] != "O") {
            gamePlays[0] = "O";
            gameHighlight();
        } else if (gamePlays[5] == "X" && gamePlays[4] == "X" && gamePlays[3] != "O") {
            gamePlays[3] = "O";
            gameHighlight();
        } else if (gamePlays[8] == "X" && gamePlays[7] == "X" && gamePlays[6] != "O") {
            gamePlays[6] = "O";
            gameHighlight();
        } else if (gamePlays[6] == "X" && gamePlays[3] == "X" && gamePlays[0] != "O") {
            gamePlays[0] = "O";
            gameHighlight();
        } else if (gamePlays[7] == "X" && gamePlays[4] == "X" && gamePlays[1] != "O") {
            gamePlays[1] = "O";
            gameHighlight();
        } else if (gamePlays[8] == "X" && gamePlays[5] == "X" && gamePlays[2] != "O") {
            gamePlays[2] = "O";
            gameHighlight();
        } else if (gamePlays[0] == "X" && gamePlays[2] == "X" && gamePlays[1] != "O") {
            gamePlays[1] = "O";
            gameHighlight();
        } else if (gamePlays[3] == "X" && gamePlays[5] == "X" && gamePlays[4] != "O") {
            gamePlays[4] = "O";
            gameHighlight();
        } else if (gamePlays[6] == "X" && gamePlays[8] == "X" && gamePlays[7] != "O") {
            gamePlays[7] = "O";
            gameHighlight();
        } else if (gamePlays[0] == "X" && gamePlays[6] == "X" && gamePlays[3] != "O") {
            gamePlays[3] = "O";
            gameHighlight();
        } else if (gamePlays[1] == "X" && gamePlays[7] == "X" && gamePlays[4] != "O") {
            gamePlays[4] = "O";
            gameHighlight();
        } else if (gamePlays[2] == "X" && gamePlays[8] == "X" && gamePlays[5] != "O") {
            gamePlays[5] = "O";
            gameHighlight();
        } else if (gamePlays[0] == "X" && gamePlays[4] == "X" && gamePlays[8] != "O") {
            gamePlays[8] = "O";
            gameHighlight();
        } else if (gamePlays[2] == "X" && gamePlays[4] == "X" && gamePlays[6] != "O") {
            gamePlays[6] = "O";
            gameHighlight();
        } else if (gamePlays[6] == "X" && gamePlays[4] == "X" && gamePlays[2] != "O") {
            gamePlays[2] = "O";
            gameHighlight();
        } else if (gamePlays[8] == "X" && gamePlays[4] == "X" && gamePlays[0] != "O") {
            gamePlays[0] = "O";
            gameHighlight();
        } else if (gamePlays[0] == "X" && gamePlays[8] == "X" && gamePlays[4] != "O") {
            gamePlays[4] = "O";
            gameHighlight();
        } else if (gamePlays[2] == "X" && gamePlays[6] == "X" && gamePlays[4] != "O") {
            gamePlays[4] = "O";
            gameHighlight();
        } //////////////////////////ELSE//////////////////////////////////////   
        else {
            int x = random.nextInt(8);
            int flag = 0;

            while (flag == 0) {
                if (gamePlays[x] == " ") {
                    gamePlays[x] = "O";
                    flag = 1;
                    gameHighlight();
                } else {
                    x = random.nextInt(8);                    
                    flag = 0;
                }
            }
        }
    }
    
    public void compTurnhard() {
        if (gamePlays[0] == "O" && gamePlays[1] == "O" && gamePlays[2] != "X") {
            gamePlays[2] = "O";
            
            gameHighlight();
             

        } else if (gamePlays[3] == "O" && gamePlays[4] == "O" && gamePlays[5] != "X") {
            gamePlays[5] = "O";
            
            gameHighlight();
             

        } else if (gamePlays[6] == "O" && gamePlays[7] == "O" && gamePlays[8] != "X") {
            gamePlays[8] = "O";
            
            gameHighlight();
             

        } else if (gamePlays[0] == "O" && gamePlays[3] == "O" && gamePlays[6] != "X") {
            gamePlays[6] = "O";
            
            gameHighlight();
             

        } else if (gamePlays[1] == "O" && gamePlays[4] == "O" && gamePlays[7] != "X") {
            gamePlays[7] = "O";
            
            gameHighlight();
             
        } else if (gamePlays[2] == "O" && gamePlays[5] == "O" && gamePlays[8] != "X") {
            gamePlays[8] = "O";
            
            gameHighlight();
             
        } else if (gamePlays[2] == "O" && gamePlays[1] == "O" && gamePlays[0] != "X") {
            gamePlays[0] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[5] == "O" && gamePlays[4] == "O" && gamePlays[3] != "X") {
            gamePlays[3] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[8] == "O" && gamePlays[7] == "O" && gamePlays[6] != "X") {
            gamePlays[6] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[6] == "O" && gamePlays[3] == "O" && gamePlays[0] != "X") {
            gamePlays[0] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[7] == "O" && gamePlays[4] == "O" && gamePlays[1] != "X") {
            gamePlays[1] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[8] == "O" && gamePlays[5] == "O" && gamePlays[2] != "X") {
            gamePlays[2] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[0] == "O" && gamePlays[2] == "O" && gamePlays[1] != "X") {
            gamePlays[1] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[3] == "O" && gamePlays[5] == "O" && gamePlays[4] != "X") {
            gamePlays[4] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[6] == "O" && gamePlays[8] == "O" && gamePlays[7] != "X") {
            gamePlays[7] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[0] == "O" && gamePlays[6] == "O" && gamePlays[3] != "X") {
            gamePlays[3] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[1] == "O" && gamePlays[7] == "O" && gamePlays[4] != "X") {
            gamePlays[4] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[2] == "O" && gamePlays[8] == "O" && gamePlays[5] != "X") {
            gamePlays[5] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[0] == "O" && gamePlays[4] == "O" && gamePlays[8] != "X") {
            gamePlays[8] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[2] == "O" && gamePlays[4] == "O" && gamePlays[6] != "X") {
            gamePlays[6] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[6] == "O" && gamePlays[4] == "O" && gamePlays[2] != "X") {
            gamePlays[2] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[8] == "O" && gamePlays[4] == "O" && gamePlays[0] != "X") {
            gamePlays[0] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[0] == "O" && gamePlays[8] == "O" && gamePlays[4] != "X") {
            gamePlays[4] = "O";
            

            gameHighlight();
             
        } else if (gamePlays[2] == "O" && gamePlays[6] == "O" && gamePlays[4] != "X") {
            gamePlays[4] = "O";
            
            gameHighlight();
             

        } //////////////////////////BLOCKING STATES///////////////////////////////////
        else if (gamePlays[0] == "X" && gamePlays[1] == "X" && gamePlays[2] != "O") {
            gamePlays[2] = "O";
            gameHighlight();
             

        } else if (gamePlays[3] == "X" && gamePlays[4] == "X" && gamePlays[5] != "O") {
            gamePlays[5] = "O";
            gameHighlight();
             

        } else if (gamePlays[6] == "X" && gamePlays[7] == "X" && gamePlays[8] != "O") {
            gamePlays[8] = "O";
            gameHighlight();
             

        } else if (gamePlays[0] == "X" && gamePlays[3] == "X" && gamePlays[6] != "O") {
            gamePlays[6] = "O";
            gameHighlight();
             

        } else if (gamePlays[1] == "X" && gamePlays[4] == "X" && gamePlays[7] != "O") {
            gamePlays[7] = "O";
            gameHighlight();
             
        } else if (gamePlays[2] == "X" && gamePlays[5] == "X" && gamePlays[8] != "O") {
            gamePlays[8] = "O";
            gameHighlight();
             
        } else if (gamePlays[2] == "X" && gamePlays[1] == "X" && gamePlays[0] != "O") {
            gamePlays[0] = "O";

            gameHighlight();
             
        } else if (gamePlays[5] == "X" && gamePlays[4] == "X" && gamePlays[3] != "O") {
            gamePlays[3] = "O";

            gameHighlight();
             
        } else if (gamePlays[8] == "X" && gamePlays[7] == "X" && gamePlays[6] != "O") {
            gamePlays[6] = "O";

            gameHighlight();
             
        } else if (gamePlays[6] == "X" && gamePlays[3] == "X" && gamePlays[0] != "O") {
            gamePlays[0] = "O";

            gameHighlight();
             
        } else if (gamePlays[7] == "X" && gamePlays[4] == "X" && gamePlays[1] != "O") {
            gamePlays[1] = "O";

            gameHighlight();
             
        } else if (gamePlays[8] == "X" && gamePlays[5] == "X" && gamePlays[2] != "O") {
            gamePlays[2] = "O";

            gameHighlight();
             
        } else if (gamePlays[0] == "X" && gamePlays[2] == "X" && gamePlays[1] != "O") {
            gamePlays[1] = "O";

            gameHighlight();
             
        } else if (gamePlays[3] == "X" && gamePlays[5] == "X" && gamePlays[4] != "O") {
            gamePlays[4] = "O";

            gameHighlight();
             
        } else if (gamePlays[6] == "X" && gamePlays[8] == "X" && gamePlays[7] != "O") {
            gamePlays[7] = "O";

            gameHighlight();
             
        } else if (gamePlays[0] == "X" && gamePlays[6] == "X" && gamePlays[3] != "O") {
            gamePlays[3] = "O";

            gameHighlight();
             
        } else if (gamePlays[1] == "X" && gamePlays[7] == "X" && gamePlays[4] != "O") {
            gamePlays[4] = "O";

            gameHighlight();
             
        } else if (gamePlays[2] == "X" && gamePlays[8] == "X" && gamePlays[5] != "O") {
            gamePlays[5] = "O";

            gameHighlight();
             
        } else if (gamePlays[0] == "X" && gamePlays[4] == "X" && gamePlays[8] != "O") {
            gamePlays[8] = "O";

            gameHighlight();
             
        } else if (gamePlays[2] == "X" && gamePlays[4] == "X" && gamePlays[6] != "O") {
            gamePlays[6] = "O";

            gameHighlight();
             
        } else if (gamePlays[6] == "X" && gamePlays[4] == "X" && gamePlays[2] != "O") {
            gamePlays[2] = "O";

            gameHighlight();
             
        } else if (gamePlays[8] == "X" && gamePlays[4] == "X" && gamePlays[0] != "O") {
            gamePlays[0] = "O";

            gameHighlight();
             
        } else if (gamePlays[0] == "X" && gamePlays[8] == "X" && gamePlays[4] != "O") {
            gamePlays[4] = "O";

            gameHighlight();
             
        } else if (gamePlays[2] == "X" && gamePlays[6] == "X" && gamePlays[4] != "O") {
            gamePlays[4] = "O";
            gameHighlight();
             

        } //////////////////////////ELSE//////////////////////////////////////   
        else {
            int x = random.nextInt(8);
            int flag = 0;

            while (flag == 0) {

                if (gamePlays[x] == " ") {
                    gamePlays[x] = "O";
                    flag = 1;
                    gameHighlight();
                     
                } else {
                    x = random.nextInt(8);
                    
                    flag = 0;
                }
            }
        }
    }
    
    public void checkScoreComp() {
         if ((gamePlays[0] == "O" && gamePlays[1] == "O" && gamePlays[2] == "O")
                || (gamePlays[3] == "O" && gamePlays[4] == "O" && gamePlays[5] == "O")
                || (gamePlays[6] == "O" && gamePlays[7] == "O" && gamePlays[8] == "O")
                || (gamePlays[0] == "O" && gamePlays[3] == "O" && gamePlays[6] == "O")
                || (gamePlays[1] == "O" && gamePlays[4] == "O" && gamePlays[7] == "O")
                || (gamePlays[2] == "O" && gamePlays[5] == "O" && gamePlays[8] == "O")
                || (gamePlays[0] == "O" && gamePlays[4] == "O" && gamePlays[8] == "O")
                || (gamePlays[2] == "O" && gamePlays[4] == "O" && gamePlays[6] == "O")) {
             try {p2Wins++;wdlLabel.setText("                    O won");gameReset();} catch (Exception ex) {}
        }
    }
    
    public void checkScoreUser() {
        if ((gamePlays[0] == "X" && gamePlays[1] == "X" && gamePlays[2] == "X")
                || (gamePlays[3] == "X" && gamePlays[4] == "X" && gamePlays[5] == "X")
                || (gamePlays[6] == "X" && gamePlays[7] == "X" && gamePlays[8] == "X")
                || (gamePlays[0] == "X" && gamePlays[3] == "X" && gamePlays[6] == "X")
                || (gamePlays[1] == "X" && gamePlays[4] == "X" && gamePlays[7] == "X")
                || (gamePlays[2] == "X" && gamePlays[5] == "X" && gamePlays[8] == "X")
                || (gamePlays[0] == "X" && gamePlays[4] == "X" && gamePlays[8] == "X")
                || (gamePlays[2] == "X" && gamePlays[4] == "X" && gamePlays[6] == "X")) {
            try {p1Wins++;wdlLabel.setText("                    X won");gameReset();} catch (Exception ex) {};
        } else if (gamePlays[0] != " " && gamePlays[1] != " " && gamePlays[2] != " "
                && gamePlays[3] != " " && gamePlays[4] != " " && gamePlays[5] != " "
                && gamePlays[6] != " " && gamePlays[7] != " " && gamePlays[8] != " ") {
            try {wdlLabel.setText("                    Draw");gameReset();} catch (Exception ex) {};
        } 
    }

    }