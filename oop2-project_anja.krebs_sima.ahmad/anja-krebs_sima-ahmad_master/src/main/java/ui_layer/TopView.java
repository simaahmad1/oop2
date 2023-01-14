package ui_layer;


import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class TopView extends GridPane implements ViewStructure {

    private Label title;
    private Label year;
    private Label genre;
    private Label duration;
    private Label ratingText;
    private CheckBox seen;
    private Slider rating;
    private ImageView imageView;
    private TextField searchField;


    public TopView(){
        super();
        setPadding(new Insets(10,10,10,10));
    }

    public void initializeSelf(){
        getStyleClass().add("rightView");
    }

    @Override
    public void initializeControls(){
        title = new Label("MovieTitle");
        title.getStyleClass().add("Title");
        year = new Label("Year");
        year.getStyleClass().add("Subtitle");
        genre = new Label("Genre");
        genre.getStyleClass().add("Subtitle");
        duration = new Label("Duration");
        duration.getStyleClass().add("Subtitle");
        imageView = new ImageView();


        seen = new CheckBox("Seen");
        seen.setSelected(true);
        seen.getStyleClass().add("Text");
        ratingText = new Label("Rating");
        ratingText.getStyleClass().add("Text");
        rating.setShowTickMarks(false);
        rating.setShowTickLabels(true);
        rating.setMajorTickUnit(1);
        rating.setMinorTickCount(4);
        rating.getStyleClass().add("Slider");
        rating.valueProperty().addListener((obs, oldVal, newVal) ->
        rating.setValue(newVal.intValue()));

    }

    @Override
    public void layoutControls() {
        //Column
        ColumnConstraints colV = new ColumnConstraints();
        colV.setHgrow(Priority.ALWAYS);
        ColumnConstraints colF = new ColumnConstraints();
        colF.setHgrow(Priority.NEVER);
        getColumnConstraints().addAll(colF, colF, colF, colV);

        //Line
        RowConstraints rowV = new RowConstraints();
        rowV.setVgrow(Priority.ALWAYS);
        RowConstraints rowF = new RowConstraints();
        rowF.setVgrow(Priority.NEVER);
        getRowConstraints().addAll(rowV, rowF, rowF, rowF, rowF);

        setHgap(10);

        add(title, 0,0,6,1);
        add(year,0,1);
        add(genre, 1,1);
        add(duration, 2,1);
        add(ratingText, 1,4);
        add(seen, 0,4);
        add(rating,2,4);
        add(imageView,3,0,1,4);

    }


    public Label getTitle(){
        return title;
    }

    public Label getYear(){
        return year;
    }
    public Label getGenre(){
        return genre;
    }
    public Label getDuration(){
        return duration;
    }
    public Slider getRating(){
        return rating;
    }
    public CheckBox getSeen(){
        return seen;
    }

    public TextField getSearchField(){
        return searchField;
    }



}