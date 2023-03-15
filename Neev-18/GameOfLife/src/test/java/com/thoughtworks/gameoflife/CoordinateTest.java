package com.thoughtworks.gameoflife;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CoordinateTest {
    @Test
    void shouldReturnXPositionAsOneWhenTheCoordinateIsOneCommaOne() {
        Coordinate coordinate = new Coordinate(1, 1);

        assertThat(coordinate.getXCoordinate(), is(1));
    }

    @Test
    void shouldReturnYPositionAsOneWhenTheCoordinateIsOneCommaOne() {
        Coordinate coordinate = new Coordinate(1, 1);

        assertThat(coordinate.getXCoordinate(), is(1));
    }
}
