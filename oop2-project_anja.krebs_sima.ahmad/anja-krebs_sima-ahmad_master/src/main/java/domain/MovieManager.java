package domain;

import Data_access_layer.MovieDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieManager {


    private MovieDAO movieDAO;
    private ArrayList<Movie> movieList = new ArrayList<>();
    private final ObservableList<Movie> movieTable = FXCollections.observableArrayList();

    public MovieManager()  {

        //read the movies from the tsv file

        movieDAO = new MovieDAO(this);
       movieList = (ArrayList<Movie>) movieDAO.getAllMovies();

    }
    public List<Movie> getAllMovies(){
        return movieList;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void addMovie() {
        movieList.add(new Movie());

    }

    public void removeMovie(Movie movie) {
        movieList.remove(movie);
    }


    public MovieDAO getMovieDAO() {
        return movieDAO;
    }

    public void dataWriter() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/data/films.tsv"));
            List<Movie> movies = this.movieList;
            for (Movie movie : movies) {
                String line = movie.getTitle() + "\t" + movie.getGenre() + "\t" + movie.getLanguage() + "\t" + movie.getDirector() + "\t" + movie.getCompany() + "\t" + movie.getCountry() + "\t" + movie.getSeen() + "\t" + movie.getRating() + "\t" + movie.getYear() + "\t" + movie.getDuration() + "\t" + movie.getBoxOffice() + "\t" + movie.getCost() + "\t" + movie.getCast();
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Movie> getAlleResult() {
        return movieTable;
    }
    public void setMovieList(List<Movie> newMovieList) {
        this.movieList = new ArrayList<>(newMovieList);
    }

}
