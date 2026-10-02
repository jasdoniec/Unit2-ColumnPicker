import kareltherobot.*;
/**
 * Counts the number of beepers in a column and puts the same
 * number of beepers at the base of the column
 * 
 * @author 
 * @version 
 */
public class ColumnPicker extends Robot
{
    public ColumnPicker(int street, int avenue, Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    public void countColumns(int numStreets)
    {
        move();
        if (nextToABeeper()){
            return;
        }
        turnLeft();
        putBeepers(countColumn(numStreets));
        turnLeft();
        countColumns(numStreets);
    }

    public void putBeepers(int num){
        if (num == 0)
            return;
        putBeeper();
        putBeepers(num-1);
    }

    public int countColumn(int length)
    {
        int count = 0;
        count += countPile();
        move();
        if (length <= 0){
            turnLeft();
            turnLeft();
        }
        else{
            count += countColumn(length-1);
        }
        move();
        
        return count;

    }

    private int countPile(){
        if (!nextToABeeper()){
            return 0;
        }

        pickBeeper();

        return 1 + countPile();
    }
}