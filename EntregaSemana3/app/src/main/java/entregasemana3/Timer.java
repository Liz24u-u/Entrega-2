package entregasemana3;

import entregasemana3.Interfaces.ICountdown;

public class Timer implements ICountdown {
    private int timeInSeconds;

    public Timer(){
        timeInSeconds = 10 * 60;
    }

    public int getTime(){
        return timeInSeconds;
    }
    @Override
    public void start() {

    }

    @Override
    public void addTime(int minutes) {

    }

    @Override
    public void stop() {

    }
}
