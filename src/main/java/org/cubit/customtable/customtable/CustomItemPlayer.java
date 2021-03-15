package org.cubit.customtable.customtable;

import org.cubit.customtable.api.ITimeConnectorApi;

import java.util.*;

public class CustomItemPlayer implements ITimeConnectorApi {

    private UUID uuid;
    private Map<CustomItem , Timer> customItemTimerMap;

    public CustomItemPlayer(UUID uuid) {
        this.uuid = uuid;
        this.customItemTimerMap = new HashMap<>();
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void addCustomItemTimer(CustomItem customItem , Timer timer) {
        this.customItemTimerMap.put(customItem , timer);
    }

    public void removeCustomItemTimer(CustomItem customItem) {
        this.customItemTimerMap.remove(customItem);
    }

    public Timer getTimer(CustomItem customItem) {
        return this.customItemTimerMap.get(customItem);
    }

    @Override
    public void startTime(CustomItem customItem) {
        if (customItem == null || this.customItemTimerMap == null) {
            return;
        }
        this.customItemTimerMap.get(customItem).schedule(this.time(()-> this.customItemTimerMap.remove(customItem)), customItem.getTick());
    }

    @Override
    public void stopTime(CustomItem customItem) {
        this.customItemTimerMap.get(customItem).cancel();
    }

    private TimerTask time(Runnable r) {
        return new TimerTask() { public void run() { r.run(); }};
    }
}
