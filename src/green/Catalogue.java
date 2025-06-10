package green;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Catalogue
{
  private static Catalogue instance = new Catalogue(); // Singleton instance
  private static final Lock lock = new ReentrantLock();

  private DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd  hh:mm:ss");



  public static Catalogue getInstance()
  {
    if (instance == null)
    {
      synchronized (lock)
      {
        if (instance == null)
        {
          instance = new Catalogue();
        }
      }
    }
    return instance;
  }

  public synchronized void add(String log)
  {
    if (log == null || log.equals(""))
    {
      return;
    }
    LogLine logLine = new LogLine(log, dateFormat.format(Calendar.getInstance().getTime()));
    System.out.println(logLine); // add to the console
  }



}
