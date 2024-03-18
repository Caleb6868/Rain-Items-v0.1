package me.myllucodes.rainitems;

import me.myllucodes.rainitems.Commands.RainItemsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class RainItems extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("rainitems").setExecutor(new RainItemsCommand(this));


    }
}
