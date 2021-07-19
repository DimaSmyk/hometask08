package selfwork08.task01;

public class Recursion {
    public static void main(String[] args) {
        int[] myArray = {8,21,532,56,63,12};

        recurse(myArray,0);
    }

    public static void recurse(int[] array, int i){
        if(i== array.length){
            return;
        }
        System.out.print(array[i] + ", ");
        recurse(array, i + 1);
    }
}
