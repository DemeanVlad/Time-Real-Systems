public class ExecutionThread extends Thread{
    Integer monitor1;
    Integer monitor2;
    int sleep_min;
    int sleep_max;
    int activity_min;
    int activity_max;
}
public ExecutionThread(Integer monitor1, Integer monitor2 , int sleep_min, int sleep_max, int activity_min, int activity_max)
{

    this.monitor1 = monitor1;

    this.monitor2 = monitor2;

    this.sleep_min = sleep_min;

    this.sleep_max = sleep_max;

    this.activity_min = activity_min;

    this.activity_max = activity_max;

}