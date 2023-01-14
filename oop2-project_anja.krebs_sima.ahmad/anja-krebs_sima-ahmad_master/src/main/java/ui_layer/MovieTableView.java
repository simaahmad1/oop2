package ui_layer;

import domain.Movie;
import domain.MovieManager;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class MovieTableView extends VBox implements ViewStructure{
    private final ApplicationUI applicationUI;
    private SortedList<Movie> sortedList;
    private TableView<Movie> tableView;

    public MovieTableView(ApplicationUI applicationUI) {

        this.applicationUI = applicationUI;
        init();
    }

    @Override
    public void initializeControls() {
        tableView = initializeMovieTableView();

    }

    private TableView<Movie> initializeMovieTableView(){


        TableColumn<Movie, Boolean> seenColumn = new TableColumn<>("👁");
        seenColumn.setCellValueFactory(new PropertyValueFactory<>("seen"));
        TableColumn<Movie, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
        TableColumn<Movie, Integer> yearColumn = new TableColumn<>("Year");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("Year"));
        TableColumn<Movie, String> genreColumn = new TableColumn<>("Genre");
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("Genre"));
        TableColumn<Movie, Integer> ratingColumn = new TableColumn<>("Rating");
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("Rating"));

        tableView.getColumns().addAll(seenColumn, titleColumn, yearColumn, ratingColumn, genreColumn);
        tableView.getStyleClass().add("movie-table");

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setPlaceholder(new Label("No Movies found!"));

        tableView.setItems(sortedList);

        return tableView;

    }

    @Override
    public void layoutControls() {
        setPadding(new Insets(10));
        setVgrow(tableView, Priority.ALWAYS);
        getChildren().add(tableView);
    }


    @Override
    public void setupBindings() {
        sortedList.comparatorProperty().bind(tableView.comparatorProperty());

    }
    public TableView<Movie> getTableView() {
        return tableView;
    }

}
