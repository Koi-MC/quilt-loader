/*
 * Copyright 2016 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.quiltmc.loader.impl.solver;

import org.quiltmc.loader.api.Version;
import org.quiltmc.loader.api.plugin.solver.AliasedLoadOption;
import org.quiltmc.loader.api.plugin.solver.LoadOption;
import org.quiltmc.loader.impl.metadata.qmj.ModProvided;

/**
 * A mod that is provided from the jar of a different mod.
 */
class ProvidedModOption extends ModLoadOptionCls implements AliasedLoadOption {
	final ModLoadOptionCls provider;
	final ModProvided provided;

	public ProvidedModOption(ModLoadOptionCls provider, ModProvided provided) {
		super(provider.candidate);
		this.provider = provider;
		this.provided = provided;
	}

	@Override
	public String group() {
		return provided.group.isEmpty() ? super.group() : provided.group;
	}

	@Override
	public String id() {
		return provided.id;
	}

	@Override
	public Version version() {
		return provided.version;
	}

	@Override
	String shortString() {
		return "provided mod '" + id() + "' from " + provider.shortString();
	}

	@Override
	String getSpecificInfo() {
		return provider.getSpecificInfo();
	}

	@Override
	public LoadOption getTarget() {
		return provider;
	}
}