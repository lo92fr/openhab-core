/*
 * Copyright (c) 2010-2025 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.core.items;

import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.types.Command;
import org.openhab.core.types.State;

/**
 * {@link GenericItem} implementation used for testing.
 *
 * @author Christoph Knauf - Initial contribution
 */
@NonNullByDefault
public class TestItem extends GenericItem {

    public TestItem(String name) {
        super("Test", name);
    }

    public Set<StateChangeListener> getListeners() {
        return listeners;
    }

    @Override
    public List<Class<? extends State>> getAcceptedDataTypes() {
        return List.of();
    }

    @Override
    public List<Class<? extends Command>> getAcceptedCommandTypes() {
        return List.of();
    }
}
