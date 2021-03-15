package org.cubit.customtable.customtable;

import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;

public class CustomItem {

    private final String name;
    private final ItemStack item;
    private Map<Integer , List<ItemStack>> itemMap;
    private long tick;
    private int percentage;
    private int proficiencyLimit;
    private int proficiency;
    private String npc;

    public CustomItem(String name, ItemStack item, Map<Integer, List<ItemStack>> itemMap, int tick, int percentage, int proficiencyLimit, int proficiency, String npc) {
        this.name = name;
        this.item = item;
        this.itemMap = itemMap;
        this.tick = tick;
        this.percentage = percentage;
        this.proficiencyLimit = proficiencyLimit;
        this.proficiency = proficiency;
        this.npc = npc;
    }

    public String getName() {
        return name;
    }

    public ItemStack getItem() {
        return item;
    }

    public Map<Integer, List<ItemStack>> getItemMap() {
        return itemMap;
    }

    public long getTick() {
        return tick;
    }

    public int getPercentage() {
        return percentage;
    }

    public int getProficiencyLimit() {
        return proficiencyLimit;
    }

    public int getProficiency() {
        return proficiency;
    }

    public String getNpc() {
        return npc;
    }
}
