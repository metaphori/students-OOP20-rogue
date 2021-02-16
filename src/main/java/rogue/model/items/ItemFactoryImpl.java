package rogue.model.items;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ItemFactoryImpl implements ItemFactory {

    /**
     * @param quantity of wanted items.
     * @return List containing randomly generated items.
     */
    public ArrayList<Item> getItems(final int quantity) {
        return null;
    }

    /**
     * Generate a stream of an Enumeration.
     * Author "https://stackoverflow.com/questions/23261803/iterate-an-enumeration-in-java-8/23276455#23276455"
     * @param <T>
     * @param e
     * @return Stream<T>
     */
    public static <T> Stream<T> enumerationAsStream(final Enumeration<T> e) {
        return StreamSupport.stream(
            Spliterators.spliteratorUnknownSize(
                new Iterator<T>() {
                    public T next() {
                        return e.nextElement();
                    }
                    public boolean hasNext() {
                        return e.hasMoreElements();
                    }
                },
                Spliterator.ORDERED), false);
    }

}
