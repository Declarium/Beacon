package com.declarium.beacon.item;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class ItemBuilder {

    private final ItemStack item;

    private ItemBuilder(ItemStack item) {
        this.item = Objects.requireNonNull(item);
    }

    public static ItemBuilder create(ItemStack item) {
        return new ItemBuilder(item);
    }

    public static ItemBuilder create(Material material) {
        return new ItemBuilder(new ItemStack(material));
    }

    public ItemBuilder setType(Material material) {
        this.item.setType(Objects.requireNonNull(material));
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        this.item.setAmount(amount);
        return this;
    }

    public ItemBuilder setData(int data) {
        this.item.setDurability((byte) data);
        return this;
    }

    public ItemBuilder setName(String name) {
        return this.adjustMeta(meta -> meta.setDisplayName(name));
    }

    public ItemBuilder setLore(List<String> lore) {
        return this.adjustMeta(meta -> meta.setLore(lore));
    }

    public ItemBuilder setUnbreakable(boolean unbreakable) {
        return this.adjustMeta(meta -> meta.setUnbreakable(unbreakable));
    }

    public ItemBuilder addItemFlags(ItemFlag... flags) {
        return this.adjustMeta(meta -> meta.addItemFlags(flags));
    }

    public ItemBuilder removeItemFlags(ItemFlag... flags) {
        return this.adjustMeta(meta -> meta.removeItemFlags(flags));
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
        this.item.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public ItemBuilder removeEnchantment(Enchantment enchantment) {
        this.item.removeEnchantment(enchantment);
        return this;
    }

    private ItemBuilder adjustMeta(Consumer<ItemMeta> metaAction) {
        ItemMeta meta = this.item.getItemMeta();
        metaAction.accept(meta);
        this.item.setItemMeta(meta);
        return this;
    }

    public ItemStack build() {
        return this.item;
    }
}