package hu.gyeekclub.workshop;

import hu.gyeekclub.workshop.movies.MovieFactory;
import hu.gyeekclub.workshop.movies.MovieTypes;
import hu.gyeekclub.workshop.movies.RegularMovie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

// these tests test for code security: how much code allows itself to be misused
// As a wise man once said: thou shalt make thine code resilient to tardiness!
public class SecurityTests {

    @Test
    public void nullConstructorTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Customer(null);
                    MovieFactory.createFilm(MovieTypes.REGULAR, null);
                },
                "Do not allow null parameters to stay unpunished."
        );
    }

    @Test
    public void nullParameterTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Customer("Test").addRental(null);
                },
                "No not allow null parameters to stay unpunished."
        );
    }

    @Test
    public void negativeDayTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Rental(new RegularMovie("It"), -1);
                },
                "Not allow negative days."
        );
    }
    
    public void nullDayTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Rental(new RegularMovie("Thing"), 0);
                },
                "Not allow null days."
        );
    }

// Deprecated because movieTpye is enum    
//    @Test
//    public void illegalParameterTest() {
//        assertThrows(
//            IllegalArgumentException.class,
//            () -> {
//                Customer customer = new Customer("Test");
//                Movie invalidMovie = new Movie("Nope", 80); // 80 is invalid
//                invalidMovie.setPriceCode(88); // even more illegal
//                customer.addRental(new Rental(invalidMovie, 5));
//                customer.statement();
//            },
//            "No not allow invalid parameters to happen."
//        );
//    }
}
