package net.stars.fabric;

import net.stars.StarsMod;
import net.fabricmc.api.ModInitializer;

/**
 * StarsModFabric类是StarsMod在Fabric平台的初始化入口。
 * 它实现了Fabric API提供的ModInitializer接口，定义了模组的初始化逻辑。
 */
public class StarsModFabric implements ModInitializer {
    /**
     * 当模块初始化时调用此方法。
     * 该方法用于执行StarsMod模块的初始化操作。
     * 在这里调用StarsMod类的init方法，以启动该模块的初始化过程。
     */
    @Override
    public void onInitialize() {
        StarsMod.init();
    }

}
