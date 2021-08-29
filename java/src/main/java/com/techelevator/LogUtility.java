package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class LogUtility {
    private File file;

    public LogUtility (String fileName){
        this.file = new File(fileName);
    }

    public void write(String message, BigDecimal a, BigDecimal b) {
      //  String nowTime = LocalDateTime.now().toString();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss aa");
        String nowTime = formatter.format(date);
        //DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");



//        >01/01/2016 12:00:15 PM FEED MONEY: \$5.00 \$10.00
//                >01/01/2016 12:00:20 PM Crunchie B4 \$10.00 \$8.50
//                >01/01/2016 12:01:25 PM Cowtales B2 \$8.50 \$7.50
//                >01/01/2016 12:01:35 PM GIVE CHANGE: \$7.50 \$0.00
        try {

            PrintWriter writer = null;

            if (this.file.exists()) {
                // append message to the existing file
                FileOutputStream outputStream = new FileOutputStream(this.file, true);
                writer = new PrintWriter(outputStream);
                writer.println(nowTime + " " + message + " " + "$" + a + " $" + b);


            } else {
                this.file = new File("log.txt");
                writer = new PrintWriter(this.file);
                writer.println(nowTime + " " + message + " " + " $" + a + " $" + b);

            }

            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




    }

}
