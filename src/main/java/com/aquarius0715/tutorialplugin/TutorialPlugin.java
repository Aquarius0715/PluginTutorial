package com.aquarius0715.tutorialplugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class TutorialPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("tutorial")).setExecutor(new TutorialPlugin()); //これはお決まりの魔法。あんまし考えることはないけど、やってたらわかります。
        //getCommandにはonCommandのlabelと同じものを入れればおk。
        //あとはresources内のplugin.ymlにcommandsを書き加えてその中にまた同じlabelをかく。こうすることでサーバーに新しいコマンドを認識させることができる。

        getServer().getPluginManager().registerEvents(new TutorialEvents(), this);
        //これはイベントリスナーをサーバーに知らせるための記述。魔法として覚えていい。
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
