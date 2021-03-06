/*
 * Copyright 2020 FabLabsMC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 *  FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 *  COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 *  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *  CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package io.github.fablabsmc.fablabs.test.block.extension;

import io.github.fablabsmc.fablabs.api.block.extensions.v1.SlipperinessExtension;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

public class SlipperinessExtensionTest implements ModInitializer {
	public static final Block SLIPPERY_TEST = ExtensionUtils.registerWithItem("slippery", new TestBlock());

	@Override
	public void onInitialize() {
	}

	private static class TestBlock extends Block implements SlipperinessExtension {
		TestBlock() {
			super(FabricBlockSettings.of(Material.METAL));
		}

		@Override
		public float getSlipperiness(World world, BlockPos pos, BlockState state, Entity entity) {
			if (entity instanceof PlayerEntity) {
				return 1.0F;
			}

			return 0.0F;
		}
	}
}
