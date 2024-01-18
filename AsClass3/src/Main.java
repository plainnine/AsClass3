import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayUtilS uArray=new ArrayUtilS(50);
        uArray.fill(3);
        uArray.print();
        uArray.sum(new ArrayUtilS.OnCalculatorLinistener() { //реализация ананимного класса-наследника
            @Override
            public void getResult(int sum) {
                System.out.println(": "+sum);
            }
        });
    }
}
class ArrayUtilS{
    private int[]array;
    public  ArrayUtilS(int count){
        array=new int[count];
        fill(1);
    }
    public void fill(int value){
        Arrays.fill(array,value);
    }
    public void print(){
        for(int i=0;i< array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    public  void sum(OnCalculatorLinistener calculatorLinistener ){
        int sum=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }
        if(calculatorLinistener!=null){
            calculatorLinistener.getResult(sum);
        }
    }
    public interface OnCalculatorLinistener{
        void  getResult(int sum);
    }
}