package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

//1й поток передает данные в exchanger, и останавливается до тех пор, пока в этот exchanger не передаст данные 2й поток. после этго разлочится 1й поток
//тут игра "камень, ножницы, бумага" в примере. первый игрок делает ход, и его ход не будет виден до тех пор, пока ход не сделает 2й игрок.
public class SyncExchangerEx {

    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();
        List<Action> friend1Action = new ArrayList<>();
        friend1Action.add(Action.NOJNICI);
        friend1Action.add(Action.BUMAGA);
        friend1Action.add(Action.NOJNICI);
        List<Action> friend2Action = new ArrayList<>();
        friend2Action.add(Action.BUMAGA);
        friend2Action.add(Action.KAMEN);
        friend2Action.add(Action.KAMEN);
        new BestFriend("Ivan", friend1Action, exchanger);
        new BestFriend("Petya", friend2Action, exchanger);
    }

}

enum Action {
    KAMEN, NOJNICI, BUMAGA;
}

class BestFriend extends Thread {

    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger;

    public BestFriend(String name, List<Action> myActions, Exchanger<Action> exchanger) {
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
        this.start(); //запуск потока при создании обьекта
    }

    private void whoWins(Action myAction, Action friendsAction) {
        if ((myAction == Action.KAMEN && friendsAction == Action.NOJNICI)
                || (myAction == Action.NOJNICI && friendsAction == Action.BUMAGA)
                || (myAction == Action.BUMAGA && friendsAction == Action.KAMEN)) {
            System.out.println(name + " WINS!!!");
        }
    }

    @Override
    public void run() {
        Action reply;
        for (Action action : myActions) {
            try {
                reply = exchanger.exchange(action); //в методе exchange() в exchanger мы передаем свою информацию, на аутпутре получаем информацию от 2го потока
                whoWins(action, reply);
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}