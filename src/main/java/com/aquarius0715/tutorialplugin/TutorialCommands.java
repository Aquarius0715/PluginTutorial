package com.aquarius0715.tutorialplugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TutorialCommands implements CommandExecutor {
    @Override

    /*
    マイクラのコマンドは/スラッシュから始まる。そのコマンドには部分的な名称がある。
    /tutorial start 100
    というコマンドが実行された時、最初の単語はlabelに、それ以降の単語はargs[]に格納されていく。よってこの場合だと
    label = tutorial
    args[0] = start
    args[1] = 100
    となる。
    また、senderにはその名の通りどの種類がコマンドを実行したのかが格納されてくる
    基本的にコンソールからのコマンドを許可する場合は、プラグインのオンオフ、リロード、データの閲覧などの権限を渡すと良い。
    それ以外は蹴るなどして対策を練らなければNullPointerExeptionを吐く。
     */

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) { //基本的にコマンドはプレーヤーしか受け付けないようにする。ちなみにinstanceofはクラスのタイプを判別するために用いられる。
            sender.sendMessage("プレーヤー以外はこのコマンドを実行することができません。");
            return false;
        }
        if (label.equalsIgnoreCase("tutorial")) { //文字列の比較にはイコール演算子は非推奨。equalsメソッドを使うのが推奨されている。
            if (args.length == 0) { //argsの要素数が0、つまり/tutorialだけで実行された時以下が実行される。
                Player player = (Player) sender; //型キャスト
                Date d = new Date(); //現在時刻を取得
                SimpleDateFormat sdf = new SimpleDateFormat("GGGGy年 M月 d日 (E) a h時 m分 s秒");//書式の設定
                StringBuilder buf = new StringBuilder(); //文字列結合がStringBuffer、StringBuilderを用いると高速
                buf.append("こんにちは！");
                buf.append(ChatColor.YELLOW);
                buf.append(player.getDisplayName());
                buf.append(ChatColor.WHITE);
                buf.append("さん！現在の時刻は");
                buf.append(ChatColor.GREEN);
                buf.append(sdf.format(d));
                buf.append(ChatColor.WHITE);
                buf.append("です。");
                sender.sendMessage(buf.toString());
            }

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("warp")) {
                    Player player = (Player) sender;
                    Random rnd = new Random();  //Randomのインスタンスを生成
                    int delta_x = player.getLocation().getBlockX() - rnd.nextInt(5); //xの座標
                    int delta_y = player.getLocation().getBlockY() - rnd.nextInt(5); //yの座標
                    int delta_z = player.getLocation().getBlockZ() - rnd.nextInt(5); //zの座標
                    Location location = new Location(player.getWorld(), delta_x, delta_y, delta_z); //座標データから座標インスタンスを生成
                    player.teleport(location); //指定座標までテレポート
                    player.playSound(location, Sound.ENTITY_ENDERMAN_TELEPORT, 8.0F, 0); //テレポート先にエンダーマンのワープの音を再生
                }
            }
        }
        return false;
    }
}
