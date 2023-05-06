package me.lyric.infinity.mixin.mixins.accessors;

import net.minecraft.util.Timer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Timer.class)
public interface ITimer {
    @Accessor(value="tickLength")
    float getTickLength();

    @Accessor(value="tickLength")
    void setTickLength(float var1);
}