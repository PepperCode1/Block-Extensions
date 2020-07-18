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

package io.github.fablabsmc.fablabs.api.block.extensions.v1;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public interface AbstractBlockStateExtensions {
	static AbstractBlockStateExtensions getExtensions(AbstractBlock.AbstractBlockState state) {
		return (AbstractBlockStateExtensions) state;
	}

	BlockState asBlockState();

	PistonBehavior getPistonBehavior(World world, BlockPos pos, Direction motionDirection, Direction pistonDirection);

	int getEnchantmentTablePower(World world, BlockPos pos);

	float getSlipperiness(World world, BlockPos pos, Entity entity);

	// -- BLOCK

	// TODO: getVelocityMultipler - State, World, pos, entity

	// TODO: getJumpVelocityMultiplier - State, World, pos, entity

	// --- hypothetical features

	// TODO: Configurable climbing speed (including entity and direction).
	// Specify this block must be in climbable tag in order to apply.
	// Or else use a callback for climb speed.

	// TODO: Beacon color modifier - May be a little hard due to having to replace an instanceof and cast to get a float[] in BeaconBlockEntity

	// TODO: Sticky blocks (can pistons use it like a slime/honey block)
}
