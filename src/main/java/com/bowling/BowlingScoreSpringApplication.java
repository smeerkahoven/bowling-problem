package com.bowling;

import com.bowling.main.BowlingScoreApp;
import com.bowling.model.BowlingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication
public class BowlingScoreSpringApplication implements CommandLineRunner {
    private static Logger LOG = LoggerFactory
            .getLogger(BowlingScoreSpringApplication.class);

   public static void main (String [] args)  {
       LOG.info("STARTING THE APPLICATION");
       SpringApplication.run(BowlingScoreSpringApplication.class, args);
       LOG.info("APPLICATION FINISHED");
   }

    @Override
    public void run(String... args) {

        if (args.length == 0) {
            LOG.info("Usage : java -jar bowling-1.0.jar path/to/file");
            LOG.info("");
            LOG.info("path/to/file : A text file with input Data");

            return ;
        }

        try {
            BowlingScoreApp app = new BowlingScoreApp(args[0]);
            app.start();
        } catch (BowlingException e) {
            e.printStackTrace();
        }

    }
}



