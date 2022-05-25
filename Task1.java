import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

public class Task1 {
    private static final int NUM_THREADS = 10;

    public static List<String> generate(final int from, final int to, final int count) {
        if (from < 0 || to < 0 || !isInRange(count, 0, to - from + 1)) throw new IllegalArgumentException();

        List<String> generated = new ArrayList<>(count);
        List<Thread> threads = new ArrayList<>();
        AtomicBoolean end = new AtomicBoolean(false);

        // TODO Create `NUM_THREADS` threads.
        // TODO Each thread:
        //      - generates a random number in the [from, to] interval
        //      - converts it into kanji using `KanjiLib.convert`
        //      - creates a string "<number>, <kanji>" using the given input and converted string
        //      - if `generated` has size equal to `count`, it exits immediately
        //      - puts the string into `generated` if it is not already present

        // TODO Start the above threads.

        // TODO Wait for each thread to finish.

        for(int i = 0; i < NUM_THREADS; ++i)
        {
            threads.add(new Thread(() -> {
                while(!end.get())
                {
                    int number = ThreadLocalRandom.current().nextInt(from, to + 1);
                    String kanji = KanjiLib.convert(number);
                    String pair = String.valueOf(number) + ", " + kanji;
                    synchronized(generated)
                    {
                        if(generated.size() < count)
                            if(generated.stream().filter(s -> s.equals(pair)).count() == 0)
                                generated.add(pair);
                        if(generated.size() == count)
                            end.set(true);
                    }
                }
            }));
        }

        threads.forEach(t -> t.start());
        for(Thread t : threads)
        {
            try{
                t.join();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        return generated;
    }

    private static boolean isInRange(int count, int from, int to) {
        return from <= count && count <= to;
    }
}
