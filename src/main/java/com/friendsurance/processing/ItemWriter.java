package com.friendsurance.processing;

/**
 * Writes result of the processing performed by ItemProcessing.
 */
public interface ItemWriter<O> {

    /**
     * Writes an item produced by ItemProcessing (see 'O process(I item)' method). This
     * could imply writing into a database or a file or an email provider, depending on
     * the implementation.
     */
    void write(O item);

}
