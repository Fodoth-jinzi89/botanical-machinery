package de.melanx.botanicalmachinery.blocks.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import de.melanx.botanicalmachinery.blocks.base.ScreenBase;
import de.melanx.botanicalmachinery.blocks.containers.ContainerAlfheimMarket;
import de.melanx.botanicalmachinery.blocks.tiles.TileAlfheimMarket;
import de.melanx.botanicalmachinery.core.LibResources;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public class ScreenAlfheimMarket extends ScreenBase<ContainerAlfheimMarket> {
    public ScreenAlfheimMarket(ContainerAlfheimMarket container, PlayerInventory inv, ITextComponent titleIn) {
        super(container, inv, titleIn);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int mouseX, int mouseY) {
        this.drawDefaultGuiBackgroundLayer(ms, LibResources.ALFHEIM_MARKET_GUI, 81, 37);
        TileAlfheimMarket tile = (TileAlfheimMarket) this.container.tile;
        if (tile.getProgress() > 0) {
            float pct = Math.min(tile.getProgress() / (float) tile.getMaxProgress(), 1.0F);
            //noinspection ConstantConditions
            this.minecraft.getTextureManager().bindTexture(LibResources.ALFHEIM_MARKET_GUI);
            vazkii.botania.client.core.helper.RenderHelper.drawTexturedModalRect(ms, this.relX + 77, this.relY + 35, 176, 0, Math.round(22 * pct), 16);
        }
    }
}
