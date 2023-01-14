package ui_layer;

import Data_access_layer.MovieDAO;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.util.StringConverter;


import java.util.Locale;

public class BottomView extends GridPane implements ViewStructure{


    private Label title;
    private Label year;
    private Label genre;
    private Label duration;
    private Label min;
    private Label language;
    private Label director;
    private Label company;
    private Label cast;
    private Label country;
    private Label boxOffice;
    private Label cost;

    private Label profit;
    private Label profitNumber;
    private TextField titleField;
    private TextField yearField;
    private TextField genreField;
    private TextField durationField;
    private ChoiceBox<Locale> languageField;
    private TextField companyField;
    private TextField directorField;
    private ListView<String> castField;
    private ChoiceBox<Locale> countryField;
    private TextField boxOfficeField;
    private TextField costField;


    private Button plus;
    private Button minus;
    private Button up;
    private Button down;

    private ApplicationUI applicationUI;


    public BottomView(ApplicationUI applicationUI){
        super();
        this.applicationUI = applicationUI;
        setPadding(new Insets(20,20,20,20));
    }

    public void initializeSelf(){
        getStyleClass().add("rightView");
    }



    @Override
    public void initializeControls() {
        title = new Label("Title");
        title.getStyleClass().add("MovieTitle");
        year = new Label("Year");
        year.getStyleClass().add("MovieTitle");
        genre = new Label("Genre");
        genre.getStyleClass().add("MovieTitle");
        duration = new Label("Duration");
        duration.getStyleClass().add("MovieTitle");
        min = new Label("min");
        min.getStyleClass().add("MovieTitle");
        language = new Label("Language");
        language.getStyleClass().add("MovieTitle");
        director = new Label("Director");
        director.getStyleClass().add("MovieTitle");
        company = new Label("Company");
        company.getStyleClass().add("MovieTitle");
        cast = new Label("Cast");
        cast.getStyleClass().add("MovieTitle");
        country = new Label("Country");
        country.getStyleClass().add("MovieTitle");
        boxOffice = new Label("Box Office");
        boxOffice.getStyleClass().add("MovieTitle");
        cost = new Label("Cost");
        cost.getStyleClass().add("MovieTitle");
        profit = new Label("Profit");
        profit.getStyleClass().add("MovieTitle");


        titleField = new TextField();
        titleField.getStyleClass().add("TextField");
        yearField = new TextField();
        yearField.getStyleClass().add("TextField");
        genreField = new TextField();
        genreField.getStyleClass().add("TextField");
        durationField = new TextField();
        durationField.getStyleClass().add("TextField");
        languageField = new ChoiceBox<Locale>(MovieDAO.getLanguageList());
        languageField.setConverter(new StringConverter<Locale>() {
            @Override
            public String toString(Locale object) {

                return object.getDisplayLanguage(Locale.ENGLISH);
            }
            @Override
            public Locale fromString(String string) {
                // TODO Auto-generated method stub
                return null;
            }
        });
        languageField.getStyleClass().add("TextField");
        directorField = new TextField();
        directorField.getStyleClass().add("TextField");
        companyField = new TextField();
        companyField.getStyleClass().add("TextField");
        countryField = new ChoiceBox<Locale>(MovieDAO.getCountryList());
        countryField.setConverter(new StringConverter<Locale>() {
            @Override
            public String toString(Locale object) {

                return object.getDisplayCountry(Locale.ENGLISH);
            }
            @Override
            public Locale fromString(String string) {
                // TODO Auto-generated method stub
                return null;
            }
        });
        countryField.getStyleClass().add("TextField");
        boxOfficeField = new TextField();
        boxOfficeField.getStyleClass().add("TextField");
        costField = new TextField();
        costField.getStyleClass().add("TextField");

        castField = new ListView<String>();
        castField.setCellFactory(TextFieldListCell.forListView());
        castField.setEditable(true);
        castField.getStyleClass().add("CastField");

        plus = new Button();
        plus.getStyleClass().add("plus");
        plus.setMinSize(30,30);
        plus.setMaxSize(30,30);

        minus = new Button();
        minus.getStyleClass().add("minus");
        minus.setMinSize(30,30);
        minus.setMaxSize(30,30);

        up = new Button();
        up.getStyleClass().add("up");
        up.setMinSize(30,30);
        up.setMaxSize(30,30);

        down = new Button();
        down.getStyleClass().add("down");
        down.setMinSize(30,30);
        down.setMaxSize(30,30);

        // ProfitNumber should be calculated
        profitNumber = new Label("ProfitCalculation");
        profitNumber.getStyleClass().add("MovieTitle");

    }

