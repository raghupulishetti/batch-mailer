package com.friendsurance.processing;

/**
 * Main processing class which should be used and extended.
 * Data to be precessed will be retrieved from ItemReader.
 * After data has been processed the result will be passed to ItemWriter.
 */
public abstract class ItemProcessing<I, O> {

    private ItemReader<I> reader;
    private ItemWriter<O> writer;

    protected ItemProcessing(ItemReader<I> reader, ItemWriter<O> writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * This method is responsible for processing of each individual item. Subclasses should define
     * custom processing logic here.
     *
     * @param item Item to process
     * @return result which will be passed to ItemWriter. Can be null if no processing was possible.
     */
    protected abstract O process(I item);

    /**
     * Main processing method which will be called by client code.
     * <p/>
     * It will receive items from ItemReader, apply processing to each
     * individual item and forward results to ItemWriter.
     */
    public final void doProcessing() {

        //Infinite loop, to FIX
        // for (I item = reader.read(); item != null; ) {
        I item;
        while ((item = reader.read()) != null) {

            O result = process(item);

            if (result != null) {
                writer.write(result);
            }

        }

    }

}
