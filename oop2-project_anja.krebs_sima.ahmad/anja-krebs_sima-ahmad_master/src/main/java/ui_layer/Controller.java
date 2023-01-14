package ui_layer;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class Controller extends GridPane implements ViewStructure {

    private Button save;
    private Button add;
    private Button remove;
    private Button searchIcon;
    private TextField search;

    private ApplicationUI applicationUI;



    public Controller(ApplicationUI applicationUI){
        super();
        this.applicationUI = applicationUI;
        init();
    }

    public void initializeSelf() {
        String stylesheet = getClass().getResource("/data/style.css").toExternalForm();
        getStylesheets().add(stylesheet);
        getStyleClass().add("header");

    }

    @Override

    public void initializeControls() {

        save = new Button("save");
        save.setMinSize(30, 30);
        save.setMaxSize(30, 30);
        save.getStyleClass().add("save");

        add = new Button();
        add.setMinSize(30, 30);
        add.setMaxSize(30, 30);
        add.getStyleClass().add("plus");

        remove = new Button();
        remove.getStyleClass().add("minus");
        remove.setMinSize(30, 30);
        remove.setMaxSize(30, 30);

        search = new TextField();
        search.setPromptText("search");
        search.getStyleClass().add("TextField");

        searchIcon = new Button();
        searchIcon.getStyleClass().add("search");
        searchIcon.setMinSize(30, 30);
        searchIcon.setMaxSize(30, 30);

    }

    @Override
    public void layoutControls() {

        ColumnConstraints colV = new ColumnConstraints();
        colV.setHgrow(Priority.ALWAYS);
        ColumnConstraints colF = new ColumnConstraints();
        colF.setHgrow(Priority.NEVER);
        getColumnConstraints().addAll(colF, colF, colF, colF, colV, colF, colF);

        // Lines
        RowConstraints rowV = new RowConstraints();
        rowV.setVgrow(Priority.ALWAYS);
        RowConstraints rowF = new RowConstraints();
        rowF.setVgrow(Priority.NEVER);
        getRowConstraints().addAll(rowF);

        setMinHeight(50);
        setMaxHeight(50);
        // setPadding(new Insets(0));
        setHgap(10);

        add(save, 1, 0);
        add(add, 2, 0);
        add(remove, 3, 0);
        add(searchIcon, 5, 0);
        add(search, 6, 0);
    }

    @Override
    public void setupEventHandlers() {
        save.setOnAction(c -> applicationUI.saveData());
        add.setOnAction(c -> applicationUI.addMovie());
        remove.setOnAction(c ->applicationUI.removeMovie());
    }
    public TextField getSearch() {
        return search;
    }


}
