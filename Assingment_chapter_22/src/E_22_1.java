import java.util.LinkedList;
import java.util.List;
public class E_22_1 {
        public static void main(String[] args) {
            List<Integer> linkedList = new LinkedList<>();

            Thread addThread1 = new Thread(new AddThread(linkedList));
            Thread addThread2 = new Thread(new AddThread(linkedList));
            Thread removeThread1 = new Thread(new RemoveThread(linkedList));
            Thread removeThread2 = new Thread(new RemoveThread(linkedList));

            addThread1.start();
            addThread2.start();
            removeThread1.start();
            removeThread2.start();
        }

        static class AddThread implements Runnable {
            private final List<Integer> linkedList;

            AddThread(List<Integer> linkedList) {
                this.linkedList = linkedList;
            }

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    linkedList.add(i);
                    System.out.println("Added: " + i);
                }
            }
        }

        static class RemoveThread implements Runnable {
            private final List<Integer> linkedList;

            RemoveThread(List<Integer> linkedList) {
                this.linkedList = linkedList;
            }

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                        Integer removed = linkedList.remove(i);
                        System.out.println("Removed: " + removed);

                }
            }
        }
    }


