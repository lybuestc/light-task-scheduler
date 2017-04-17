package tasktracker;

import com.github.ltsopensource.tasktracker.TaskTracker;
import com.github.ltsopensource.tasktracker.TaskTrackerBuilder;

/**
 * Created by lybuestc on 17/3/8.
 */
public class TaskTrackerStart implements Runnable{

    String tasktracker_properties;

    public TaskTrackerStart(String tasktracker_properties) {
        this.tasktracker_properties = tasktracker_properties;
    }

    @Override
    public void run() {
        final TaskTracker taskTracker = new TaskTrackerBuilder()
                .setPropertiesConfigure(this.tasktracker_properties)
                .build();

        taskTracker.start();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                taskTracker.stop();
            }
        }));
    }
}
