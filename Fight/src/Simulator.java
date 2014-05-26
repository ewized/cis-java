abstract class Event extends AbstractEvent {
    double time;

    public boolean lessThan(Comparable y) {
        Event e = (Event) y;  // Will throw an exception if y is not an Event
        return this.time < e.time;
    }
}

class Simulator extends AbstractSimulator {
    int health = 100;

    double time;
    double now() {
        return time;
    }

    Event nextEvent(){
        return (Event) events.removeFirst();
    }

    String executeNext(){
        Event e  = (Event) events.removeFirst();
        return e.execute(this);
    }

    void doAllEvents() {
        Event e;
        while ( (e= (Event) events.removeFirst()) != null) {
            time = e.time;
            e.execute(this);
        }
    }
}
