package net.rngaming.structure.nature.util;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class OptimizedEventManager {
    public static final Logger LOGGER = LoggerFactory.getLogger(OptimizedEventManager.class);

    private final Map<Identifier, Integer> eventCounts = new HashMap<>();
    private static final long EVENT_PROCESS_INTERVAL = 1000; // Milliseconds
    private long lastProcessTime = 0;

    public OptimizedEventManager() {
        // Register the event listener
        registerEventListener();
    }

    private void registerEventListener() {
        // Registering a listener for block break events as an example
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            Identifier eventType = Identifier.of("minecraft", "block_break");
            // Increment the count for the event type
            eventCounts.merge(eventType, 1, Integer::sum);
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastProcessTime >= EVENT_PROCESS_INTERVAL) {
                // Process events if the time interval has passed
                processEvents();
                lastProcessTime = currentTime;
            }
            return false;
        });

        // Log that the event listener has been registered
        LOGGER.info("Event listener registered with optimized processing.");
    }

    private void processEvents() {
        for (Map.Entry<Identifier, Integer> entry : eventCounts.entrySet()) {
            Identifier eventType = entry.getKey();
            int count = entry.getValue();
            if (count > 0) {
                // Process the events in batches
                LOGGER.info("Processing {} events for type: {}", count, eventType);
                // Implement your logic here to handle the events
                // Reset the count for the event type
                eventCounts.put(eventType, 0);
            }
        }
    }
}
