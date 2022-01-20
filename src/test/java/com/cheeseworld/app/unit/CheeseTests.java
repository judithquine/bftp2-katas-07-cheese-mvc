package com.cheeseworld.app.unit;

import com.cheeseworld.app.Cheese;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheeseTests {

    @Test
    void eachCheeseHasAName() {
        assertThat(new Cheese("Rochefort|stinky french cheese|250gr").getName(), is("Rochefort"));
        assertThat(new Cheese("Manchego|gourmet spanish cheese|100gr").getName(), is("Manchego"));
        assertThat(new Cheese("Cabrales|super smelly cheese|100gr").getName(), is("Cabrales"));
    }

    @Test
    void aCheeseIsConsideredStinkyIfContainsStinkyOrSmellyInTheDescription () {
        assertThat(new Cheese("Rochefort|stinky french cheese|250gr").isStinky(), is(true));
        assertThat(new Cheese("Manchego|gourmet spanish cheese|100gr").isStinky(), is(false));
        assertThat(new Cheese("Cabrales|super smelly cheese|100gr").isStinky(), is(true));
    }

    @Test
    void aCheeseHasDiscountIfContainDiscountInTheDescription () {
        assertThat(new Cheese("Rochefort|stinky french cheese discount|250gr").hasDiscount(), is(true));
        assertThat(new Cheese("Manchego|gourmet spanish cheese|100gr").hasDiscount(), is(false));
        assertThat(new Cheese("Cabrales|super smelly cheese|100gr").hasDiscount(), is(false));
    }

    @Test
    public void aCheeseHasPriceNormal() {
        Cheese cheese = new Cheese("Rochefort|stinky french cheese discount|250gr");
        cheese.setPrice(5.0);
        assertThat(cheese.getPrice(), equalTo(4.5));

    }



}
