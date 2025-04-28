package main;

import orange.GemDeposit;
import orange.GemMine;
import orange.GemMineWorker;
import orange.GemTransporter;
import red.TreasureRoom;
import red.TreasureRoomGuard;

public class Test
{
  public static void main(String[] args)
  {
    GemDeposit gemDeposit = new GemDeposit();
    GemMine gemMine = new GemMine();
    TreasureRoom treasureRoom = new TreasureRoom();
    TreasureRoomGuard treasureRoomGuard = new TreasureRoomGuard(treasureRoom);

    GemMineWorker worker1 = new GemMineWorker(gemMine, gemDeposit, "Worker1");
    GemMineWorker worker2 = new GemMineWorker(gemMine, gemDeposit,"Worker2");
    GemMineWorker worker3 = new GemMineWorker(gemMine, gemDeposit, "Worker3");
    GemMineWorker worker4 = new GemMineWorker(gemMine, gemDeposit, "Worker4");
    GemMineWorker worker5 = new GemMineWorker(gemMine, gemDeposit, "Worker5");
    worker1.changeMineStrategy("MineFast");
    worker2.changeMineStrategy("MineSlow");
    worker3.changeMineStrategy("MineCows");
    worker4.changeMineStrategy("MineBestQuality");
    worker5.changeMineStrategy("MineWorstQuality");

    GemTransporter transporter1 = new GemTransporter(gemDeposit, "Transporter1", treasureRoomGuard);
    GemTransporter transporter2 = new GemTransporter(gemDeposit, "Transporter2", treasureRoomGuard);
    GemTransporter transporter3 = new GemTransporter(gemDeposit, "Transporter3",treasureRoomGuard);

    Thread workerThread1 = new Thread(worker1);
    Thread workerThread2 = new Thread(worker2);
    Thread workerThread3 = new Thread(worker3);
    Thread workerThread4 = new Thread(worker4);
    Thread workerThread5 = new Thread(worker5);

    Thread transporterThread1 = new Thread(transporter1);
    Thread transporterThread2 = new Thread(transporter2);
    Thread transporterThread3 = new Thread(transporter3);

    workerThread1.start();
    workerThread2.start();
    workerThread3.start();
    workerThread4.start();
    workerThread5.start();
    transporterThread1.start();
    transporterThread2.start();
    transporterThread3.start();
  }
}
