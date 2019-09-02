package com.friendsurance.processing.impl;

import com.friendsurance.model.UserDetails;
import com.friendsurance.processing.ItemReader;

import java.util.Iterator;
import java.util.List;
/*
This is concrete implementation of ItemReader interface.
 */
public class ItemReaderImpl implements ItemReader<UserDetails> {

    private List<UserDetails> items;

    private Iterator<UserDetails> iterator;

    public ItemReaderImpl(List<UserDetails> items) {
        this.items = items;
        this.iterator = items.iterator();
    }

    public UserDetails read() {
        if (!hasNext())
            return null;

        return next();
    }

    private boolean hasNext() {
        return iterator.hasNext();
    }

    private UserDetails next() {
        return iterator.next();
    }
}
