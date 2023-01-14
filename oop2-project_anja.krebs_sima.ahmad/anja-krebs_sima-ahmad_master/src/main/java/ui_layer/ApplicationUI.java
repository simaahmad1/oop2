package ui_layer;

import Data_access_layer.MovieDAO;
import domain.MovieManager;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;



public class ApplicationUI extends GridPane implements ViewStructure {

    private  MovieDAO movieDAO;
    private MovieManager movieManager;
    private MovieTableView movieTableView;
    private Controller controller;

    private TopView topView;
    private BottomView bottomView;

    private SplitPane splitPane;
    private VBox rightSplit;



    public ApplicationUI(MovieManager movieManager) {
        this.movieManager = movieManager;
        this.movieDAO = new MovieDAO(movieManager);

    }


    public void initializeSelf() {
        String stylesheet = getClass().getResource("/data/style.css").toExternalForm();
        getStylesheets().add(stylesheet);

    }

    public void initializeControls() {

        splitPane = new SplitPane();
        rightSplit = new VBox();
        topView = new TopView();
        bottomView = new BottomView(this);
        controller = new Controller(this);



    }

    public void layoutControls() {

        // Columns
        ColumnConstraints colV = new ColumnConstraints();
        colV.setHgrow(Priority.ALWAYS);
        ColumnConstraints colF = new ColumnConstraints();
        colF.setHgrow(Priority.NEVER);
        getColumnConstraints().addAll(colF, colV);

        // Lines
        RowConstraints rowV = new RowConstraints();
        rowV.setVgrow(Priority.ALWAYS);
        RowConstraints rowF = new RowConstraints();
        rowF.setVgrow(Priority.NEVER);
        getRowConstraints().addAll(rowF, rowV);

        // Linke und Rechte seite der Splitpane füllen + startverhältnis setzen
        rightSplit.getChildren().addAll(topView, bottomView);

        rightSplit.setVgrow(bottomView, Priority.ALWAYS);

        splitPane.getItems().add(rightSplit);
        splitPane.setDividerPositions(0.50f, 0.50f);

        add(splitPane, 0, 1, 2, 1);


        movieDAO = new MovieDAO(movieManager);
        movieTableView = new MovieTableView(this);
        movieTableView.getTableView().setItems(movieDAO.getAllMovies());

    }
    public void setupBindings() {
    }
    public void setupEventHandlers() {
    }

    public void setupValueChangedListeners() {
    }

    public void removeCast() {
        try {
            bottomView.getCastField().getItems().remove(bottomView.getCastField().getSelectionModel().getSelectedIndex());
        } catch (IndexOutOfBoundsException e) {

        }
    }

    public void addCast() {
        ListView<String> castField = bottomView.getCastField();
        castField.getItems().add("New");
        castField.layout();
        castField.edit(castField.getItems().size() - 1);
    }
    public void moveCast(boolean dir) {
        try {
            final int step = 1;
            ListView<String> castField = bottomView.getCastField();
            String item = castField.getSelectionModel().getSelectedItem();
            int index;
            if (dir) {
                index = castField.getSelectionModel().getSelectedIndex() - step;
            } else {
                index = castField.getSelectionModel().getSelectedIndex() + step;
            }
            if (index >= castField.getItems().size())
                index = 0;
            else if (index < 0) {
                index = castField.getItems().size() - step;
            }
            castField.getItems().remove(castField.getSelectionModel().getSelectedIndex());
            castField.getItems().add(index, item);
            castField.getSelectionModel().clearAndSelect(index);
        } catch (IndexOutOfBoundsException e) {

        }

    }

    public IntegerProperty getProfitStyle() {
        return movieDAO.getProfitStyle();
    }


    public void removeMovie(){
        movieDAO.removeMovie(movieTableView.getTableView().getSelectionModel().getSelectedItem());
    }

    public void addMovie(){
        movieDAO.addMovie();
        movieTableView.getTableView().getSelectionModel().selectLast();
        movieTableView.getTableView().scrollTo(movieTableView.getTableView().getSelectionModel().getSelectedItem());
    }

    public void saveData() {
        movieDAO.saveData();
    }



}

