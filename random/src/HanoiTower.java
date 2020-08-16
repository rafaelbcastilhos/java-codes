public class HanoiTower {
    public static void main(String [] args){
        Hanoi(0, 2, 1, 8);
    }

    public static void Hanoi(int ori, int dst, int aux, int qnt){
        if(qnt == 1){
            System.out.println("Move from " + ori + " to " + dst);
        }else{
            Hanoi(ori, aux, dst, qnt-1);
            Hanoi(ori, dst, aux, 1);
            Hanoi(aux, dst, ori, qnt-1);
        }
    }
}
