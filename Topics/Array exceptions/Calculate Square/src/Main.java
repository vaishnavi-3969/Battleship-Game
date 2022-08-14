class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        // write your code here
        if(array == null || index < 0 || index > array.length - 1){
            System.out.println("Exception!");
        }else{
            System.out.println((int)Math.pow(array[index], 2));
        }
    }
}