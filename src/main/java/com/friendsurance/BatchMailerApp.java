package com.friendsurance;

import com.friendsurance.model.UserDetails;
import com.friendsurance.processing.ItemProcessing;
import com.friendsurance.processing.impl.ItemProcessingImpl;
import com.friendsurance.processing.impl.ItemReaderImpl;
import com.friendsurance.processing.impl.ItemWriterImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class is client class where execution starts.
 * This class has to be executed based on the schedule, we use cron expressions and quartz jobs to specify the schedule.
 *
 */
public class BatchMailerApp {

    public static void main(String[] args) {

        List<UserDetails> users = new ArrayList<>();
        //below record matches email_type2 & email_type3 but system pick email_type3 as it is high priority.
        users.add(new UserDetails("ram@gmail.com" , false, 1, 7));

        users.add(new UserDetails("John@gmail.com" , false, 0, 0));
        users.add(new UserDetails("Jack@gmail.com" , false, 3, 0));
        users.add(new UserDetails("Sara@gmail.com" , false, 4, 2));
        users.add(new UserDetails("Jeff@gmail.com" , false, 2, 2));
        users.add(new UserDetails("Doug@gmail.com" , false, 2, 10));
        users.add(new UserDetails("Nelsan@gmail.com" , true, 0, 0));
        users.add(new UserDetails("Lisa@gmail.com" , true, 0, 5));
        users.add(new UserDetails("Harper@gmail.com" , true, 2, 2));
        users.add(new UserDetails("raghu@gmail.com" , true, 5, 4));


        // Using executor framework as we may get large volume of records from other system/database.
        // Even we can assign fixed number of users to each thread.
        // Here all users are given to 5 threads.
        ExecutorService service = Executors.newFixedThreadPool(5);

        service.submit(new Thread(()->{
            ItemProcessing itemProcessing = new ItemProcessingImpl(new ItemReaderImpl(users),new ItemWriterImpl());

            itemProcessing.doProcessing();
        }));

        service.shutdown();
        

    }
}
