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
package org.openhab.core.thing.internal.profiles;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.openhab.core.library.types.DateTimeType;
import org.openhab.core.thing.profiles.ProfileCallback;
import org.openhab.core.thing.profiles.ProfileTypeUID;
import org.openhab.core.thing.profiles.StateProfile;
import org.openhab.core.thing.profiles.SystemProfiles;
import org.openhab.core.types.Command;
import org.openhab.core.types.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the default implementation for a change timestamp profile.
 * The timestamp updates to now each time the Channel state changes.
 *
 * @author Gaël L'hopital - Initial contribution
 */
@NonNullByDefault
public class TimestampChangeProfile implements StateProfile {

    private final Logger logger = LoggerFactory.getLogger(TimestampChangeProfile.class);
    private final ProfileCallback callback;

    private @Nullable State previousState;

    public TimestampChangeProfile(ProfileCallback callback) {
        this.callback = callback;
    }

    @Override
    public ProfileTypeUID getProfileTypeUID() {
        return SystemProfiles.TIMESTAMP_CHANGE;
    }

    @Override
    public void onStateUpdateFromItem(State state) {
        // no-op
    }

    @SuppressWarnings("null")
    @Override
    public void onStateUpdateFromHandler(State state) {
        logger.debug("Received state update from Handler");
        if (previousState == null || !state.equals(previousState.as(state.getClass()))) {
            logger.debug("Item state changed, sending timestamp to callback");
            previousState = state;
            callback.sendUpdate(new DateTimeType());
        }
    }

    @Override
    public void onCommandFromItem(Command command) {
        // no-op
    }

    @Override
    public void onCommandFromHandler(Command command) {
        // no-op
    }
}
