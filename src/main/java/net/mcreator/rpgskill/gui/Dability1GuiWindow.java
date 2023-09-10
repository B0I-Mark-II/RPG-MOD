
package net.mcreator.rpgskill.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.rpgskill.RpgskillMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Dability1GuiWindow extends ContainerScreen<Dability1Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Dability1Gui.guistate;

	public Dability1GuiWindow(Dability1Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 423;
		this.ySize = 212;
	}

	private static final ResourceLocation texture = new ResourceLocation("rpgskill:textures/screens/dability_1.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("rpgskill:textures/screens/dp3.png"));
		this.blit(ms, this.guiLeft + 4, this.guiTop + 48, 0, 0, 42, 42, 42, 42);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("rpgskill:textures/screens/dash.png"));
		this.blit(ms, this.guiLeft + 4, this.guiTop + 156, 0, 0, 42, 42, 42, 42);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Your Next Attack Applies A Debuff ", 130, 57, -256);
		this.font.drawString(ms, "Decreeses enemy Damage Resistance", 130, 66, -3407617);
		this.font.drawString(ms, "Enhance your Next 3 Attacks", 130, 102, -256);
		this.font.drawString(ms, "Each Attack Deals Bonus Damage", 130, 111, -65536);
		this.font.drawString(ms, "Gain Invisibility and Dash Forward ", 130, 165, -256);
		this.font.drawString(ms, "Deals Bonus Damage Upon Next Attack", 130, 174, -65536);
		this.font.drawString(ms, "5 Sec Cooldown", 337, 84, -16777216);
		this.font.drawString(ms, "15 Sec Cooldown", 337, 138, -16777216);
		this.font.drawString(ms, "20 Sec Cooldown", 337, 192, -16777216);
		this.font.drawString(ms, "[Cooldown]", 328, 21, -12829636);
		this.font.drawString(ms, "[Ability Description]", 139, 21, -12829636);
		this.font.drawString(ms, "[Ability Name]", 22, 21, -12829636);
		this.font.drawString(ms, "Dash", 58, 165, -12829636);
		this.font.drawString(ms, "Swift Strike", 58, 102, -12829636);
		this.font.drawString(ms, "Dash", 58, 57, -12829636);
		this.font.drawString(ms, "(LVL 15)", 58, 183, -12829636);
		this.font.drawString(ms, "(LVL 8)", 58, 120, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 355, this.guiTop + 57, 40, 20, new StringTextComponent("Use"), e -> {
			if (true) {
				RpgskillMod.PACKET_HANDLER.sendToServer(new Dability1Gui.ButtonPressedMessage(0, x, y, z));
				Dability1Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 355, this.guiTop + 111, 40, 20, new StringTextComponent("Use"), e -> {
			if (true) {
				RpgskillMod.PACKET_HANDLER.sendToServer(new Dability1Gui.ButtonPressedMessage(1, x, y, z));
				Dability1Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 355, this.guiTop + 165, 40, 20, new StringTextComponent("Use"), e -> {
			if (true) {
				RpgskillMod.PACKET_HANDLER.sendToServer(new Dability1Gui.ButtonPressedMessage(2, x, y, z));
				Dability1Gui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
