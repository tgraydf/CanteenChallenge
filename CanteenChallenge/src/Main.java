public class Main {
    public static void main(String[] args) {
        Canteen canteen = new Canteen(20.00, 10.00, 2, 2);
        while (canteen.isStoreOpen()) {
            canteen.sellTreat();
        }
    }
}