    @Override
    public void layoutControls() {

        //Columns
        ColumnConstraints colV = new ColumnConstraints();
        colV.setHgrow(Priority.ALWAYS);
        ColumnConstraints colF = new ColumnConstraints();
        colF.setHgrow(Priority.NEVER);
        getColumnConstraints().addAll(colF, colF, colF, colF, colF, colV, colF);

        //Lines
        RowConstraints rowV = new RowConstraints();
        rowV.setVgrow(Priority.ALWAYS);
        RowConstraints rowF = new RowConstraints();
        rowF.setVgrow(Priority.NEVER);
        getRowConstraints().addAll(rowF, rowF, rowF, rowF, rowV, rowF, rowF, rowF, rowV, rowF, rowF, rowF);

        setHgap(5);
        setVgap(10);


        add(title, 0, 0);
        add(year, 0, 1);
        add(genre, 4, 1);
        add(duration, 0, 2);
        add(min, 2, 2);
        add(language, 4, 2);
        add(director, 0, 3);
        add(company, 4, 3);
        add(cast, 0, 4);
        add(country, 0, 10);
        add(boxOffice, 0, 11);
        add(cost, 4, 11);
        add(profit, 0, 12);
        add(profitNumber, 1, 12);
        add(titleField, 1, 0, 6, 1);
        add(yearField, 1, 1, 2, 1);
        add(genreField, 5, 1, 2, 1);
        add(durationField, 1, 2, 1, 1);
        add(languageField, 5, 2, 2, 1);
        add(directorField, 1, 3, 2, 1);
        add(companyField, 5, 3, 2, 1);
        add(castField, 1, 4, 5, 5);
        add(plus, 6, 4);
        add(minus, 6, 5);
        add(up, 6, 6);
        add(down, 6, 7);
        add(countryField, 1, 10, 6, 1);
        add(boxOfficeField, 1, 11, 2, 1);
        add(costField, 5, 11, 2, 1);


    }

    @Override
    public void setupEventHandlers() {
        up.setOnAction(c -> applicationUI.moveCast(true));
        down.setOnAction(c -> applicationUI.moveCast(false));
        minus.setOnAction(c -> applicationUI.removeCast());
        plus.setOnAction(c -> applicationUI.addCast());

    }

    @Override
    public void setupValueChangedListeners() {
       applicationUI.getProfitStyle().addListener((obser, oldValue, newValue) -> {
            if(newValue.intValue() == 0) {
                profitNumber.setStyle("-fx-text-fill: #ff0000");
            }
            else if(newValue.intValue() == 1) {
                profitNumber.setStyle("-fx-text-fill: #7a7a7a");
            }
            else {
                profitNumber.setStyle("-fx-text-fill: #00ff18");
            }
        });

    }

    @Override
    public void setupBindings() {

    }


    public TextField getTitleField() {
        return titleField;
    }

    public TextField getYearField() {
        return yearField;
    }

    public TextField getGenreField() {
        return genreField;
    }

    public TextField getDurationField() {
        return durationField;
    }

    public ChoiceBox<Locale> getLanguageField() {
        return languageField;
    }

    public TextField getDirectorField() {
        return directorField;
    }

    public TextField getCompanyField() {
        return companyField;
    }

    public ListView<String> getCastField() {
        return castField;
    }

    public ChoiceBox<Locale> getCountryField() {
        return countryField;
    }

    public TextField getBoxOfficeField() {
        return boxOfficeField;
    }

    public TextField getCostField() {
        return costField;
    }

    public Label getProfitNumber() {
        return profitNumber;
    }
}

