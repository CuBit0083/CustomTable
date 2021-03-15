package org.cubit.customtable.inside;

import org.cubit.customtable.customtable.CustomItem;
import org.cubit.customtable.customtable.CustomItemPlayer;

import java.util.UUID;

public interface ICustomTableManager {

    CustomItem getCustomItem(String name);
    void createCustomItem(String name, CustomItem customItem);
    void removeCustomItem(String name);

    CustomItemPlayer getCustomItemPlayer(UUID uuid);
    void addItemTime(UUID uuid , CustomItemPlayer customItemPlayer);
    void removeItemTime(UUID uuid);

    Integer getProficiency(UUID uuid);
    void addProficiency(UUID uuid , Integer value);
    void removeProficiency(UUID uuid);



}