
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

import net.mcreator.rpgskill.procedures.DAGGERSKILLTREELVL2Procedure;
import net.mcreator.rpgskill.RpgskillModVariables;
import net.mcreator.rpgskill.RpgskillMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class DaggerPage1GuiWindow extends ContainerScreen<DaggerPage1Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = DaggerPage1Gui.guistate;

	public DaggerPage1GuiWindow(DaggerPage1Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 410;
		this.ySize = 234;
	}

	private static final ResourceLocation texture = new ResourceLocation("rpgskill:textures/screens/dagger_page_1.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("rpgskill:textures/screens/lvl.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 131, 0, 0, 176, 47, 176, 47);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("rpgskill:textures/screens/lvl.png"));
		this.blit(ms, this.guiLeft + 222, this.guiTop + 23, 0, 0, 176, 47, 176, 47);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("rpgskill:textures/screens/lvl.png"));
		this.blit(ms, this.guiLeft + 222, this.guiTop + 77, 0, 0, 176, 47, 176, 47);

		if (DAGGERSKILLTREELVL2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("rpgskill:textures/screens/lvl_2.png"));
			this.blit(ms, this.guiLeft + 6, this.guiTop + 77, 0, 0, 176, 47, 176, 47);
		}

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("rpgskill:textures/screens/lvl_2.1.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 77, 0, 0, 176, 47, 176, 47);

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
		this.font.drawString(ms, "Weapon LVL = " + (int) ((entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new RpgskillModVariables.PlayerVariables())).Dagger_lvl) + "/50", 6, 5, -12829636);
		this.font.drawString(ms, "Skill Points = " + (int) ((entity.getCapability(RpgskillModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new RpgskillModVariables.PlayerVariables())).Skill_points) + "", 330, 5, -12829636);
		this.font.drawString(ms, "Page 1/5", 186, 212, -12829636);
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
		this.addButton(new Button(this.guiLeft + 6, this.guiTop + 203, 72, 20, new StringTextComponent("Prev Page"), e -> {
			if (true) {
				RpgskillMod.PACKET_HANDLER.sendToServer(new DaggerPage1Gui.ButtonPressedMessage(0, x, y, z));
				DaggerPage1Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 87, this.guiTop + 203, 72, 20, new StringTextComponent("Next Page"), e -> {
			if (true) {
				RpgskillMod.PACKET_HANDLER.sendToServer(new DaggerPage1Gui.ButtonPressedMessage(1, x, y, z));
				DaggerPage1Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 339, this.guiTop + 203, 61, 20, new StringTextComponent("LEVEL UP!"), e -> {
			if (true) {
				RpgskillMod.PACKET_HANDLER.sendToServer(new DaggerPage1Gui.ButtonPressedMessage(2, x, y, z));
				DaggerPage1Gui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 240, this.guiTop + 203, 93, 20, new StringTextComponent("Select Skills"), e -> {
			if (true) {
				RpgskillMod.PACKET_HANDLER.sendToServer(new DaggerPage1Gui.ButtonPressedMessage(3, x, y, z));
				DaggerPage1Gui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
