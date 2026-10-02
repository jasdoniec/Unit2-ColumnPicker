import kareltherobot.*;

public class Driver
{
   public static void main(String[] args)
   {
       World.setVisible(true);
       World.readWorld("RandomColumns.kwld");
       World.setDelay(0);
       World.setTrace(false);
       
       ColumnPicker baker = new ColumnPicker(1,1,Directions.North,-1);
       baker.turnLeft();
       baker.turnLeft();
       baker.turnLeft();
       baker.countColumns(8);
    }
}
