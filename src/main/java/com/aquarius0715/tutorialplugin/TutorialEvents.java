package com.aquarius0715.tutorialplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


//この形はイベントリスナーを使う中で変わらないので、覚えるしかないです。魔法です。楽しいですね。
public class TutorialEvents implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!(player.hasPlayedBefore())) {
            StringBuilder buf = new StringBuilder();
            buf.append(ChatColor.BOLD);
            buf.append(ChatColor.YELLOW);
            buf.append(player.getDisplayName());
            buf.append("さんが初めてこのサーバにログインしました。歓迎しましょう！！！");
            Bukkit.broadcastMessage(buf.toString());
            buf = new StringBuilder();
            buf.append(ChatColor.GREEN);
            buf.append("こんにちは！！！始めました！！！");
            player.sendMessage(buf.toString());
        } else {
            StringBuilder buf = new StringBuilder();
            buf.append(ChatColor.GREEN);
            buf.append("こんにちは！！！お帰りなさい！！！");
            player.sendMessage(buf.toString());
        }
    }
}
