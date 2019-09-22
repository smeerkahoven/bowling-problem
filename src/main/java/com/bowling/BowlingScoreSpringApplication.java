package com.bowling;

import com.bowling.model.BowlingToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 */
@SpringBootApplication
public class BowlingScoreSpringApplication implements CommandLineRunner {
    private static Logger LOG = LoggerFactory
            .getLogger(BowlingScoreSpringApplication.class);

    public File loadFile(String f)
            throws IOException {

        File file = new File(f);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
        return file;
    }


   public static void main (String [] args)  {
       LOG.info("STARTING THE APPLICATION");
       SpringApplication.run(BowlingScoreSpringApplication.class, args);
       LOG.info("APPLICATION FINISHED");
   }

    @Override
    public void run(String... args) {
        System.out.println("args");

        System.out.println(args);

        if (args.length == 0) {
            LOG.info("Usage : java -jar bowling-1.0.jar path/to/file");
            LOG.info("");
            LOG.info("path/to/file : A text file with input Data");

            return ;
        }


        LOG.info("EXECUTING : command line runner");

        BowlingToken t = new BowlingToken("JOse",4);

        System.out.println(t.getKey());


        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
            System.out.println("Hola mundo "+ i);
        }
        try {

                loadFile(args[0]);

        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
}



