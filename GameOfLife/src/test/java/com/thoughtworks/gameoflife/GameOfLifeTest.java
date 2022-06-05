package com.thoughtworks.gameoflife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GameOfLifeTest {
    private GameOfLife gameOfLife;

    @BeforeEach
    public void setUp() {
        gameOfLife = new GameOfLife();
    }

    @Test
    public void shouldReturnAllLivingCellBlockPattern() {
        assertThat(gameOfLife.play("1 1\n" + "1 2\n" + "2 1\n" + "2 2\n"), is("1 1\n" + "1 2\n" + "2 1\n" + "2 2\n"));
    }

    @Test
    public void shouldReturnAllLivingCellBoatPattern() {
        assertThat(gameOfLife.play("0 1\n" + "1 0\n" + "2 1\n" + "0 2\n" + "1 2\n"), is("0 1\n" + "0 2\n" + "1 0\n" + "1 2\n" + "2 1\n"));
    }

    @Test
    public void shouldReturnNewLivingCellBlinkerPattern() {
        assertThat(gameOfLife.play("1 1\n" + "1 0\n" + "1 2\n"), is("0 1\n" + "1 1\n" + "2 1\n"));
    }

    @Test
    public void shouldReturnNewLivingCellToadPattern() {
        assertThat(gameOfLife.play("1 1\n" + "1 2\n" + "1 3\n" + "2 2\n" + "2 3\n" + "2 4\n"), is("0 2\n" + "1 1\n" + "1 4\n" + "2 1\n" + "2 4\n" + "3 3\n"));
    }
}
