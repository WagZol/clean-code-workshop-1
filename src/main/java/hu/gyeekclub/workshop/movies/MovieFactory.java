/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.gyeekclub.workshop.movies;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 *
 * @author wagnerz
 */
public class MovieFactory {

    private static Map<MovieTypes, Function<String, Movie>> movieCreationTable=
            new HashMap<>();
    
    static {
        movieCreationTable.put(MovieTypes.REGULAR, RegularMovie::new);
        movieCreationTable.put(MovieTypes.CHILDRENS, ChildrensMovie::new);
        movieCreationTable.put(MovieTypes.NEW_RELEASE, NewReleaseMovie::new);
    }

    public static Movie createFilm(MovieTypes types, String movieTitle) {
        return movieCreationTable.get(types).apply(movieTitle);
    }
}

