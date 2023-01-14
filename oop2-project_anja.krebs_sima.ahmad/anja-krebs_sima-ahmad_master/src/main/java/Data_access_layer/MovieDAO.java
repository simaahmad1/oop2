package Data_access_layer;

import com.sun.javafx.collections.ObservableListWrapper;
import domain.Movie;
import domain.MovieManager;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class MovieDAO {

    private MovieManager movieManager;
    private List<Movie> movieList;

    private IntegerProperty profitStyle = new SimpleIntegerProperty(1);

    public MovieDAO(MovieManager movieManager){
        this.movieManager = movieManager;
        movieManager.setMovieList(readMoviesFromTSV());

    }
    public ObservableList<Movie> getAllMovies(){
        return FXCollections.observableArrayList(movieManager.getMovieList());
    }



    public List<Movie> readMoviesFromTSV(){
            List<Movie> movies = new ArrayList<>();
            try {
                FileReader fileReader = new FileReader(ClassLoader.getSystemResource("/films.tsv").getFile());
                movieList = new CsvToBeanBuilder<Movie>(fileReader)
                    .withType(Movie.class)
                    .withSeparator('\t')
                    .withSkipLines(1)
                    .build()
                    .parse();

                for (Movie movie : movieList) {
                    System.out.println(movie);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return movies;
        }




    public void addMovie(){
        movieManager.addMovie();

    }

    public void removeMovie(Movie movie){
        movieManager.removeMovie(movie);

    }

    public void saveData(){
        movieManager.dataWriter();

    }

    public StringProperty getProfit(ObjectProperty<Long> cost, ObjectProperty<Long> boxOffice) {
        StringProperty profit = new SimpleStringProperty();
        Long earnings;
        try {
            if (cost.get() != null && boxOffice.get() != null) {
                earnings = boxOffice.get() - cost.get();
                Long profitValue = (long)((float)earnings / cost.get() * 100);
                String string = "$" + earnings + " (" + profitValue + "%)";
                profit.set(string);
            } else {
                profit.set("");
            }
        } catch (NullPointerException e) {
            profit.set("");
        }
        return profit;
    }
    public IntegerProperty getProfitStyle(){
        return profitStyle;
    }


    public static StringProperty getRatingSymbol(IntegerProperty rating) {
            StringProperty s = new SimpleStringProperty();
            s.bind(Bindings.createStringBinding(() -> {
                if (rating.get() == 1) {
                    return "★";
                } else if (rating.get() == 2) {
                    return "★★";
                } else if (rating.get() == 3) {
                    return "★★★";
                } else if (rating.get() == 4) {
                    return "★★★★";
                } else if (rating.get() == 5) {
                    return "★★★★★";
                } else {
                    return "";
                }
            }, rating));
            return s;
    }


    public StringProperty getSeenSymbol(BooleanProperty seen) {
        StringProperty s = new SimpleStringProperty();
        s.bind(Bindings.createStringBinding(() -> {
            if (seen.get()) {
                return "✔";
            } else {
                return "";
            }
        }, seen));
        return s;
    }

    public static StringProperty getHandM(ObjectProperty<Integer> duration) {
        StringProperty s = new SimpleStringProperty();
        s.bind(Bindings.createStringBinding(() -> {
            try {
                int h = duration.get() / 60;
                int min = duration.get() % 60;
                return h + " h " + min + " min";
            } catch (NullPointerException e) {
                return "";
            }
        }, duration));
        return s;
    }
    public static ObservableList<Locale> getLanguageList() {
        List<Locale> languages = Arrays.stream(Locale.getISOLanguages())
            .map(l -> new Locale(l))
            .collect(Collectors.toList());
        return new ObservableListWrapper<Locale>(languages);
    }

    public static ObservableList<Locale> getCountryList() {
        List<Locale> countries = Arrays.stream(Locale.getISOCountries())
            .map(c -> new Locale("", c))
            .collect(Collectors.toList());
        return new ObservableListWrapper<Locale>(countries);
    }

}