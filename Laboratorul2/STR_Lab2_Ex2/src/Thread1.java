public class Thread1 extends Thread {
    Integer monitor1;
    Integer monitor2;

    int sleep_min, sleep_max, activity_min1, activity_max1, activity_min2, activity_max2;


    public Thread1(Integer monitor1, Integer monitor2, int sleepMin, int sleepMax, int activityMin1, int activityMax1, int activityMin2) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity_min1 = activity_min1;
        this.activity_max1 = activity_max1;
        this.activity_min2 = activity_min1;
        this.activity_max2 = activity_max1;

    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity_max1 - activity_min1) + activity_min1);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        synchronized (monitor1) {
            synchronized (monitor2) {
            System.out.println(this.getName() + " - STATE 2");
            int k1 = (int) Math.round(Math.random() * (activity_max2 - activity_min2) + activity_min2);
            for (int i = 0; i < k1 * 100000; i++) {
                i++;
                i--;
            }

            System.out.println(this.getName() + " - STATE 3");
            try {
                Thread.sleep(Math.round(Math.random() * (sleep_max - sleep_min) + sleep_min) * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
         }
        }
        System.out.println(this.getName() + " - STATE 4");
    }
}