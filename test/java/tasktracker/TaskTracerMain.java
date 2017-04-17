package tasktracker;

/**
 * Created by lybuestc on 17/3/8.
 */
/**
 * @author Robert HG (254963746@qq.com) on 4/17/16.
 */
public class TaskTracerMain {

    public static void main(String[] args) {

//        final TaskTracker taskTracker = new TaskTracker();
//        // 任务执行类，实现JobRunner 接口
//        taskTracker.setJobRunnerClass(TestJobRunner.class);
//        taskTracker.setRegistryAddress("zookeeper://127.0.0.1:2181");
//        taskTracker.setNodeGroup("test_trade_TaskTracker"); // 同一个TaskTracker集群这个名字相同
//        taskTracker.setClusterName("test_cluster");
//        taskTracker.setWorkThreads(64);
//        taskTracker.addConfig("job.fail.store", "mapdb");

        new Thread(new TaskTrackerStart("tasktracker.properties")).start();
        new Thread(new TaskTrackerStart("tasktracker2.properties")).start();

        try {
            Thread.sleep(30000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}