package de.melanx.botanicalmachinery.blocks.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import de.melanx.botanicalmachinery.blocks.base.ScreenBase;
import de.melanx.botanicalmachinery.blocks.containers.ContainerIndustrialAgglomerationFactory;
import de.melanx.botanicalmachinery.blocks.tiles.TileIndustrialAgglomerationFactory;
import de.melanx.botanicalmachinery.core.LibResources;
import de.melanx.botanicalmachinery.helper.RenderHelper;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import vazkii.botania.common.item.ModItems;

import javax.annotation.Nonnull;

public class ScreenIndustrialAgglomerationFactory extends ScreenBase<ContainerIndustrialAgglomerationFactory> {
    public ScreenIndustrialAgglomerationFactory(ContainerIndustrialAgglomerationFactory container, PlayerInventory inv, ITextComponent titleIn) {
        super(container, inv, titleIn);
        this.ySize = 195;
        this.manaBar.x -= 5;
        this.manaBar.y += 23;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(@Nonnull MatrixStack ms, float partialTicks, int mouseX, int mouseY) {
        this.drawDefaultGuiBackgroundLayer(ms, LibResources.INDUSTRIAL_AGGLOMERATION_FACTORY_GUI, 81, 37);
        RenderHelper.renderFadedItem(ms, this, ModItems.manaSteel, this.relX + 61, this.relY + 83);
        RenderHelper.renderFadedItem(ms, this, ModItems.manaDiamond, this.relX + 80, this.relY + 83);
        RenderHelper.renderFadedItem(ms, this, ModItems.manaPearl, this.relX + 99, this.relY + 83);
        TileIndustrialAgglomerationFactory tile = (TileIndustrialAgglomerationFactory) this.container.tile;
        if (tile.getProgress() > 0) {
            float pct = Math.min(tile.getProgress() / (float) tile.getMaxProgress(), 1.0F);
            //noinspection ConstantConditions
            this.minecraft.getTextureManager().bindTexture(LibResources.INDUSTRIAL_AGGLOMERATION_FACTORY_GUI);
            vazkii.botania.client.core.helper.RenderHelper.drawTexturedModalRect(ms, this.relX + 73, this.relY + 76, 176, 25, 30, Math.round(-(25 * pct)));
        }
    }

}
