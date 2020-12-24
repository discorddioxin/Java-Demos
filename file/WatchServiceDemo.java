package file;

import java.io.IOException;
import java.nio.file.*;

public class WatchServiceDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Define path of directory to watch
        Path path = Paths.get("src/examples/file");

        // Define types of events types
        WatchEvent.Kind<?>[] eventTypes = {
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY
        };

        // Create new service
        WatchService watchService = FileSystems.getDefault().newWatchService();

        // Register service & types to desired path
        path.register(watchService, eventTypes);

        // Loop to continuously handle events
        while(true) {
            // Take key from service (method will wait until event is triggered)
            WatchKey key = watchService.take();

            // Loop through events
            for(WatchEvent<?> event : key.pollEvents()) {
                System.out.println(event.kind());
                System.out.println(event.context());
            }

            // Must reset the key
            boolean valid = key.reset();

            // If watched directory no longer exists
            if(!valid)
                break;
        }
    }
}
