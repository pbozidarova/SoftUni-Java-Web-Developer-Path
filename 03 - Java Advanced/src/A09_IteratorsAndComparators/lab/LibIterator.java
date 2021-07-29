package A09_IteratorsAndComparators.lab;

import java.util.Iterator;

public class LibIterator implements Iterator<Book> {

    private Book[] data;
    private int index;

    public LibIterator(Book[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.data.length;
    }

    @Override
    public Book next() {
        return this.data[this.index++];
    }
}
