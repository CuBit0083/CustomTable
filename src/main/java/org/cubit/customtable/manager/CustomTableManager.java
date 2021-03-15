package org.cubit.customtable.manager;

import org.cubit.customtable.api.ICustomTableManagerApi;
import org.cubit.customtable.customtable.CustomItem;
import org.cubit.customtable.customtable.CustomItemPlayer;
import org.cubit.customtable.inside.ICustomTableManager;

import java.util.*;

public class CustomTableManager implements ICustomTableManagerApi , ICustomTableManager {

    private Map<String ,CustomItem> customItems;
    private Map<UUID, CustomItemPlayer> itemTimeInfo;
    private Map<UUID , Integer> proficiencyInfo;

    public CustomTableManager() {
        this.customItems = new HashMap<>();
        this.itemTimeInfo = new HashMap<>();
        this.proficiencyInfo = new HashMap<>();
    }

    @Override
    public CustomItem getCustomItem(String name) {
        if (name == null || this.customItems == null || !this.customItems.containsKey(name)) {
            return null;
        }
        return this.customItems.get(name);
    }

    @Override
    public void createCustomItem(String name, CustomItem customItem) {
        if (name == null || customItem == null || this.customItems == null || this.customItems.containsKey(name)) {
            return;
        }
        this.customItems.put(name , customItem);
    }

    @Override
    public void removeCustomItem(String name) {
        if (name == null || this.customItems == null || !this.customItems.containsKey(name)) {
            return;
        }
        this.customItems.remove(name);
    }

    @Override
    public CustomItemPlayer getCustomItemPlayer(UUID uuid) {
        if (customItems == null || uuid == null || this.itemTimeInfo == null || !this.itemTimeInfo.containsKey(uuid)) {
            return null;
        }
        return this.itemTimeInfo.get(uuid);
    }

    @Override
    public void addItemTime(UUID uuid, CustomItemPlayer customItemPlayer) {
        if (uuid == null || customItemPlayer == null || this.itemTimeInfo == null || this.itemTimeInfo.containsKey(uuid) ) {
            return;
        }
        this.itemTimeInfo.put(uuid , customItemPlayer);
    }

    @Override
    public void removeItemTime(UUID uuid) {
        if (uuid == null || this.itemTimeInfo == null || !this.itemTimeInfo.containsKey(uuid)) {
            return;
        }
        this.itemTimeInfo.remove(uuid);
    }

    @Override
    public Integer getProficiency(UUID uuid) {
        if (uuid == null ||this.proficiencyInfo == null || !this.proficiencyInfo.containsKey(uuid)) {
            return null;
        }
        return this.proficiencyInfo.get(uuid);
    }

    @Override
    public void addProficiency(UUID uuid, Integer value) {
        if (uuid == null || value == null || this.proficiencyInfo == null || this.proficiencyInfo.containsKey(uuid) ) {
            return;
        }
        this.proficiencyInfo.put(uuid , (this.getProficiency(uuid) + value));
    }

    @Override
    public void removeProficiency(UUID uuid) {
        if (uuid == null || this.proficiencyInfo == null || !this.proficiencyInfo.containsKey(uuid)) {
            return;
        }
        this.proficiencyInfo.remove(uuid);
    }

    @Override
    public CustomItem getLoadCustomItem(String name) {
        return null;
    }

    @Override
    public List<CustomItem> getLoadCustomItems() {
        return null;
    }
}
